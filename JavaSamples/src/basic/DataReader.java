package basic;

import java.util.ArrayList;

public interface DataReader {
	
	ArrayList<Tweet> read(String filename);

}