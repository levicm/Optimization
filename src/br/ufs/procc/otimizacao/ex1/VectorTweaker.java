package br.ufs.procc.otimizacao.ex1;

import br.ufs.procc.otimizacao.hc.Tweaker;

public abstract class VectorTweaker extends Tweaker {

	protected double min;
	protected double max;
	protected double deltaMin;
	protected double deltaMax;

	public VectorTweaker(double min, double max, double deltaMin,
			double deltaMax) {
		this.min = min;
		this.max = max;
		this.deltaMin = deltaMin;
		this.deltaMax = deltaMax;
	}

}
