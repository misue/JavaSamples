// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package visual.sample06;

import java.awt.Dimension;
import java.io.File;

public class Mediator {
	private Chart chart;
	private final DataReader dataReader = new DataReader();
	private final LayoutMaker layoutMaker;
	private final ChartPanel chartPanel;
	
	public Mediator(ChartPanel chartPanel, Dimension area) {
		this.chartPanel = chartPanel;
		this.layoutMaker = new LayoutMaker(area);
	}
	
	public void readData(File file) {
		chart = dataReader.read(file);
		layoutChart();
		chartPanel.setChart(chart);
	}

	public void readData(String filename) {
		chart = dataReader.read(filename);
		layoutChart();
		chartPanel.setChart(chart);
	}
	
	public void layoutChart() {
		layoutMaker.layout(chart);
	}

}
