package ui.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.Command;
import ui.buttons.StergeEmailButton;
import ui.buttons.StergeEmailHtmlButton;
import ui.buttons.StergeMesajButton;
import ui.combo.ComboEmail;
import ui.combo.ComboEmailHtml;
import ui.combo.ComboSMS;

public class StergeMesajFrame extends JPanel implements ActionListener{
	
	JLabel textVechi;
	JLabel comboLabel;
	JLabel textEmail;
	JLabel textHtml;
	
	ComboEmail comboEmail;
	ComboSMS combo;
	ComboEmailHtml comboHTML;
	
	StergeMesajButton button;
	StergeEmailButton buttonEmail;
	StergeEmailHtmlButton buttonHTML;
	
	public StergeMesajFrame() {
		
		this.textVechi = new JLabel("Selecteaza Mesaj ");
		this.add(textVechi);
		
		this.comboLabel = new JLabel();
		this.combo = new ComboSMS(comboLabel);
		
		this.add(combo);
		this.button = new StergeMesajButton(combo);
		this.add(button);
		this.button.addActionListener(this);
		
		
		this.textEmail = new JLabel("Selecteaza email");
		this.add(textEmail);
		this.comboEmail= new ComboEmail(textEmail);
		this.add(comboEmail);
		
		this.buttonEmail = new StergeEmailButton(comboEmail);
		this.add(buttonEmail);
		this.buttonEmail.addActionListener(this);
		
		
		this.textHtml = new JLabel("Selecteaza email HTML");
		this.add(textHtml);
		this.comboHTML = new ComboEmailHtml(textHtml);
		this.add(comboHTML);
		
		this.buttonHTML = new StergeEmailHtmlButton(comboHTML);
		this.add(buttonHTML);
		this.buttonHTML.addActionListener(this);

	
		
	}
	
	public void actionPerformed(ActionEvent e) {
		((Command)e.getSource()).execute();
	}

}
