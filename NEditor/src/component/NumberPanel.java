package component;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class NumberPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int rows;
	int hoff=1;

	public NumberPanel() {
		super();
		setLayout(null);
		rows = MainFrame.lines;
		setSize(18, MainFrame.lines*17);
	}

	public void paintComponent(Graphics g) {
		removeAll();
		
		rows = MainFrame.lines;
		setSize(18, rows*17);
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, getWidth(), getHeight());

		for (int i = 1; i <= rows; i++) {
			NumberLabel l = new NumberLabel(i + "");
			l.setLocation(0, 17 * (i - 1));
			add(l);
		}
	}
}
