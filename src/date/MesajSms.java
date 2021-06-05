package date;

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

}
