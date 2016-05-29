package br.ufs.procc.otimizacao.sprp.aco;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import br.ufs.procc.otimizacao.Solution;
import br.ufs.procc.otimizacao.aco.Ant;
import br.ufs.procc.otimizacao.aco.AntColonyEnvironment;
import br.ufs.procc.otimizacao.sprp.SPRPSolution;

public class SPRPAnt extends Ant {

	static public int MAX_DISTANCE = 80;
	private SPRPSolution solution;
	private int currentNode;

	public SPRPAnt(int startNode, int targetNode) {
		this.solution = new SPRPSolution(startNode, targetNode);
	}

	@Override
	public Solution getSolution() {
		return solution;
	}

	public void buildSolution(AntColonyEnvironment e) {
		SPRPACOEnvironment environment = (SPRPACOEnvironment) e;
		currentNode = solution.getStartNode();

		int tries = 0;
		while (!solution.isComplete()) {
			// Obtém os alcançáveis a partir do corrente
			List<Integer> neighbourhood = getNeighbourhood(environment);
			List<Double> probabilties = new ArrayList<Double>();

			// Calcula as probabilidades pra cada alcançável e acumula
			double total = 0;
			for (Integer neighbour : neighbourhood) {
				double p = environment.getProbability(currentNode, neighbour);
				probabilties.add(p);
				total += p;
			}
			// Sorteia pra qual alcançável irá andar, usando a prob. como peso
			// Algoritmo 30 do Essentials
			double random = ThreadLocalRandom.current().nextDouble(total);
			total = 0;
			for (int i = 0; i < neighbourhood.size(); ++i) {
				Integer neighbour = neighbourhood.get(i);
				Double p = probabilties.get(i);
				total += p;
				if (total >= random) {
					solution.add(neighbour, environment.getNetwork()
							.getDistance(currentNode, neighbour));
					currentNode = neighbour;
					break;
				}
			}
			// Se andou o dobro do tamanho do ambiente, desiste
			if (tries++ > environment.getNetwork().getData().length * 2) {
				return;
			}
		}
		// Apenas se completou, deposita os feromônios
		for (int i = 0; i < solution.getPath().size() - 1; ++i) {
			environment.depositPheromone(solution.getPath().get(i), solution
					.getPath().get(i + 1));
		}
	}

	/**
	 * Retorna os nós alcançaveis a partir do corrente.
	 * 
	 * @param e
	 * @return
	 */
	public List<Integer> getNeighbourhood(AntColonyEnvironment e) {
		SPRPACOEnvironment environment = (SPRPACOEnvironment) e;
		List<Integer> result = new ArrayList<Integer>();
		double[][] data = environment.getNetwork().getData();

		for (int i = 0; i < data.length; ++i) {
			double distance = environment.getNetwork().getDistance(currentNode,
					i);
			if (distance > 0 && distance < MAX_DISTANCE) {
				result.add(i);
			}
		}
		return result;
	}

	@Override
	public void clear() {
		this.solution = new SPRPSolution(solution.getStartNode(),
				solution.getTargetNode());
	}
}
