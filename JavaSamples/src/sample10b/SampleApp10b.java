// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package sample10b;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class SampleApp10b extends JFrame {
	private static String cmdname = "SampleApp #10b";
	private static Dimension area = new Dimension(800, 600);
	private final String initFilename;

	public SampleApp10b(final String[] args) {
		super(cmdname);
		initFilename = (args.length > 0) ? args[0] : null;
	}
	
	private void init() {
		ChartPanel canvas = new ChartPanel();
		final Mediator mediator = new Mediator(canvas, area);

		// Setup Controls
		Box ctrlPanel = Box.createVerticalBox();
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, ctrlPanel, canvas);
		this.getContentPane().add(splitPane);
		JButton button = new JButton("Add Item");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mediator.addItem();
			}
		});		
		ctrlPanel.add(button);
		
		
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
				SampleApp10b frame = new SampleApp10b(args);
				frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				frame.setSize(area);
				frame.init();
				frame.setVisible(true);			
			}
		});
	}
}
