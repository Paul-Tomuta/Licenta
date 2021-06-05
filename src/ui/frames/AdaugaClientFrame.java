package ui.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ui.Command;
import ui.buttons.AdaugaStudentButton;

public class AdaugaClientFrame extends JPanel implements ActionListener{
	
	JLabel textLabel;
	JTextField textField;
	
	JLabel textPrenumeLabel;
	JTextField textPrenumeField;
	
	JLabel textTelefonLabel;
	JTextField textTelefonField;
	
	JLabel textEmailLabel;
	JTextField textEmailField;
	
	
	AdaugaStudentButton button;
	
	public AdaugaClientFrame() {
		
		this.textLabel = new JLabel("Introdu numele");
		this.add(textLabel);
		this.textField = new  JTextField(15);
		this.add(textField);
		
		this.textPrenumeLabel = new JLabel("Intreduceti prenumele");
		this.add(textPrenumeLabel);
		this.textPrenumeField = new JTextField(15);
		this.add(textPrenumeField);
		
		this.textTelefonLabel = new JLabel("Introdu numarul de telefon");
		this.add(textTelefonLabel);
		this.textTelefonField = new JTextField(15);
		this.add(textTelefonField);
		
		this.textEmailLabel = new JLabel("Introdu numarul de telefon");
		this.add(textEmailLabel);
		this.textEmailField = new JTextField(15);
		this.add(textEmailField);
		
		
		
		
		this.button = new AdaugaStudentButton(this.textField, this.textPrenumeField, this.textTelefonField, this.textEmailField);
		this.button.addActionListener(this);
		this.add(button);
		
		
		
		
	}
	public void actionPerformed(ActionEvent e) {
		((Command)e.getSource()).execute();
	}

}
