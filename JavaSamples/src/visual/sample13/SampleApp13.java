// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package visual.sample13;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SampleApp13 extends JFrame {
	private static String cmdname = "SampleApp #13";
	private static Dimension canvasSize = new Dimension(800, 600);
	private final String filename;

	public SampleApp13(final String[] args) {
		super(cmdname);
		filename = args[0];
	}
	
	private void init() {
		DataReader dataReader = new DataReader();
		LayoutMaker layoutMaker = new LayoutMaker(canvasSize);
		Chart chart = dataReader.read(filename);
		ChartPanel chartPanel = new ChartPanel(chart, layoutMaker);
		chartPanel.setPreferredSize(canvasSize);
		this.getContentPane().add(chartPanel);
		chartPanel.start();
	}

	public static void main(final String[] args) {		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				if (args.length > 0) {
					SampleApp13 frame = new SampleApp13(args);
					frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
					frame.init();
					frame.pack();
					frame.setVisible(true);
				}
			}
		});
	}
}
