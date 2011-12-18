// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package sample01;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SampleApp01 extends JFrame {
	private static String cmdname = "SampleApp #01";
	private static int itemNum = 7;
	private static Dimension canvasSize = new Dimension(800, 600);

	private SampleApp01() {
		super(cmdname);
	}
	
	private void init() {
		Chart chart = Chart.createSample(itemNum);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(canvasSize);
		this.getContentPane().add(chartPanel);
		LayoutMaker layoutMaker = new LayoutMaker(canvasSize);
		layoutMaker.layout(chart);
	}

	public static void main(final String[] args) {		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				SampleApp01 frame = new SampleApp01();
				frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				frame.init();
				frame.pack();
				frame.setVisible(true);
			}
		});
	}
}