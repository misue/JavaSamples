// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package sample04;

import java.util.ArrayList;

public class LayoutMaker {
	
//	public LayoutMaker() { }

	public void layout(Chart chart) {
		ArrayList<Item> itemSet = chart.getItemSet();
		int itemNum = itemSet.size();
		double unitAngle = Math.PI * 2.0 / itemNum;
		
		int count = 0;
		for (Item item: itemSet) {
			double angle = unitAngle * count;
			item.x = Math.cos(angle);
			item.y = Math.sin(angle);
			count ++;
		}
	}

}
