package ui.buttons;

import javax.swing.JButton;
import javax.swing.JLabel;

import combo.ComboStudent;
import repo.Repository;
import ui.Command;

public class StergeClientButton extends JButton implements Command {
	
	ComboStudent text;

	public StergeClientButton(ComboStudent text) {
		super("Stergeti Stduentu");
		
		this.text = text;
	}
	
	public void execute() {
		main.Main.logger.info("Studentu a fost sters");
		String nume = text.getSelectedItem().toString().trim();
		
		Repository.getInstance().stergeStudentFull(nume);
		
	}

}
