package ui.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.Command;
import ui.buttons.SendEmailButton;
import ui.buttons.SendEmailHTMLButton;
import ui.buttons.SendSMSButton;
import ui.combo.ComboEmail;
import ui.combo.ComboEmailHtml;
import ui.combo.ComboPersoana;
import ui.combo.ComboSMS;

public class UtilitareFrame extends JPanel implements ActionListener{
	
	JLabel text;
	JPanel first;	
	JPanel last;
	ComboPersoana comboPersoana;
	ComboEmail comboEmail;
	ComboEmailHtml comboHtml;
	ComboSMS comboSms;
	
	JPanel second;
	
	JLabel selectEmail;
	JLabel selectSms;
	JLabel selectHtml;

	JLabel mesajEmail;
	
	
	SendEmailHTMLButton buttonEmailHTML;
	SendEmailButton buttonEmail;
	SendSMSButton buttonSMS;

	
	public UtilitareFrame() {
		
		
		this.first = new JPanel();
		first.setLayout(new BoxLayout(first, BoxLayout.Y_AXIS));
		this.add(first);		
		this.text = new JLabel("Selecteaza persoana");
		this.first.add(text);
		this.comboPersoana = new ComboPersoana(text);
		this.first.add(comboPersoana);
		
//////////////////////////////////////////////////////////////		
		this.second = new JPanel();
		second.setLayout(new BoxLayout(second, BoxLayout.Y_AXIS));
		this.add(second);
		
		this.selectEmail = new JLabel("Selecteaza Email");
		this.second.add(selectEmail);
		this.comboEmail = new ComboEmail(selectEmail);
		this.second.add(comboEmail);
		
		this.selectHtml = new JLabel("Selecteaza Email Html");
		this.second.add(selectHtml);
		this.comboHtml= new ComboEmailHtml(selectHtml);
		this.second.add(comboHtml);
		
		this.selectSms = new JLabel("Selecteaza SMS");
		this.second.add(selectSms);
		this.comboSms = new ComboSMS(selectSms);
		this.second.add(comboSms);
		
		//////////////////////
		
		this.last = new JPanel();
		last.setLayout(new BoxLayout(last, BoxLayout.Y_AXIS));
		this.add(last);
		
		this.buttonEmail = new SendEmailButton(comboPersoana, comboEmail);
		this.buttonEmail.addActionListener(this);
		this.last.add(buttonEmail);
		
		this.buttonEmailHTML = new SendEmailHTMLButton(comboPersoana, comboHtml);
		this.buttonEmailHTML.addActionListener(this);
		this.last.add(buttonEmailHTML);
		
		this.buttonSMS = new SendSMSButton(comboPersoana, comboSms);
		this.buttonSMS.addActionListener(this);
		this.last.add(buttonSMS);
		

		
	}
	
	public void actionPerformed(ActionEvent e) {
		((Command)e.getSource()).execute();
	}
}
