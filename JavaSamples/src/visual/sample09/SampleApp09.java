// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package visual.sample09;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SampleApp09 extends JFrame {
	private static String cmdname = "SampleApp #09";
	private static Dimension canvasSize = new Dimension(800, 600);
	private final String initFilename;
	private final Color color1 = Color.red;
	private final Color color2 = Color.blue;

	private SampleApp09(final String[] args) {
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
		JRadioButton buttonRed = new JRadioButton("Red", (mediator.defaultColor == color1));
		buttonRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mediator.setItemColor(color1);
			}
		});		
		ctrlPanel.add(buttonRed);
		
		JRadioButton buttonBlue = new JRadioButton("Blue", (mediator.defaultColor == color2));
		buttonBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mediator.setItemColor(color2);
			}
		});		
		ctrlPanel.add(buttonBlue);
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(buttonRed);
		buttonGroup.add(buttonBlue);

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
				SampleApp09 frame = new SampleApp09(args);
				frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				frame.init();
				frame.pack();
				frame.setVisible(true);			
			}
		});
	}
}