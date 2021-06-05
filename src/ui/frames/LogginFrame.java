package ui.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import ui.buttons.LogginButton;

public class LogginFrame extends JPanel {
	
	JTextField textField;
	JLabel textLabel;
	
	LogginButton logginbuton;
	
	
	public LogginFrame() {
		
		

		this.textLabel = new JLabel("Introdu Parola");
		
		this.add(textLabel);
		this.textField = new JTextField(15);
		this.add(textField);
		
		this.logginbuton = new LogginButton(this.textField);
		//this.logginbuton.addActionListener(this);
		this.add(logginbuton);
		
		
		
		
	}

	

}
