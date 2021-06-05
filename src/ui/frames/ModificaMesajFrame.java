package ui.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import combo.ModificaMesajCombo;
import ui.Command;
import ui.buttons.ModificaMesajButton;

public class ModificaMesajFrame extends JPanel implements ActionListener {
	
	JLabel txtVechiLabel;
	JLabel txtNouLabel;
	
	JTextField txtNouField;
	JTextField txtVechiField;
	
	ModificaMesajCombo combo;
	
	
	ModificaMesajButton button;
	
	
	public ModificaMesajFrame() {
	
		this.txtVechiLabel = new JLabel("Selectati mesaju pe care vreti sa il schimbati");
		this.add(txtVechiLabel);
		this.combo= new ModificaMesajCombo(txtVechiField);
		this.add(combo);
		
		this.txtVechiField = new JTextField(15);
		this.add(txtVechiField);
		
		
		
		
		this.txtVechiLabel = new JLabel("Adaugati mesaj nou");
		this.add(txtVechiLabel);
		this.txtNouField = new JTextField(15);
		this.add(txtNouField);
	
		this.button = new ModificaMesajButton(this.txtVechiField, this.txtNouField);
		this.add(button);
		this.button.addActionListener(this);
}
	
	public void actionPerformed(ActionEvent e) {
		((Command)e.getSource()).execute();
	}
	
}
