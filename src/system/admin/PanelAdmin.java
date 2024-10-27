package system.admin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import components.PanelRoundRect;
import components.Tab;
import components.TabPane;
import oop.interfaces.Theme;
import res.Resource;
import system.admin.inventory.PanelInventory;
import system.admin.transactions.PanelTransactions;

public class PanelAdmin extends JPanel implements Theme{
	private static final long serialVersionUID = 4864384612729816588L;

	public PanelAdmin() {
		setOpaque(false);
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		PanelRoundRect panel = new PanelRoundRect();
		panel.setLayout(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder());
		add(panel, BorderLayout.CENTER);
		
		JPanel header = new JPanel(new GridLayout(1, 2));
		header.setOpaque(false);
		header.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
		panel.add(header, BorderLayout.NORTH);
		
		JPanel header_left = new JPanel(new FlowLayout(FlowLayout.LEFT));
		header_left.setOpaque(false);
		header.add(header_left);
		
		JLabel logo = new JLabel(new ImageIcon(new Resource().get("ABM LOGO 2.png")));
		logo.setBorder(BorderFactory.createEmptyBorder());
		header_left.add(logo);
		
		JPanel header_right = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		header_right.setOpaque(false);
		header.add(header_right);
		
		PanelRoundRect center = new PanelRoundRect();
		center.setLayout(new BorderLayout());
		center.setBackground(main_color[3]);
		center.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
		panel.add(center, BorderLayout.CENTER);
		
		TabPane tab_pane = new TabPane();
		center.add(tab_pane, BorderLayout.CENTER);

		tab_pane.addTab(new Tab("Inventory", new PanelInventory()));
		tab_pane.addTab(new Tab("Transactions", new PanelTransactions()));
		tab_pane.addTab(new Tab("Store", new JPanel()));
		tab_pane.addTab(new Tab("Reserves", new JPanel()));
		tab_pane.addTab(new Tab("Disposal", new JPanel()));
		tab_pane.addTab(new Tab("Product Returns", new JPanel()));
		tab_pane.addTab(new Tab("Statistics", new JPanel()));
		tab_pane.addTab(new Tab("Customers", new JPanel()));
		tab_pane.setSelectedTab(0);
	}
}
