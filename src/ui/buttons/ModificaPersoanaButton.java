package ui.buttons;

import javax.swing.JButton;
import javax.swing.JTextField;

import main.Main;
import repo.Repository;
import ui.Command;
import ui.combo.ComboPersoana;

public class ModificaPersoanaButton extends JButton implements Command {
	
	ComboPersoana first;
	JTextField nume;
	JTextField prenume;
	JTextField email;
	JTextField telefon;
	
	
	
	public ModificaPersoanaButton(ComboPersoana first, JTextField nume,JTextField prenume, JTextField email , JTextField telefon) {
		super("Modifica");
		
		this.first = first;
		this.nume = nume;
		this.prenume=prenume;
		this.email=email;
		this.telefon=telefon;
	}

	public void execute() {
		
		String textCombo = first.getSelectedItem().toString().trim();
		String numeNou = nume.getText().toString().trim();
		String prenumeNou = prenume.getText().toString().trim();
		String emailNou = email.getText().toString().trim();
		String telefonNou = telefon.getText().toString().trim();
		
		Repository.getInstance().modificaNumeFull(textCombo, numeNou, prenumeNou,emailNou,telefonNou);
		
		Main.logger.info("Persoana: " +textCombo+" A fost modificat cu:  Nume: " +numeNou+" Prenume: "+prenumeNou+ " Email: " +emailNou+ " Telefon: "+telefonNou);
	}
}
