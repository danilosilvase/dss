package ufs.metaheuristics.GA;

import ufs.core.*;

import java.util.ArrayList;




public class GA extends Algorithm {

	private Solution solutionBest;
	private int numAvaliation;
	private int popSize;
	private ArrayList<Solution> populationP;
	private ArrayList<Solution> populationG;

	public GA(int numAvaliation, int dimensaoArray, int popSize, double min, double max) {
		populationP = new ArrayList<>();

		for (int i = 0; i < popSize; i++) {
			populationP.add(new Solution(dimensaoArray, max, min));
		}

		this.solutionBest = null;

		this.numAvaliation = numAvaliation;
		this.popSize = popSize;
	}

	@Override
	public Solution execute() throws CloneNotSupportedException {

		do {

			for (Solution pi : populationP) {
				quality(pi);
				if (solutionBest == null || (pi.getObjetivo() < solutionBest.getObjetivo())) {
					solutionBest = pi.clone();
					
										
				}

			}

			populationG = new ArrayList<>();

			for (int j = 0; j < popSize / 2; j++) {
				Solution pa = selectWithReplacement(populationP);
				Solution pb = selectWithReplacement(populationP);

				Solution[] c = sbxCrossover(pa.clone(), pb.clone());
				Solution ca = c[0];
				Solution cb = c[1];

				populationG.add(operator.tweak(ca));
				populationG.add(operator.tweak(cb));
			}

			populationP.clear();
			populationP.addAll(populationG);

			//System.out.println(funcaoObjetivo.getAvaliacao());
			//System.out.println(numAvaliation);

		} while ((this.numAvaliation > funcaoObjetivo.getAvaliacao()) && solutionBest.getObjetivo() != 0.0);

		// System.out.println("Numero de avaliações: " +
		// operator.getAvaliacao());

		return solutionBest;

	}

	private Solution selectWithReplacement(ArrayList<Solution> p) {

		// Seleção por torneio.

		int randomPosition1 = (int) (Math.random() * p.size());
		int randomPosition2 = (int) (Math.random() * p.size());

		while (randomPosition1 == randomPosition2) {
			randomPosition2 = (int) (Math.random() * p.size());
		}

		Solution p1 = p.get(randomPosition1);
		Solution p2 = p.get(randomPosition2);

		if (p1.getObjetivo() > p2.getObjetivo())
			return p1;

		return p2;
	}

	private Solution[] crossover(Solution clone, Solution clone2) {
	
		// Uniform crossover

		for (int i = 0; i < clone.getArraySolution().length; i++) {

			boolean change = Math.random() > 0.5;

			if (change) {
				double aux = clone.getArraySolution()[i];
				clone.getArraySolution()[i] = clone2.getArraySolution()[i];
				clone2.getArraySolution()[i] = aux;
			}
		}

		Solution[] result = new Solution[2];
		result[0] = clone;
		result[1] = clone2;

		return result;
	}
	
	private Solution[] sbxCrossover(Solution clone, Solution clone2) {
		double beta;
		
		int n = 1;
		for (int i = 0; i < clone.getArraySolution().length; i++) {

			double p = Math.random();

			if (p < 0.5) {

				beta = Math.pow(2 * p, 1 / (n + 1));

				// Z1 = 0.5[(1+ β )X + (1− β )Y ]
				// Z2 = 0.5[(1− β )X + (1+ β )Y ]
				clone.getArraySolution()[i] = (0.5
						* (((1 + beta) * clone.getArraySolution()[i]) + ((1 - beta) * clone2.getArraySolution()[i])));
				clone.getArraySolution()[i] = (0.5
						* (((1 - beta) * clone.getArraySolution()[i]) + ((1 + beta) * clone2.getArraySolution()[i])));

			} else {

				beta = Math.pow(1 / (2 * (1 - p)), 1 / (n + 1));

				clone.getArraySolution()[i] = (0.5
						* (((1 + beta) * clone.getArraySolution()[i]) + ((1 - beta) * clone2.getArraySolution()[i])));
				clone.getArraySolution()[i] = (0.5
						* (((1 - beta) * clone.getArraySolution()[i]) + ((1 + beta) * clone2.getArraySolution()[i])));
			}

		}

		Solution[] result = new Solution[2];
		result[0] = clone;
		result[1] = clone2;

		return result;
	}
	

	private double quality(Solution solution) {
		double calcFuncao = funcaoObjetivo.quality(solution, funcaoObjetivo.getBiasZero());
		solution.setObjetivo(calcFuncao);
		funcaoObjetivo.contAvaliacao();
		return calcFuncao;
	}

}
