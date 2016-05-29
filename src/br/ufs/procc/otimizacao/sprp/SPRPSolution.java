package br.ufs.procc.otimizacao.sprp;

import java.util.ArrayList;
import java.util.List;

import br.ufs.procc.otimizacao.Solution;

public class SPRPSolution extends Solution {

	private int startNode;
	private int targetNode;

	private List<Integer> path;
	private List<Double> length;
	private boolean complete;

	public SPRPSolution(int from, int to) {
		super();
		this.startNode = from;
		this.targetNode = to;
		this.path = new ArrayList<Integer>();
		this.length = new ArrayList<Double>();
		add(from, (double) 0);

	}

	public void add(Integer node, Double distance) {
		this.path.add(node);
		this.length.add(distance);
		if (node == targetNode) {
			setComplete(true);
		}
	}

	public int getStartNode() {
		return startNode;
	}

	public int getTargetNode() {
		return targetNode;
	}

	public List<Integer> getPath() {
		return path;
	}

	public List<Double> getLength() {
		return length;
	}

	public double getPathLength() {
		double result = 0;
		for (Double d : length) {
			result += d;
		}
		return result;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	@Override
	public Solution getCopy() {
		SPRPSolution result = (SPRPSolution) super.getCopy();
		result.path = new ArrayList<Integer>();
		result.path.addAll(this.path);
		result.length = new ArrayList<Double>();
		result.length.addAll(this.length);
		return result;
	}

	@Override
	public String toString() {
		// return "Path: " + getPath() + ". PathLength: " + getPathLength() +
		// ". Length: " + getLength();
//		return "Path: " + getPath() + ". PathLength: " + getPathLength();
		return String.valueOf(getPathLength());
	}
}
