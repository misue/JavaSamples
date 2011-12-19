// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package visual.sample12;

import java.awt.Color;
import java.awt.Graphics2D;

public class Item {
	private final String label;
	int x = 0;
	int y = 0;
	int size = 0;
	boolean selected = false;
	
	private Color nodeColor = Color.blue;
	private Color labelColor = Color.white;
	private Color selectedColor = Color.yellow;
	
	public Item(String label) {
		this.label = label;
	}
	
	public boolean isPointed(int px, int py) {
		double dx = x - px;
		double dy = y - py;
		return (dx * dx + dy * dy) <= (size * size);
	}
	
	private void draw(Graphics2D g2, Color nodeColor, Color labelColor) {
		int d = size * 2;
		Graphics2D g2tmp = (Graphics2D)g2.create();
		g2tmp.setColor(selected ? selectedColor : nodeColor);
		g2tmp.fillOval(x - size, y - size, d, d);
		g2tmp.setColor(labelColor);
		g2tmp.drawString(label, x, y);
		g2tmp.dispose();
	}

	public void draw(Graphics2D g2) {
		draw(g2, nodeColor, labelColor);
	}

}
