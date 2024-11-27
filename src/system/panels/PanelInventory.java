package system.panels;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import components.Item;
import components.Label;
import components.SearchPanel;
import oop.interfaces.Theme;
import system.buttons.ButtonAddProduct;
import system.buttons.ButtonDisposeProduct;
import system.buttons.ButtonEditProduct;
import system.buttons.ButtonPrintProduct;
import system.buttons.ButtonReserveProduct;
import system.tables.TableInventory;

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
			search_panel.getComboBox().addItem(new Item(new Label(null, field)));
		}
		search_panel.getComboBox().setSelectedItem(0);
		header_left.add(search_panel);	

		MouseAdapter close_search_panel_on_hover = new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				search_panel.getComboBox().close();
			}
		};
		
		ButtonPrintProduct btn_printProduct = new ButtonPrintProduct();
		btn_printProduct.addMouseListener(close_search_panel_on_hover);
		btn_printProduct.setEnabled(false);
		header_right.add(btn_printProduct);
		
		ButtonReserveProduct btn_reserveProduct = new ButtonReserveProduct();
		btn_reserveProduct.addMouseListener(close_search_panel_on_hover);
		btn_reserveProduct.setEnabled(false);
		header_right.add(btn_reserveProduct);
		
		ButtonDisposeProduct btn_disposeProduct = new ButtonDisposeProduct();
		btn_disposeProduct.addMouseListener(close_search_panel_on_hover);
		btn_disposeProduct.setEnabled(false);
		header_right.add(btn_disposeProduct);
		
		ButtonEditProduct btn_editProduct = new ButtonEditProduct();
		btn_editProduct.addMouseListener(close_search_panel_on_hover);
		btn_editProduct.setEnabled(false);
		header_right.add(btn_editProduct);

		ButtonAddProduct btn_addProduct = new ButtonAddProduct();
		btn_addProduct.addMouseListener(close_search_panel_on_hover);
		header_right.add(btn_addProduct);
		
		TableInventory table_inventory = new TableInventory();
		table_inventory.addMouseListener(close_search_panel_on_hover);
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
