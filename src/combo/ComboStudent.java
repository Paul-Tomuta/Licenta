package combo;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import date.Persoana;
import repo.Repository;
import ui.Command;
import ui.Observer;

public class ComboStudent extends JComboBox implements Observer, Command {

	private static ArrayList<Persoana> listaStudent;
	private static Vector<String> v = new Vector<String>();
	
	JLabel studenti;

	static {
		listaStudent = Repository.getInstance().getListaFull();
		for (Persoana student : listaStudent) {
			v.add(student.getNume());

		}

	}

	public ComboStudent(JLabel s) {
		super(v);
		
		this.studenti=s;
		Repository.getInstance().addObserver(this);

	}

	public void update() {
		this.removeAllItems();
		ArrayList<Persoana> lista = Repository.getInstance().getListaFull();
		for (Persoana student : lista) {
			this.addItem(student.getNume());

		}

	}

	
	public void execute() {
		
		String studentSelectat = this.getSelectedItem().toString().trim();
		
		studenti.setText(studentSelectat);
		
		
	}

}
