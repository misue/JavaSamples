// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package sample10b;

import java.awt.Color;
import java.awt.Graphics2D;

public class Item {
	private final String label;
	int x = 0;
	int y = 0;
	int size = 0;
	
	private Color nodeColor = Color.blue;
	private Color labelColor = Color.white;
	
	public Item(String label) {
		this.label = label;
	}
	
	private void draw(Graphics2D g2, Color nodeColor, Color labelColor) {
		int d = size * 2;
		g2.setColor(nodeColor);
		g2.fillOval(x - size, y - size, d, d);
		g2.setColor(labelColor);
		g2.drawString(label, x, y);
	}

	public void draw(Graphics2D g2) {
		draw(g2, nodeColor, labelColor);
	}

}
