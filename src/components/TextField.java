package components;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import oop.interfaces.Theme;

public class TextField extends JTextField implements Theme{
	private static final long serialVersionUID = 5030767401767931571L;
	private Color line_color;

	{
		setOpaque(false);
		setBorder(BorderFactory.createEmptyBorder());
		
		setFont(font[0]);
		setForeground(text_color[0]);
		setLineColor(main_color[3]);
	}
	@Override
	public void paint(Graphics g) {
		g.setColor(getLineColor());
		g.drawLine(0, getHeight()-2, getWidth(), getHeight()-2);
		super.paint(g);
	}
	public Color getLineColor() {
		return line_color;
	}
	public void setLineColor(Color line_color) {
		this.line_color = line_color;
	}
}
