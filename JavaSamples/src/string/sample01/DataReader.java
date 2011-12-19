// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package string.sample01;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataReader {
	private final String regex;
	private final Pattern p;

	public DataReader() {
		regex = "(\\d\\d\\d\\d)/(\\d\\d)/(\\d\\d) (\\d\\d):(\\d\\d):(\\d\\d)";
		p = Pattern.compile(regex);
	}

	public Calendar readDate(String line) {
		Calendar cal = null;
		Matcher m = p.matcher(line);
		if (m.find()) {
			int year = Integer.parseInt(m.group(1));
			int month = Integer.parseInt(m.group(2)) - 1;
			int day = Integer.parseInt(m.group(3));
			int hour = Integer.parseInt(m.group(4));
			int min = Integer.parseInt(m.group(5));
			int second = Integer.parseInt(m.group(6));
			
			cal = Calendar.getInstance();
			cal.set(year, month, day, hour, min, second);
		}
		return cal;
	}
}
