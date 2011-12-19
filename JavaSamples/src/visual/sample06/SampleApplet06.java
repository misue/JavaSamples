// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
// parameter
// file	../data/sample1.txt
package visual.sample06; 

import java.awt.Dimension;

import javax.swing.JApplet;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

@SuppressWarnings("serial")
public class SampleApplet06 extends JApplet {
	private static Dimension canvasSize = new Dimension(800, 600);
	private String initFilename;
	
	public SampleApplet06() {}
	
	@Override
	public void init() {
		this.setSize((int)canvasSize.getWidth(), (int)canvasSize.getHeight());
		
		ChartPanel canvas = new ChartPanel();
		this.getContentPane().add(canvas);
		Mediator mediator = new Mediator(canvas, canvasSize);
		
		initFilename = getParameter("file");
		if (initFilename != null) mediator.readData(initFilename);

		// Set up UI
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);	
		FileMenuFactory menuFactory = new FileMenuFactory(mediator);
		JMenu menu = menuFactory.createMenu("File");
		menuBar.add(menu);
	}

}
