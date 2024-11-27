package system.tables;

import javax.swing.JLabel;

import components.Column;
import components.Row;
import components.Table;

public class TableInventory extends Table{
	private static final long serialVersionUID = 4737286913516237032L;

	public TableInventory() {
		super(inventory_columns(), new Row[0]);
		
	}
	private static final Column[] inventory_columns() {
		Column columns[] = new Column[12];
		
		String fields[] = {"Item No.", "Description", "Lot No.", "Date Added", "Exp Date", "Brand", "Quantity", "UOM", "Cost", "Unit Price", "Discount", "Unit Amount"};
		for(int i=0; i<columns.length; i++) {
			columns[i] = new Column(new JLabel(fields[i]));
		}
		
		return columns;
	}
}
