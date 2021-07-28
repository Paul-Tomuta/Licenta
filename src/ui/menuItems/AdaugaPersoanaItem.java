package ui.menuItems;

import javax.swing.JMenuItem;

import ui.Command;
import ui.frames.AdaugaPersoanaFrame;
import ui.frames.MainFrame;


public class AdaugaPersoanaItem extends JMenuItem implements Command {
	
	MainFrame mf;
	
	public AdaugaPersoanaItem (MainFrame m) {
		super("Adauga Persoana");
		
		this.mf=m;
		
		
	}
	
	public void execute() {
		
		AdaugaPersoanaFrame lg = new AdaugaPersoanaFrame();
		this.mf.pannel.removeAll();
		this.mf.pannel.add(lg);
		this.mf.pannel.repaint();
		this.mf.repaint();
		
	}

}
