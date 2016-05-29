package br.ufs.procc.otimizacao.aco;

import java.util.List;

import br.ufs.procc.otimizacao.Algorithm;
import br.ufs.procc.otimizacao.Fitness;
import br.ufs.procc.otimizacao.Solution;

public class ACOAlgorithm extends Algorithm {

	private AntColony antColony;
	private int numberOfIterations;
	private Solution bestSolution;
	private double bestSolutionQuality;
	private Fitness fitness;

	public ACOAlgorithm(AntColony antColony, int numberOfIterations,
			Fitness fitness) {
		this.antColony = antColony;
		this.numberOfIterations = numberOfIterations;
		this.fitness = fitness;
	}

	public AntColony getAntColony() {
		return antColony;
	}

	@Override
	public Solution run() {
		int iteration = 0;
		while (iteration < numberOfIterations) {
			antColony.clearSolutions();
			antColony.buildSolutions();
			antColony.getEnvironment().evaporateAllPheromones();

			updateBestSolution();
			iteration++;
		}
		return bestSolution;
	}

	private void updateBestSolution() {
		Ant bestAnt = getBestPerformingAnt();
		if (bestAnt != null) {
			double quality = fitness.getResult(bestAnt.getSolution());
			if (bestSolution == null || bestSolutionQuality > quality) {
				bestSolution = (Solution) bestAnt.getSolution().getCopy();
				bestSolutionQuality = quality;
			}
		}
	}

	public Ant getBestPerformingAnt() {
		List<Ant> hive = antColony.getHive();
		Ant bestAnt = null;
		for (Ant ant : hive) {
			if (ant.getSolution().isComplete()) {
				if (bestAnt == null
						|| fitness.getResult(ant.getSolution()) < fitness
								.getResult(bestAnt.getSolution())) {
					bestAnt = ant;
				}
			}
		}
		return bestAnt;
	}

}
