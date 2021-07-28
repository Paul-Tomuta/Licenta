package ui.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ui.Command;
import ui.buttons.CreareSmsButton;

public class CreareSmsFrame  extends JPanel implements ActionListener{
	
	JLabel titluLabel;
	JTextField titluField;
	JLabel textLabel;
	JTextField textField;
	
	CreareSmsButton button;
	
	public CreareSmsFrame() {
		
		this.titluLabel = new JLabel(" Introduce titlul ");
		this.add(titluLabel);
		this.titluField = new JTextField(15);
		this.add(titluField);
		
		this.textLabel = new JLabel(" Introduce textul ");
		this.add(textLabel);
		this.textField = new JTextField(15);
		this.add(textField);
		
		
		
		this.button = new CreareSmsButton(this.titluField, this.textField);
		this.add(button);
		this.button.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		((Command)e.getSource()).execute();
	}

}
