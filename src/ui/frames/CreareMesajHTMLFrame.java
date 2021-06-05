package ui.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ui.Command;
import ui.buttons.CreeareMesajHTMLButton;

public class CreareMesajHTMLFrame extends JPanel implements ActionListener{
	
	JLabel titluLabel;
	JTextField titluFIeld;
	
	JLabel textLabel;
	JTextField textField;
	
	CreeareMesajHTMLButton button;

	public CreareMesajHTMLFrame() {
		
		this.titluLabel = new JLabel("Introduceti titlul");
		this.add(titluLabel);
		this.titluFIeld = new JTextField(15);
		this.add(titluFIeld);
		
		this.textLabel = new JLabel("Introducesti textul");
		this.add(textLabel);
		this.textField= new JTextField(15);
		this.add(textField);
		
		this.button = new CreeareMesajHTMLButton(this.titluFIeld, this.textField);
		this.add(button);
		this.button.addActionListener(this);
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		((Command)e.getSource()).execute();
	}
}
