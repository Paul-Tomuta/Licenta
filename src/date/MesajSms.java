package date;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;

import main.Main;
import repo.Conexiune;

public class MesajSms {

	private String titlu;
	private String text;

	public MesajSms(String titlu, String text) {

		this.titlu = titlu;
		this.text = text;
	}

	public String getTitlu() {
		return titlu;
	}

	public String getText() {
		return text;
	}

	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String toString() {
		return "MesajSms [titlu=" + titlu + ", text=" + text + "]";
	}

	public static ArrayList<MesajSms> getSMS() {
		ArrayList<MesajSms> lista = new ArrayList<MesajSms>();
		try {
			Statement st = Conexiune.getInstance().getConnection().createStatement();
			ResultSet rs = st.executeQuery(Conexiune.interograreSMS);
			while (rs.next()) {
				
				String titlu = rs.getString("Titlu");
				String text = rs.getString("Text");
				
				MesajSms s = new MesajSms(titlu, text);
				
				Main.logger.info(s.toString());
				lista.add(s);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	public void insertMesajSMS() {

		try {
			Statement st = Conexiune.getInstance().getConnection().createStatement();
			String sql = "INSERT INTO mesajesms (Titlu, Text) VALUES ('" + this.titlu + "','" + this.text + "');";
			st.execute(sql);
			Main.logger.info("Mesajul sms a fost adaugat in baza de date");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void modifySMS(String nume_vechi) {

		try {
			Statement st = Conexiune.getInstance().getConnection().createStatement();
			String sql = "UPDATE `mesajesms` SET `Titlu`='" + this.titlu + "',`Text`='" + this.text+ "'  WHERE Titlu= + '" + nume_vechi + "'";
			Main.logger.info("Execute sql:" + sql);
			st.execute(sql);
			Main.logger.info("Sms a fost modificata");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void deleteSMS() {
		
		
		try {
			Statement st = Conexiune.getInstance().getConnection().createStatement();
			String sql = "DELETE FROM `mesajesms` WHERE Titlu= '"+this.titlu+"'";
			st.execute(sql);
			Main.logger.info("Sms a fost stearsa");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MesajSms other = (MesajSms) obj;
		return Objects.equals(text, other.text) && Objects.equals(titlu, other.titlu);
	}

}
