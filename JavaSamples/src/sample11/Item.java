// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package sample11;

import java.awt.Color;
import java.awt.Graphics2D;

public class Item {
	private final String label;
	int x = 0;
	int y = 0;
	
	private Color nodeColor = Color.blue;
	private Color labelColor = Color.white;
	
	public Item(String label) {
		this.label = label;
	}
	
	void draw(Graphics2D g2, int size, Color nodeColor, Color labelColor) {
		int d = size * 2;
		Graphics2D g2tmp = (Graphics2D)g2.create();
		g2tmp.setColor(nodeColor);
		g2tmp.fillOval(x - size, y - size, d, d);
		g2tmp.setColor(labelColor);
		g2tmp.drawString(label, x, y);
		g2tmp.dispose();
	}

	public void draw(Graphics2D g2, int size) {
		draw(g2, size, nodeColor, labelColor);
	}

}
