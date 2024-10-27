package components;

import java.awt.Component;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import oop.interfaces.Theme;

public class ListPane extends ScrollPane implements Theme, ComponentListener{
	private static final long serialVersionUID = 3941388225399542457L;
	private int xTranslate, yTranslate, item_h, h_gap, v_gap;
	private JPanel list_container;
	private Item selected_item = null;
	
	public ListPane() {
		super(new JPanel());
		
		list_container = getPanelView();
		//list_container.setOpaque(false);
		list_container.addComponentListener(this);
		
		xTranslate = 0;
		yTranslate = 0;
		
		setItemHeight(25);
		setGap(0, 0);
	}
	@Override
	public void componentResized(ComponentEvent e) {
		align();
		revalidate();
		repaint();
	}
	@Override
	public void componentMoved(ComponentEvent e) {}
	@Override
	public void componentShown(ComponentEvent e) {}
	@Override
	public void componentHidden(ComponentEvent e) {}
	@Override
	public int viewingWidth() {
		return 0;
	}
	@Override
	public int viewingHeight() {
		return getItemCount() * getItemHeight();
	}
	@Override
	public void onScrollPanel(int scroll_x, int scroll_y) {
		yTranslate = scroll_y;
		align();
	}
	public JPanel getListContainer() {
		return list_container;
	}
	public void addItem(Item item) {
		list_container.add(item);
		item.addMouseListener(new ItemMouseListener());
	}
	public void removeItem(int index) {
		list_container.remove(index);
	}
	public void removeItem(Item item) {
		list_container.remove(item);
	}
	public Item getItem(int index) {
		return (Item)list_container.getComponent(index);
	}
	public int getItemHeight() {
		return item_h;
	}
	public void setItemHeight(int item_h) {
		this.item_h = item_h;
	}
	public int getHGap() {
		return h_gap;
	}
	public int getVGap() {
		return v_gap;
	}
	public void setGap(int h_gap, int v_gap) {
		this.h_gap = h_gap;
		this.v_gap = v_gap;
	}
	public void setSelectedItem(int index) {
		selected_item = ((Item)list_container.getComponent(index));
		selected_item.setSelected(true);
	}
	public int getItemCount() {
		if(list_container != null) {
			return list_container.getComponentCount();
		}
		return 0;
	}
	
	private int xt, yt;
	private void align() {
		xt = xTranslate;
		yt = yTranslate;
		
		for(Component comp: list_container.getComponents()) {
			comp.setBounds(xt, yt, list_container.getWidth(), item_h);
			yt += comp.getHeight() + h_gap;
		}
	}

	private class ItemMouseListener implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			if(selected_item != null) {
				selected_item.setSelected(false);
			}
			selected_item = ((Item)e.getSource());
			selected_item.setSelected(true);
		}
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
	}

}
