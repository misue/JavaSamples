// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package sample04;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ChartPanel extends JPanel {
	private Chart chart;
	
	public ChartPanel(Chart chart) {
		this.chart = chart;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		chart.draw((Graphics2D)g, getWidth(), getHeight());
	}
}
