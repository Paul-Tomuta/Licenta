package ui.frames;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.buttons.UploadListEmailButton;

public class UploadListEmailFrame extends JPanel{
	
	JLabel testLabel;
	UploadListEmailButton uppButton;
	
	public UploadListEmailFrame() {
		
		this.testLabel = new JLabel("Incarca lista cu emailuri");
		this.add(testLabel);
		this.uppButton = new UploadListEmailButton(this.testLabel);
		
		//this.addAncestorListener(this);
		this.add(uppButton);
		
	}
	

}
