package ui.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import combo.StergeMesajCombo;
import ui.Command;
import ui.buttons.StergeMesajButton;

public class StergeMesajFrame extends JPanel implements ActionListener{
	
	JLabel textVechi;
	JLabel comboLabel;
	
	JTextField textVechiField;
	
	StergeMesajCombo combo;
	
	StergeMesajButton button;
	
	public StergeMesajFrame() {
		
		this.textVechi = new JLabel("Selecteaza Mesaj VECHI");
		this.add(textVechi);
		this.comboLabel = new JLabel();
		this.combo = new StergeMesajCombo(comboLabel);
		
		this.add(combo);
		
		this.textVechiField = new JTextField(15);
		this.add(textVechiField);
		
		this.button = new StergeMesajButton(this.textVechiField);
		this.add(button);
		this.button.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		((Command)e.getSource()).execute();
	}

}
