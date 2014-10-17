package component;

import java.awt.Font;

import javax.swing.JLabel;

public class NumberLabel extends JLabel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NumberLabel(String text){
		super(text);
		setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		setSize(18,17);
	}

}
