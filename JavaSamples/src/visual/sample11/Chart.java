// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package visual.sample11;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Chart {
	private ArrayList<Item> itemSet = new ArrayList<Item>();
	private int itemSize = 30;
	private Color nodeColor = Color.red;
	private Color labelColor = Color.white;
	
	public Chart(Color nodeColor) {
		if (nodeColor != null) this.nodeColor = nodeColor; 
	}
	
	public Chart() {		
	}
	
	public ArrayList<Item> getItemSet() {
		return itemSet;
	}
	
	public int getItemNum() {
		return itemSet.size();
	}
	
	public void setItemSize(int s) {
		itemSize = s;
	}
	
	public void setItemColor(Color color) {
		nodeColor = color;
	}
	
	public void entry(Item item) {
		itemSet.add(item);
	}	
	
	public void draw(Graphics2D g2) {
		for (Item item: itemSet) {
			item.draw(g2, itemSize, nodeColor, labelColor);
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

