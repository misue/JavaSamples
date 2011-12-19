// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package string.sample01;

import java.util.Calendar;

public class StringSample01 {

	void exec() {
		String pattern = "(\\d\\d\\d\\d)/(\\d\\d)/(\\d\\d) (\\d\\d):(\\d\\d):(\\d\\d)";
		DataReader dataReader = new DataReader(pattern);
		
		String line = "2011/12/19 01:23:45";
		Calendar date = dataReader.readDate(line);
		System.out.println(String.format("%1$tY-%1$tm-%1$td %1$tA %1$tH:%1$tM:%1$tS", date));
	}

	public static void main(final String[] args) {
		StringSample01 sample = new StringSample01();
		sample.exec();
	}
}