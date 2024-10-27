package components;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tab extends PanelRoundRect implements MouseListener{
	private static final long serialVersionUID = 3839302809616823664L;
	private boolean toggled;
	private JLabel label;
	private JPanel panel;

	public Tab(String title, JPanel panel){
		setArc(20);
		setCorner(2, false);
		setCorner(3, false);
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension( 100, 40));
		setMinimumSize(getPreferredSize());
		setMaximumSize(getPreferredSize());
		setBackground(main_color[0].brighter());
		setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		
		label = new JLabel(title);
		label.setFont(font[0]);
		label.setForeground(text_color[3]);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		add(label, BorderLayout.CENTER);
		
		setPanel(panel);
		
		addMouseListener(this);
	}
	public JLabel getLabel() {
		return label;
	}
	public void setLabel(JLabel label) {
		this.label = label;
	}
	public void toggle() {
		toggled = !toggled;
		if(toggled) {
			label.setForeground(text_color[0]);
			setBackground(main_color[2]);
		}
		else {
			label.setForeground(text_color[3]);
			setBackground(main_color[0].brighter());
		}
		repaint();
	}
	public boolean isToggled() {
		return toggled;
	}
	public JPanel getPanel() {
		return panel;
	}
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		toggle();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if(!isToggled()) {
			label.setForeground(text_color[3]);
			setBackground(main_color[0]);
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if(!isToggled()) {
			label.setForeground(text_color[3]);
			setBackground(main_color[0].brighter());
		}
	}
}
