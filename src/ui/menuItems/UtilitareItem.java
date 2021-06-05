package ui.menuItems;

import javax.swing.JMenuItem;

import ui.Command;
import ui.frames.MainFrame;
import ui.frames.UtilitareFrame;

public class UtilitareItem extends JMenuItem implements Command {
	
	MainFrame mf;

	public UtilitareItem(MainFrame mf) {
		super("Utilitare");
		this.mf = mf;
	}
	
	public void execute() {
		
		
		UtilitareFrame lg = new UtilitareFrame();
		this.mf.pannel.removeAll();
		this.mf.pannel.add(lg);
		this.mf.pannel.repaint();
		this.mf.repaint();
	}
	

}
