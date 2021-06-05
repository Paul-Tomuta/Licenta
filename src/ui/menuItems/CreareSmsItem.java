package ui.menuItems;

import javax.swing.JMenuItem;

import ui.Command;
import ui.frames.MainFrame;
import ui.frames.CreareSmsFrame;

public class CreareSmsItem extends JMenuItem implements Command{
	
	MainFrame mf;

	public CreareSmsItem(MainFrame m) {
		super("Creare sms");
		
		this.mf = m;
	}
	
	public void execute() {
		
		CreareSmsFrame lg = new CreareSmsFrame();
		this.mf.pannel.removeAll();
		this.mf.pannel.add(lg);
		this.mf.pannel.repaint();
		this.mf.repaint();
		
	}
	

}
