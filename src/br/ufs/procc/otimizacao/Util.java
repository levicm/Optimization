package br.ufs.procc.otimizacao;

public class Util {

	public static void printVector(double[] vetor) {
		System.out.print("[");
		for (int i = 0; i < vetor.length; ++i) {
			if (i > 0) {
				System.out.print(", ");
			}
			System.out.print(vetor[i]);
		}
		System.out.println("]");
	}

	public static void printArray(double[][] array) {
		System.out.print("[");
		for (int i = 0; i < array.length; ++i) {
			for (int j = 0; j < array[0].length; ++j) {
				if (j > 0) {
					System.out.print(", ");
				}
				System.out.print(array[i][j]);
			}
			System.out.println(" ");
		}
		System.out.println("]");
	}

}
