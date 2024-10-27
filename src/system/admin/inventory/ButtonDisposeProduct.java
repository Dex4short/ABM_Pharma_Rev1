package system.admin.inventory;

import java.awt.Dimension;

import javax.swing.ImageIcon;

import components.ButtonRoundRect;
import res.Resource;

public class ButtonDisposeProduct extends ButtonRoundRect{
	private static final long serialVersionUID = -211465351098739393L;

	public ButtonDisposeProduct() {
		setArc(30);
		setPreferredSize(new Dimension(30,30));
		
		setIcon(new ImageIcon(new Resource().get("delete.png")));
	}
}
