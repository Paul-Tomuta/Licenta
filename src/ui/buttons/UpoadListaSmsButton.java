package ui.buttons;

import javax.swing.JButton;
import javax.swing.JLabel;

import ui.Command;

public class UpoadListaSmsButton extends JButton implements Command {
	
	JLabel text;
	
	public UpoadListaSmsButton(JLabel t) {
		super("Incara Lista sms");
		
		this.text=t;
	}
	
	public void execute() {
		
		
		
	}

}
