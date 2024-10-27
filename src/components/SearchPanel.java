package components;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;

import extras.ImageRGBA;
import extras.Settings;
import res.Resource;

public class SearchPanel extends PanelRoundRect{
	private static final long serialVersionUID = 5613802306658005888L;
	private ComboButton combo_button;
	private TextField search_field;
	private Graphics2D g2d;

	public SearchPanel() {
		setLayout(new BorderLayout(2,2));
		setArc(30);
		setForeground(main_color[3]);
		setPreferredSize(new Dimension(360, 30));
		setMinimumSize(getPreferredSize());
		setMaximumSize(getPreferredSize());
		setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
		
		combo_button = new ComboButton();
		combo_button.setArc(26);
		combo_button.setText("Search Field:: ");
		combo_button.setHorizontalAlignment(ComboButton.LEFT);
		combo_button.setIcon(ImageRGBA.alterImageIcon(new Resource().get("filter.png"), combo_button.getForeground(), combo_button));
		combo_button.addMouseListener(new ComboButtonMouseListener());
		combo_button.setPreferredSize(new Dimension(120, 30));
		combo_button.setMinimumSize(getPreferredSize());
		combo_button.setMaximumSize(getPreferredSize());
		add(combo_button, BorderLayout.WEST);
		
		search_field = new TextField();
		search_field.setColumns(10);
		add(search_field, BorderLayout.CENTER);
		
		ButtonRoundRect search_button = new ButtonRoundRect();
		search_button.setArc(26);
		search_button.setIcon(ImageRGBA.alterImageIcon(new Resource().get("search.png"), main_color[2], search_button));
		search_button.setBorder(BorderFactory.createEmptyBorder(0,23,0,23));
		add(search_button, BorderLayout.EAST);
		
	}
	@Override
	public void paint(Graphics g) {
		g2d = (Graphics2D)g;
		Settings.rendering_hint(g2d);

		
		super.paint(g2d);
		
		g2d.setColor(getForeground());
		g2d.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, getArc(), getArc());
	}
	public ComboButton getComboButton() {
		return combo_button;
	}
	public void setComboButton(ComboButton combo_button) {
		this.combo_button = combo_button;
	}
	public TextField getSearchField() {
		return search_field;
	}
	public void setSearchField(TextField search_field) {
		this.search_field = search_field;
	}
	
	private class ComboButtonMouseListener extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e) {
			combo_button.setIcon(ImageRGBA.alterImageIcon(new Resource().get("filter.png"), combo_button.getForeground(), combo_button));
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			combo_button.setIcon(ImageRGBA.alterImageIcon(new Resource().get("filter.png"), combo_button.getForeground(), combo_button));
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			combo_button.setIcon(ImageRGBA.alterImageIcon(new Resource().get("filter.png"), combo_button.getForeground(), combo_button));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			combo_button.setIcon(ImageRGBA.alterImageIcon(new Resource().get("filter.png"), combo_button.getForeground(), combo_button));
		}
	}
}
