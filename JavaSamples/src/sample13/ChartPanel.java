// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package sample13;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class ChartPanel extends JPanel {
	private Chart chart;
	private LayoutMaker layoutMaker;
	private Timer timer;
	
	public ChartPanel(Chart chart, LayoutMaker layoutMaker) {
		this.chart = chart;
		this.layoutMaker = layoutMaker;
		this.timer = new Timer(33, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layoutChart();
			}
		});		
	}
	
	public void start() {
		timer.start();
	}
	
	public void stop() {
		timer.stop();
	}
	
	private void layoutChart() {
		layoutMaker.layout(chart);
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		chart.draw((Graphics2D)g);
	}
}
