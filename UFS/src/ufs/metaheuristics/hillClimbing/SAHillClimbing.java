package ufs.metaheuristics.hillClimbing;

import ufs.core.*;
import ufs.*;

public class SAHillClimbing extends Algorithm {

	private Solution solutionS;
	private Solution solutionR;
	private Solution solutionW;
	private int numAvaliation;
	private int numVizinhos;

	public SAHillClimbing(int numAvaliation, int dimensaoArray, double min, double max, int numVizinhos) {
		this.solutionS = new Solution(dimensaoArray, max, min);
		this.numAvaliation = numAvaliation;
		this.numVizinhos = numVizinhos;
	}

	@Override
	public Solution execute() throws CloneNotSupportedException {

		quality(this.solutionS);
		System.out.println("Solução inicial: " + solutionS.getObjetivo());

		do {

			solutionR = operator.tweak(solutionS.clone());

			for (int j = 0; j < numVizinhos; j++) {
				solutionW = operator.tweak(solutionR.clone());

				if (quality(solutionW) < this.solutionR.getObjetivo()) {
					solutionR = solutionW.clone();
				}
			}
			if (quality(solutionR) < this.solutionS.getObjetivo()) {
				solutionS = solutionR.clone();
			}

		} while (this.numAvaliation > operator.getAvaliacao() && solutionS.getObjetivo() != 0.0);

		System.out.println("Numero de avaliações: " + operator.getAvaliacao());

		return solutionS;
	}

	private double quality(Solution solution) {
		double calcFuncao = funcaoObjetivo.quality(solution, null);
		solution.setObjetivo(calcFuncao);
		return calcFuncao;
	}

}
