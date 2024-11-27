package components;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import extras.Settings;
import extras.Shadow;

public class ShadowPanel extends JPanel{
	private static final long serialVersionUID = 1852291924125391732L;
	private Graphics2D g2d;
	
	public ShadowPanel(JPanel panel) {
		setOpaque(false);
		setLayout(new BorderLayout());
		
		add(panel, BorderLayout.CENTER);
	}
	@Override
	public void paint(Graphics g) {
		g2d = (Graphics2D)g;
		Settings.rendering_hint(g2d);
		
		Shadow.cast_shadow(getBounds(), g2d);
		super.paint(g2d);
	}
}
