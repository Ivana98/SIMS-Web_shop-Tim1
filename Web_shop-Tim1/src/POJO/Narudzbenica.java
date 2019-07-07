package POJO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Narudzbenica {
	
	private boolean malverzacija;
	private boolean noviPokusaj;
	private boolean zadovoljan;
	private String ime;
	private int id;
	private String prezime;
	private String adresa;
	private LocalDateTime datum;
	private ArrayList<StavkaNarudzbenice>listaNarudzbina;
	private Registrovan_korisnik reg_korisnik;
	
	public Narudzbenica() {
		listener =  new ArrayList<UpdateListener>();
		tekuceStanje = new Kreiranje(this);
		malverzacija = false;
		id = 1;
		ime = "neko";
		prezime = "nesto";
		datum = null;
		adresa = "NEKA";
		noviPokusaj = true;
		zadovoljan = true;
		listaNarudzbina = new ArrayList<StavkaNarudzbenice>();
		reg_korisnik = new Registrovan_korisnik();
	}
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
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



	public String getAdresa() {
		return adresa;
	}



	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}



	public LocalDateTime getDatum() {
		return datum;
	}



	public void setDatum(LocalDateTime datum) {
		this.datum = datum;
	}



	public void setMalverzacija(boolean malverzacija) {
		this.malverzacija = malverzacija;
	}



	public void setNoviPokusaj(boolean noviPokusaj) {
		this.noviPokusaj = noviPokusaj;
	}



	public void setZadovoljan(boolean zadovoljan) {
		this.zadovoljan = zadovoljan;
	}

	private ArrayList<UpdateListener> listener;
	private Stanje tekuceStanje;
	
	
	
	
	
	public Stanje getTekuceStanje() {
		return tekuceStanje;
	}



	public void setTekuceStanje(Stanje tekuceStanje) {
		this.tekuceStanje = tekuceStanje;
	}



	public void promeniStanje(Stanje s) {
		tekuceStanje = s;
	}

	
	
	public boolean isNoviPokusaj() {
		return noviPokusaj;
	}



	public boolean isZadovoljan() {
		return zadovoljan;
	}

	

	public boolean isMalverzacija() {
		return malverzacija;
	}

	public void zavrsenaKupovina() {
		tekuceStanje.zavrsenaKupovina();
		this.osveziNarudzbenicu();
	}
	
	public void proveraPorudzbine() {
		tekuceStanje.proveraPorudzbine();
		this.osveziNarudzbenicu();
	}
	
	public void proveraLagera() {
		tekuceStanje.proveraLagera();
		this.osveziNarudzbenicu();
	}
	
	public void krajPorudzbine() {
		tekuceStanje.krajPorudzbine();
		this.osveziNarudzbenicu();
	}
	
	public void novaPorudzbina() {
		tekuceStanje.novaPorudzbina();
		this.osveziNarudzbenicu();
	}
	
	public void problemiUTransportu() {
		tekuceStanje.problemiUTransportu();
		this.osveziNarudzbenicu();
	}
	
	public void posaljiPorudzbinu() {
		tekuceStanje.posaljiPorudzbinu();
		this.osveziNarudzbenicu();
	}
	
	public void azurirajMalverzaciju(boolean bol) {
		malverzacija = bol;
	}
	
	public void azurirajPokusaj(boolean bol) {
		noviPokusaj = bol;
	}
	
	public void azurirajZadovoljstvo(boolean bol) {
		zadovoljan = bol;
	}
	
	public void azurirajKolicinu(int kol) {
		//
	}
	
	
	
	public ArrayList<UpdateListener> getListener() {
		return listener;
	}

	public void setListener(ArrayList<UpdateListener> listener) {
		this.listener = listener;
	}

	public void addListener(UpdateListener listener2) {
		listener.add(listener2);
	}
	
	public void osveziNarudzbenicu() {		
		UpdateEvent e = new UpdateEvent(this,tekuceStanje );
		//Slanje dogadjaja da se desila promena svima koji su se registrovali za pracenje promena:
//		for (UpdateListener updateListener : this.getListener()) {
//			System.out.println(getListener().size());
//			updateListener.updatePerformed(e);
//		}
		getListener().get(0).updatePerformed(e);
		
		//U slucaju realnog kontrolera, ovde bi se direktno izdavale komande izlaznim uredjajima.
	}
	
	public boolean porudzbinaURedu() {//Treba parametar ali videcemo
		return true;
	}

	

	public Registrovan_korisnik getReg_korisnik() {
		return reg_korisnik;
	}

	public void setReg_korisnik(Registrovan_korisnik reg_korisnik) {
		this.reg_korisnik = reg_korisnik;
	}

	public ArrayList<StavkaNarudzbenice> getListaNarudzbina() {
		return listaNarudzbina;
	}

	public void setListaNarudzbina(ArrayList<StavkaNarudzbenice> listaNarudzbina) {
		this.listaNarudzbina = listaNarudzbina;
	}

	
	
}
