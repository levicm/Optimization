package br.ufs.procc.otimizacao.sprp.aco;

import java.io.File;
import java.io.IOException;

import br.ufs.procc.otimizacao.Util;
import br.ufs.procc.otimizacao.aco.ACOAlgorithm;
import br.ufs.procc.otimizacao.sprp.Network;
import br.ufs.procc.otimizacao.sprp.SPRPFitness;
import br.ufs.procc.otimizacao.sprp.SPRPSolution;

public class SPRPACOApp {

	public static final int START_NODE = 8;
	public static final int TARGET_NODE = 16;
	public static final int REPETITIONS = 1000;
	public static final int EXECUTIONS = 50;
	
	public static final int NUMBER_OF_ANTS = 4;

	public static void main(String[] args) throws IOException {
		Network network = new Network();
		network.readFile(new File("bayg29.tsp"));
		Util.printArray(network.getData());

		// ACO simples
		System.out.println("ACO com 3 formigas:");
		SPRPFitness fitness = new SPRPFitness();
/*		for (int i = 0; i < EXECUTIONS; i++) {
			SPRPACOEnvironment environment = new SPRPACOEnvironment(network,
					START_NODE, TARGET_NODE);
			SPRPAntColony colony = new SPRPAntColony(environment, 3);
			ACOAlgorithm algorithm = new ACOAlgorithm(colony, REPETITIONS, fitness);
			SPRPSolution solution = (SPRPSolution) algorithm.run();
//			System.out.println("Solução " + i + ": " + solution);
			System.out.println(solution);
		}

		System.out.println("ACO com 5 formigas:");
		for (int i = 0; i < EXECUTIONS; i++) {
			SPRPACOEnvironment environment = new SPRPACOEnvironment(network,
					START_NODE, TARGET_NODE);
			SPRPAntColony colony = new SPRPAntColony(environment, 5);
			ACOAlgorithm algorithm = new ACOAlgorithm(colony, REPETITIONS, fitness);
			SPRPSolution solution = (SPRPSolution) algorithm.run();
//			System.out.println("Solução " + i + ": " + solution);
			System.out.println(solution);
		}
*/		
		System.out.println("ACO com 10 formigas:");
		for (int i = 0; i < EXECUTIONS; i++) {
			SPRPACOEnvironment environment = new SPRPACOEnvironment(network,
					START_NODE, TARGET_NODE);
			SPRPAntColony colony = new SPRPAntColony(environment, 10);
			ACOAlgorithm algorithm = new ACOAlgorithm(colony, REPETITIONS, fitness);
			SPRPSolution solution = (SPRPSolution) algorithm.run();
//			System.out.println("Solução " + i + ": " + solution);
			System.out.println(solution);
		}
	}

}
