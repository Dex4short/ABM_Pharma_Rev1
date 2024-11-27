package components;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;

import oop.interfaces.Theme;

public class Cell extends JPanel implements Theme{
	private static final long serialVersionUID = -1471486271615938005L;

	public Cell(JComponent component) {
		setOpaque(false);
		setLayout(new BorderLayout());
		
		component.setFont(font[0]);
		component.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		add(component, BorderLayout.CENTER);
		
	}
}
