package system.buttons;

import java.awt.Dimension;

import javax.swing.ImageIcon;

import components.Button;
import res.Resource;

public class ButtonDisposeProduct extends Button{
	private static final long serialVersionUID = -211465351098739393L;

	public ButtonDisposeProduct() {
		setArc(30);
		setPreferredSize(new Dimension(30,30));

		setIcon(new ImageIcon(Resource.get("delete.png")));
	}
}
