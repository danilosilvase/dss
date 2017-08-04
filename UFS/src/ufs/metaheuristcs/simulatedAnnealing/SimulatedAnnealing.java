package ufs.metaheuristcs.simulatedAnnealing;

import ufs.core.*;
import ufs.*;

public class SimulatedAnnealing extends Algorithm {

	private Solution solutionS;
	private Solution solutionR;
	private int numAvaliation;
	private double temperature;

	public SimulatedAnnealing(double temperature, int numAvaliation, int dimensaoArray, double min, double max) {
		this.solutionS = new Solution(dimensaoArray, max, min);
		this.numAvaliation = numAvaliation;
		this.temperature = temperature;
	}

	@Override
	public Solution execute() throws CloneNotSupportedException {
		
		double variationTemperature = this.temperature / this.numAvaliation;

		quality(this.solutionS);
		//System.out.println("Solução inicial: " + solutionS.getObjetivo());

		do {
		
			solutionR = operator.tweak(solutionS.clone());
			
			if ((quality(solutionR) < this.solutionS.getObjetivo())|| (Math.random() > Math.exp((solutionR.getObjetivo()-solutionS.getObjetivo())/temperature))) {

				solutionS = solutionR.clone();
			}
			
			temperature -= variationTemperature;
			//System.out.println(temperature);
		} while (this.numAvaliation > operator.getAvaliacao() && solutionS.getObjetivo() != 0.0);

		//System.out.println("Numero de avaliações: " + operator.getAvaliacao());

		return solutionS;
	}

	private double quality(Solution solution) {
		double calcFuncao = funcaoObjetivo.quality(solution, funcaoObjetivo.getBias());
		solution.setObjetivo(calcFuncao);
		return calcFuncao;
	}

}
