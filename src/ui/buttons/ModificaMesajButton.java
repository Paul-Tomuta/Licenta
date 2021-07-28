package ui.buttons;

import javax.swing.JButton;
import javax.swing.JTextField;

import main.Main;
import repo.Repository;
import ui.Command;
import ui.combo.ComboSMS;

public class ModificaMesajButton extends JButton implements Command{
	
	ComboSMS textVechil;
	JTextField textnou;
	JTextField textNou;
	
	public ModificaMesajButton(ComboSMS tv, JTextField tn, JTextField tnn) {
		super("Modifica Mesaj");
		
		
		this.textVechil = tv;
		this.textnou = tn;
		this.textNou=tnn;
	}

	public void execute() {
		
		String numeVechi = textVechil.getSelectedItem().toString().trim();
		String numeNou = textnou.getText().toString().trim();
		String textnou = textNou.getText().toString().trim();
		
		Repository.getInstance().modificaSMS(numeVechi, numeNou,textnou);
		
		Main.logger.info("SMS-ul cu titlul: " +numeVechi+" A fost modificat cu:  Titlu: " +numeNou+" Textul : "+textnou);
		
	}
}
