package ui.menuItems;

import javax.swing.JMenuItem;

import ui.Command;
import ui.frames.MainFrame;
import ui.frames.ModificaPersoanaFrame;

public class ModificaPersoanaItem extends JMenuItem  implements Command{
	
	MainFrame mf;

	public ModificaPersoanaItem(MainFrame mf) {
		super("Modifica Persoana");
		this.mf = mf;
	}
	
	public void execute() {
		
		
		ModificaPersoanaFrame lg = new ModificaPersoanaFrame();
		this.mf.pannel.removeAll();
		this.mf.pannel.add(lg);
		this.mf.pannel.repaint();
		this.mf.repaint();
	}

}
