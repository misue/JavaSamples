// All Rights Reserved. Copyright (C) Kazuo Misue (2011)
package visual.sample12;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;


@SuppressWarnings("serial")
public class ChartPanel extends JPanel {
	private Chart chart;
	private Item selectedItem = null;
	
	public ChartPanel(Chart chart) {
		this.chart = chart;
		addMouseListener( new BasicMouseListener());
		addMouseMotionListener(new BasicMouseMotionListener());
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		chart.draw((Graphics2D)g);
	}

	
	public class BasicMouseListener extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			Item pointedItem = chart.findItem(e.getX(), e.getY());
			if (selectedItem != null) {
				selectedItem.selected = false;
				selectedItem = null;
			}
			if (pointedItem != null) {
				selectedItem = pointedItem;
				selectedItem.selected = true;
			}
			e.consume();
			repaint();
		}

	}

	public class BasicMouseMotionListener extends MouseMotionAdapter {
	}

}
