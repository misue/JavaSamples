// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package visual.sample10;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class SampleApp10 extends JFrame {
	private static String cmdname = "SampleApp #10";
	private static Dimension canvasSize = new Dimension(800, 600);
	private final String initFilename;

	private SampleApp10(final String[] args) {
		super(cmdname);
		initFilename = (args.length > 0) ? args[0] : null;
	}
	
	private void init() {
		ChartPanel chartPanel = new ChartPanel();
		chartPanel.setPreferredSize(canvasSize);
		final Mediator mediator = new Mediator(chartPanel, canvasSize);
		
		JPanel ctrlPanel = new JPanel();
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, ctrlPanel, chartPanel);
		this.getContentPane().add(splitPane);

		// Setup Controls
		final JSlider slider = new JSlider();
		ctrlPanel.add(slider);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider s = (JSlider)e.getSource();
				mediator.changeSize(s.getValue());
			}
		});

		// Setup Menus
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);	
		FileMenuFactory menuFactory = new FileMenuFactory(mediator);
		JMenu menu = menuFactory.createMenu("File");
		menuBar.add(menu);

		if (initFilename != null) mediator.readData(initFilename);
	}	

	public static void main(final String[] args) {		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				SampleApp10 frame = new SampleApp10(args);
				frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				frame.init();
				frame.pack();
				frame.setVisible(true);			
			}
		});
	}
}
