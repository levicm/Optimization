package br.ufs.procc.otimizacao.sprp.aco;

import br.ufs.procc.otimizacao.aco.AntColonyEnvironment;
import br.ufs.procc.otimizacao.sprp.Network;

public class SPRPACOEnvironment extends AntColonyEnvironment {

	private Network network;
	private int startNode;
	private int targetNode;

	public SPRPACOEnvironment(Network network, int startNode, int targetNode) {
		super(network.getData().length, network.getData()[0].length);
		this.network = network;
		this.startNode = startNode;
		this.targetNode = targetNode;
	}

	public Network getNetwork() {
		return network;
	}

	public int getStartNode() {
		return startNode;
	}

	public int getTargetNode() {
		return targetNode;
	}
	
	@Override
	public double getHeuristicValue(int from, int to) {
		return 1 / network.getDistance(from, to);
	}

}
