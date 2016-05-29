package br.ufs.procc.otimizacao.ex1;

import br.ufs.procc.otimizacao.Solution;

public class VectorSolution extends Solution {

	private double[] data;

	public VectorSolution(double[] data) {
		this.data = data;
	}

	public double[] getData() {
		return data;
	}

	@Override
	public boolean isComplete() {
		return true;
	}

}
