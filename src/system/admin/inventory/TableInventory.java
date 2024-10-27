package system.admin.inventory;

import javax.swing.JLabel;

import components.Cell;
import components.Column;
import components.Row;
import components.Table;

public class TableInventory extends Table{
	private static final long serialVersionUID = 4737286913516237032L;

	public TableInventory() {
		super(inventory_columns(), invetory_rows());
		
		
	}
	private static final Column[] inventory_columns() {
		Column columns[] = new Column[12];
		
		String fields[] = {"Item No.", "Description", "Lot No.", "Date Added", "Exp Date", "Brand", "Quantity", "UOM", "Cost", "Unit Price", "Discount", "Unit Amount"};
		for(int i=0; i<columns.length; i++) {
			columns[i] = new Column(new JLabel(fields[i]));
		}
		
		return columns;
	}
	private static final Row[] invetory_rows() {
		Row rows[]= new Row[50];
		
		for(int i=0; i<rows.length; i++) {
			rows[i] = new Row(
					new Cell[] {
							new Cell(new JLabel((i+1000)+"")),
							new Cell(new JLabel("sample")),
							new Cell(new JLabel("0001")),
							new Cell(new JLabel("21-10-2024")),
							new Cell(new JLabel("21-10-2025")),
							new Cell(new JLabel("xxxx")),
							new Cell(new JLabel("100")),
							new Cell(new JLabel("box")),
							new Cell(new JLabel("1,000.00")),
							new Cell(new JLabel("1,200.00")),
							new Cell(new JLabel("10%")),
							new Cell(new JLabel("1,080.00"))
					}
			);
		}
		
		return rows;
	}
}
