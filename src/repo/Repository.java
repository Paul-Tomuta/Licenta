package repo;

import java.util.ArrayList;

import date.MesajEmailHTML;
import date.MesajEmailSimplu;
import date.MesajSms;
import date.Persoana;
import date.SendHTMLEmail;
import ui.Observer;

public class Repository {

	private ArrayList<Persoana> listaSMS = new ArrayList<Persoana>();
	private ArrayList<Persoana> listaEmail = new ArrayList<Persoana>();
	private ArrayList<Persoana> listaFull = new ArrayList<Persoana>();

	private ArrayList<MesajSms> listeMesaje = new ArrayList<MesajSms>();
	private ArrayList<MesajEmailSimplu> listaEmailSimpla = new ArrayList<MesajEmailSimplu>();
	private ArrayList<MesajEmailHTML> listaEmailHTML = new ArrayList<MesajEmailHTML>();

	private ArrayList<Observer> observatori = new ArrayList<Observer>();

	private static Repository obiectCreeat = null;

	public void adaugaStudentSMS(String nume, String prenume, String telefon) { // singleton

		Persoana s = new Persoana(nume, prenume, telefon, true);
		listaSMS.add(s);
		notifyAllObservers();
		main.Main.logger.info("Studentul: " + s.toString() + " a fost adaugat in repo");
	}

	public void adaugaStudentEmail(String nume, String prenume, String email) { // singleton

		int i = 0;
		Persoana s = new Persoana(nume, prenume, email, false);

		listaEmail.add(s);
		main.Main.logger.info("Studentul: " + s.toString() + " a fost adaugat in repo");
		notifyAllObservers();

	}

	public void adaugaStudentFull(String nume, String prenume, String telefon, String email) { // singleton

		Persoana s = new Persoana(nume, prenume, email, telefon, true);

		listaFull.add(s);

		notifyAllObservers();

		main.Main.logger.info("Studentul: " + s.toString() + " a fost adaugat in repo");

	}

	public void stergeStudentSMS(String nume) {

		for (int i = 0; i < listaSMS.size(); i++) {
			if (listaSMS.get(i).getNume().toString().contains(nume)) {
				listaSMS.remove(i);
				break;
			}
		}
		main.Main.logger.info("Studentul: " + nume.toString() + "a fost sters");
		notifyAllObservers();
	}

	public void stergeStudentEmail(String nume) {

		for (int i = 0; i < listaEmail.size(); i++) {
			if (listaEmail.get(i).getNume().toString().contains(nume)) {
				listaEmail.remove(i);
				break;
			}
		}
		notifyAllObservers();
		main.Main.logger.info("Studentul: " + nume.toString() + "a fost sters");
	}

	public void stergeStudentFull(String nume) {

		for (int i = 0; i < listaFull.size(); i++) {
			if (listaFull.get(i).getNume().toString().contains(nume)) {
				listaFull.remove(i);
				break;
			}
		}
		main.Main.logger.info("Studentul: " + nume.toString() + "a fost sters");
		notifyAllObservers();
	}

	public void modificaNumeSMS(String nv, String nn) {

		for (int i = 0; i < listaSMS.size(); i++) {

			if (listaSMS.get(i).getNume().equals(nv)) {

				listaSMS.get(i).setNume(nn);

			}

		}
		main.Main.logger.info("Studentul: " + nv.toString() + "a fost modificat cu: " + nn.toString());
		notifyAllObservers();
	}

	public void modificaNumeEmail(String nv, String nn) {

		for (int i = 0; i < listaEmail.size(); i++) {

			if (listaEmail.get(i).getNume().equals(nv)) {

				listaEmail.get(i).setNume(nn);

			}

		}
		main.Main.logger.info("Studentul: " + nv.toString() + "a fost modificat cu: " + nn.toString());
		notifyAllObservers();
	}

	public void modificaNumeFull(String nv, String nn) {

		for (int i = 0; i < listaFull.size(); i++) {

			if (listaFull.get(i).getNume().equals(nv)) {

				listaFull.get(i).setNume(nn);

			}

		}
		main.Main.logger.info("Studentul: " + nv.toString() + "a fost modificat cu: " + nn.toString());
		notifyAllObservers();
	}

	public void adaugaSms(String titlu, String text) { // singleton

		MesajSms s = new MesajSms(titlu, text);
		listeMesaje.add(s);
		notifyAllObservers();

		main.Main.logger.info("Mesajul cu titlul " + titlu.toString() + "a fost creeat in repository");
	}

