package component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

//该类实现右键好友时的自定义弹出菜单
public class MyPopupMenu extends JPopupMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyPopupMenu() {
		setBorder(new GrayRectBorder());
		setBackground(new Color(241, 241, 241));
	}

	public class MyMenuItem extends JMenuItem {
		boolean mouseIn = false;
		String name;

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MyMenuItem() {

		}

		public MyMenuItem(String name) {
			this.name = name;
			setBorder(null); // 覆盖父类的初始化
			addMouseListener(new MouseListener() {
				public void mouseExited(MouseEvent e) {
					mouseIn = false;
					repaint();
				}

				public void mouseReleased(MouseEvent e) {
		
				}

				public void mouseClicked(MouseEvent e) {

				}

				public void mouseEntered(MouseEvent e) {
					mouseIn = true;
					repaint();
				}

				public void mousePressed(MouseEvent e) {

				}
			});
		}

		public Dimension getPreferredSize() { // 调整为期望的合适大小
			return new Dimension(180, 25);
		}

		public void paintComponent(Graphics g) {
			removeAll();

			g.setColor(new Color(241, 241, 241));
			g.fillRect(0, 0, getWidth(), getHeight());

			if (mouseIn) {
				g.setColor(new Color(234, 237, 244));
				g.fillRoundRect(2, 1, getWidth() - 4, getHeight() - 3, 3, 3);
				g.setColor(new Color(189, 205, 231));
				g.drawRoundRect(2, 1, getWidth() - 4, getHeight() - 3, 3, 3);
			}

			g.setColor(new Color(227, 227, 227));
			g.drawLine(30, 0, 30, getHeight());

			g.setColor(new Color(255, 255, 255));
			g.drawLine(31, 0, 31, getHeight());

			if (mouseIn) {
				g.setColor(new Color(189, 205, 231));
				g.drawLine(30, 1, 31, 1);
				g.drawLine(30, getHeight() - 2, 31, getHeight() - 2);
			}

			JLabel l = new JLabel(name);
			l.setFont(new Font("微软雅黑", Font.PLAIN, 12));
			l.setBounds(35, 0, 100, getHeight());
			l.setForeground(new Color(44, 44, 44));

			add(l);
		}
	}

}