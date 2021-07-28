package ui.buttons;

import javax.swing.JButton;
import javax.swing.JTextField;

import repo.Repository;
import ui.Command;

public class CreeareMesajHTMLButton extends JButton implements Command {
	
	JTextField titluField;
	JTextField textField;

	public CreeareMesajHTMLButton(JTextField text, JTextField tf) {
		super("Creaza Mesaj HTML");
		this.titluField = text;
		this.textField = tf;
	};
	
	public void execute() {
		main.Main.logger.info("Email-ul HTML  a fost creeat");
		
		String titlu = titluField.getText().toString().trim();
		String text = textField.getText().toString().trim();
		
		Repository.getInstance().adaugaMesajEmailHTML(titlu, text);
		
		
	}

}
