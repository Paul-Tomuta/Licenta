package ui.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ui.Command;
import ui.buttons.ModificaPersoanaButton;
import ui.combo.ComboPersoana;

public class ModificaPersoanaFrame extends JPanel implements ActionListener{
	
	JLabel textFirst;
	JLabel textSecond;
	
	JTextField numeField;
	
	ComboPersoana combo;
	ModificaPersoanaButton button;
	
	JLabel prenumeLabel;
	JLabel emailLabel;
	JLabel telefonLabel;
	 
	 JTextField prenumeField;
	 JTextField emailField;
	 JTextField telefonField;
	
	public ModificaPersoanaFrame() {
		
		this.textFirst = new JLabel("Selecteaza stundent");
		this.combo= new ComboPersoana(textFirst);
		
		this.add(combo);
		
		
		this.textSecond = new JLabel("Introdu numele nou");
		this.add(textSecond);
		this.numeField = new JTextField(15);
		this.add(numeField);
		
		this.prenumeLabel = new JLabel("Introdu Prenume nou");
		this.add(prenumeLabel);
		this.prenumeField = new JTextField(15);
		this.add(prenumeField);
		
		this.emailLabel = new JLabel("Introdu email nou");
		this.add(emailLabel);
		this.emailField = new JTextField(15);
		this.add(emailField);
		
		this.telefonLabel = new JLabel("Introdu telefon nou");
		this.add(telefonLabel);
		this.telefonField = new JTextField(15);
		this.add(telefonField);
		
		
		this.button = new ModificaPersoanaButton(this.combo, this.numeField, this.prenumeField,this.emailField,this.telefonField);
		this.add(button);
		
		this.button.addActionListener(this);
		
		this.revalidate();
	}
	
	public void actionPerformed(ActionEvent e) {
		((Command)e.getSource()).execute();
	}

}
