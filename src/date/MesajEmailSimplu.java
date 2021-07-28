package date;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.Main;
import repo.Conexiune;

public class MesajEmailSimplu {
	
	private String titlu;
	private String text;
	
	public MesajEmailSimplu(String titlu, String text) {
		
		
		this.titlu = titlu;
		this.text = text;
	}
	
	public String toString() {
		return "MesajEmailSimplu [titlu=" + titlu + ", text=" + text + "]";
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
	
	public static ArrayList<MesajEmailSimplu> getEmail() {
		ArrayList<MesajEmailSimplu> lista = new ArrayList<MesajEmailSimplu>();
		try {
			
			Statement st = Conexiune.getInstance().getConnection().createStatement();
			ResultSet rs = st.executeQuery(Conexiune.interograreEmail);
			while (rs.next()) {
				
				String titlu = rs.getString("Titlu");
				String text = rs.getString("Text");
				
				MesajEmailSimplu s = new MesajEmailSimplu(titlu, text);
				
				Main.logger.info(s.toString());
				
				lista.add(s);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}
	
	public void insertEmail() {

		try {
			Statement st = Conexiune.getInstance().getConnection().createStatement();
			String sql = "INSERT INTO email (Titlu, Text) VALUES ('" + this.titlu + "','" + this.text + "');";
			st.execute(sql);
			Main.logger.info("Email  a fost adaugat in baza de date");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void modifyEmail(String nume_vechi) {

		try {
			Statement st = Conexiune.getInstance().getConnection().createStatement();
			String sql = "UPDATE `email` SET `Titlu`='" + this.titlu + "',`Text`='" + this.text
					+ "'  WHERE Titlu= + '" + nume_vechi + "'";
			Main.logger.info("Execute sql:" + sql);
			st.execute(sql);
			Main.logger.info("Email a fost modificat");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void deleteEmail() {
		
		
		try {
			Statement st = Conexiune.getInstance().getConnection().createStatement();
			String sql = "DELETE FROM `email` WHERE Titlu= '"+this.titlu+"'";
			st.execute(sql);
			Main.logger.info("Email a fost stears");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
