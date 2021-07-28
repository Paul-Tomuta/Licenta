package ui.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.Command;
import ui.buttons.UpoadListaSmsButton;

public class UploadListaSmsFrame extends JPanel implements ActionListener {

	JLabel textLabel;

	UpoadListaSmsButton button;

	public UploadListaSmsFrame() {

		this.textLabel = new JLabel("Adauga lista sms");
		this.add(textLabel);
		
		this.button = new UpoadListaSmsButton(this.textLabel);
		this.button.addActionListener(this);
		this.add(button);

	}

	public void actionPerformed(ActionEvent e) {
		((Command) e.getSource()).execute();
	}

}
