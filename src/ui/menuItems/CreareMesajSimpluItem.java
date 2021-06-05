package ui.menuItems;

import javax.swing.JMenuItem;

import ui.frames.MainFrame;
import ui.Command;
import ui.frames.CreareMesajSimpluFrame;

public class CreareMesajSimpluItem extends JMenuItem implements Command{
	
	MainFrame mf;

	public CreareMesajSimpluItem(MainFrame mf) {
		super("Creaza mesaj simplu");
		this.mf = mf;
	}
	
	public void execute() {
		
		
		CreareMesajSimpluFrame lg = new CreareMesajSimpluFrame();
		this.mf.pannel.removeAll();
		this.mf.pannel.add(lg);
		this.mf.pannel.repaint();
		this.mf.repaint();
	}

}