	public void stergeSms(String titlu) {

		for (int i = 0; i < listeMesaje.size(); i++) {
			if (listeMesaje.get(i).getTitlu().toString().contains(titlu)) {
				listeMesaje.remove(i);
				break;
			}
		}
		main.Main.logger.info("Mesajul cu titlul " + titlu.toString() + "a fost sters");
		notifyAllObservers();
	}

	public void mdoficaSms(String titlu, String text) {

		for (int i = 0; i < listeMesaje.size(); i++) {

			if (listeMesaje.get(i).getTitlu().equals(titlu)) {

				listeMesaje.get(i).setText(text);

			}

		}

		main.Main.logger.info("Mesajul cu titlul " + titlu.toString() + "a fost creeat in repository");
		notifyAllObservers();
	}

	public void adaugaMesajEmailSimplu(String titlu, String text) { // singleton

		MesajEmailSimplu s = new MesajEmailSimplu(titlu, text);
		listaEmailSimpla.add(s);
		notifyAllObservers();

		main.Main.logger.info("Emailu cu titulul " + titlu.toString() + "a fost creeat in repository");
	}

	public void stergeMesajEmailSimplu(String titlu) {

		for (int i = 0; i < listaEmailSimpla.size(); i++) {
			if (listaEmailSimpla.get(i).getTitlu().toString().contains(titlu)) {
				listaEmailSimpla.remove(i);
				break;
			}
		}
		main.Main.logger.info("Emailu cu titlul " + titlu.toString() + "a fost sters");
		notifyAllObservers();
	}

	public void mdoficaMesajEmailSimplu(String titlu, String text) {

		for (int i = 0; i < listaEmailSimpla.size(); i++) {

			if (listaEmailSimpla.get(i).getTitlu().equals(titlu)) {

				listaEmailSimpla.get(i).setText(text);

			}

		}

		main.Main.logger.info("Emailu cu titlu " + titlu.toString() + "a fost creeat in repository");
		notifyAllObservers();
	}

	public void adaugaMesajEmailHTML(String titlu, String text) { // singleton

		MesajEmailHTML s = new MesajEmailHTML(titlu, text);
		listaEmailHTML.add(s);
		notifyAllObservers();

		main.Main.logger.info("Emailu HTML cu titulul " + titlu.toString() + "a fost creeat in repository");
	}

	public void stergeMesajEmailHTML(String titlu) {

		for (int i = 0; i < listaEmailHTML.size(); i++) {
			if (listaEmailHTML.get(i).getTitlu().toString().contains(titlu)) {
				listaEmailHTML.remove(i);
				break;
			}
		}
		main.Main.logger.info("Emailu HTML cu titlul " + titlu.toString() + "a fost sters");
		notifyAllObservers();
	}

	public void mdoficaMesajEmailHTML(String titlu, String text) {

		for (int i = 0; i < listaEmailHTML.size(); i++) {

			if (listaEmailHTML.get(i).getTitlu().equals(titlu)) {

				listaEmailHTML.get(i).setText(text);

			}

		}

		main.Main.logger.info("Emailu HTML cu titlu " + titlu.toString() + "a fost creeat in repository");
		notifyAllObservers();
	}

	public void SendEmailSimplu(String emailto, String subject, String text) {

		SendHTMLEmail se = new SendHTMLEmail(emailto, subject, text);

	}
	
	public void SendEmailHTML() {
		
		
		
	}
	

	public void addObserver(Observer o) {

		observatori.add(o);

	}

	public void removeObserver(Observer o) {

		observatori.remove(o);

	}

	public void notifyAllObservers() {

		for (Observer o : observatori)
			o.update();

	}

	public static Repository getInstance() {
		if (obiectCreeat == null) {
			obiectCreeat = new Repository();
			return obiectCreeat;
		} else
			return obiectCreeat;

	}

	public ArrayList<Persoana> getListaSMS() {
		return listaSMS;
	}

	public ArrayList<Persoana> getListaEmail() {
		return listaEmail;
	}

	public ArrayList<Persoana> getListaFull() {
		return listaFull;
	}

	public ArrayList<MesajSms> getMesajeSms() {
		return listeMesaje;
	}

	public ArrayList<MesajEmailSimplu> getListaEmailSimpla() {
		return listaEmailSimpla;
	}

	public ArrayList<MesajEmailHTML> getListaEmailHTML() {
		return listaEmailHTML;
	}

	public void setListaSMS(ArrayList<Persoana> listaSMS) {
		this.listaSMS = listaSMS;
	}

}
