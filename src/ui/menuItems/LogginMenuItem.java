package ui.menuItems;

import javax.swing.JMenuItem;

import ui.Command;
import ui.frames.LogginFrame;
import ui.frames.MainFrame;

public class LogginMenuItem extends JMenuItem implements Command {

	MainFrame mf;
	
	public LogginMenuItem(MainFrame m) {
		super("Loggin");
		
		this.mf= m; 
		
	}
	
	
	
	public void execute() {
		
		LogginFrame lg = new LogginFrame();
		this.mf.pannel.removeAll();
		this.mf.pannel.add(lg);
		this.mf.pannel.repaint();
		this.mf.repaint();
		
	}

}
