package system.admin.inventory;

import java.awt.Dimension;

import javax.swing.ImageIcon;

import components.ButtonRoundRect;
import res.Resource;

public class ButtonEditProduct extends ButtonRoundRect{
	private static final long serialVersionUID = 2805362815419509096L;

	public ButtonEditProduct() {
		setArc(30);
		setPreferredSize(new Dimension(30,30));
		
		setIcon(new ImageIcon(new Resource().get("pencil.png")));
	}

}
