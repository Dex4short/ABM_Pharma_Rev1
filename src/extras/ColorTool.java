package extras;

import java.awt.Color;

public class ColorTool {

	private ColorTool() {
		
	}
	public static Color setAlpha(Color color, int alpha) {
		return new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);
	}
	
}
