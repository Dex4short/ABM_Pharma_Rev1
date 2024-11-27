package system.window;

import java.awt.BorderLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;

import components.StackPanel;
import oop.interfaces.Theme;
import system.panels.PanelLogin;
import system.panels.PanelAdmin;
import system.panels.PanelEmployee;

public class Window extends JFrame implements Theme{
	private static final long serialVersionUID = -6729595845570486177L;
	private static StackPanel stack_panel;

	public Window() {
		setTitle("ABM Pharma - DIMS Rev.1");
		setLayout(new BorderLayout());
		
		stack_panel = new StackPanel();
		stack_panel.setBackground(main_color[0]);
		stack_panel.addComponentListener(new ContentPaneComponentAdapter());
		stack_panel.setName("abm");
		add(stack_panel, BorderLayout.CENTER);
		
		PanelLogin panel_login = new PanelLogin() {
			private static final long serialVersionUID = 179005001334507847L;
			@Override
			public void openAdminInterface() {
				stack_panel.popPanel();
				stack_panel.pushPanel(new PanelAdmin());
			}
			@Override
			public void openEmployeeInterface() {
				stack_panel.popPanel();
				stack_panel.add(new PanelEmployee());
			}
		};
		stack_panel.pushPanel(panel_login);
		
	}
	public static StackPanel getStackPanel() {
		return stack_panel;
	}

	private class ContentPaneComponentAdapter extends ComponentAdapter{
		@Override
		public void componentResized(ComponentEvent e) {
			repaint();
			revalidate();
		}
	}
}
