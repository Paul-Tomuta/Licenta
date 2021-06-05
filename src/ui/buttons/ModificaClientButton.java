package ui.buttons;

import javax.swing.JButton;
import javax.swing.JTextField;

import combo.ComboStudent;
import repo.Repository;
import ui.Command;

public class ModificaClientButton extends JButton implements Command {
	
	ComboStudent first;
	JTextField second;
	public ModificaClientButton(ComboStudent first, JTextField second) {
		super("Modifica Nume");
		
		this.first = first;
		this.second = second;
	}

	public void execute() {
		
		String textCombo = first.getSelectedItem().toString().trim();
		String numeNou = second.getText().toString().trim();
		
		Repository.getInstance().modificaNumeFull(textCombo, numeNou);
		
		
	}
}
