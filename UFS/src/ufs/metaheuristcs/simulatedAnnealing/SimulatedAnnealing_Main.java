package ufs.metaheuristcs.simulatedAnnealing;

import ufs.core.*;
import ufs.functions.*;
import ufs.operators.*;

public class SimulatedAnnealing_Main {

	public static void main(String[] args) throws CloneNotSupportedException {

		Solution solution; // problema a ser resolvido
		Operator operator; // Operador Tweak
		Function function; // Funcao de avaliação
		SimulatedAnnealing algorithm; // Algoritmo escolhido

		for (int i = 0; i < 20; i++) {

			// Dimensão do array
			int dimensaoArray = 50;

			// Numero de avaliações
			int numAvaliacoes = 50000;

			// Intervalo do array
			int max = 5;
			int min = -5;

			// temperatura

			double temperature = 500;

			// Função de avaliação
			 function = new RosenbrockFunction();
			//function = new RastriginFunction();
			//function = new SchwefelFunction();
			//function = new SphereFunction();

			// Operador
			operator = new Tweak_4();

			// Algoritmo
			algorithm = new SimulatedAnnealing(temperature, numAvaliacoes, dimensaoArray, max, min);
			algorithm.setFuncaoObjetivo(function);
			algorithm.setOperator(operator);

			solution = algorithm.execute();
			function.quality(solution, function.getBias());
			// System.out.println("Melhor solução: " + solution.getObjetivo());
			System.out.println(solution.getObjetivo());

		}
	}

}
