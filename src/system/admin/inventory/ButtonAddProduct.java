package system.admin.inventory;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import components.ButtonRoundRect;
import res.Resource;

public class ButtonAddProduct extends ButtonRoundRect{
	private static final long serialVersionUID = -8319852584060410711L;

	public ButtonAddProduct() {
		setArc(30);
		setPreferredSize(new Dimension(120,30));
		setBorder(BorderFactory.createEmptyBorder());
		
		setIcon(new ImageIcon(new Resource().get("add.png")));
		setText("Add Product");
	}
}
