package date;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.Main;
import repo.Conexiune;

public class MesajEmailHTML {
	
	String titlu;
	String text;
	public MesajEmailHTML(String titlu, String text) {
		super();
		this.titlu = titlu;
		this.text = text;
	}
	
	public String toString() {
		return "MesajEmailHTML [titlu=" + titlu + ", text=" + text + "]";
	}
	public String getTitlu() {
		return titlu;
	}
	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public static ArrayList<MesajEmailHTML> getEmail() {
		ArrayList<MesajEmailHTML> lista = new ArrayList<MesajEmailHTML>();
		try {
			
			Statement st = Conexiune.getInstance().getConnection().createStatement();
			ResultSet rs = st.executeQuery(Conexiune.interograreEmailHtml);
			while (rs.next()) {
				
				String titlu = rs.getString("Titlu");
				String text = rs.getString("Text");
				
				MesajEmailHTML s = new MesajEmailHTML(titlu, text);
				
				Main.logger.info(s.toString());
				
				lista.add(s);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}
	
	public void insertEmailHtml() {

		try {
			Statement st = Conexiune.getInstance().getConnection().createStatement();
			String sql = "INSERT INTO emailhtml (Titlu, Text) VALUES ('" + this.titlu + "','" + this.text + "');";
			st.execute(sql);
			Main.logger.info("Email HTML  a fost adaugat in baza de date");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void modifyEmailHtml(String nume_vechi) {

		try {
			Statement st = Conexiune.getInstance().getConnection().createStatement();
			String sql = "UPDATE `emailhtml` SET `Titlu`='" + this.titlu + "',`Text`='" + this.text
					+ "'  WHERE Titlu= + '" + nume_vechi + "'";
			Main.logger.info("Execute sql:" + sql);
			st.execute(sql);
			Main.logger.info("EmailHtml a fost modificat");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void deleteEmailHtml() {
		
		
		try {
			Statement st = Conexiune.getInstance().getConnection().createStatement();
			String sql = "DELETE FROM `emailhtml` WHERE Titlu= '"+this.titlu+"'";
			st.execute(sql);
			Main.logger.info("EmailHtml a fost stears");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

}
