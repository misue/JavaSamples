// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package visual.sample04;

import java.awt.Color;
import java.awt.Graphics2D;

public class Item {
	private final String label;
	double x = 0.0;
	double y = 0.0;
	
	private Color nodeColor = Color.blue;
	private Color labelColor = Color.white;
	private double itemSize = 0.1;
	
	public Item(String label) {
		this.label = label;
	}
	
	private void draw(Graphics2D g2, double scale, double centerX, double centerY, Color nodeColor, Color labelColor) {
		double r = itemSize * scale;
		int d = (int)(r * 2);
		int posX = (int)(centerX + scale * x);
		int posY = (int)(centerY + scale * y);
		Graphics2D g2tmp = (Graphics2D)g2.create();
		g2tmp.setColor(nodeColor);
		g2tmp.fillOval((int)(posX - r), (int)(posY - r), d, d);
		g2tmp.setColor(labelColor);
		g2tmp.drawString(label, (int)posX, (int)posY);
		g2tmp.dispose();
	}

	public void draw(Graphics2D g2, double scale, double centerX, double centerY) {
		draw(g2, scale, centerX, centerY, nodeColor, labelColor);
	}

}
