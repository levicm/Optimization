package br.ufs.procc.otimizacao.ex1;

import java.util.concurrent.ThreadLocalRandom;

import br.ufs.procc.otimizacao.Solution;

public class TweakerRandom extends VectorTweaker {

	public TweakerRandom(double min, double max, double deltaMin,
			double deltaMax) {
		super(min, max, deltaMin, deltaMax);
	}

	public Solution tweak(Solution solution) {
		double[] s = ((VectorSolution) solution).getData();
		int position = ThreadLocalRandom.current().nextInt(s.length);

		double[] result = new double[s.length];
		System.arraycopy(s, 0, result, 0, s.length);

		double d = 0;
		do {
			d = ThreadLocalRandom.current().nextDouble(deltaMin, deltaMax);
		} while (s[position] + d < min || s[position] + d > max);
		result[position] = s[position] + d;

		return new VectorSolution(result);
	}
}
