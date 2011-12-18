// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package sample11;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DataReader {

//	public DataReader() {}

	private Chart read(FileReader fileReader, Color defaultColor) throws IOException {
		Chart chart = new Chart(defaultColor);
		BufferedReader rawData = new BufferedReader(fileReader);
		while (rawData.ready()) {
			String line = rawData.readLine();
			chart.entry(new Item(line));
		}
		return chart;
	}

	public Chart read(File file, Color defaultColor) {
		Chart chart = null;
		try {
			chart = read(new FileReader(file), defaultColor);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return chart;
	}

	public Chart read(String filename, Color defaultColor) {
		Chart chart = null;
		try {
			chart = read(new FileReader(filename), defaultColor);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return chart;
	}

}
