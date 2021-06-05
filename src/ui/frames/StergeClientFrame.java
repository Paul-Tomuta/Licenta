package ui.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import combo.ComboStudent;
import ui.Command;
import ui.buttons.StergeClientButton;

public class StergeClientFrame extends JPanel implements ActionListener {
	
	JLabel textFirst;

	ComboStudent studenti;
	
	StergeClientButton button;
	
	public StergeClientFrame() {
		
		this.studenti =new ComboStudent(textFirst);
		this.add(studenti);
		
		this.textFirst = new JLabel("Selectati studentu pe care doriti sa il stergeti");
		this.add(textFirst);
		
		this.button = new StergeClientButton(studenti);
		this.button.addActionListener(this);
		this.add(button);
		
		
	}

	public void actionPerformed(ActionEvent e) {
		((Command)e.getSource()).execute();
	}
}
