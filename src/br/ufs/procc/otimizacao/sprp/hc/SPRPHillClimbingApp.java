package br.ufs.procc.otimizacao.sprp.hc;

import java.io.File;
import java.io.IOException;

import br.ufs.procc.otimizacao.Util;
import br.ufs.procc.otimizacao.hc.HillClimbingAlgorithm;
import br.ufs.procc.otimizacao.hc.SteepestAscentHCAlgorithm;
import br.ufs.procc.otimizacao.hc.SteepestAscentHCWithReplacement;
import br.ufs.procc.otimizacao.sprp.Network;
import br.ufs.procc.otimizacao.sprp.SPRPFitness;
import br.ufs.procc.otimizacao.sprp.SPRPRandomPathFinder;
import br.ufs.procc.otimizacao.sprp.SPRPSolution;

public class SPRPHillClimbingApp {

	public static final int START_NODE = 8;
	public static final int TARGET_NODE = 16;
	public static final int REPETITIONS = 1000;
	public static final int EXECUTIONS = 50;

	public static void main(String[] args) throws IOException {
		Network network = new Network();
		network.readFile(new File("bayg29.tsp"));
		Util.printArray(network.getData());

		SPRPRandomPathFinder pathFinder = new SPRPRandomPathFinder(network,
				START_NODE, TARGET_NODE);
		SPRPSolution initial = getInitialSolution(pathFinder);
		System.out.println("Solução inicial: " + initial);

		// HillClimbing simples
		System.out.println("HillClimbing simples:");
		SPRPRandomTweaker tweaker = new SPRPRandomTweaker(pathFinder);
		SPRPFitness fitness = new SPRPFitness();
		HillClimbingAlgorithm algorithm = new HillClimbingAlgorithm(
				REPETITIONS, tweaker, fitness, initial);
		for (int i = 0; i < EXECUTIONS; i++) {
			SPRPSolution solution = (SPRPSolution) algorithm.run();
//			System.out.println("Solução " + i + ": " + solution);
			System.out.println(solution);
		}

		// HillClimbing SteepestAscent
		System.out.println("HillClimbing SteepestAscent:");
		algorithm = new SteepestAscentHCAlgorithm(REPETITIONS, tweaker,
				fitness, initial);
		for (int i = 0; i < EXECUTIONS; i++) {
			SPRPSolution solution = (SPRPSolution) algorithm.run();
//			System.out.println("Solução " + i + ": " + solution);
			System.out.println(solution);
		}

		// HillClimbing SteepestAscentHCWithReplacement
		System.out.println("HillClimbing SteepestAscentHCWithReplacement:");
		algorithm = new SteepestAscentHCWithReplacement(REPETITIONS, tweaker,
				fitness, initial);
		for (int i = 0; i < EXECUTIONS; i++) {
			SPRPSolution solution = (SPRPSolution) algorithm.run();
//			System.out.println("Solução " + i + ": " + solution);
			System.out.println(solution);
		}
	}

	private static SPRPSolution getInitialSolution(
			SPRPRandomPathFinder pathFinder) {
		return pathFinder.run();
	}
}
