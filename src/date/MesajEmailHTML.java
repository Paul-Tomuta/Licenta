package date;

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
	
	

}
