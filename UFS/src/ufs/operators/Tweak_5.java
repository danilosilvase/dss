package ufs.operators;

import java.util.Arrays;


import ufs.core.Operator;
import ufs.core.Solution;

public class Tweak_5 extends Operator {

	/*
	 * 
	 */

	@Override
	public Solution tweak(Solution s) throws CloneNotSupportedException {

		
		double val = 0.2 * (Math.random() > 0.5 ? 1 : -1);
		double[] copySolution = Arrays.copyOf(s.getArraySolution(), s.getArraySolution().length); 
		
		for(int i = 0; i < copySolution.length; i++)
			if(copySolution[i] + val <= 100 && copySolution[i] + val >= -100)
				copySolution[i] += val;
		
		Solution s2 = new Solution(s.getArraySolution().length, -100, 100);
		s2.setArraySolution(copySolution);
		
		return s2;

	}

}
