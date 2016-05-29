package br.ufs.procc.otimizacao.ex1;

import br.ufs.procc.otimizacao.Fitness;
import br.ufs.procc.otimizacao.Solution;

public class FunctionRastrigin extends Fitness {

	public double getResult(Solution solution) {
		double[] vetor = ((VectorSolution) solution).getData();
		double result = 0;
		for (int i = 0; i < vetor.length; ++i) {
			result += (vetor[i] * vetor[i]) - 10 * Math.cos(2 * Math.PI * vetor[i] + 10);
		}
		return result;
	}

}
