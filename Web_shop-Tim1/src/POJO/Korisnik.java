package POJO;

public abstract class Korisnik {
	
	protected String ime;
	protected String prezime;
	
	public Korisnik(String ime, String prezime) {
		this.setIme(ime);
		this.setPrezime(prezime);
	}
	
	public Korisnik() {
		this.setIme("");
		this.setPrezime("");
	}
	
	public Korisnik(Korisnik k)
	{
		this.setIme(k.getIme());
		this.setPrezime(k.getPrezime());
	}
	
	@Override
	public String toString()
	{
		return "";
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
}
