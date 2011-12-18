// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package sample02;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SampleApp02 extends JFrame {
	private static String cmdname = "SampleApp #02";
	private static int defaultItemNum = 7;
	private static Dimension canvasSize = new Dimension(800, 600);

	private SampleApp02() {
		super(cmdname);
	}
	
	private void init(int n) {
		Chart chart = Chart.createSample(n);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(canvasSize);
		this.getContentPane().add(chartPanel);
		LayoutMaker layoutMaker = new LayoutMaker(canvasSize);
		layoutMaker.layout(chart);
	}

	public static void main(final String[] args) {		
		final int n = (args.length > 0) ? Integer.valueOf(args[0]) : defaultItemNum;
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				SampleApp02 frame = new SampleApp02();
				frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				frame.init(n);
				frame.pack();
				frame.setVisible(true);
			}
		});
	}
}
