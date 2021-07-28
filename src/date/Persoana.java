package date;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.Main;
import repo.Conexiune;

public class Persoana {

	private String nrTelefon;
	private String email;
	private String nume;
	private String prenume;
	private int sex;

	public Persoana(String num, String prenume, String email, String numar, int b) {
		this.nume = num;
		this.prenume = prenume;
		this.nrTelefon = numar;
		this.email = email;
		this.sex = b;
	}
	
	public Persoana(String num, String prenume,  String numar, int b) {
		this.nume = num;
		this.prenume = prenume;
		this.nrTelefon = numar;
		this.sex = b;
		
	}
	
	public Persoana(String num, String prenume, String email, int b, int k) {
		this.nume = num;
		this.prenume = prenume;
		this.email = email;
		this.sex = b;
	}

	public String toString() {
		return "Lista [numar=" + nrTelefon + ", email=" + email + ", nume=" + nume + ", prenume=" + prenume + "Sex: "+ sex+ "]";
	}

	public String getNumar() {
		return nrTelefon;
	}

	public void setNumar(String numar) {
		this.nrTelefon = numar;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public int isBarbat() {
		return sex;
	}



	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persoana other = (Persoana) obj;
		if (sex != other.sex)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nrTelefon == null) {
			if (other.nrTelefon != null)
				return false;
		} else if (!nrTelefon.equals(other.nrTelefon))
			return false;
		if (nume == null) {
			if (other.nume != null)
				return false;
		} else if (!nume.equals(other.nume))
			return false;
		if (prenume == null) {
			if (other.prenume != null)
				return false;
		} else if (!prenume.equals(other.prenume))
			return false;
		return true;
	}

	public void setBarbat(int sex) {
		this.sex = sex;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	
	
	public static ArrayList<Persoana> getPersoane(){
		ArrayList<Persoana> lista=new ArrayList<Persoana>();
		
		try {
			Statement st=Conexiune.getInstance().getConnection().createStatement();
			ResultSet rs=st.executeQuery(Conexiune.interogarePersoane);
			while(rs.next()) {
				String nrTelefon = rs.getString("NumarTelefon");
				String nume = rs.getString("Nume");
				String prenume = rs.getString("Prenume");
				String email = rs.getString("Email");
				int s = rs.getInt("Sex");
				Persoana p = new Persoana(nume, prenume, email, nrTelefon, s);
				Main.logger.info(p.toString());
				lista.add(p);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return lista;
	}
	
	public void insertPersoana() {
		
		
		try {
			Statement st = Conexiune.getInstance().getConnection().createStatement();
			String sql = "INSERT INTO `persoana` (`NumarTelefon`, `Nume`, `Prenume`, `Email`, `Sex`) VALUES ('"+this.nrTelefon+"', "
					+ "'"+this.nume+"', '"+this.prenume+"', '"+this.email+"', '"+(this.sex)+"');";
			st.execute(sql);
			Main.logger.info("Persoana a fost adaugata");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void modifyPersoana(String nume_vechi) {
		
		
		try {
			Statement st = Conexiune.getInstance().getConnection().createStatement();
			String sql = "UPDATE `persoana` SET `NumarTelefon`='"+this.nrTelefon+"',`Nume`='"+this.nume+"',`Prenume`='"+this.prenume+"',`Email`='"+this.email+"',`Sex`='"+this.sex+"' WHERE Nume='"+nume_vechi + "'";
			Main.logger.info("Execute sql:" + sql);
			st.execute(sql);
			Main.logger.info("Persoana a fost modificata");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deletePersoana() {
		
		
		try {
			Statement st = Conexiune.getInstance().getConnection().createStatement();
			String sql = "DELETE FROM `persoana` WHERE Nume= '"+this.nume+"'";
			st.execute(sql);
			Main.logger.info("Persoana a fost stearsa");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
