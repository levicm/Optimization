package br.ufs.procc.otimizacao.sprp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Network {

	private double[][] data;

	public Network() {
	}

	public void readFile(File file) throws IOException {
		BufferedReader reader = null;
		try {
			data = null;
			reader = new BufferedReader(new FileReader(file));
			int lines = 0;
			String line = reader.readLine();
			while (line != null && line.length() > 0) {
				String[] tokens = line.trim().split("\\s+");
				if (data == null) {
					data = new double[tokens.length + 1][tokens.length + 1];
				}
				for (int i = 0; i < tokens.length; ++i) {
					data[lines][lines + i + 1] = Double.parseDouble(tokens[i]);
				}

				lines++;
				line = reader.readLine();
			}
			;

		} finally {
			if (reader != null) {
				reader.close();
			}
		}

	}

	public double[][] getData() {
		return data;
	}

	public double getDistance(int from, int to) {
		if (from > to && from < data.length) {
			return data[to][from];
		} else if (to < data.length) {
			return data[from][to];
		}
		return -1;
	}

}
