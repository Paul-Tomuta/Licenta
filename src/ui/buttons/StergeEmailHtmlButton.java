package ui.buttons;

import javax.swing.JButton;

import main.Main;
import repo.Repository;
import ui.Command;
import ui.combo.ComboEmailHtml;

public class StergeEmailHtmlButton extends JButton implements Command{
	
	ComboEmailHtml jtf;

	public StergeEmailHtmlButton(ComboEmailHtml jtf) {
		super("Sterge emailHTML");
		
		this.jtf = jtf;
	}
	
	public void execute() {
	
		
		String mesaj = jtf.getSelectedItem().toString().trim();
		
		Repository.getInstance().stergeMesajEmailHTML(mesaj);
		
		Main.logger.info("Email-ul HTML :" +mesaj+" a fost sters");
	}

}
