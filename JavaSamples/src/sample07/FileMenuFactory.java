// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package sample07;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

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
		            new Thread(new Runnable() {
		            	@Override
		            	public void run() {
		            		mediator.readData(file);
		            	}		            	
		            }).start();
		            
		        }
			}
		});
		menu.add(menuItem);
		
       	return menu;
	}
	
}
