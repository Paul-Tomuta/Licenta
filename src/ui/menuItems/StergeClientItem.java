package ui.menuItems;

import javax.swing.JMenuItem;

import ui.Command;
import ui.frames.MainFrame;
import ui.frames.StergeClientFrame;

public class StergeClientItem extends JMenuItem implements Command {
	
	MainFrame mf;

	public StergeClientItem(MainFrame mf) {
		super("Sterge student");
		this.mf = mf;
	}
	
	public void execute() {
		
		
		StergeClientFrame lg = new StergeClientFrame();
		this.mf.pannel.removeAll();
		this.mf.pannel.add(lg);
		this.mf.pannel.repaint();
		this.mf.repaint();
	}

}
