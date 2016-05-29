package br.ufs.procc.otimizacao.sprp.hc;

import java.util.concurrent.ThreadLocalRandom;

import br.ufs.procc.otimizacao.Solution;
import br.ufs.procc.otimizacao.hc.Tweaker;
import br.ufs.procc.otimizacao.sprp.SPRPRandomPathFinder;
import br.ufs.procc.otimizacao.sprp.SPRPSolution;

public class SPRPRandomTweaker extends Tweaker {

	private SPRPRandomPathFinder pathFinder;

	public SPRPRandomTweaker(SPRPRandomPathFinder pathFinder) {
		this.pathFinder = pathFinder;
	}

	@Override
	public Solution tweak(Solution s) {
		SPRPSolution solution = (SPRPSolution) s;
		SPRPSolution result = new SPRPSolution(solution.getStartNode(),
				solution.getTargetNode());
		int positionToChange = ThreadLocalRandom.current().nextInt(1,
				solution.getLength().size());
		for (int i = 1; i < positionToChange; ++i) {
			result.add(solution.getPath().get(i), solution.getLength().get(i));
		}
		pathFinder.run(result);
		return result;
	}

}
