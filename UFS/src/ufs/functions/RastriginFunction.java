package ufs.functions;

import ufs.core.Function;
import ufs.core.Solution;

public class RastriginFunction extends Function {

	@Override
	public double quality(Solution soluction, double[] o) {
		double result = 0;

		for (int i = 0; i < soluction.getArraySolution().length; i++) {
			double z1 = Math.pow(soluction.getArraySolution()[i] - o[i], 2);

			result += z1 - 10 * Math.cos(2 * Math.PI * soluction.getArraySolution()[i]) + 10;
		}

		soluction.setObjetivo(result);

		return result;
	}

}
