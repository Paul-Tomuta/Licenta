package ui.combo;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import date.MesajEmailHTML;
import date.MesajEmailSimplu;
import date.MesajSms;
import repo.Repository;
import ui.Command;
import ui.Observer;

public class ComboEmailHtml extends JComboBox implements Observer, Command {

	private static ArrayList<MesajEmailHTML> listaMesaje;
	private static Vector<String> v = new Vector<String>();

	JLabel mesaje;

	static {
		listaMesaje = Repository.getInstance().getListaEmailHTML();
		for (MesajEmailHTML mesaj : listaMesaje) {
			v.add(mesaj.getTitlu());

		}

	}

	public ComboEmailHtml(JLabel s) {
		super(v);

		this.mesaje = s;
		Repository.getInstance().addObserver(this);

	}

	public void update() {
		this.removeAllItems();
		ArrayList<MesajEmailHTML> lista = Repository.getInstance().getListaEmailHTML();
		for (MesajEmailHTML mesaj : lista) {
			this.addItem(mesaj.getTitlu());

		}

	}

	public void execute() {

		String emailSelectat = this.getSelectedItem().toString().trim();

		mesaje.setText(emailSelectat);

	}

}
