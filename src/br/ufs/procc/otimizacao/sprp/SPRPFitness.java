package br.ufs.procc.otimizacao.sprp;

import br.ufs.procc.otimizacao.Fitness;
import br.ufs.procc.otimizacao.Solution;

public class SPRPFitness extends Fitness {

	@Override
	public double getResult(Solution s) {
		double result = -1;
		if (s instanceof SPRPSolution) {
			if (((SPRPSolution) s).isComplete()) {
				result = ((SPRPSolution) s).getPathLength();
			}
		}
		return result;
	}

}
