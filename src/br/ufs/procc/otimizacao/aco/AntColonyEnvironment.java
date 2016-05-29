package br.ufs.procc.otimizacao.aco;

public abstract class AntColonyEnvironment {

	private double[][] pheromone;

	private double heuristicImportance = 0.5;
	private double pheromoneImportance = 0.7;

	private double initialPheromone = 0.1;
	private double maxPheromone = 2;
	private double pheromoneFactor = 0.3;
	private double evaporationRatio = 0.1;

	public AntColonyEnvironment(int width, int height) {
		this.pheromone = new double[width][height];
		initializePheromones();
	}

	public double[][] getPheromonio() {
		return pheromone;
	}

	public double getPheromone(int from, int to) {
		if (to > from) {
			return pheromone[from][to];
		} else {
			return pheromone[to][from];
		}
	}

	public double depositPheromone(int from, int to) {
		if (to > from) {
			pheromone[from][to] = Math.min(maxPheromone, pheromone[from][to]
					+ pheromoneFactor);
		} else {
			pheromone[to][from] = Math.min(maxPheromone, pheromone[to][from]
					+ pheromoneFactor);
		}
		return getPheromone(from, to);
	}

	public void evaporateAllPheromones() {
		for (int i = 0; i < pheromone.length; ++i) {
			for (int j = 0; j < pheromone[0].length; ++j) {
				pheromone[i][j] = Math.max(initialPheromone, pheromone[i][j]
						- evaporationRatio);
			}
		}
	}

	public void initializePheromones() {
		for (int i = 0; i < pheromone.length; ++i) {
			for (int j = 0; j < pheromone[0].length; ++j) {
				pheromone[i][j] = initialPheromone;
			}
		}
	}

	public double getProbability(int from, int to) {
		double heuristicValue = getHeuristicValue(from, to);
		double pheromoneValue = getPheromone(from, to);

		double result = Math.pow(heuristicValue, getHeuristicImportance())
				* Math.pow(pheromoneValue, getPheromoneImportance());
		return result;
	}

	public double getHeuristicValue(int from, int to) {
		return 1;
	}

	public double getHeuristicImportance() {
		return this.heuristicImportance;
	}

	public void setHeuristicImportance(double heuristicImportance) {
		this.heuristicImportance = heuristicImportance;
	}

	public double getPheromoneImportance() {
		return this.pheromoneImportance;
	}

	public void setPheromoneImportance(double pheromoneImportance) {
		this.pheromoneImportance = pheromoneImportance;
	}
}
