package extras;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import oop.interfaces.Miscellaneous;


public class Decoration {
	private Font font;
	private Color background,foreground,accent[];
	private Miscellaneous misc;

	public Decoration(Font font, Color foreground, Color background) {
		setFont(font);
		setForeground(foreground);
		setBackground(background);
	}
	public void decorate(Component component) {
		if(background != null) {
			component.setBackground(background);
		}
		if(foreground != null) {
			component.setForeground(foreground);
		}
		if(font != null) {
			component.setFont(font);
		}
		if(misc != null) {
			misc.apply(component);
		}
	}
	public Color getBackground() {
		return background;
	}
	public void setBackground(Color background) {
		this.background = background;
	}
	public Color getForeground() {
		return foreground;
	}
	public void setForeground(Color foreground) {
		this.foreground = foreground;
	}
	public Font getFont() {
		return font;
	}
	public void setFont(Font font) {
		this.font = font;
	}
	public Color getAccent(int index) {
		return accent[index];
	}
	public Color[] getAccent() {
		return accent;
	}
	public void setAccent(Color accent[]) {
		this.accent = accent;
	}
	public Miscellaneous getMiscellaneous() {
		return misc;
	}
	public void setMiscellaneous(Miscellaneous misc) {
		this.misc = misc;
	}
}
