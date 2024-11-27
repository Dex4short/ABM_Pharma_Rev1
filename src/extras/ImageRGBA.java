package extras;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ImageRGBA {

	private ImageRGBA() {
		
	}
	public static ImageIcon alterImageIcon(URL src, Color color, ImageObserver observer) {
		BufferedImage buff_img = null;
		
		try {
			buff_img = ImageIO.read(src);
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return new ImageIcon(alterImage(buff_img, color, observer));
	}	
	public static ImageIcon alterImageIcon(ImageIcon src, Color color, ImageObserver observer) {
		BufferedImage buff_img = new BufferedImage(src.getIconWidth(), src.getIconHeight(), BufferedImage.TYPE_4BYTE_ABGR);
		buff_img.createGraphics().drawImage(src.getImage(), 0, 0, observer);
		return new ImageIcon(alterImage(buff_img, color, observer));
	}
	public static ImageIcon alterIcon(Icon src, Color color, ImageObserver observer) {
		BufferedImage buff_img = new BufferedImage(src.getIconWidth(), src.getIconHeight(), BufferedImage.TYPE_4BYTE_ABGR);
		src.paintIcon(null, buff_img.createGraphics(), 0, 0);
		return new ImageIcon(alterImage(buff_img, color, observer));
	}
	public static Image alterImage(BufferedImage buff_img, Color color, ImageObserver observer) {
		int 
		img_w = buff_img.getWidth(),
		img_h = buff_img.getHeight();
		
		Graphics2D g2d = (Graphics2D)buff_img.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawImage(buff_img, 0, 0, img_w, img_h, observer);
		g2d.dispose();
		
		for(int x=0; x<img_w; x++) {
			for(int y=0; y<img_h; y++) {
				int argb = buff_img.getRGB(x, y);
				
				int alpha = (argb >> 24) & 0xFF;
				if(alpha==0) {
					continue;
				}
				
				int new_argb = (alpha << 24) | (color.getRed() << 16) | (color.getGreen() << 8) | color.getBlue();
				buff_img.setRGB(x, y, new_argb);
			}
		}
		
		return buff_img;
	}
}
