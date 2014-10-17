package component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

//自定义边界类，将绘制灰色矩形边框
public class GrayRectBorder implements Border {

	public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
		g.setColor(new Color(150, 150, 150));
		g.drawRect(0, 0, w - 1, h - 1);
	}

	public Insets getBorderInsets(Component c) {
		return new Insets(1, 1, 1, 1);
	}

	public boolean isBorderOpaque() {
		return true;
	}

}
