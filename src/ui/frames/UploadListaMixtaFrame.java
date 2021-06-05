package ui.frames;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.buttons.UploadListaMixtaButton;

public class UploadListaMixtaFrame extends JPanel{
	
	JLabel text ;
	
	UploadListaMixtaButton button;
	
	public UploadListaMixtaFrame() {
		
		this.text = new JLabel("Upload lista mixta");
		this.add(text);
		
		this.button = new UploadListaMixtaButton(this.text);
		this.add(button);
		//this.button.addActionListener(this);
	}
	
	

}
