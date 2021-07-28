package ui.buttons;

import javax.swing.JButton;
import javax.swing.JLabel;

import repo.Repository;
import ui.Command;
import ui.combo.ComboPersoana;

public class StergePersoanaButton extends JButton implements Command {
	
	ComboPersoana text;

	public StergePersoanaButton(ComboPersoana text) {
		super("Stergeti persoana");
		
		this.text = text;
	}
	
	public void execute() {
		
		
		String nume = text.getSelectedItem().toString().trim();
		
		Repository.getInstance().stergePersoanaFull(nume);
		
		
		main.Main.logger.info("Persoana: " +nume+" a fost stearsa");
		
	}

}
