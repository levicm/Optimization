package br.ufs.procc.otimizacao;

public abstract class Solution implements Cloneable {

	public Solution getCopy() {
		try {
			return (Solution) clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	public abstract boolean isComplete();

}
