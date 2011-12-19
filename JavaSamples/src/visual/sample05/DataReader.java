// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package visual.sample05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataReader {

//	public DataReader() {}

	public Chart read(String filename) {
		Chart chart = new Chart();

		try {
			FileReader rawDataFile = new FileReader(filename);
			BufferedReader rawData = new BufferedReader(rawDataFile);
			while(rawData.ready()) {
				String line = rawData.readLine();
				chart.entry(new Item(line));
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		return chart;
	}

}
