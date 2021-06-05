package date;

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
	
	

}
