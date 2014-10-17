package component;

import java.awt.Font;

import javax.swing.JMenuItem;

public class MyMenuItem extends JMenuItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MyMenuItem(String text){
		super(text);
		setBorder(null);
		setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
	}

}
