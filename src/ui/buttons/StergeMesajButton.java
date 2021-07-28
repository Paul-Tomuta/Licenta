package ui.buttons;

import javax.swing.JButton;
import javax.swing.JTextField;

import main.Main;
import repo.Repository;
import ui.Command;
import ui.combo.ComboSMS;

public class StergeMesajButton extends JButton implements Command{
	
	ComboSMS jtf;

	public StergeMesajButton(ComboSMS jtf) {
		super("Sterge mesaj");
		
		this.jtf = jtf;
	}
	
	public void execute() {
		
		
		String mesaj = jtf.getSelectedItem().toString().trim();
		
		Repository.getInstance().stergeSms(mesaj);
		
		Main.logger.info("SMS-ul :" +mesaj+" a fost sters");
	}

}
