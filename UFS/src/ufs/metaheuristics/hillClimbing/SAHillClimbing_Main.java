package ufs.metaheuristics.hillClimbing;

import ufs.core.*;
import ufs.functions.*;
import ufs.operators.*;

public class SAHillClimbing_Main {

	public static void main(String[] args) throws CloneNotSupportedException {

		Solution solution; // problema a ser resolvido
		Operator operator; // Operador Tweak
		Function function; // Funcao de avaliação
		SAHillClimbing algorithm; // Algoritmo escolhido

		// Dimensão do array
		int dimensaoArray = 50;
		
		// Numero de Vizinhos
		int numVizinhos = 10;

		// Numero de avaliações
		int numAvaliacoes = 50000/numVizinhos;

		// Intervalo do array
		int max = 100;
		int min = -100;

		// Função de avaliação
		// function = new RosenbrockFunction();
		// function = new RastriginFunction();
		// function = new SchwefelFunction();
		function = new SphereFunction();

		// Operador
		operator = new Tweak_4();

		// Algoritmo
		algorithm = new SAHillClimbing(numAvaliacoes, dimensaoArray, max, min, numVizinhos);
		algorithm.setFuncaoObjetivo(function);
		algorithm.setOperator(operator);

		solution = algorithm.execute();
		function.quality(solution, null);
		System.out.println("Melhor solução:  " + solution.getObjetivo());

	}

}
