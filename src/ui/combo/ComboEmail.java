package ui.combo;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import date.MesajEmailSimplu;
import date.MesajSms;
import repo.Repository;
import ui.Command;
import ui.Observer;

public class ComboEmail extends JComboBox implements Observer, Command {

	private static ArrayList<MesajEmailSimplu> listaMesaje;
	private static Vector<String> v = new Vector<String>();
	
	private static Vector<String> text = new Vector<String>();

	JLabel mesaje;

	static {
		listaMesaje = Repository.getInstance().getListaEmailSimpla();
		for (MesajEmailSimplu mesaj : listaMesaje) {
			v.add(mesaj.getTitlu());
			

		}

	}

	public ComboEmail(JLabel s) {
		super(v);

		this.mesaje = s;
		Repository.getInstance().addObserver(this);

	}

	public void update() {
		this.removeAllItems();
		ArrayList<MesajEmailSimplu> lista = Repository.getInstance().getListaEmailSimpla();
		for (MesajEmailSimplu mesaj : lista) {
			this.addItem(mesaj.getTitlu());

		}

	}

	public void execute() {

		String emailSelectat = this.getSelectedItem().toString().trim();

		mesaje.setText(emailSelectat);

	}

}
