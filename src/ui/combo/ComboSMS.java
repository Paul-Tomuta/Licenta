package ui.combo;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import date.MesajSms;
import repo.Repository;
import ui.Command;
import ui.Observer;

public class ComboSMS extends JComboBox implements Observer, Command {

	private static ArrayList<MesajSms> listaMesaje;
	private static Vector<String> v = new Vector<String>();

	
	JLabel mesaje;

	static {
		listaMesaje = Repository.getInstance().getMesajeSms();
		for (MesajSms mesaj : listaMesaje) {
			v.add(mesaj.getTitlu());

		}

	}

	public ComboSMS(JLabel m) {
		super(v);
		
		this.mesaje=m;
	
		Repository.getInstance().addObserver(this);

	}

	public void update() {
		this.removeAllItems();
		ArrayList<MesajSms> lista = Repository.getInstance().getMesajeSms();
		for (MesajSms mesaj : lista) {
			this.addItem(mesaj.getTitlu());
			

		}
		
	}

	
	public void execute() {
		
		String smsSelectat = this.getSelectedItem().toString().trim();
		
		mesaje.setText(smsSelectat);
		
		
	}
	

}
