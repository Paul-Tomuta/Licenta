package ui.menuItems;

import javax.swing.JMenuItem;

import ui.Command;
import ui.frames.MainFrame;
import ui.frames.UploadListaMixtaFrame;

public class UploadListaMixtaItem extends JMenuItem implements Command {
	
	MainFrame mf;
	 
	public UploadListaMixtaItem(MainFrame m) {
		super("Upload lista Mixta");
		
		this.mf=m;
		
	}
	
	public void execute() {
		
		UploadListaMixtaFrame lg = new UploadListaMixtaFrame();
		this.mf.pannel.removeAll();
		this.mf.pannel.add(lg);
		this.mf.pannel.repaint();
		this.mf.repaint();
		
		
	}

}
