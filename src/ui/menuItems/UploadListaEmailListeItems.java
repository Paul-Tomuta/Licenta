package ui.menuItems;

import javax.swing.JMenuItem;

import ui.Command;
import ui.frames.MainFrame;
import ui.frames.UploadListEmailFrame;

public class UploadListaEmailListeItems extends JMenuItem implements Command {
	
	MainFrame mf; 
	
	public UploadListaEmailListeItems(MainFrame m) {
		super("Upload Lista Email");
		
		this.mf=m;
		
		
	}

	public void execute() {
		
		UploadListEmailFrame ulef = new UploadListEmailFrame();
		this.mf.pannel.removeAll();
		this.mf.pannel.add(ulef);
		this.mf.pannel.repaint();
		this.mf.repaint();
	}
}
