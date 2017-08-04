package ufs.operators;

import javax.management.JMException;

import ufs.core.Operator;
import ufs.core.Solution;

public class PolynomialMutation extends Operator{

	
	@Override
	public Solution tweak(Solution solution) throws CloneNotSupportedException {
		
		double 	probability = Math.random();
		// TODO Auto-generated method stub
		double eta_m_ = 20;
		double distributionIndex_ = 20;

		double rnd, delta1, delta2, mut_pow, deltaq;
		double y, yl, yu, val, xy;
		// XReal x = new XReal(solution) ;
		Solution newSolution = solution.clone();
		double[] x = newSolution.getArraySolution().clone();
		for (int i = 0; i < solution.getArraySolution().length; i++) {
			if (Math.random() <= probability) {
				y = x[i];
				// yl = x.getLowerBound(i);
				yl = 1;
				// yu = x.getUpperBound(i);
				yu = 100;
				delta1 = (y - yl) / (yu - yl);
				delta2 = (yu - y) / (yu - yl);
				rnd = Math.random();
				mut_pow = 1.0 / (eta_m_ + 1.0);
				if (rnd <= 0.5) {
					xy = 1.0 - delta1;
					val = 2.0 * rnd + (1.0 - 2.0 * rnd) * (Math.pow(xy, (distributionIndex_ + 1.0)));
					deltaq = java.lang.Math.pow(val, mut_pow) - 1.0;
				} else {
					xy = 1.0 - delta2;
					val = 2.0 * (1.0 - rnd) + 2.0 * (rnd - 0.5) * (java.lang.Math.pow(xy, (distributionIndex_ + 1.0)));
					deltaq = 1.0 - (java.lang.Math.pow(val, mut_pow));
				}
				y = y + deltaq * (yu - yl);
				if (y < yl)
					y = yl;
				if (y > yu)
					y = yu;

				// x.setValue(i, y);
				x[i] = y;
			}
		} // for
		return newSolution;

	}
	
	public Solution polynomialMutation(double probability, Solution solution) throws JMException, CloneNotSupportedException {
		return solution;
		
		
		
	} // doMutation


}
