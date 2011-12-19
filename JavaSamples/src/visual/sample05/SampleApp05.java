// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package visual.sample05;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SampleApp05 extends JFrame {
	private static String cmdname = "SampleApp #05";
	private static Dimension canvasSize = new Dimension(800, 600);
	private final String filename;

	public SampleApp05(final String[] args) {
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
					SampleApp05 frame = new SampleApp05(args);
					frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
					frame.init();
					frame.pack();
					frame.setVisible(true);
				}
			}
		});
	}
}
