package date;
public class Persoana {

	private String numar;
	private String email;
	private String nume;
	private String prenume;
	private boolean barbat;

	public Persoana(String num, String prenume, String email, String numar, boolean b) {
		this.nume = num;
		this.prenume = prenume;
		this.numar = numar;
		this.email = email;
		this.barbat = b;
	}
	
	public Persoana(String num, String prenume,  String numar, boolean b) {
		this.nume = num;
		this.prenume = prenume;
		this.numar = numar;
		this.barbat = b;
		
	}
	
	public Persoana(String num, String prenume, String email, boolean b, int k) {
		this.nume = num;
		this.prenume = prenume;
		this.email = email;
		this.barbat = b;
	}

	public String toString() {
		return "Lista [numar=" + numar + ", email=" + email + ", nume=" + nume + ", prenume=" + prenume + "]";
	}

	public String getNumar() {
		return numar;
	}

	public void setNumar(String numar) {
		this.numar = numar;
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

	public boolean isBarbat() {
		return barbat;
	}

	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (barbat ? 1231 : 1237);
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((numar == null) ? 0 : numar.hashCode());
		result = prime * result + ((nume == null) ? 0 : nume.hashCode());
		result = prime * result + ((prenume == null) ? 0 : prenume.hashCode());
		return result;
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persoana other = (Persoana) obj;
		if (barbat != other.barbat)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (numar == null) {
			if (other.numar != null)
				return false;
		} else if (!numar.equals(other.numar))
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

	public void setBarbat(boolean barbat) {
		this.barbat = barbat;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	
}
