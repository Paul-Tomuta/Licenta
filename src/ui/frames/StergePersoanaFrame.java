package ui.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ui.Command;
import ui.buttons.StergePersoanaButton;
import ui.combo.ComboPersoana;

public class StergePersoanaFrame extends JPanel implements ActionListener {
	
	JLabel textFirst;

	ComboPersoana studenti;
	
	StergePersoanaButton button;
	
	public StergePersoanaFrame() {
		
		this.studenti =new ComboPersoana(textFirst);
		this.add(studenti);
		
		this.textFirst = new JLabel("Selectati studentu pe care doriti sa il stergeti");
		this.add(textFirst);
		
		this.button = new StergePersoanaButton(studenti);
		this.button.addActionListener(this);
		this.add(button);
		
		
	}

	public void actionPerformed(ActionEvent e) {
		((Command)e.getSource()).execute();
	}
}
