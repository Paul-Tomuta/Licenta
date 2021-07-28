package repo;

import java.util.ArrayList;

import date.MesajEmailHTML;
import date.MesajEmailSimplu;
import date.MesajSms;
import date.Persoana;
import date.SendEmail;
import date.SendSMS;
import main.Main;
import ui.Observer;

public class Repository {

	private ArrayList<Persoana> listaSMS = new ArrayList<Persoana>();
	private ArrayList<Persoana> listaEmail = new ArrayList<Persoana>();
	private ArrayList<Persoana> listaFull = new ArrayList<Persoana>();

	private ArrayList<MesajSms> listeMesaje = new ArrayList<MesajSms>();
	private ArrayList<MesajEmailSimplu> listaEmailSimpla = new ArrayList<MesajEmailSimplu>();
	private ArrayList<MesajEmailHTML> listaEmailHTML = new ArrayList<MesajEmailHTML>();
	

	private ArrayList<Observer> observatori = new ArrayList<Observer>();
	private Conexiune cnx = Conexiune.getInstance();

	private static Repository obiectCreeat = null;

	public void adaugaPersoanaSMS(String nume, String prenume, String telefon) {

		Persoana s = new Persoana(nume, prenume, telefon, 1);
		listaSMS.add(s);
		notifyAllObservers();
		main.Main.logger.info("Persoana: " + s.toString() + " a fost creeat in repository");
	}

	public void adaugaPersoanaEmail(String nume, String prenume, String email) {

		int i = 0;
		Persoana s = new Persoana(nume, prenume, email, 0);

		listaEmail.add(s);
		main.Main.logger.info("Persoana: " + s.toString() + " a fost creeat in repository");
		notifyAllObservers();

	}

	public void adaugaPersoanaFull(String nume, String prenume, String telefon, String email) {
		
		Persoana s = new Persoana(nume, prenume, email, telefon, 1);

		listaFull.add(s);
		s.insertPersoana();

		notifyAllObservers();

		main.Main.logger.info("Persoana: " + s.toString() + " a fost creeat in repository");

	}


	public void stergePersoanaFull(String nume) {

		for (int i = 0; i < listaFull.size(); i++) {
			if (listaFull.get(i).getNume().toString().contains(nume)) {
				Persoana pers = listaFull.get(i);
				pers.deletePersoana();
				break;
			}
		}
		
		notifyAllObservers();
	}


	public void modificaNumeFull(String nv, String nn, String pr, String em, String tel) {

		for (int i = 0; i < listaFull.size(); i++) {

			if (listaFull.get(i).getNume().equals(nv)) {
				Persoana pers = listaFull.get(i);
				String nume_vechi = pers.getNume();

				pers.setNume(nn);
				pers.setPrenume(pr);
				pers.setEmail(em);
				pers.setNumar(tel);
				pers.modifyPersoana(nume_vechi);
				break;
			}

		}
		
		notifyAllObservers();
	}

	public void adaugaSms(String titlu, String text) {

		MesajSms s = new MesajSms(titlu, text);

		s.insertMesajSMS();

		listeMesaje.add(s);
		notifyAllObservers();

	
	}

	public void stergeSms(String titlu) {

		for (int i = 0; i < listeMesaje.size(); i++) {
			if (listeMesaje.get(i).getTitlu().toString().contains(titlu)) {
				MesajSms msg = listeMesaje.get(i);
				msg.deleteSMS();
				break;
			}
		}
		
		notifyAllObservers();
	}

	public void modificaSMS(String nv, String nn, String tn) {

		for (int i = 0; i < listeMesaje.size(); i++) {

			if (listeMesaje.get(i).getTitlu().equals(nv)) {
				MesajSms ms = listeMesaje.get(i);
				String nume_vechi = ms.getTitlu();

				ms.setTitlu(nn);
				ms.setText(tn);
				ms.modifySMS(nume_vechi);
				break;

			}

		}
		
		notifyAllObservers();
	}

	public void adaugaMesajEmailSimplu(String titlu, String text) {

		MesajEmailSimplu s = new MesajEmailSimplu(titlu, text);
		s.insertEmail();
		listaEmailSimpla.add(s);
		notifyAllObservers();

		
	}

	public void stergeMesajEmailSimplu(String titlu) {

		for (int i = 0; i < listaEmailSimpla.size(); i++) {
			if (listaEmailSimpla.get(i).getTitlu().toString().contains(titlu)) {
				MesajEmailSimplu msg = listaEmailSimpla.get(i);
				msg.deleteEmail();
				break;
			}
		}
		
		notifyAllObservers();
	}

