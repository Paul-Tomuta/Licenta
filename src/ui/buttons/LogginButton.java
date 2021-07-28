package ui.buttons;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import ui.Command;
import xml.XmlParser;

public class LogginButton extends JButton implements Command{
	
	JTextField tParola;
	JTextField tRezultat;
	
	public LogginButton(JTextField tParola, JTextField tRezultat) {
		super("Login");
		
		this.tParola = tParola;
		this.tRezultat = tRezultat;
	}

	public void execute() {
		
		String parola = tParola.getText().trim();
		
		if (new XmlParser().verificaParola(parola)) {
			tRezultat.setText("Parola corecta");
		} else {
			tRezultat.setText("Parola gresita");
		}
	}
}