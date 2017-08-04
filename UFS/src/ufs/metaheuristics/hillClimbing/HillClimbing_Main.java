package ufs.metaheuristics.hillClimbing;

import ufs.core.*;
import ufs.functions.*;
import ufs.operators.*;

public class HillClimbing_Main {

	public static void main(String[] args) throws CloneNotSupportedException {

		Solution solution; // problema a ser resolvido
		Operator operator; // Operador Tweak
		Function function; // Funcao de avaliação
		HillClimbing algorithm; // Algoritmo escolhido

		for (int i = 0; i < 20; i++) {

			// Dimensão do array
			int dimensaoArray = 50;

			// Numero de avaliações
			int numAvaliacoes = 50000;

			// Intervalo do array
			int max = 100;
			int min = -100;

			// Função de avaliação
			//function = new RastriginFunction();
			 function = new RosenbrockFunction();
			
			//function = new SchwefelFunction();
			//function = new SphereFunction();

			// Operador
			operator = new Tweak_4();

			// Algoritmo
			algorithm = new HillClimbing(numAvaliacoes, dimensaoArray, max, min);
			algorithm.setFuncaoObjetivo(function);
			algorithm.setOperator(operator);

			solution = algorithm.execute();
			function.quality(solution, function.getBiasZero());
			System.out.println(solution.getObjetivo());
			// System.out.println("Melhor solução: " + solution.getObjetivo());

		}
	}

}
