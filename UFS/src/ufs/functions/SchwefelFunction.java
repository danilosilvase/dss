package ufs.functions;

import ufs.core.Function;
import ufs.core.Solution;

public class SchwefelFunction extends Function {

	@Override
	public double quality(Solution soluction, double[] o) {
		double result = 0;

		for (int i = 0; i < soluction.getArraySolution().length; i++) {
			double z = soluction.getArraySolution()[i] - o[i];

			if (Math.abs(z) > result)
				result = Math.abs(z);
		}

		soluction.setObjetivo(result);

		return result;
	}

}
