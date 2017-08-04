package ufs.operators;

import ufs.core.*;

public class Tweak_2 extends Operator {

	@Override
	public Solution tweak(Solution s) throws CloneNotSupportedException {
		Solution newSolution = s.clone();
		double[] array = newSolution.getArraySolution().clone();
		contAvaliacao();
		
		// Sorteia uma posição aleatória no vetor e faz a alteração.

		int indiceRandom = (int) (Math.random() * array.length);

		array[indiceRandom] = array[indiceRandom] * 0.05;
		newSolution.setArraySolution(array);
		return newSolution;
	}

}
