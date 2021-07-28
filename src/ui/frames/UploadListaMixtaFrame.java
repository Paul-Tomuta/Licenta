package ui.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.Command;
import ui.buttons.UploadListaMixtaButton;

public class UploadListaMixtaFrame extends JPanel implements ActionListener {

	JLabel text;

	UploadListaMixtaButton button;

	public UploadListaMixtaFrame() {

		this.text = new JLabel("Upload lista mixta");
		this.add(text);

		this.button = new UploadListaMixtaButton(this.text);
		this.add(button);
		this.button.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		((Command) e.getSource()).execute();
	}

}
