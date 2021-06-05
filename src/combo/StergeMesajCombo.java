package combo;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import date.MesajSms;
import repo.Repository;
import ui.Command;
import ui.Observer;

public class StergeMesajCombo extends JComboBox implements Observer, Command {

	private static ArrayList<MesajSms> listaMesaje;
	private static Vector<String> v = new Vector<String>();
	
	JLabel mesaje;

	static {
		listaMesaje = Repository.getInstance().getMesajeSms();
		for (MesajSms mesaj : listaMesaje) {
			v.add(mesaj.getTitlu());

		}

	}

	public StergeMesajCombo(JLabel s) {
		super(v);
		
		this.mesaje=s;
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
		
		String studentSelectat = this.getSelectedItem().toString().trim();
		
		mesaje.setText(studentSelectat);
		
		
	}
	
	public Object getSelectedText() {
		
		return null;
	}

}
