package ui.buttons;

import javax.swing.JButton;
import javax.swing.JTextField;

import repo.Repository;
import ui.Command;

public class AdaugaPersoanaButton extends JButton implements Command {

	JTextField textNume;
	JTextField textPrenume;
	JTextField textTelfon;
	JTextField textEmail;
	

	public AdaugaPersoanaButton(JTextField n, JTextField p, JTextField nr, JTextField e) {
		super("Adauga Student");

		this.textNume = n;
		this.textPrenume = p;
		this.textTelfon = nr;
		this.textEmail = e;
		

	}

	public void execute() {
		main.Main.logger.info("Persoana a fost creeata");
		
		String nume = textNume.getText().trim();
		String prenume = textPrenume.getText().trim();
		String numar = textTelfon.getText().trim();
		String email = textEmail.getText().trim();
		
		Repository.getInstance().adaugaPersoanaFull(nume, prenume, numar, email);

	}
}
