// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package sample01b;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

public class LayoutMaker {
	private final double centerX;
	private final double centerY;
	private final double radius;
	private final int itemSize;

	public LayoutMaker(Dimension area) {
		centerX = area.getWidth() / 2.0;
		centerY = area.getHeight() / 2.0;
		radius = Math.min(area.getWidth(), area.getHeight()) * 0.35;
		itemSize = (int)(radius / 10.0);
	}

	public void layout(Chart chart) {
		ArrayList<Item> itemSet = chart.getItemSet();
		int itemNum = itemSet.size();
		double unitAngle = Math.PI * 2.0 / itemNum;
		
		int count = 0;
		for (Item item: itemSet) {
			layoutItem(item, unitAngle * count, itemSize);
			count ++;
		}
	}

	private void layoutItem(Item item, Double angle, int size) {
		item.x = (int)(centerX + radius * Math.cos(angle));
		item.y = (int)(centerY + radius * Math.sin(angle));
		item.size = size;
		item.nodeColor = new Color(Color.HSBtoRGB((float)(angle / (2.0 * Math.PI)), 1.0f, 1.0f));
	}
	
}
