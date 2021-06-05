package ui.buttons;

import javax.swing.JButton;
import javax.swing.JTextField;

import repo.Repository;
import ui.Command;

public class ModificaMesajButton extends JButton implements Command{
	
	JTextField textVechil;
	JTextField textnou;
	
	public ModificaMesajButton(JTextField tv, JTextField tn) {
		super("Modifica Mesaj");
		
		
		this.textVechil = tv;
		this.textnou = tn;
	}

	public void execute() {
		
		String numeVechi = textVechil.getText().toString().trim();
		String numeNou = textnou.getText().toString().trim();
		
		Repository.getInstance().modificaNumeSMS(numeVechi, numeNou);
		
		
	}
}
