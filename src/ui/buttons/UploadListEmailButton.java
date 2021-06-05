package ui.buttons;

import javax.swing.JButton;
import javax.swing.JLabel;

import ui.Command;

public class UploadListEmailButton extends JButton implements Command{
	
	JLabel text;
	
	public UploadListEmailButton(JLabel txt) {
		super("Incarca fisier");
		
		this.text=txt;
		
		
	}

	public void execute() {
		
		
		
	}
}
