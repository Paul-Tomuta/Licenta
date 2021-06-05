package ui.buttons;

import javax.swing.JButton;
import javax.swing.JLabel;

import ui.Command;

public class UploadListaMixtaButton extends JButton implements Command{

	JLabel txt;
	
	public UploadListaMixtaButton(JLabel t) {
		super("Upload lista mixta");
		
		this.txt = t;
	}
	
	public void execute () {
		
		
	}
}
