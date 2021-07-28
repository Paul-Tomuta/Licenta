package ui.buttons;

import javax.swing.JButton;

import repo.Repository;
import ui.Command;
import ui.combo.ComboEmail;
import ui.combo.ComboPersoana;
import ui.combo.ComboSMS;

public class SendSMSButton extends JButton implements Command{
	
	ComboPersoana comboPersoana;
	ComboSMS comboEmailHtml;
	
	
	
	public SendSMSButton(ComboPersoana cp, ComboSMS ce ) {
		super("Send SMS");
		
		this.comboPersoana=cp;
		this.comboEmailHtml=ce;
		
	}

	
	public void execute() {
		
		String comboPers = comboPersoana.getSelectedItem().toString().trim();
		String emailCombo = comboEmailHtml.getSelectedItem().toString().trim();
		
		Repository.getInstance().SendSms(comboPers, emailCombo);
		
		
	}

}
