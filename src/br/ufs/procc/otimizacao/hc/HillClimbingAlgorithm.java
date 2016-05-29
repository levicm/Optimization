package br.ufs.procc.otimizacao.hc;

import br.ufs.procc.otimizacao.Algorithm;
import br.ufs.procc.otimizacao.Fitness;
import br.ufs.procc.otimizacao.Solution;

public class HillClimbingAlgorithm extends Algorithm {

	protected int repetitions;
	protected Tweaker tweaker;
	protected Fitness fitness;
	protected Solution solution;

	public HillClimbingAlgorithm(int repetitions, Tweaker tweaker,
			Fitness fitness, Solution solution) {
		this.repetitions = repetitions;
		this.tweaker = tweaker;
		this.fitness = fitness;
		this.solution = solution;
	}

	public Solution run() {
		Solution s = solution;
		int reps = 0;
		do {
			Solution r = tweaker.tweak(s);
			if (fitness.getResult(r) < fitness.getResult(s)) {
				s = r;
			}
		} while (reps++ < repetitions);
		return s;
	}
}
