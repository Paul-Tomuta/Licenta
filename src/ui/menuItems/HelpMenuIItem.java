package ui.menuItems;

import javax.swing.JMenuItem;

import ui.Command;
import ui.frames.HelpFrame;
import ui.frames.MainFrame;

public class HelpMenuIItem extends JMenuItem implements Command {
	
	MainFrame  mf ;
	
	public HelpMenuIItem(MainFrame m) {
		super("Help");
		this.mf=m;
	}

	public void execute() {
		
		HelpFrame hf = new HelpFrame();
		this.mf.pannel.removeAll();
		this.mf.pannel.add(hf);
		this.mf.pannel.repaint();
		this.mf.repaint();
		
	}

	
}
