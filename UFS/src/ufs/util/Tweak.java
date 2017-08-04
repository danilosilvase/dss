package ufs.util;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import ufs.core.Solution;

public abstract class Tweak {

	/** Altera para um valor aleatorio em uma posicao aleatoria **/
	public static Soluction tWeak(Soluction soluction) {

		int randomPosition = (int) (Math.random() * soluction.getSolution().length);
		double randomValue = ThreadLocalRandom.current().nextDouble(Soluction.min, Soluction.max + 1);
		double[] copySolution = Arrays.copyOf(soluction.getSolution(), soluction.getSolution().length);

		copySolution[randomPosition] = randomValue;

		Soluction soluction2 = new Soluction(soluction.getSolution().length, Soluction.min, Soluction.max);
		soluction2.setSoluction(copySolution);

		return soluction2;
	}

	/**
	 * Incrementa ou decrementa em 0.2 o valor de uma posi��o aleat�ria da
	 * solu��o
	 **/
	public static Soluction tWeak2(Soluction soluction) {

		double val = 0.2 * (Math.random() > 0.5 ? 1 : -1);

		int randomPosition = (int) (Math.random() * soluction.getSolution().length);
		double[] copySolution = Arrays.copyOf(soluction.getSolution(), soluction.getSolution().length);

		if (copySolution[randomPosition] + val <= Soluction.max && copySolution[randomPosition] + val >= Soluction.min)
			copySolution[randomPosition] += val;

		Soluction soluction2 = new Soluction(soluction.getSolution().length, Soluction.min, Soluction.max);
		soluction2.setSoluction(copySolution);

		soluction2.setChangedPosition(randomPosition);
		soluction2.setChangedValue(val);

		return soluction2;
	}

	/**
	 * Incrementa ou decrementa em 0.2 o valor de todas as posi��es da solu��o
	 **/
	public static Soluction tWeak3(Soluction soluction) {

		double val = 0.2 * (Math.random() > 0.5 ? 1 : -1);
		double[] copySolution = Arrays.copyOf(soluction.getSolution(), soluction.getSolution().length);

		for (int i = 0; i < copySolution.length; i++)
			if (copySolution[i] + val <= Soluction.max && copySolution[i] + val >= Soluction.min)
				copySolution[i] += val;

		Soluction soluction2 = new Soluction(soluction.getSolution().length, Soluction.min, Soluction.max);
		soluction2.setSoluction(copySolution);

		return soluction2;
	}

	public static Soluction polynomialMutation(Soluction soluction) {
		double probability = Math.random();
		// TODO Auto-generated method stub
		double eta_m_ = 20;
		double distributionIndex_ = 20;

		double rnd, delta1, delta2, mut_pow, deltaq;
		double y, yl, yu, val, xy;
		// XReal x = new XReal(solution) ;
		// Solution newSolution = soluction.clone();
		double[] x = Arrays.copyOf(soluction.getSolution(), soluction.getSolution().length);

		for (int i = 0; i < x.length; i++) {
			if (Math.random() <= probability) {
				y = x[i];
				// yl = x.getLowerBound(i);
				yl = 1;
				// yu = x.getUpperBound(i);
				yu = 8;
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
		Soluction soluction2 = new Soluction(soluction.getSolution().length, Soluction.min, Soluction.max);
		soluction2.setSoluction(x);

		return soluction2;

	}
}
