package ui.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.AncestorListener;

import ui.Command;
import ui.buttons.UploadListEmailButton;

public class UploadListEmailFrame extends JPanel implements ActionListener {

	JLabel testLabel;
	
	UploadListEmailButton uppButton;

	public UploadListEmailFrame() {

		this.testLabel = new JLabel("Incarca lista cu emailuri");
		this.add(testLabel);
		this.uppButton = new UploadListEmailButton(this.testLabel);

		this.uppButton.addActionListener(this);
		this.add(uppButton);

	}

	public void actionPerformed(ActionEvent e) {
		((Command) e.getSource()).execute();
	}

}
