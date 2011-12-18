package basic;


public abstract class AbstractDataReader implements DataReader {

	protected String comma = ",";
	protected String colon = ":";
	
	protected int timeInSecond(String field) {
		int time = 0;
		String[] stringTime = field.split(colon);
		if (stringTime.length == 3) {
			int h = Integer.parseInt(stringTime[0]);
			int m = Integer.parseInt(stringTime[1]);
			int s = Integer.parseInt(stringTime[2]);
			time = ((h * 60) + m) * 60 + s;
		}
		return time;
	}

}
