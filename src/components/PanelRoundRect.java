package components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Area;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import extras.RoundRect;
import extras.Settings;
import oop.interfaces.Theme;

public class PanelRoundRect extends JPanel implements Theme{
	private static final long serialVersionUID = -4587780315956796207L;
	public static final int TopLeftCorner=0, TopRightCorner=1, BottomLeftCorner=2, BottomRightCorner=3;
	private int arc;
	private boolean corner[];
	private Area area;
	private Graphics2D g2d;

	{
		setOpaque(false);
		setBackground(main_color[2]);
		setForeground(new Color(0,0,0,0));
		setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		arc = 10;
		corner = new boolean[] {true, true, true, true};
		area = new RoundRect(0, 0, getWidth(), getHeight(), arc, arc, corner[0], corner[1], corner[2], corner[3]);
		
	}
	@Override
	public void paint(Graphics g) {
		g2d = (Graphics2D)g;
		Settings.rendering_hint(g2d);
		
		g2d.setColor(getBackground());
		area = new RoundRect(0, 0, getWidth(), getHeight(), arc, arc, corner[0], corner[1], corner[2], corner[3]);
		g2d.fill(area);
		
		super.paint(g2d);

		g2d.setColor(getForeground());
		area = new RoundRect(0, 0, getWidth()-1, getHeight()-1, arc-2, arc-2, corner[0], corner[1], corner[2], corner[3]);
		g2d.draw(area);
		
	}
	public int getArc() {
		return arc;
	}
	public void setArc(int arc) {
		this.arc = arc;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public void setCorner(int corner_index, boolean flag) {
		corner[corner_index] = flag;
	}
	public boolean getCorner(int corner_index) {
		return corner[corner_index];
	}
}
