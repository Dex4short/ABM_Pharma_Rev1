package components;

import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JPanel;

import extras.Shadow;

public class StackPanel extends JPanel{
	private static final long serialVersionUID = 4962917535590190005L;

	public StackPanel() {
		setLayout(null);
		addComponentListener(new StackPanelComponentAdapter());
	}
	public void pushPanel(JPanel panel) {
		add(panel);
		resize();
		revalidate();
		repaint();
	}
	public void pushPanel(JPanel panel, int w, int h) {
		PanelLayer panel_layer = new PanelLayer(panel, w, h);
		pushPanel(panel_layer);
	}
	public void pushPanel(JPanel panel, float horizontal, float vertical) {
		PanelLayer panel_layer = new PanelLayer(panel, horizontal, vertical);
		pushPanel(panel_layer);
	}
	public void pushPanel(JPanel panel, float top, float left, float bottom, float right) {
		PanelLayer panel_layer = new PanelLayer(panel, top, left, bottom, right);
		pushPanel(panel_layer);
	}
	public void popPanel() {
		remove(getComponentCount() - 1);
	}

	private int p,count;
	private void resize() {
		count = getComponentCount();
		for(p=0; p<count; p++) {
			getComponent(p).setBounds(getBounds());
		}
	}
	
	private class StackPanelComponentAdapter extends ComponentAdapter{
		
		public StackPanelComponentAdapter() {
			
		}
		@Override
		public void componentResized(ComponentEvent e) {
			resize();
		}
	}
	private class PanelLayer extends JPanel{
		private static final long serialVersionUID = -7078947632773482648L;
		
		{
			setOpaque(false);
		}
		public PanelLayer(JPanel panel, int w, int h) {
			add(panel);
			addComponentListener(new ComponentAdapter() {
				@Override
				public void componentResized(ComponentEvent e) {
					panel.setBounds((getWidth()/2) - (w/2), (getHeight()/2) - (h/2), w, h);
				}
			});
		}
		public PanelLayer(JPanel panel, float top, float left, float bottom, float right) {
			add(panel);		
			addComponentListener(new ComponentAdapter() {
				@Override
				public void componentResized(ComponentEvent e) {
					panel.setLocation(
							Math.round(getWidth() * top),
							Math.round(getHeight() * left)
					);
					panel.setSize(
							Math.round(getWidth() * bottom) - panel.getX(),
							Math.round(getHeight() * right) - panel.getY()
					);
				}
			});
		}
		public PanelLayer(JPanel panel, float horizontal, float vertical) {
			add(panel);	
			addComponentListener(new ComponentAdapter() {
				private int w,h;
				@Override
				public void componentResized(ComponentEvent e) {
					w = Math.round(getWidth() * horizontal);
					h = Math.round(getHeight() * vertical);
					panel.setBounds((getWidth()/2) - (w/2), (getHeight()/2) - (h/2), w, h);
				}
			});
		}
		@Override
		public void paint(Graphics g) {
			g.setColor(Shadow.shadow_color);
			g.fillRect(0, 0, getWidth(), getHeight());
			super.paint(g);
		}
	}
}
