package ui.buttons;

import javax.swing.JButton;

import main.Main;
import repo.Repository;
import ui.Command;
import ui.combo.ComboEmail;

public class StergeEmailButton extends JButton implements Command{
	
	ComboEmail jtf;

	public StergeEmailButton(ComboEmail jtf) {
		super("Sterge email");
		
		this.jtf = jtf;
	}
	
	public void execute() {
		
		
		String mesaj = jtf.getSelectedItem().toString().trim();
		
		Repository.getInstance().stergeMesajEmailSimplu(mesaj);
		
		Main.logger.info("Email-ul :" +mesaj+" a fost sters");
	}

}
