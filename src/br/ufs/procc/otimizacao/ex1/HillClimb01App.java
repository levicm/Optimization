package br.ufs.procc.otimizacao.ex1;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.concurrent.ThreadLocalRandom;

import br.ufs.procc.otimizacao.Algorithm;
import br.ufs.procc.otimizacao.Fitness;
import br.ufs.procc.otimizacao.hc.HillClimbingAlgorithm;
import br.ufs.procc.otimizacao.hc.SteepestAscentHCAlgorithm;
import br.ufs.procc.otimizacao.hc.SteepestAscentHCWithReplacement;
import br.ufs.procc.otimizacao.hc.Tweaker;

public class HillClimb01App {

	public static double MIN = -100;
	public static double MAX = 100;
	public static int SIZE = 100;
	public static int REPETITIONS = 10000;

	public static double DELTA_MIN = -2;
	public static double DELTA_MAX = 2;

	public static String fileName = "Execucoes-Levi Mota.txt";

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// PrintStream ps = new PrintStream(new File(fileName));
		PrintStream ps = System.out;

		VectorSolution s = getInitialSolution();
		runFunction(s, new FunctionSphere(), ps);

		runFunction(s, new FunctionRastrigin(), ps);

		ps.close();
	}

	private static void runFunction(VectorSolution s, Fitness fitness,
			PrintStream ps) {
		// Variação 1
		Tweaker tweaker = new TweakerUniform(MIN, MAX, DELTA_MIN, DELTA_MAX);
		Algorithm algorithm = new HillClimbingAlgorithm(REPETITIONS, tweaker,
				fitness, s);
		for (int i = 0; i < 20; ++i) {
			ps.println(fitness.getResult(algorithm.run()));
		}
		ps.println();
		// Variação 2
		algorithm = new SteepestAscentHCAlgorithm(REPETITIONS, tweaker,
				fitness, s);
		for (int i = 0; i < 20; ++i) {
			ps.println(fitness.getResult(algorithm.run()));
		}
		ps.println();
		// Variação 3
		algorithm = new SteepestAscentHCWithReplacement(REPETITIONS, tweaker,
				fitness, s);
		for (int i = 0; i < 20; ++i) {
			ps.println(fitness.getResult(algorithm.run()));
		}
		ps.println();
		// Variação 4
		tweaker = new TweakerRandom(MIN, MAX, DELTA_MIN, DELTA_MAX);
		algorithm = new HillClimbingAlgorithm(REPETITIONS, tweaker,
				fitness, s);
		for (int i = 0; i < 20; ++i) {
			ps.println(fitness.getResult(algorithm.run()));
		}
		ps.println();
		// Variação 5
		algorithm = new SteepestAscentHCAlgorithm(REPETITIONS, tweaker,
				fitness, s);
		for (int i = 0; i < 20; ++i) {
			ps.println(fitness.getResult(algorithm.run()));
		}
		ps.println();
		// Variação 6
		algorithm = new SteepestAscentHCWithReplacement(REPETITIONS, tweaker,
				fitness, s);
		for (int i = 0; i < 20; ++i) {
			ps.println(fitness.getResult(algorithm.run()));
		}
		ps.println();
	}

	private static VectorSolution getInitialSolution() {
		double[] vetor = new double[SIZE];
		for (int i = 0; i < vetor.length; ++i) {
			vetor[i] = ThreadLocalRandom.current().nextDouble(MIN, MAX);
		}
		return new VectorSolution(vetor);
	}
}
