package ui.buttons;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import ui.Command;

public class LogginButton extends JButton implements Command{
	
	JTextField text;
	
	public LogginButton(JTextField t) {
		super("Loggin");
		
		this.text= t;
	}

	public void execute() {
		
		
		
	}
}
