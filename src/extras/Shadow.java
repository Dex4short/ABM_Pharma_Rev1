package extras;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;

public class Shadow {
	static Color shadow = new Color(0,0,0,64);

	private Shadow() {
		
	}
	public static void cast_shadow(Area area, int x, int y, Graphics2D g2d) {
		g2d.translate(x, y);
		g2d.setColor(shadow);
		g2d.fill(area);
		g2d.translate(-x, -y);
	}
	public static void cast_shadow(Rectangle rect, Graphics2D g2d) {
		g2d.setColor(shadow);
		g2d.fill(rect);
	}
}
