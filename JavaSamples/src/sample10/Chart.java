// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package sample10;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class Chart {
	private ArrayList<Item> itemSet = new ArrayList<Item>();
	private int itemSize = 30;
	
//	public Chart() {}
	
	public ArrayList<Item> getItemSet() {
		return itemSet;
	}
	
	public int getItemNum() {
		return itemSet.size();
	}
	
	public void setItemSize(int s) {
		itemSize = s;
	}
	
	public void entry(Item item) {
		itemSet.add(item);
	}	
	
	void draw(Graphics2D g2) {
		for (Item item: itemSet) {
			item.draw(g2, itemSize);
		}
	}
	
	public static Chart createSample(int n) {
		Chart chart = new Chart();
		for (int i = 0; i < n; i ++) {
			chart.entry(new Item(String.valueOf(i)));		
		}
		return chart;
	}
}

