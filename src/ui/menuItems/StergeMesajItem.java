package ui.menuItems;

import javax.swing.JMenuItem;

import ui.Command;
import ui.frames.MainFrame;
import ui.frames.StergeMesajFrame;

public class StergeMesajItem extends JMenuItem implements Command  {
	
	MainFrame mf;

	public StergeMesajItem(MainFrame mf) {
		super("Sterge mesaj");
		this.mf = mf;
	}
	
	public void execute() {
		
		
		StergeMesajFrame lg = new StergeMesajFrame();
		this.mf.pannel.removeAll();
		this.mf.pannel.add(lg);
		this.mf.pannel.repaint();
		this.mf.repaint();
	}

}