	public void mdoficaMesajEmailSimplu(String titluVechi, String titluNou, String textNou) {

		for (int i = 0; i < listaEmailSimpla.size(); i++) {

			if (listaEmailSimpla.get(i).getTitlu().equals(titluVechi)) {

				MesajEmailSimplu ms = listaEmailSimpla.get(i);
				String nume_vechi = ms.getTitlu();

				ms.setTitlu(titluNou);
				ms.setText(textNou);
				ms.modifyEmail(nume_vechi);
				break;

			}

		}

		
		notifyAllObservers();
	}

	public void adaugaMesajEmailHTML(String titlu, String text) {

		MesajEmailHTML s = new MesajEmailHTML(titlu, text);
		s.insertEmailHtml();

		listaEmailHTML.add(s);
		notifyAllObservers();

		
	}

	public void stergeMesajEmailHTML(String titlu) {

		for (int i = 0; i < listaEmailHTML.size(); i++) {
			if (listaEmailHTML.get(i).getTitlu().toString().contains(titlu)) {
				MesajEmailHTML msg = listaEmailHTML.get(i);
				msg.deleteEmailHtml();
				break;
			}
		}
		
		notifyAllObservers();
	}

	public void modificaMesajHtml(String titluVechi, String titluNou, String textNou) {

		for (int i = 0; i < listaEmailHTML.size(); i++) {

			if (listaEmailHTML.get(i).getTitlu().equals(titluVechi)) {

				MesajEmailHTML ms = listaEmailHTML.get(i);
				String nume_vechi = ms.getTitlu();

				ms.setTitlu(titluNou);
				ms.setText(textNou);

				ms.modifyEmailHtml(nume_vechi);
				break;

			}

		}

		
		notifyAllObservers();
	}

	public void SendEmail(String nume, String numeText) {
		String email = "";
		String titluEmail = "";
		String textEmail = "";
		for (int i = 0; i < listaFull.size(); i++) {
			if (listaFull.get(i).getNume().contains(nume)) {

				email = listaFull.get(i).getEmail();
				
				break;
			}
		}

		for (int i = 0; i < listaEmailSimpla.size(); i++) {
			if (listaEmailSimpla.get(i).getTitlu().contains(numeText)) {
				titluEmail = listaEmailSimpla.get(i).getTitlu().toString().trim();
				textEmail = listaEmailSimpla.get(i).getText().toString().trim();
				break;

			}

		}

		SendEmail se = new SendEmail(email, titluEmail, textEmail);
		
		Main.logger.info("Emailul: " +titluEmail+ " cu textul: " + textEmail+ " a fost trimis catre: " +nume);

	}
	
	
	public void SendEmailHTML(String nume, String numeText) {
		String email = "";
		String titluEmail = "";
		String textEmail = "";
		for (int i = 0; i < listaFull.size(); i++) {
			if (listaFull.get(i).getNume().contains(nume)) {

				email = listaFull.get(i).getEmail();
				
				break;
			}
		}

		for (int i = 0; i < listaEmailHTML.size(); i++) {
			if (listaEmailHTML.get(i).getTitlu().contains(numeText)) {
				titluEmail = listaEmailHTML.get(i).getTitlu().toString().trim();
				textEmail = listaEmailHTML.get(i).getText().toString().trim();
				break;

			}

		}

		SendEmail se = new SendEmail(email, titluEmail, textEmail);
		
		Main.logger.info("Email-ul HTML: " +titluEmail+ " cu textul: " + textEmail+ " a fost trimis catre: " +nume);

	}
	
	public void SendSms(String nume, String numeTitlu) {
		String numar ="";
		String titluSMS="";
		String textSMS="";
		for (int i = 0; i < listaFull.size(); i++) {
			if (listaFull.get(i).getNume().contains(nume)) {

				numar = listaFull.get(i).getNumar();			
				break;
			}
		}
		
		for (int i = 0; i < listeMesaje.size(); i++) {
			if (listeMesaje.get(i).getTitlu().contains(numeTitlu)) {
				
				textSMS = listeMesaje.get(i).getText().toString().trim();
				break;

			}

		}
		
		SendSMS send = new SendSMS(numar, textSMS);
		send.send();
		
		Main.logger.info("SMS-ul : " +nume+ " cu textul: " + textSMS+ " a fost trimis catre: " +nume);
		
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

		listaFull = Persoana.getPersoane();

		return listaFull;
	}

	public ArrayList<MesajSms> getMesajeSms() {

		listeMesaje = MesajSms.getSMS();

		return listeMesaje;
	}

	public ArrayList<MesajEmailSimplu> getListaEmailSimpla() {

		listaEmailSimpla = MesajEmailSimplu.getEmail();

		return listaEmailSimpla;
	}

	public ArrayList<MesajEmailHTML> getListaEmailHTML() {

		listaEmailHTML = MesajEmailHTML.getEmail();

		return listaEmailHTML;
	}

}
