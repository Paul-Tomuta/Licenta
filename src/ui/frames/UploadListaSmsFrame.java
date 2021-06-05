package ui.frames;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.buttons.UpoadListaSmsButton;

public class UploadListaSmsFrame extends JPanel {
	
	JLabel textLabel;
	
	UpoadListaSmsButton button;
	
	public UploadListaSmsFrame() {
		
		this.textLabel = new JLabel("Adauga lista sms");
		this.add(textLabel);
		this.button = new UpoadListaSmsButton(this.textLabel);
		this.add(button);
		
		
		
	}
	

}
