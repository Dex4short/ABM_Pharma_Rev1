package system.action_panels;

import java.awt.Dimension;

import components.ActionPanel;
import components.Label;

public class ActionPanelAddProduct  extends ActionPanel{
	private static final long serialVersionUID = -4880139382406239412L;
	
	public ActionPanelAddProduct() {
		super(new Label(null, "Add Product"));
		
		setMaximumSize(new Dimension(Integer.MAX_VALUE, 200));
	}
	@Override
	public void onOk() {
		
	}
	@Override
	public void onCancel() {
		
	}

}
