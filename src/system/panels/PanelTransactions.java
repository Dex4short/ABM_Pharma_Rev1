package system.panels;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import components.Item;
import components.Label;
import components.SearchPanel;
import oop.interfaces.Theme;

public class PanelTransactions extends JPanel implements Theme{
	private static final long serialVersionUID = -4728899875964533207L;

	public PanelTransactions() {
		setOpaque(false);
		setLayout(new BorderLayout());
		
		JPanel header = new JPanel(new BorderLayout());
		header.setOpaque(false);
		add(header, BorderLayout.NORTH);
		
		JPanel header_left = new JPanel(new FlowLayout(FlowLayout.LEFT));
		header_left.setOpaque(false);
		header.add(header_left, BorderLayout.WEST);
		
		JPanel header_right = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		header_left.setOpaque(false);
		header.add(header_right, BorderLayout.EAST);
		
		SearchPanel search_customer = new SearchPanel();
		String customer_fields[] = {"Customer Name", "TIN No.", "Address", "Date", "Terms", "Cost Amount", "Profit"};
		for(String customer_field: customer_fields) {
			search_customer.getComboBox().addItem(new Item(new Label(null, customer_field)));
		}
		header_left.add(search_customer);
	}
}
