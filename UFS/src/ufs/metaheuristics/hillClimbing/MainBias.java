package ufs.metaheuristics.hillClimbing;

import ufs.core.Function;
import ufs.functions.SphereFunction;

public class MainBias {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Function function; // Funcao de avaliação
		function = new SphereFunction();
		
		
		for (int i=0 ; i < function.getBias().length;i++){
			System.out.println(function.getBias()[i]+" :"+i);
		}
		
		

	}

}
