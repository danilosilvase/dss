package ufs.main;

import ufs.metaheuristics.GA.Genetic;
import ufs.methaeuristcs.pso.*;
import ufs.util.Soluction;

public class Main {

	public static void main(String[] args) {
		int neighbors = 1000;
		int numAvaliation = 50000 / neighbors;
		int tWeakSize = 50;
		double min = -5;
		double max = 5;

		double[] o = new double[tWeakSize];
		/*
		 * double[] o = { -2.1984809693274691e+001, 1.1554996930588054e+001,
		 * -3.6010680930410572e+001, 6.9372732348913601e+001,
		 * -3.7608870747492858e+001, -4.8536292149608940e+001,
		 * 5.3764766904999085e+001, 1.3718568644579500e+001,
		 * 6.9828587467188129e+001, -1.8627811237527567e+001,
		 * 2.9306608681863466e+001, -7.0216918290093815e+001,
		 * -5.1740284602598457e+001, 7.1737585569505583e+001,
		 * -5.7097788490456374e+001, 7.4868392084559218e+001,
		 * 7.5589061492732164e+000, 6.0387714099661700e+001,
		 * 1.5723311866999682e+001, 3.1662383508634154e+001,
		 * -4.9340767695180610e+001, 5.5037882705394999e+001,
		 * -5.2664146736691549e+001, -2.6052382991662000e+001,
		 * 5.4047889276639125e+001, -7.7471421571386827e+001,
		 * 6.4605085107437162e+001, -1.7712124964030018e+001,
		 * -1.1574279228715504e+001, -4.2591386228491821e+001,
		 * 1.4099868763503226e+001, -2.0849153638990408e+001,
		 * 1.2829750891508976e+001, -1.3033429343112887e+001,
		 * -3.4228784448817365e+001, -6.0900486247534531e+001,
		 * 3.6699060076450962e+001, -7.5821585436271661e+001,
		 * 3.0963033600311711e+001, -3.3284036733990504e+001,
		 * -3.8685615461807110e+000, 1.5045199483878651e+001,
		 * 8.8286354912650538e+000, -2.2556601714105376e+001,
		 * 1.7891609883397138e+001, -2.4669921528691788e+001,
		 * 4.7683985288383184e+001, -4.9744941398180913e+000,
		 * 4.7272935138506071e+001, 2.5724408972544834e+000, };
		 */
		/*
		 * for (int j = 0; j < 50; j++) { System.out.print(o[j] + " "); }
		 */
		double media = 0;
		for (int i = 0; i < 20; i++) {
			// System.out.println("i = " + (i+1));
			// ======================Metaheur�sticas======================
			//
			// HillClimbing meta = new HillClimbing(numAvaliation, tWeakSize,
			// min, max, o);
			// AscentHillClimbing meta = new AscentHillClimbing(numAvaliation,
			// neighbors,
			// tWeakSize, min, max, o);
			// Tabu meta = new Tabu(listTabuSize, numAvaliation, neighbors,
			// tWeakSize, min,
			// max, o);
			Genetic meta = new Genetic(neighbors, numAvaliation, tWeakSize, min, max, o);
			// Pso meta = new Pso(neighbors, numAvaliation, tWeakSize, min, max,
			// o);
			//
			// ===========================================================

			Soluction result = meta.execute();

			System.out.println(result.getResult());
			//media = media + result.getResult();

			// System.out.printf("%.10f /n",result.getResult());
			Particle.gBest = null;
			// System.out.println(result.getLastPosition());
		}

		System.out.println("");
		// System.out.println(media / 20);

	}
}
