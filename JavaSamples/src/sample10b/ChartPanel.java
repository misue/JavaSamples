// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package sample10b;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ChartPanel extends JPanel {
	private Chart chart = null;
	
	public ChartPanel(Chart chart) {
		this.chart = chart;
	}
	
	public ChartPanel() {
		this(null);
	}
	
	public void setChart(Chart chart) {
		this.chart = chart;
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (chart != null) chart.draw((Graphics2D)g);
	}
}
