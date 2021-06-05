package ui.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import combo.ComboStudent;
import ui.Command;
import ui.buttons.ModificaClientButton;

public class ModificaClientFrame extends JPanel implements ActionListener{
	
	JLabel textFirst;
	JLabel textSecond;
	
	JTextField first;
	JTextField last;
	
	ComboStudent combo;
	ModificaClientButton button;
	
	public ModificaClientFrame() {
		
		this.textFirst = new JLabel("Selecteaza stundent");
		this.combo= new ComboStudent(textFirst);
		
		this.add(combo);
		
		
		this.textSecond = new JLabel("Introdu numele nou");
		this.add(textSecond);
		this.last = new JTextField(15);
		this.add(last);
		
		this.button = new ModificaClientButton(this.combo, this.last);
		this.add(button);
		
		this.button.addActionListener(this);
		
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		((Command)e.getSource()).execute();
	}

}
