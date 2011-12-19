// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package visual.sample04;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class Chart {
	private ArrayList<Item> itemSet = new ArrayList<Item>();
	
//	public Chart() {}
	
	public ArrayList<Item> getItemSet() {
		return itemSet;
	}
	
	public void entry(Item item) {
		itemSet.add(item);
	}	
	
	void draw(Graphics2D g2, int width, int height) {
		int size = Math.min(width, height);
		double scale = size * 0.35;
		double centerX = width / 2.0;
		double centerY = height / 2.0;

		for (Item item: itemSet) {
			item.draw(g2, scale, centerX, centerY);
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
