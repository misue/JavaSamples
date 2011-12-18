package basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataReaderCsv8 extends AbstractDataReader {

	public DataReaderCsv8() {
	}

	public ArrayList<Tweet> read(String filename) {
		ArrayList<Tweet> tweetList = new ArrayList<Tweet>();

		try {
			FileReader rawDataFile = new FileReader(filename);
			BufferedReader rawData = new BufferedReader(rawDataFile);
			while(rawData.ready()) {
				String line = rawData.readLine();
				String[] field = line.split(comma);
				if (field.length == 8) {
					Tweet tweet = createTweet(field);
					tweetList.add(tweet);
				}
			}

		} catch(IOException e) {
			e.printStackTrace();
		}
		return tweetList;
	}
	
	protected Tweet createTweet(String[] field) {
		return new Tweet(field[7], timeInSecond(field[3]));
//		return new Tweet(field[0], timeInSecond(field[3]));
	}

}
