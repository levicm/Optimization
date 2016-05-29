package br.ufs.procc.otimizacao.aco;

import br.ufs.procc.otimizacao.Solution;

public abstract class Ant {

	public abstract Solution getSolution();

	public abstract void buildSolution(AntColonyEnvironment environment);

	public abstract void clear();
}
