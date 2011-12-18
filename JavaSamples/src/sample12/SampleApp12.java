// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package sample12;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SampleApp12 extends JFrame {
	private static String cmdname = "SampleApp #12";
	private static Dimension canvasSize = new Dimension(800, 600);
	private final String filename;

	public SampleApp12(final String[] args) {
		super(cmdname);
		filename = args[0];
	}
	
	private void init() {
		DataReader dataReader = new DataReader();
		Chart chart = dataReader.read(filename);
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
				if (args.length > 0) {
					SampleApp12 frame = new SampleApp12(args);
					frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
					frame.init();
					frame.pack();
					frame.setVisible(true);
				}
			}
		});
	}
}
