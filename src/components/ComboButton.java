package components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import extras.Decoration;
import extras.Settings;

public class ComboButton extends ButtonRoundRect implements ActionListener{
	private static final long serialVersionUID = 2967464342223499866L;
	private ComboPanel combo_panel;
	private ListPane list_pane;
	private boolean open;

	public ComboButton() {
		setArc(30);
		setBorder(BorderFactory.createEmptyBorder(0,15,0,15));

		setNormalDecoration(new Decoration(font[0], text_color[2], main_color[2]));
		getNormalDecoration().setAccent(new Color[] {new Color(0,0,0,0)});
		getNormalDecoration().decorate(this);
		
		setHoveredDecoration(new Decoration(font[0], text_color[2], main_color[2]));
		getHoveredDecoration().setAccent(new Color[] {main_color[3]});
		
		setPressedDecoration(new Decoration(font[0], text_color[3], main_color[3]));
		getPressedDecoration().setAccent(new Color[] {new Color(0,0,0,0)});
		
		addActionListener(this);
		
		combo_panel = new ComboPanel();
		combo_panel.setOpaque(false);
		
		list_pane = new ListPane();
		combo_panel.add(list_pane, BorderLayout.CENTER);
		combo_panel.addMouseWheelListener(list_pane.getVertical_scrollbar());
		
		BorderLayout border_layout = (BorderLayout)list_pane.getLayout();
		border_layout.setHgap(5);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(isOpen()) {
			close();
		}
		else {
			open();
		}
	}
	public void addItem(Item item) {
		item.addMouseListener(new ComboItemMouseAdapter());
		list_pane.addItem(item);
	}
	public void removeItem(int index) {
		list_pane.removeItem(index);
	}
	public void removeItem(Item item) {
		list_pane.removeItem(item);
	}
	public void getItem(int index) {
		list_pane.getItem(index);
	}
	public boolean isOpen() {
		return open;
	}
	private int px=0, py=0;
	public void open() {
		px=0;
		py=0;
		Component parent = getParent();
		while(parent!=getRootPane()) {
			px += parent.getX();
			py += parent.getY();
			parent = parent.getParent();
		}
		
		combo_panel.setBounds(px, py + getHeight() + 5, getWidth(), 100);
		getRootPane().add(combo_panel, 0);
		getRootPane().revalidate();
		getRootPane().repaint();
		
		new Timer().scheduleAtFixedRate(new TimerTask() {
			private Point mouse_location,window_location;
			private int mx,my;
			@Override
			public void run() {
				mouse_location  = MouseInfo.getPointerInfo().getLocation();
				window_location = getRootPane().getParent().getLocation();

				mx = mouse_location.x - window_location.x - px - getRootPane().getX();
				my = mouse_location.y - window_location.y - py - getRootPane().getY();
				
				if(mx<0 || mx>getWidth() || my<0 || my>(getHeight()+combo_panel.getHeight())) {
					close();
					cancel();
				}
			}
		}, 0, 15);
		
		open = true;
	}
	public void close() {
		getRootPane().remove(combo_panel);
		getRootPane().revalidate();
		getRootPane().repaint();
		open = false;
	}
	public void setSelectedItem(int index) {
		if(list_pane.getItemCount() == 0) {
			setText("");
			return;
		}
		list_pane.setSelectedItem(index);
		setText(list_pane.getItem(index).getLabel().getText());
	}
	
	private final class ComboPanel extends PanelRoundRect{
		private static final long serialVersionUID = 265426238802373121L;
		private Graphics2D g2d;
		
		public ComboPanel() {
			setLayout(new BorderLayout(5,5));
			setForeground(main_color[3]);
			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			
		}
		@Override
		public void paint(Graphics g) {
			g2d = (Graphics2D)g;
			Settings.rendering_hint(g2d);
			
			super.paint(g2d);
			
			//g2d.setColor(getForeground());
			//g2d.drawRoundRect(0, 0, getWidth()-1,
		}
	}
	
	public static class ComboItem extends Item{
		private static final long serialVersionUID = -7155604137719906832L;

		public ComboItem(ImageIcon img_ico, String text) {
			super(new JLabel(text, img_ico, JLabel.LEFT) {
				private static final long serialVersionUID = 6618469810418135848L;
				
				{
					setOpaque(false);
					setFont(font[0]);
					setForeground(text_color[0]);
				}
			});
		}
	}
	
	private class ComboItemMouseAdapter extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			setText(((Item)e.getSource()).getLabel().getText());
			close();
		}
	}
}
