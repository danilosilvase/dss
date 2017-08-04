package ufs.operators;

import ufs.core.Operator;
import ufs.core.Solution;
import ufs.core.Util;

public class BitFlipMutation extends Operator {

	@Override
	public Solution tweak(Solution s) throws CloneNotSupportedException {
				
		// Método de multação. Retorna a própria solução s multacionada
		
		byte[] sByte = Util.toByteArray(s.getArraySolution());

		double p = 1 / sByte.length;

		for (int i = 0; i < sByte.length; i++) {
			if (p >= Math.random()) {
				sByte[i] = (byte) ~sByte[i];
			}
		}

		double[] sDouble = Util.toDoubleArray(sByte);
		s.setArraySolution(sDouble);

		return s;
	}

}
