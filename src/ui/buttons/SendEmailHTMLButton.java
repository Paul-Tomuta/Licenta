package ui.buttons;

import javax.swing.JButton;

import repo.Repository;
import ui.Command;
import ui.combo.ComboEmailHtml;
import ui.combo.ComboPersoana;

public class SendEmailHTMLButton extends JButton implements Command{
	
	ComboPersoana comboPersoana;
	ComboEmailHtml comboEmailHtml;
	
	
	
	public SendEmailHTMLButton(ComboPersoana cp, ComboEmailHtml ce ) {
		super("Send Email Html");
		
		this.comboPersoana=cp;
		this.comboEmailHtml=ce;
		
	}

	
	public void execute() {
		
		String comboPers = comboPersoana.getSelectedItem().toString().trim();
		String emailCombo = comboEmailHtml.getSelectedItem().toString().trim();
		
		Repository.getInstance().SendEmailHTML(comboPers, emailCombo);
		
		
	}

}
