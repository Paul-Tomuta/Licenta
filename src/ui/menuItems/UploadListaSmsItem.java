package ui.menuItems;

import javax.swing.JMenuItem;

import ui.Command;
import ui.frames.MainFrame;
import ui.frames.UploadListaSmsFrame;

public class UploadListaSmsItem extends JMenuItem implements Command {
	
	MainFrame mf;
	
	public UploadListaSmsItem(MainFrame m) {
		super("Incarca lista sms");
		
		this.mf=m;
		
	}
	
	public void execute() {
		
		UploadListaSmsFrame lg = new UploadListaSmsFrame();
		this.mf.pannel.removeAll();
		this.mf.pannel.add(lg);
		this.mf.pannel.repaint();
		this.mf.repaint();
		
		
	}

}
