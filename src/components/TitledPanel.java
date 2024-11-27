package components;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class TitledPanel extends PanelRoundRect{
	private static final long serialVersionUID = 2770960288601698032L;
	private PanelHead panel_head;
	private PanelBody panel_body;

	public TitledPanel(Label title) {
		setLayout(new BorderLayout());
		
		panel_head = new PanelHead();
		title.setForeground(main_color[1]);
		panel_head.add(title);
		add(panel_head, BorderLayout.NORTH);
		
		panel_body = new PanelBody();
		add(panel_body, BorderLayout.CENTER);
	}
	public PanelHead getPanelHead() {
		return panel_head;
	}
	public void setPanelHead(PanelHead panel_head) {
		this.panel_head = panel_head;
	}
	public PanelBody getPanelBody() {
		return panel_body;
	}
	public void setPanelBody(PanelBody panel_body) {
		this.panel_body = panel_body;
	}
	
	private class PanelHead extends JPanel{
		private static final long serialVersionUID = -5060388821116578839L;

		public PanelHead() {
			setOpaque(false);
			setLayout(new BorderLayout());
		}
	}
	private class PanelBody extends JPanel{
		private static final long serialVersionUID = 460599379005674587L;

		public PanelBody() {
			setOpaque(false);
			setLayout(new BorderLayout());
		}
	}
}
