package ui.buttons;

import javax.swing.JButton;
import javax.swing.JTextField;

import ui.Command;

public class StergeMesajButton extends JButton implements Command{
	
	JTextField jtf;

	public StergeMesajButton(JTextField jtf) {
		super("Sterge mesaj");
		this.jtf = jtf;
	}
	
	public void execute() {
		
		
	}

}
