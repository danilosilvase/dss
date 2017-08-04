package ufs.functions;

import ufs.core.Function;
import ufs.core.Solution;

public class RosenbrockFunction extends Function {

	@Override
	public double quality(Solution soluction, double[] o) {
		double result = 0;

		for (int i = 0; i < soluction.getArraySolution().length - 1; i++) {
			double z1 = Math.pow(soluction.getArraySolution()[i] - o[i] + 1, 2);
			double z2 = soluction.getArraySolution()[i+1] - o[i+1] + 1;						
			
			double pt1 = Math.pow(z1 - z2, 2);
			double pt2 = Math.pow(z1 - 1, 2);
			
			result += 100 * pt1 + pt2;
		}

		soluction.setObjetivo(result);

		return result;
	}

}
