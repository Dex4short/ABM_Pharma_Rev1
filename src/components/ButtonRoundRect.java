package components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import extras.Decoration;
import extras.Settings;
import oop.interfaces.BasicDecoration;
import oop.interfaces.ButtonModel;
import oop.interfaces.Theme;

public class ButtonRoundRect extends JButton implements Theme, MouseListener, BasicDecoration, ButtonModel{
	private static final long serialVersionUID = -5480176998308828496L;
	private int arc;
	private boolean isHovered, isPressed;
	private Decoration normal,hovered,pressed;

	private Graphics2D g2d;

	{
		setOpaque(false);
		
		setBorderPainted(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
		
		normal = new Decoration(font[0], text_color[3], main_color[0]);
		normal.setAccent(new Color[] {main_color[0]});
		normal.decorate(this);
		
		hovered = new Decoration(font[0], text_color[3], main_color[0]);
		hovered.setAccent(new Color[] {accent_color[0][0]});

		pressed = new Decoration(font[0], text_color[3], main_color[0].darker());
		pressed.setAccent(new Color[] {accent_color[0][0]});
		
		setArc(10);
		setBorder(BorderFactory.createEmptyBorder(6,30,6,30));
		
		addMouseListener(this);
	}
	@Override
	public void paint(Graphics g) {
		g2d = (Graphics2D)g;
		Settings.rendering_hint(g2d);

		g2d.setColor(getBackground());
		g2d.fillRoundRect(0, 0, getWidth(), getHeight(), arc, arc);
		
		if(isHovered) {
			g2d.setColor(hovered.getAccent(0));
			g2d.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, arc, arc);
		}
		
		super.paint(g2d);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		isHovered = true;
		hovered.decorate(this);
		repaint();
	}
	@Override
	public void mouseExited(MouseEvent e) {
		isHovered = false;
		normal.decorate(this);
		repaint();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		isPressed = true;
		pressed.decorate(this);
		repaint();
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		isPressed = false;
		hovered.decorate(this);
		repaint();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	public int getArc() {
		return arc;
	}
	public void setArc(int arc) {
		this.arc = arc;
	}	
	public Decoration getNormalDecoration() {
		return normal;
	}
	public void setNormalDecoration(Decoration normal) {
		this.normal = normal;
	}
	public Decoration getHoveredDecoration() {
		return hovered;
	}
	public void setHoveredDecoration(Decoration hovered) {
		this.hovered = hovered;
	}
	public Decoration getPressedDecoration() {
		return pressed;
	}
	public void setPressedDecoration(Decoration pressed) {
		this.pressed = pressed;
	}
	public boolean isHovered() {
		return isHovered;
	}
	public void setHovered(boolean isHovered) {
		this.isHovered = isHovered;
	}
	public boolean isPressed() {
		return isPressed;
	}
	public void setPressed(boolean isPressed) {
		this.isPressed = isPressed;
	}

}
