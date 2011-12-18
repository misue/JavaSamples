// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package sample06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DataReader {

//	public DataReader() {}

	private Chart read(FileReader fileReader) throws IOException {
		Chart chart = new Chart();
		BufferedReader rawData = new BufferedReader(fileReader);
		while (rawData.ready()) {
			String line = rawData.readLine();
			chart.entry(new Item(line));
		}
		return chart;
	}

	public Chart read(File file) {
		Chart chart = null;
		try {
			chart = read(new FileReader(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return chart;
	}

	public Chart read(String filename) {
		Chart chart = null;
		try {
			chart = read(new FileReader(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return chart;
	}

}
