package system;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import oop.interfaces.Theme;
import system.admin.PanelAdmin;
import system.employee.PanelEmployee;
import system.login.LoginPanel;

public class Window extends JFrame implements Theme{
	private static final long serialVersionUID = -6729595845570486177L;
	private JPanel content_pane;

	public Window() {
		setTitle("ABM Pharma - DIMS Rev.1");
		
		content_pane = new JPanel();
		content_pane.setName("abm");
		content_pane.setBackground(main_color[0]);
		content_pane.addComponentListener(new ContentPaneComponentAdapter());
		setContentPane(content_pane);
		
		CardLayout card_layout = new CardLayout();
		content_pane.setLayout(card_layout);
		
		JPanel panel = new LoginPanel() {
			private static final long serialVersionUID = 179005001334507847L;
			@Override
			public void openAdminInterface() {
				content_pane.remove(this);
				content_pane.add(new PanelAdmin(), BorderLayout.CENTER);
				content_pane.revalidate();
				content_pane.repaint();
			}
			@Override
			public void openEmployeeInterface() {
				content_pane.remove(this);
				content_pane.add(new PanelEmployee(), BorderLayout.CENTER);
				content_pane.revalidate();
				content_pane.repaint();
			}
		};
		add(panel, BorderLayout.CENTER);
	}

	private class ContentPaneComponentAdapter extends ComponentAdapter{
		@Override
		public void componentResized(ComponentEvent e) {
			repaint();
			revalidate();
		}
	}
}
