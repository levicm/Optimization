package br.ufs.procc.otimizacao.ex1;

import java.util.concurrent.ThreadLocalRandom;

import br.ufs.procc.otimizacao.Solution;

public class TweakerUniform extends VectorTweaker {

	public TweakerUniform(double min, double max, double deltaMin,
			double deltaMax) {
		super(min, max, deltaMin, deltaMax);
	}

	public Solution tweak(Solution solution) {
		double[] s = ((VectorSolution) solution).getData();
		double[] result = new double[s.length];

		for (int i = 0; i < s.length; ++i) {
			double d = 0;
			do {
				d = ThreadLocalRandom.current().nextDouble(deltaMin, deltaMax);
			} while (s[i] + d < min || s[i] + d > max);
			result[i] = s[i] + d;
		}

		return new VectorSolution(result);
	}

}
