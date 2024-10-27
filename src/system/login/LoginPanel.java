package system.login;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import components.PasswordField;
import components.ButtonRoundRect;
import components.PanelRoundRect;
import components.SeamlessButton;
import database.MySQL_Security;
import extras.Settings;
import extras.Shadow;
import oop.objects.Access;
import res.Resource;

public abstract class LoginPanel extends JPanel{
	private static final long serialVersionUID = 1519322616962176557L;
	private PanelRoundRect roundRect_panel;
	private PasswordField password_field;
	private Graphics2D g2d;

	public LoginPanel() {
		setOpaque(false);
		
		FlowLayout flow_layout = new FlowLayout(FlowLayout.CENTER);
		setLayout(flow_layout);
		
		setPreferredSize(new Dimension(300,400));
		setMaximumSize(getPreferredSize());
		setMinimumSize(getPreferredSize());
		
		roundRect_panel = new PanelRoundRect();
		roundRect_panel.setArc(20);
		roundRect_panel.setPreferredSize(new Dimension(300,400));
		roundRect_panel.setMaximumSize(getPreferredSize());
		roundRect_panel.setMinimumSize(getPreferredSize());
		roundRect_panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		roundRect_panel.setLayout(new BorderLayout());
		add(roundRect_panel);
		
		JLabel logo = new JLabel(new ImageIcon(new Resource().get("ABM LOGO.png")));
		roundRect_panel.add(logo, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
		roundRect_panel.add(panel, BorderLayout.CENTER);

		BoxLayout box_layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(box_layout);
		
		password_field = new PasswordField();
		password_field.setAlignmentX(PasswordField.CENTER_ALIGNMENT);
		password_field.addKeyListener(new PasswordKeyListener());
		panel.add(Box.createVerticalStrut(10));
		panel.add(password_field);
		
		ButtonRoundRect login_btn = new ButtonRoundRect();
		login_btn.setText("Log In");
		login_btn.addActionListener(new LoginActionListener());
		login_btn.setAlignmentX(ButtonRoundRect.CENTER_ALIGNMENT);
		panel.add(Box.createVerticalStrut(10));
		panel.add(login_btn);
		
		SeamlessButton cancel_exit = new SeamlessButton();
		cancel_exit.setText("Cancel or Exit");
		cancel_exit.setAlignmentX(ButtonRoundRect.CENTER_ALIGNMENT);
		cancel_exit.addActionListener(new ExitActionListener());
		panel.add(Box.createVerticalStrut(5));
		panel.add(cancel_exit);
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				flow_layout.setVgap((getHeight()-roundRect_panel.getHeight()) / 2);
				revalidate();
				repaint();
			}
		});
	}
	@Override
	public void paint(Graphics g) {
		g2d = (Graphics2D)g;
		Settings.rendering_hint(g2d);
		Shadow.cast_shadow(roundRect_panel.getArea(), roundRect_panel.getX(), roundRect_panel.getY() + 5, g2d);
		super.paint(g2d);
	}
	private void inputPassword(char password[]) {
		Access access = MySQL_Security.getAccess(password);
		
		if(access != null) {
			switch(access.getRole()){
			case adm:

				password_field.setText("");
				password_field.setMessage("Welcome Admin...");
				openAdminInterface();
				break;
			case emp:

				password_field.setText("");
				password_field.setMessage("Welcome Employee...");
				openEmployeeInterface();
				break;
			default:
				password_field.setText("");
				password_field.setMessage("Unidentified...");
				break;
			}
		}
		else {
			password_field.setText("");
			password_field.setMessage("Wrong Password!");
		}
	}
	public abstract void openAdminInterface();
	public abstract void openEmployeeInterface();
	
	private class PasswordKeyListener implements KeyListener{
		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				inputPassword(password_field.getPassword());
			}
		}
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
		}
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
		}
	}
	private class LoginActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			inputPassword(password_field.getPassword());			
		}
	}
	private class ExitActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}
