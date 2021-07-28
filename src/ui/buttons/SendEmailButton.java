package ui.buttons;

import javax.swing.JButton;

import repo.Repository;
import ui.Command;
import ui.combo.ComboEmail;
import ui.combo.ComboPersoana;

public class SendEmailButton extends JButton implements Command{
	
	ComboPersoana comboPersoana;
	ComboEmail comboEmailHtml;
	
	
	
	public SendEmailButton(ComboPersoana cp, ComboEmail ce ) {
		super("Send Email");
		
		this.comboPersoana=cp;
		this.comboEmailHtml=ce;
		
	}

	
	public void execute() {
		
		String comboPers = comboPersoana.getSelectedItem().toString().trim();
		String emailCombo = comboEmailHtml.getSelectedItem().toString().trim();
		
		Repository.getInstance().SendEmail(comboPers, emailCombo);
		
		
	}

}
