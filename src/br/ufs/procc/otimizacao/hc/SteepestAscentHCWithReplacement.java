package br.ufs.procc.otimizacao.hc;

import br.ufs.procc.otimizacao.Fitness;
import br.ufs.procc.otimizacao.Solution;

public class SteepestAscentHCWithReplacement extends HillClimbingAlgorithm {

	public SteepestAscentHCWithReplacement(int repetitions, Tweaker tweaker,
			Fitness function, Solution solution) {
		super(repetitions, tweaker, function, solution);
	}

	@Override
	public Solution run() {
		int reps = 0;
		int samples = 20;
		int maxReps = repetitions / samples;
		Solution s = solution;
		Solution best = s;
		do {
			Solution r = tweaker.tweak(s);
			for (int i = 0; i < samples; ++i) {
				Solution w = tweaker.tweak(s);
				if (fitness.getResult(w) < fitness.getResult(r)) {
					r = w;
				}
			}
			s = r;
			if (fitness.getResult(s) < fitness.getResult(best)) {
				best = s;
			}
		} while (reps++ < maxReps);
		return best;
	}
}
