package ufs.operators;

import ufs.core.Operator;
import ufs.core.Solution;

public class Tweak_1 extends Operator {

	@Override
	public Solution tweak(Solution s) throws CloneNotSupportedException {
		Solution newSolution = s.clone();
		double[] array = newSolution.getArraySolution().clone();
		contAvaliacao();
		
		// Sorteia uma posição aleatória no vetor e faz a alteração.

		int indiceRandom = (int) (Math.random() * array.length);

		int nunBin = (int) (Math.random() * 2);

		if (nunBin == 1) {
			//array[indiceRandom] = Math.random() + 0.3;
			array[indiceRandom] += 0.3;
		} else {
			//array[indiceRandom] = Math.random() - 0.3;
			array[indiceRandom] += -0.3;
		}

		newSolution.setArraySolution(array);
		return newSolution;
	}
}
