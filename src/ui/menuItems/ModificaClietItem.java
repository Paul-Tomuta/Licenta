package ui.menuItems;

import javax.swing.JMenuItem;

import ui.Command;
import ui.frames.MainFrame;
import ui.frames.ModificaClientFrame;

public class ModificaClietItem extends JMenuItem  implements Command{
	
	MainFrame mf;

	public ModificaClietItem(MainFrame mf) {
		super("Modifica Student");
		this.mf = mf;
	}
	
	public void execute() {
		
		
		ModificaClientFrame lg = new ModificaClientFrame();
		this.mf.pannel.removeAll();
		this.mf.pannel.add(lg);
		this.mf.pannel.repaint();
		this.mf.repaint();
	}

}
