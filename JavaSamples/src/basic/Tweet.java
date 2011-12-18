package basic;


public class Tweet {
	private String keyword;
	private int timeInSecond = 0;
	private int category;

	public Tweet(String keyword, int time, int category) {
		this.keyword = keyword;
		this.timeInSecond = time;
		this.category = category;
	}
	
	public Tweet(String keyword, int time) {
		this(keyword, time, 0);
	}
	
	public String getKeyword() {
		return keyword;
	}
	
	public int getTime() {
		return timeInSecond;
	}

	public int getCategory() {
		return category;
	}
}
