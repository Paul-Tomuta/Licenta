package ui.buttons;

import javax.swing.JButton;
import javax.swing.JTextField;

import repo.Repository;
import ui.Command;

public class AdaugaStudentButton extends JButton implements Command {

	JTextField textNume;
	JTextField textPrenume;
	JTextField textTelfon;
	JTextField textEmail;
	

	public AdaugaStudentButton(JTextField n, JTextField p, JTextField nr, JTextField e) {
		super("Adauga Student");

		this.textNume = n;
		this.textPrenume = p;
		this.textTelfon = e;
		this.textEmail = nr;
		

	}

	public void execute() {
		main.Main.logger.info("Studentu a fost adaugat");
		
		String nume = textNume.getText().trim();
		String prenume = textPrenume.getText().trim();
		String numar = textTelfon.getText().trim();
		String email = textEmail.getText().trim();
		
		Repository.getInstance().adaugaStudentFull(nume, prenume, numar, email);

	}
}
