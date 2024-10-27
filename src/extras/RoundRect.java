package extras;

import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class RoundRect extends Area{

	public RoundRect(int x, int y, int w, int h, int arcW, int arcH, boolean arc_topLeft, boolean arc_topRight, boolean arc_bottomLeft, boolean arc_bottomRight) {
		add(new Area(new Rectangle2D.Double(x, y, w, h)));

		if(arc_topLeft) {
			subtract(new Area(new Rectangle2D.Double( x, y, Math.round(arcW/2f),Math.round( arcH/2f))));
			add(new Area(new Ellipse2D.Double( x, y, arcW, arcH)));
		}
		
		if(arc_topRight) {
			subtract(new Area(new Rectangle2D.Double( x + w - Math.round(arcW/2f), y, Math.round(arcW/2f), Math.round(arcH/2f))));
			add(new Area(new Ellipse2D.Double( x + w - arcW, y, arcW, arcH)));
		}
		
		if(arc_bottomLeft) {
			subtract(new Area(new Rectangle2D.Double( x, y + h - Math.round(arcH/2f), arcW/2f, Math.round(arcH/2f))));
			add(new Area(new Ellipse2D.Double( x, y + h - arcH, arcW, arcH)));
		}
		
		if(arc_bottomRight) {
			subtract(new Area(new Rectangle2D.Double( x + w - (arcW/2f), y + h - (arcH/2f), arcW/2f, arcH/2f)));
			add(new Area(new Ellipse2D.Double( x + w - arcW, y + h - arcH, arcW, arcH)));
		}
	}
}
