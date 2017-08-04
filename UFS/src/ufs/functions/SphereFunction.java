package ufs.functions;

import ufs.core.Function;
import ufs.core.Solution;

public class SphereFunction extends Function {

	@Override
	public double quality(Solution solution, double[] o) {
		double result = 0;
		double z = 0;

		for (int i = 0; i < solution.getArraySolution().length; i++) {
			z = solution.getArraySolution()[i] - o[i];
			//result += Math.pow(solution.getArraySolution()[i], 2);
			result += Math.pow(z, 2);
		}

		solution.setObjetivo(result);

		return result;

	}

}
