package system.admin.inventory;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import components.Item;
import components.SearchPanel;
import oop.interfaces.Theme;

public class PanelInventory extends JPanel implements Theme, ComponentListener{
	private static final long serialVersionUID = 5294758605465387431L;
	private JPanel panel;

	public PanelInventory() {
		setOpaque(false);
		setLayout(null);
		
		panel = new JPanel(new BorderLayout());
		panel.setOpaque(false);
		add(panel);
		
		JPanel header = new JPanel(new BorderLayout(0,0));
		header.setOpaque(false);
		header.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		panel.add(header, BorderLayout.NORTH);
		
		JPanel header_left = new JPanel(new FlowLayout(FlowLayout.LEFT));
		header_left.setOpaque(false);
		header.add(header_left, BorderLayout.WEST);
		
		JPanel header_right = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		header_right.setOpaque(false);
		header.add(header_right, BorderLayout.EAST);
		
		SearchPanel search_panel = new SearchPanel();
		String fields[] = {"Item No.", "Description", "Lot No.", "Date Added", "Exp Date", "Brand", "Quantity", "UOM", "Cost", "Unit Price", "Discount", "Unit Amount"};
		for(String field: fields) {
			search_panel.getComboButton().addItem(new Item(new JLabel(field, JLabel.LEFT)));
		}
		search_panel.getComboButton().setSelectedItem(0);
		header_left.add(search_panel);		

		ButtonPrintProduct btn_printProduct = new ButtonPrintProduct();
		header_right.add(btn_printProduct);
		
		ButtonReserveProduct btn_reserveProduct = new ButtonReserveProduct();
		header_right.add(btn_reserveProduct);
		
		ButtonDisposeProduct btn_disposeProduct = new ButtonDisposeProduct();
		header_right.add(btn_disposeProduct);
		
		ButtonEditProduct btn_editProduct = new ButtonEditProduct();
		header_right.add(btn_editProduct);

		ButtonAddProduct btn_addProduct = new ButtonAddProduct();
		header_right.add(btn_addProduct);
		
		TableInventory table_inventory = new TableInventory();
		panel.add(table_inventory, BorderLayout.CENTER);
		
		addComponentListener(this);
	}
	@Override
	public void componentResized(ComponentEvent e) {
		panel.setBounds(0, 0, getWidth(), getHeight());
		panel.revalidate();
		panel.repaint();
	}
	@Override
	public void componentMoved(ComponentEvent e) {}
	@Override
	public void componentShown(ComponentEvent e) {}
	@Override
	public void componentHidden(ComponentEvent e) {}
}
