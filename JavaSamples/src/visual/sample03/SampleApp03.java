// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package visual.sample03;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SampleApp03 extends JFrame {
	private static String cmdname = "SampleApp #03";
	private static int defaultItemNum = 7;
	private static Dimension frameSize = new Dimension(600, 400);
	private static Dimension canvasSize = new Dimension(800, 600);

	private SampleApp03() {
		super(cmdname);
	}
	
	private void init(int n) {
		Chart chart = Chart.createSample(n);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(canvasSize);				// canvasのサイズを指定する。		
		chartPanel.setBackground(new Color(chartPanel.getBackground().getRGB()));	// 背景色を再指定		
		JScrollPane scrollPane = new JScrollPane(chartPanel);	// canvasを含むスクロールペインを作る。
		this.getContentPane().add(scrollPane);				// スクロールペインをframeに追加する。
		LayoutMaker layoutMaker = new LayoutMaker(canvasSize);
		layoutMaker.layout(chart);
	}

	public static void main(final String[] args) {		
		final int n = (args.length > 0) ? Integer.valueOf(args[0]) : defaultItemNum;
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				SampleApp03 frame = new SampleApp03();
				frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				frame.init(n);
				frame.setSize(frameSize);
				frame.setVisible(true);
			}
		});
	}
}
