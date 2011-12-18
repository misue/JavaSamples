// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package sample08;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
//import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SampleApp08 extends JFrame {
	private static String cmdname = "SampleApp #08";
	private static Dimension canvasSize = new Dimension(800, 600);
	private final String initFilename;

	public SampleApp08(final String[] args) {
		super(cmdname);
		initFilename = (args.length > 0) ? args[0] : null;
	}
	
	private void init() {
		ChartPanel chartPanel = new ChartPanel();
		chartPanel.setPreferredSize(canvasSize);
		chartPanel.setBackground(Color.lightGray);
		final Mediator mediator = new Mediator(chartPanel, canvasSize);

		// Setup Controls
		Box ctrlPanel = Box.createVerticalBox();
		JButton button = new JButton("Add Item");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            new Thread(new Runnable() {
	            	@Override
	            	public void run() {
	        			mediator.addItem();
	            	}		            	
	            }).start();	
			}
		});		
		ctrlPanel.add(button);
		
		Container pane = this.getContentPane();
		pane.setLayout(new BorderLayout());
	    pane.add(ctrlPanel, BorderLayout.WEST);
	    pane.add(chartPanel, BorderLayout.CENTER);
		

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
				SampleApp08 frame = new SampleApp08(args);
				frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				frame.init();
				frame.pack();
				frame.setVisible(true);			
			}
		});
	}
}
