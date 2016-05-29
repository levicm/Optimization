package br.ufs.procc.otimizacao.sprp;

import java.util.concurrent.ThreadLocalRandom;

public class SPRPRandomPathFinder {

	static public int MAX_DISTANCE = 80;
	private Network network;
	private int startNode;
	private int targetNode;

	public SPRPRandomPathFinder(Network network, int startNode, int targetNode) {
		this.network = network;
		this.startNode = startNode;
		this.targetNode = targetNode;
	}

	public SPRPSolution run() {
		return run(new SPRPSolution(startNode, targetNode));
	}

	public SPRPSolution run(SPRPSolution solution) {
		while (!solution.isComplete()) {
			int currentNode = solution.getPath().get(
					solution.getPath().size() - 1);
			int nextNode = getNextNode();
			if (nextNode != currentNode) {
				double distance = network.getDistance(currentNode, nextNode);
				if (distance > 0 && distance < MAX_DISTANCE) {
					solution.add(nextNode, distance);
				}
			}
		}
		return solution;
	}

	protected int getNextNode() {
		return ThreadLocalRandom.current()
				.nextInt(network.getData().length - 1);
	}

}
