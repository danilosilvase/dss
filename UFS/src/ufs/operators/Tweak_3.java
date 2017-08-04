package ufs.operators;

import ufs.core.Operator;
import ufs.core.Solution;

public class Tweak_3 extends Operator {

	/*
	 * Algorithm 8 Bounded Uniform Convolution
	 */

	@Override
	public Solution tweak(Solution s) throws CloneNotSupportedException {

		Solution newSolution = s.clone();
		double[] array = newSolution.getArraySolution().clone();
		int p = 1; // probability of adding noise to an element in the vector
		double r = 1; // half-range of uniform noise
		double n = 0.0;

		for (int i = 0; i < array.length; i++) {

			if (p >= Math.random()) {
				int nunBin = (int) (Math.random() * 2);
				n = Math.random() * r;
				if (nunBin == 1) {
				} else {
					n = Math.random() * r;
				}
				System.out.println(n);
				if (array[i] + n < 100 && array[i] + n > -100)
					array[i] += n;
			}
		}
		contAvaliacao();
		newSolution.setArraySolution(array);
		return newSolution;

	}

}
