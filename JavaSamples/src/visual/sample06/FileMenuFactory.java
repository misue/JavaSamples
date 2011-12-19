// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package visual.sample06;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
//import javax.swing.SwingUtilities;

public class FileMenuFactory {
	protected final Mediator mediator;
	
	public FileMenuFactory(Mediator mediator) {
		this.mediator = mediator;
	}

	public JMenu createMenu(String title) {
		JMenu menu = new JMenu(title);

		JMenuItem menuItem = new JMenuItem("Open ...");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        JFileChooser filechooser = new JFileChooser();

		        int selected = filechooser.showOpenDialog(null /* JFrame is necessary */);
		        if (selected == JFileChooser.APPROVE_OPTION) {
		            final File file = filechooser.getSelectedFile();
//		            System.out.println("1 On EDT:" + SwingUtilities.isEventDispatchThread());
		            new Thread(new Runnable() {
		            	@Override
		            	public void run() {
//		            		System.out.println("2 On EDT:" + SwingUtilities.isEventDispatchThread());
		            		mediator.readData(file);
		            	}		            	
		            }).start();
		            
		        }
			}
		});
		menu.add(menuItem);
		
       	return menu;
	}
	
	
//	public abstract class ActionCommand implements ActionListener {
////		protected Mediator m;
////		protected int param;
//
////		public ActionCommand(Mediator mediator, int param) {
////			this.m = mediator;
////			this.param = param;
////		}
//
//		public ActionCommand(Mediator mediator) {
////			this.m = mediator;
////			this.param = 0;
//		}
//
//		public abstract void actionPerformed(ActionEvent evt);
//	}
	
}
