package components;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public abstract class ActionPanel extends TitledPanel{
	private static final long serialVersionUID = 7853217988420344926L;
	private JPanel button_pane;
	private Button ok, cancel;

	public ActionPanel(Label title) {
		super(title);
		
		button_pane = new JPanel();
		button_pane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		button_pane.setOpaque(false);
		add(button_pane, BorderLayout.SOUTH);
		
		ok = new Button();
		ok.setText("ok");
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onOk();
			}
		});
		button_pane.add(ok);
		
		cancel = new Button();
		cancel.setText("cancel");
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onCancel();
			}
		});
		button_pane.add(cancel);
	}
	public abstract void onOk();
	public abstract void onCancel();
}
