package components;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import extras.Decoration;
import oop.interfaces.BasicDecoration;
import oop.interfaces.Theme;

public class SeamlessButton extends JButton implements Theme, MouseListener, BasicDecoration{
	private static final long serialVersionUID = 2014350748158676383L;
	private Decoration normal, hovered, pressed;
	private int arc;

	{
		setOpaque(false);
		
		setBorderPainted(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
		
		setArc(10);
		normal = new Decoration(font[0], main_color[1], null);
		normal.decorate(this);
		
		hovered = new Decoration(font[0], main_color[1].darker(), null);
		pressed = new Decoration(font[0], main_color[1].darker().darker(), null);
		
		addMouseListener(this);
	}
	public int getArc() {
		return arc;
	}
	public void setArc(int arc) {
		this.arc = arc;
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		hovered.decorate(this);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		normal.decorate(this);
	}
	@Override
	public void mousePressed(MouseEvent e) {
		pressed.decorate(this);
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		hovered.decorate(this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public Decoration getNormalDecoration() {
		return normal;
	}
	@Override
	public void setNormalDecoration(Decoration normal) {
		this.normal = normal;
	}
	@Override
	public Decoration getHoveredDecoration() {
		return hovered;
	}
	@Override
	public void setHoveredDecoration(Decoration hovered) {
		this.hovered = hovered;
	}
	@Override
	public Decoration getPressedDecoration() {
		return pressed;
	}
	@Override
	public void setPressedDecoration(Decoration pressed) {
		this.pressed = pressed;
	}

}
