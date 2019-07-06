package POJO;

import java.util.ArrayList;

public class Narudzbenica {
	
	private boolean malverzacija;
	private boolean noviPokusaj;
	private boolean zadovoljan;
	
	private ArrayList<UpdateListener> listener;
	private Stanje tekuceStanje;
	
	public Narudzbenica() {
		listener =  new ArrayList<UpdateListener>();
		tekuceStanje = null;
		malverzacija = false;
		noviPokusaj = true;
		zadovoljan = true;
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
		UpdateEvent e = new UpdateEvent(this,tekuceStanje);
		//Slanje dogadjaja da se desila promena svima koji su se registrovali za pracenje promena:
		for (UpdateListener updateListener : this.getListener()) {
			updateListener.updatePerformed(e);
		}
		
		//U slucaju realnog kontrolera, ovde bi se direktno izdavale komande izlaznim uredjajima.
	}
	
	public boolean porudzbinaURedu() {//Treba parametar ali videcemo
		return false;
	}
	
}
