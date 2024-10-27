package system.admin.inventory;

import java.awt.Dimension;

import javax.swing.ImageIcon;

import components.ButtonRoundRect;
import res.Resource;

public class ButtonPrintProduct extends ButtonRoundRect{
	private static final long serialVersionUID = 2144489025943712049L;

	public ButtonPrintProduct() {
		setArc(30);
		setPreferredSize(new Dimension(30,30));
		
		setIcon(new ImageIcon(new Resource().get("printer.png")));
	}
}
