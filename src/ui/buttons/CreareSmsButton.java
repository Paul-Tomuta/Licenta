package ui.buttons;

import javax.swing.JButton;
import javax.swing.JTextField;

import repo.Repository;
import ui.Command;

public class CreareSmsButton extends JButton implements Command {
	
	JTextField titluField;
	JTextField textField;
	

	public CreareSmsButton(JTextField te, JTextField tf) {
		super("Trimite sms");
		
		this.titluField = te;
		this.textField = tf;
	}
	
	
	public void execute() {
		main.Main.logger.info("Mesajul a fost creeat");
		
		
		String titlu = titluField.getText().toString().trim();
		String text = textField.getText().toString().trim();
		
		Repository.getInstance().adaugaSms(titlu, text);
		
	}

}
