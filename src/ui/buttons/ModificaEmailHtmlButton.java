package ui.buttons;

import javax.swing.JButton;
import javax.swing.JTextField;

import main.Main;
import repo.Repository;
import ui.Command;
import ui.combo.ComboSMS;
import ui.combo.ComboEmail;
import ui.combo.ComboEmailHtml;

public class ModificaEmailHtmlButton extends JButton implements Command{
	
	ComboEmailHtml textVechil;
	JTextField titluNou;
	JTextField textNou;
	
	public ModificaEmailHtmlButton(ComboEmailHtml tv, JTextField tn, JTextField tnn) {
		super("Modifica HTML");
		
		
		this.textVechil = tv;
		this.titluNou = tn;
		this.textNou=tnn;
	}

	public void execute() {
		
		String numeVechi = textVechil.getSelectedItem().toString().trim();
		String numeNou = titluNou.getText().toString().trim();
		String textnou = textNou.getText().toString().trim();
		
		Repository.getInstance().modificaMesajHtml(numeVechi, numeNou,textnou);
		
		Main.logger.info("Email-ul HTML cu titlul: " +numeVechi+" A fost modificat cu:  Titlu: " +numeNou+" Textul : "+textnou);
	}
}
