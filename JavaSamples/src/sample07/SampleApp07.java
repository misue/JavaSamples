// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package sample07;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SampleApp07 extends JFrame {
	private final Framework framework;
	private static String cmdname = "SampleApp #07";
	private static Dimension canvasSize = new Dimension(800, 600);
	
	private SampleApp07(final String[] args) {
		framework = new Framework(this, cmdname, args, canvasSize);
	}	
	
	private void init() {
		framework.init();
	}

	public static void main(final String[] args) {		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				SampleApp07 frame = new SampleApp07(args);
				frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				frame.init();
				frame.pack();
				frame.setVisible(true);			
			}
		});
	}
}
