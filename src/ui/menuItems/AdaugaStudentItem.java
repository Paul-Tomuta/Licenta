package ui.menuItems;

import javax.swing.JMenuItem;

import ui.Command;
import ui.frames.AdaugaClientFrame;
import ui.frames.MainFrame;


public class AdaugaStudentItem extends JMenuItem implements Command {
	
	MainFrame mf;
	
	public AdaugaStudentItem (MainFrame m) {
		super("Adauga student");
		
		this.mf=m;
		
		
	}
	
	public void execute() {
		
		AdaugaClientFrame lg = new AdaugaClientFrame();
		this.mf.pannel.removeAll();
		this.mf.pannel.add(lg);
		this.mf.pannel.repaint();
		this.mf.repaint();
		
	}

}
