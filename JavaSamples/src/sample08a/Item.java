// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package sample08a;

import java.awt.Color;
import java.awt.Graphics2D;

public class Item {
	private String label;
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
		Graphics2D g2tmp = (Graphics2D)g2.create();
		g2tmp.setColor(nodeColor);
		g2tmp.fillOval(x - size, y - size, d, d);
		g2tmp.setColor(labelColor);
		g2tmp.drawString(label, x, y);
		g2tmp.dispose();
	}

	public void draw(Graphics2D g2) {
		draw(g2, nodeColor, labelColor);
	}

}
