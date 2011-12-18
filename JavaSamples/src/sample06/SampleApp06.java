// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package sample06;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SampleApp06 extends JFrame {
	private static String cmdname = "SampleApp #06";
	private static Dimension canvasSize = new Dimension(800, 600);
	private final String initFilename;

	private SampleApp06(final String[] args) {
		super(cmdname);
		initFilename = (args.length > 0) ? args[0] : null;
	}
	
	private void init() {
		ChartPanel chartPanel = new ChartPanel();
		chartPanel.setPreferredSize(canvasSize);
		this.getContentPane().add(chartPanel);
		Mediator mediator = new Mediator(chartPanel, canvasSize);
		if (initFilename != null) mediator.readData(initFilename);

		// Set up UI
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);	
		FileMenuFactory menuFactory = new FileMenuFactory(mediator);
		JMenu menu = menuFactory.createMenu("File");
		menuBar.add(menu);
	}

	public static void main(final String[] args) {		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				SampleApp06 frame = new SampleApp06(args);
				frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				frame.init();
				frame.pack();
				frame.setVisible(true);			
			}
		});
	}
}
