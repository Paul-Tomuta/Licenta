package ui.menuItems;

import javax.swing.JMenuItem;

import ui.Command;
import ui.frames.MainFrame;
import ui.frames.StergePersoanaFrame;

public class StergePersoanaItem extends JMenuItem implements Command {
	
	MainFrame mf;

	public StergePersoanaItem(MainFrame mf) {
		super("Sterge Persoana");
		this.mf = mf;
	}
	
	public void execute() {
		
		
		StergePersoanaFrame lg = new StergePersoanaFrame();
		this.mf.pannel.removeAll();
		this.mf.pannel.add(lg);
		this.mf.pannel.repaint();
		this.mf.repaint();
	}

}
