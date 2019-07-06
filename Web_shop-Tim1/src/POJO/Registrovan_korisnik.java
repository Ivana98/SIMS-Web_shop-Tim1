package POJO;

import java.util.ArrayList;

public class Registrovan_korisnik extends Korisnik {

	protected String adresa;
	protected String telefon;
	protected String eMail;

	protected ArrayList<Kupon> kupon;
	
	public Tip_korisnika tipKorisnika;
	
	protected String Username;
	protected String Password;
	
	protected ArrayList<Proizvod>wishlista;
	
	public Registrovan_korisnik(String ime, String prezime, String adresa, String telefon, String eMail,
			ArrayList<Kupon> kupon, Tip_korisnika tipKorisnika, String Username, String Password, ArrayList<Proizvod>wishlista) {
		super(ime, prezime);
		this.setAdresa(adresa);
		this.setTelefon(telefon);
		this.seteMail(eMail);
		this.setKupon(kupon);
		this.setTipKorisnika(tipKorisnika);
		this.setUsername(Username);
		this.setPassword(Password);
		this.setWishlista(wishlista);
	}
	
	public Registrovan_korisnik() {
		super("", "");
		this.setAdresa("");
		this.setTelefon("");
		this.seteMail("");
		this.setKupon(new ArrayList<Kupon>());
		this.setTipKorisnika(Tip_korisnika.administrator);
		this.setUsername("");
		this.setPassword("");
		this.setWishlista(new ArrayList<Proizvod>());
	}
	
	public Registrovan_korisnik(Registrovan_korisnik rk) {
		super(rk.getIme(),rk.getPrezime());
		this.setAdresa(rk.getAdresa());
		this.setTelefon(rk.getTelefon());
		this.seteMail(rk.geteMail());
		this.setKupon(rk.getKupon());
		this.setTipKorisnika(rk.getTipKorisnika());
		this.setUsername(rk.getUsername());
		this.setPassword(rk.getPassword());
		this.setWishlista(rk.getWishlista());
	}
	
	@Override
	public String toString()
	{
		return "";
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}else if(o instanceof Registrovan_korisnik){
			Registrovan_korisnik c = (Registrovan_korisnik)o;
			if(c.getTelefon() == this.getTelefon() && c.geteMail()==this.geteMail()) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public ArrayList<Kupon> getKupon() {
		return kupon;
	}

	public void setKupon(ArrayList<Kupon> kupon) {
		this.kupon = kupon;
	}

	public Tip_korisnika getTipKorisnika() {
		return tipKorisnika;
	}

	public void setTipKorisnika(Tip_korisnika tipKorisnika) {
		this.tipKorisnika = tipKorisnika;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public ArrayList<Proizvod> getWishlista() {
		return wishlista;
	}

	public void setWishlista(ArrayList<Proizvod> wishlista) {
		this.wishlista = wishlista;
	}
	
	
	
}
