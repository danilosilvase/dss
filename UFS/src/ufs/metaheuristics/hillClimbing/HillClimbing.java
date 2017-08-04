package ufs.metaheuristics.hillClimbing;

import ufs.core.*;
import ufs.*;

public class HillClimbing extends Algorithm {

	private Solution solutionS;
	private Solution solutionR;
	private int numAvaliation;

	public HillClimbing(int numAvaliation, int dimensaoArray, double min, double max) {
		this.solutionS = new Solution(dimensaoArray, max, min);
		this.numAvaliation = numAvaliation;
	}

	@Override
	public Solution execute() throws CloneNotSupportedException {

		quality(this.solutionS);
		//System.out.println("Solução inicial: " + solutionS.getObjetivo());

		do {
		
			solutionR = operator.tweak(solutionS.clone());

			if (quality(solutionR) < this.solutionS.getObjetivo()) {

				solutionS = solutionR.clone();
			}
		} while (this.numAvaliation > operator.getAvaliacao() && solutionS.getObjetivo() != 0.0);

		//System.out.println("Numero de avaliações: " + operator.getAvaliacao());

		return solutionS;
	}

	private double quality(Solution solution) {
		double calcFuncao = funcaoObjetivo.quality(solution, funcaoObjetivo.getBiasZero());
		solution.setObjetivo(calcFuncao);
		return calcFuncao;
	}

}
