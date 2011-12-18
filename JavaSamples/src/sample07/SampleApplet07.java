// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
// parameter
// file	../data/sample1.txt
package sample07; 

import java.awt.Dimension;

import javax.swing.JApplet;

@SuppressWarnings("serial")
public class SampleApplet07 extends JApplet {
	private final Framework framework;
	private static Dimension area = new Dimension(800, 600);

	public SampleApplet07() {
		framework = new Framework(this, area);
	}	
	
	@Override
	public void init() {
		framework.init();
	}

}
