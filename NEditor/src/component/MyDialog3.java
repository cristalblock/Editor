package component;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class MyDialog3 extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyDialog3(Frame owner, String title) {
		super(owner, title);
		setSize(300, 150);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.white);

		setLayout(null);

		JLabel info = new JLabel("当前文本已经修改， 是否保存?");
		info.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		info.setBounds(50,0,200,60);
		getContentPane().add(info);
		
		JButton yes=new JButton("是");
		yes.setBounds(60,70,60,25);
		yes.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		yes.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MyDialog3.this.dispose();
				MainFrame.window.save();
				System.exit(0);
			}
			
		});
		getContentPane().add(yes);
		
		JButton no=new JButton("否");
		no.setBounds(150,70,60,25);
		no.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		no.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MyDialog3.this.dispose();
				System.exit(0);
			}
			
		});
		getContentPane().add(no);
	}

}

