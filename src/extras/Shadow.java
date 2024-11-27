package extras;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;

public class Shadow {
	public static final Color shadow_color = new Color(0,0,0,64);
	public static int x_offset=0, y_offset=10;

	private Shadow() {
		
	}
	public static void cast_shadow(Area area, int x, int y, Graphics2D g2d) {
		g2d.translate(x + x_offset, y + y_offset);
		g2d.setColor(shadow_color);
		g2d.fill(area);
		g2d.translate(-(x + x_offset), -(y + y_offset));
	}
	public static void cast_shadow(Rectangle rect, Graphics2D g2d) {
		g2d.setColor(shadow_color);
		g2d.fillRect(rect.x + x_offset, rect.y + y_offset, rect.width, rect.height);
	}
}
