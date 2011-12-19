// All Rights Reserved. Copyright (C) Kazuo Misue (2009-2010)
package visual.sample07;

import java.awt.Dimension;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class Framework {

	protected final JApplet jApplet;
	protected final JFrame jFrame;
	protected final String cmdname;
	private final Dimension canvasSize;

	protected Mediator mediator;
	protected String initFilename = null;

	public Framework(final JFrame jFrame, final String cmdname, final String[] args, final Dimension canvasSize) {
		this.jFrame = jFrame;
		this.jApplet = null;
		this.cmdname = cmdname;
		this.canvasSize = canvasSize;
		initFilename = (args.length > 0) ? args[0] : null;
	}

	public Framework(final JApplet jApplet, final Dimension canvasSize) {
		this.jApplet = jApplet;
		this.jFrame = null;
		this.cmdname = null;
		this.canvasSize = canvasSize;
	}

	public void init() {
		ChartPanel chartPanel = new ChartPanel();
		chartPanel.setPreferredSize(canvasSize);
		Mediator mediator = new Mediator(chartPanel, canvasSize);

		// Set up UI
		JMenuBar menuBar = new JMenuBar();
		FileMenuFactory menuFactory = new FileMenuFactory(mediator);
		JMenu menu = menuFactory.createMenu("File");
		menuBar.add(menu);
		
		if (jApplet != null) {
			jApplet.setJMenuBar(menuBar);
			jApplet.getContentPane().add(chartPanel);
			jApplet.setSize((int)canvasSize.getWidth(), (int)canvasSize.getHeight());
			initFilename = jApplet.getParameter("file");
		} else {
			jFrame.setJMenuBar(menuBar);
			jFrame.getContentPane().add(chartPanel);
		}
		
		if (initFilename != null) mediator.readData(initFilename);
	}

}
