// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package visual.sample13;

import java.awt.Dimension;
import java.util.ArrayList;

public class LayoutMaker {
	private final double centerX;
	private final double centerY;
	private final double radius;
	private final int itemSize;
	private final int rotateUnit = 3;
	private int rotateDegree = 0;

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
		double rotateAngle = Math.PI * rotateDegree / 180.0;
		
		int count = 0;
		for (Item item: itemSet) {
			layoutItem(item, unitAngle * count + rotateAngle, itemSize);
			count ++;
		}
		rotateDegree += rotateUnit;
		if (rotateDegree >= 360) rotateDegree -= 360;
	}
	
	private void layoutItem(Item item, Double angle, int size) {
		item.x = (int)(centerX + radius * Math.cos(angle));
		item.y = (int)(centerY + radius * Math.sin(angle));
		item.size = size;
	}

}
