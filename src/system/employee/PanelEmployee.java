package system.employee;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import components.PanelRoundRect;

public class PanelEmployee extends JPanel{
	private static final long serialVersionUID = -6277054873151673957L;

	public PanelEmployee() {
		setOpaque(false);
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		PanelRoundRect panel = new PanelRoundRect();
		add(panel, BorderLayout.CENTER);
		
	
	}
}