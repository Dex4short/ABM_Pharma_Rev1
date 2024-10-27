package system.admin.inventory;

import java.awt.Dimension;

import javax.swing.ImageIcon;

import components.ButtonRoundRect;
import res.Resource;

public class ButtonReserveProduct extends ButtonRoundRect{
	private static final long serialVersionUID = -2701202578036756483L;

	public ButtonReserveProduct() {
		setArc(30);
		setPreferredSize(new Dimension(30,30));
		
		setIcon(new ImageIcon(new Resource().get("reserve.png")));
	}

}
