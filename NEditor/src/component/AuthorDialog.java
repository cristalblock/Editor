package component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class AuthorDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AuthorDialog(Frame owner, String title) {
		super(owner, title);
		setSize(300, 300);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		
		JPanel p=new MyPanel();
		p.setBounds(0,0,getContentPane().getWidth(),getContentPane().getHeight());
		p.setLayout(null);
		add(p);
		
		JLabel l=new JLabel();
		l.setBounds(180,20,100,150);
		l.setIcon(new ImageIcon(MainFrame.class
				.getResource("/img/author.jpg")));
		l.setBorder(new Border(){

			@Override
			public void paintBorder(Component c, Graphics g, int x, int y,
					int width, int height) {
				// TODO Auto-generated method stub
				g.setColor(Color.darkGray);
				g.drawRect(x, y, width-1, height-1);
			}

			@Override
			public Insets getBorderInsets(Component c) {
				// TODO Auto-generated method stub
				return new Insets(1,1,1,1);
			}

			@Override
			public boolean isBorderOpaque() {
				// TODO Auto-generated method stub
				return true;
			}
			
		});
		p.add(l);
		
		JLabel ins=new JLabel("author：nlz");
		ins.setFont(new Font("华文行楷", Font.BOLD, 30));
		ins.setBounds(10,20,150,60);
		p.add(ins);
		
		JLabel ins2=new JLabel("date：14-8");
		ins2.setFont(new Font("华文行楷", Font.BOLD, 30));
		ins2.setBounds(10,80,150,60);
		p.add(ins2);
		
		final JLabel ins3=new JLabel("进入NEditor官方网站");
		ins3.setFont(new Font("微软雅黑", Font.PLAIN, 10));
		ins3.setBounds(100,220,100,20);
		ins3.setForeground(Color.white);
		ins3.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					Desktop.getDesktop().browse(new URI("www.baidu.com"));
				} catch (IOException | URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				setCursor(new Cursor(Cursor.HAND_CURSOR));
				ins3.setBorder(new Border(){

					@Override
					public void paintBorder(Component c, Graphics g, int x,
							int y, int width, int height) {
						// TODO Auto-generated method stub
						g.setColor(Color.white);
						g.drawLine(0, height-1, width, height-1);
					}

					@Override
					public Insets getBorderInsets(Component c) {
						// TODO Auto-generated method stub
						return new Insets(1,1,1,1);
					}

					@Override
					public boolean isBorderOpaque() {
						// TODO Auto-generated method stub
						return true;
					}
					
				});
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				ins3.setBorder(null);
			}
			
		});
		p.add(ins3);
	}
	
	public class MyPanel extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g){
			GradientPaint gradient=new GradientPaint(150,0,Color.white,150,300,Color.black);
			Graphics2D g2=(Graphics2D)g;
			g2.setPaint(gradient);
			g2.fillRect(0, 0, this.getWidth(), this.getHeight());
		}
	}

}
