package ui.buttons;

import javax.swing.JButton;
import javax.swing.JTextField;

import repo.Repository;
import ui.Command;

public class CreareEmailSimpluButton extends JButton implements Command {
	
	JTextField titlu;
	JTextField text;

	public CreareEmailSimpluButton(JTextField mesaj, JTextField text) {
		super("Creaza Mesaj");
		
		this.titlu = mesaj;
		this.text = text;
	}
	
	public void execute() {
		main.Main.logger.info("Email-ul a fost creeat");
		
		String textTitlu = titlu.getText().toString().trim();
		String testMesaj = text.getText().toString().trim();
		
		Repository.getInstance().adaugaMesajEmailSimplu(textTitlu, testMesaj);
		
		
	}
	

}
