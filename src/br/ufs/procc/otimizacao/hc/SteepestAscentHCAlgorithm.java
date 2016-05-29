package br.ufs.procc.otimizacao.hc;

import br.ufs.procc.otimizacao.Fitness;
import br.ufs.procc.otimizacao.Solution;

public class SteepestAscentHCAlgorithm extends HillClimbingAlgorithm {

	public SteepestAscentHCAlgorithm(int repetitions, Tweaker tweaker,
			Fitness function, Solution solution) {
		super(repetitions, tweaker, function, solution);
	}

	@Override
	public Solution run() {
		int reps = 0;
		int samples = 20;
		int maxReps = repetitions / samples;
		Solution s = solution;
		do {
			Solution r = tweaker.tweak(s);
			for (int i = 0; i < samples; ++i) {
				Solution w = tweaker.tweak(s);
				if (fitness.getResult(w) < fitness.getResult(r)) {
					r = w;
				}
			}
			if (fitness.getResult(r) < fitness.getResult(s)) {
				s = r;
			}
		} while (reps++ < maxReps);
		return s;
	}
}
