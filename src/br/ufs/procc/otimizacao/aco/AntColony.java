package br.ufs.procc.otimizacao.aco;

import java.util.ArrayList;
import java.util.List;

public abstract class AntColony {

	private int numberOfAnts;
	private List<Ant> hive;
	private AntColonyEnvironment environment;

	public AntColony(AntColonyEnvironment environment, int numberOfAnts) {
		this.environment = environment;
		this.numberOfAnts = numberOfAnts;
		buildColony();
	}

	public void buildColony() {
		this.hive = new ArrayList<Ant>();
		for (int j = 0; j < numberOfAnts; j++) {
			hive.add(this.createAnt(environment));
		}
	}

	protected abstract Ant createAnt(AntColonyEnvironment environment);

	public AntColonyEnvironment getEnvironment() {
		return environment;
	}

	public List<Ant> getHive() {
		return hive;
	}

	public void buildSolutions() {
		for (Ant ant : hive) {
			ant.buildSolution(environment);
		}
	}

	public void clearSolutions() {
		for (Ant ant : hive) {
			ant.clear();
		}
	}
}
