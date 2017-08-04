package ufs.operators;

import ufs.core.Operator;
import ufs.core.Solution;

public class Tweak_4 extends Operator {

	/*
	 * Algorithm 8 Bounded Uniform Convolution
	 */

	@Override
	public Solution tweak(Solution s) throws CloneNotSupportedException {

		
		//Adiciona ou subtrai um ruído "r" em todas as posições do vetor;
		
		Solution newSolution = s.clone();
		double[] array = newSolution.getArraySolution().clone();
		double p = 1; // probability of adding noise to an element in the vector
		double r = 0.2; // half-range of uniform noise
		double n = 0.0;

		for (int i = 0; i < array.length; i++) {
			if (p >= Math.random()) {
				n = r * (Math.random() > 0.5 ? 1 : -1);

				if (array[i] + n < 100 && array[i] + n > -100)
					array[i] += n;

			}
		}
		
		contAvaliacao();
		newSolution.setArraySolution(array);
		return newSolution;

	}

}
