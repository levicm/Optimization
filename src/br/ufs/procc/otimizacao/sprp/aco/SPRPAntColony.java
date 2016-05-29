package br.ufs.procc.otimizacao.sprp.aco;

import br.ufs.procc.otimizacao.aco.Ant;
import br.ufs.procc.otimizacao.aco.AntColony;
import br.ufs.procc.otimizacao.aco.AntColonyEnvironment;

public class SPRPAntColony extends AntColony {

	public SPRPAntColony(SPRPACOEnvironment environment, int numberOfAnts) {
		super(environment, numberOfAnts);
	}

	@Override
	protected Ant createAnt(AntColonyEnvironment environment) {
		SPRPACOEnvironment e = (SPRPACOEnvironment) environment;
		return new SPRPAnt(e.getStartNode(), e.getTargetNode());
	}
}
