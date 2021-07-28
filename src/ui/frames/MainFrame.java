package ui.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


import main.Main;
import ui.Command;
import ui.menuItems.AdaugaPersoanaItem;
import ui.menuItems.CreareMesajHTMLItem;
import ui.menuItems.CreareMesajSimpluItem;
import ui.menuItems.CreareSmsItem;
import ui.menuItems.HelpMenuIItem;
import ui.menuItems.LogginMenuItem;
import ui.menuItems.ModificaPersoanaItem;
import ui.menuItems.ModificaMesajItem;
import ui.menuItems.UploadListaEmailListeItems;
import ui.menuItems.UploadListaSmsItem;
import ui.menuItems.UtilitareItem;
import ui.menuItems.UploadListaMixtaItem; 
import ui.menuItems.StergePersoanaItem;
import ui.menuItems.StergeMesajItem;

public class MainFrame extends JFrame implements ActionListener{

	JPanel mainFrame;
	JMenuBar baraMeniu;
	JMenu fileMenu;
	LogginMenuItem logginItem;
	HelpMenuIItem helpItem;
	JMenuItem exitItem;

	JMenu listaClientiMeniu;
	UploadListaEmailListeItems uploadListaEmailItem;
	UploadListaSmsItem uploeadListaSmsItem;
	UploadListaMixtaItem uploadListaMixtaItem;
	AdaugaPersoanaItem adaugaClientItem;
	ModificaPersoanaItem modificaClientItem;
	StergePersoanaItem stergePersoanaItem;

	JMenu mesajeMenu;
	CreareMesajSimpluItem creeareMesajSimpluItem;
	CreareMesajHTMLItem creeareMesajHTMLItem;
	CreareSmsItem creeareSMSItem;
	ModificaMesajItem modificaMesajItem;
	StergeMesajItem stergeMesajItem;
	UtilitareItem utilitateItem;
	
	public JPanel pannel;

	public MainFrame() {
		Main.logger.info("S-a creeat main frame");
		
		
		this.mainFrame = new JPanel();
		

		this.baraMeniu = new JMenuBar();
		this.setJMenuBar(baraMeniu);
		this.fileMenu = new JMenu("File");
		
		this.logginItem = new LogginMenuItem(this);
		this.logginItem.addActionListener(this);
		this.fileMenu.add(logginItem);
		
		this.helpItem = new HelpMenuIItem(this);
		this.helpItem.addActionListener(this);
		this.fileMenu.add(helpItem);
		
		this.exitItem = new JMenuItem("Exit");
		this.fileMenu.add(exitItem);
		this.baraMeniu.add(fileMenu);
		

		this.listaClientiMeniu = new JMenu("Lista clienti");
		this.baraMeniu.add(listaClientiMeniu);
		
		this.uploadListaEmailItem = new UploadListaEmailListeItems(this);
		this.uploadListaEmailItem.addActionListener(this);
		this.listaClientiMeniu.add(uploadListaEmailItem);
		
		this.uploeadListaSmsItem = new UploadListaSmsItem(this);
		this.uploeadListaSmsItem.addActionListener(this);
		this.listaClientiMeniu.add(uploeadListaSmsItem);
		
		this.uploadListaMixtaItem = new UploadListaMixtaItem(this);
		this.uploadListaMixtaItem.addActionListener(this);
		this.listaClientiMeniu.add(uploadListaMixtaItem);
		
		this.adaugaClientItem = new AdaugaPersoanaItem(this);
		this.adaugaClientItem.addActionListener(this);
		this.listaClientiMeniu.add(adaugaClientItem);
		
		this.modificaClientItem = new ModificaPersoanaItem(this);
		this.modificaClientItem.addActionListener(this);
		this.listaClientiMeniu.add(modificaClientItem);
		
		this.stergePersoanaItem = new StergePersoanaItem(this);
		this.stergePersoanaItem.addActionListener(this);
		this.listaClientiMeniu.add(stergePersoanaItem);
		

		this.mesajeMenu = new JMenu("Mesaje");
		this.baraMeniu.add(mesajeMenu);
		
		this.creeareMesajSimpluItem = new CreareMesajSimpluItem(this);
		this.creeareMesajSimpluItem.addActionListener(this);
		this.mesajeMenu.add(creeareMesajSimpluItem);
		
		this.creeareMesajHTMLItem = new CreareMesajHTMLItem(this);
		this.creeareMesajHTMLItem.addActionListener(this);
		this.mesajeMenu.add(creeareMesajHTMLItem);
		
		this.creeareSMSItem = new CreareSmsItem(this);
		this.creeareSMSItem.addActionListener(this);
		this.mesajeMenu.add(creeareSMSItem);
		
		this.modificaMesajItem = new ModificaMesajItem(this);
		this.modificaMesajItem.addActionListener(this);
		this.mesajeMenu.add(modificaMesajItem); 
		
		this.stergeMesajItem = new StergeMesajItem(this);
		this.stergeMesajItem.addActionListener(this);
		this.mesajeMenu.add(stergeMesajItem);
		
		this.utilitateItem = new UtilitareItem(this);
		this.utilitateItem.addActionListener(this);
		this.mesajeMenu.add(utilitateItem);

		this.pannel = new JPanel();
		this.mainFrame.add(pannel);
		
		this.add(mainFrame);
		this.pack();
		this.setVisible(true);
		this.setSize(800, 800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		((Command) e.getSource()).execute();
	}

}
