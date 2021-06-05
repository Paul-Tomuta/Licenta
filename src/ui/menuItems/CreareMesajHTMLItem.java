package ui.menuItems;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import ui.Command;
import ui.frames.CreareMesajHTMLFrame;
import ui.frames.MainFrame;

public class CreareMesajHTMLItem extends JMenuItem implements Command{
	
	MainFrame mf;

	public CreareMesajHTMLItem(MainFrame mf) {
		super("Creare mesaj HTML");
		this.mf = mf;
	}
	
	public void execute() {
		
		CreareMesajHTMLFrame lg = new CreareMesajHTMLFrame();
		this.mf.pannel.removeAll();
		this.mf.pannel.add(lg);
		this.mf.pannel.repaint();
		this.mf.repaint();
		
	}

}
