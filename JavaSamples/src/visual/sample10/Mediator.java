// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package visual.sample10;

import java.awt.Dimension;
import java.io.File;

public class Mediator {
	private Chart chart;
	private final DataReader dataReader = new DataReader();
	private final LayoutMaker layoutMaker;
	private final ChartPanel canvas;
	
	public Mediator(ChartPanel canvas, Dimension area) {
		this.canvas = canvas;
		this.layoutMaker = new LayoutMaker(area);
	}
	
	public void readData(File file) {
		chart = dataReader.read(file);
		layoutChart();
		canvas.setChart(chart);
	}

	public void readData(String filename) {
		chart = dataReader.read(filename);
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
	
}
