package ui.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ui.Command;
import ui.buttons.LogginButton;

public class LogginFrame extends JPanel implements ActionListener {
	
	JPasswordField parolaTextField;
	JTextField resultatTextField;
	JLabel textLabel;
	
	
	LogginButton logginbuton;
	
	
	public LogginFrame() {
		
		

		this.textLabel = new JLabel("Introdu Parola");
		
		this.add(textLabel);
		
		this.parolaTextField = new JPasswordField(15);
		this.add(parolaTextField);
		
		this.resultatTextField = new JTextField(15);
		this.add(resultatTextField);
		
		this.logginbuton = new LogginButton(this.parolaTextField, this.resultatTextField);
		this.logginbuton.addActionListener(this);
		this.add(logginbuton);

	}
	
	public void actionPerformed(ActionEvent e) {
		((Command)e.getSource()).execute();
	}
	

}
