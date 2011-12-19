// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package visual.sample11;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;

public class Mediator {
	private Chart chart;
	private final DataReader dataReader = new DataReader();
	private final LayoutMaker layoutMaker;
	private final ChartPanel canvas;
	final Color defaultColor = Color.blue;
	
	public Mediator(ChartPanel canvas, Dimension area) {
		this.canvas = canvas;
		this.layoutMaker = new LayoutMaker(area);
	}
	
	private void createChart() {
		chart = new Chart(defaultColor);
		canvas.setChart(chart);
	}
	
	public void readData(File file) {
		chart = dataReader.read(file, defaultColor);
		layoutChart();
		canvas.setChart(chart);
	}

	public void readData(String filename) {
		chart = dataReader.read(filename, defaultColor);
		layoutChart();
		canvas.setChart(chart);
	}
	
	public void layoutChart() {
		layoutMaker.layout(chart);
	}

	public void addItem() {
		if (chart == null) {
			chart = new Chart();
			canvas.setChart(chart);
		}
		String label = String.valueOf(chart.getItemNum());
		chart.entry(new Item(label));
		layoutChart();
		canvas.repaint();
	}
	
	public void changeSize(int s) {
		if (chart != null) {
			chart.setItemSize(s);
			canvas.repaint();
		}
	}
	
	public void setItemColor(Color color) {
		if (chart == null) createChart();
		chart.setItemColor(color);
		canvas.repaint();
	}
	
}
