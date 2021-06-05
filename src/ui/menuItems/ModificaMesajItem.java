package ui.menuItems;

import javax.swing.JMenuItem;

import ui.Command;
import ui.frames.MainFrame;
import ui.frames.ModificaMesajFrame;

public class ModificaMesajItem extends JMenuItem implements Command{
	
	MainFrame mf ;

	public ModificaMesajItem(MainFrame mf) {
		super("Modifica Mesaj");
		this.mf = mf;
	}
	
	public void execute() {
		
		ModificaMesajFrame lg = new ModificaMesajFrame();
		this.mf.pannel.removeAll();
		this.mf.pannel.add(lg);
		this.mf.pannel.repaint();
		this.mf.repaint();
	}
	

}
