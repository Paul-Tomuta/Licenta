package ui.buttons;

import javax.swing.JButton;
import javax.swing.JTextField;

import main.Main;
import repo.Repository;
import ui.Command;
import ui.combo.ComboSMS;
import ui.combo.ComboEmail;

public class ModificaEmailButton extends JButton implements Command{
	
	ComboEmail textVechil;
	JTextField titluNou;
	JTextField textNou;
	
	public ModificaEmailButton(ComboEmail tv, JTextField tn, JTextField tnn) {
		super("Modifica email");
		
		
		this.textVechil = tv;
		this.titluNou = tn;
		this.textNou=tnn;
	}

	public void execute() {
		
		
		String numeVechi = textVechil.getSelectedItem().toString().trim();
		String numeNou = titluNou.getText().toString().trim();
		String textnou = textNou.getText().toString().trim();
		
		Repository.getInstance().mdoficaMesajEmailSimplu(numeVechi, numeNou,textnou);
		
		Main.logger.info("Email-ul cu titlul: " +numeVechi+" A fost modificat cu:  Titlu: " +numeNou+" Textul : "+textnou);
	}
}
