package ui.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ui.Command;
import ui.buttons.CreareEmailSimpluButton;


public class CreareMesajSimpluFrame extends JPanel implements ActionListener {
	
	JLabel titluLabel;
	JLabel textLabel;
	
	JTextField titluField;
	JTextField textField;
	
	CreareEmailSimpluButton button;

	public CreareMesajSimpluFrame() {
		
		this.titluLabel = new JLabel("Introduceti tutlu mesajului");
		this.add(titluLabel);
		
		this.titluField = new JTextField(15);
		BoxLayout layout = new BoxLayout(titluField, BoxLayout.Y_AXIS);
		this.titluField.setLayout(layout);
		this.add(titluField);
		
		this.textLabel = new JLabel("Introduceti textul");
		this.add(textLabel);
		this.textField = new JTextField(40);
		this.add(textField);
		
		
		this.button = new CreareEmailSimpluButton(this.titluField, this.textField);
		this.add(button);
		this.button.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		((Command)e.getSource()).execute();
	}
}
