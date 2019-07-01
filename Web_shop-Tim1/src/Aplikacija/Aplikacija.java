package Aplikacija;

import java.io.IOException;
import java.util.ArrayList;

import POJO.Cenovnik;
import POJO.Korisnik;
import POJO.Kupon;
import POJO.Prodavnica;

public class Aplikacija {
	
	private static Aplikacija instance ;
	
	public static Aplikacija getInstance() {
		if(instance == null) {
			instance = new Aplikacija();
		}
		return instance;
	}
	
	protected ArrayList<Prodavnica> prodavnica ;
	protected ArrayList<Cenovnik> cenovnik ;
	protected ArrayList<Korisnik> korisnik ;
	protected ArrayList<Kupon> kupon;
	
	public Aplikacija(ArrayList<Prodavnica> prodavnica, ArrayList<Cenovnik> cenovnik, ArrayList<Korisnik> korisnik,
			ArrayList<Kupon> kupon) {
		this.setProdavnica(prodavnica);
		this.setCenovnik(cenovnik);
		this.setKorisnik(korisnik);
		this.setKupon(kupon);
	}
	
	public Aplikacija()
	{
		this.setProdavnica(new ArrayList<Prodavnica>());
		this.setCenovnik(new ArrayList<Cenovnik>());
		this.setKorisnik(new ArrayList<Korisnik>());
		this.setKupon(new ArrayList<Kupon>());
	}
	
	public Aplikacija(Aplikacija a)
	{
		this.setProdavnica(a.getProdavnica());
		this.setCenovnik(a.getCenovnik());
		this.setKorisnik(a.getKorisnik());
		this.setKupon(a.getKupon());
	}
	
	@Override
	public String toString()
	{
		return "";
	}
	
	public ArrayList<Prodavnica> getProdavnica() {
		return prodavnica;
	}

	public void setProdavnica(ArrayList<Prodavnica> prodavnica) {
		this.prodavnica = prodavnica;
	}

	public ArrayList<Cenovnik> getCenovnik() {
		return cenovnik;
	}

	public void setCenovnik(ArrayList<Cenovnik> cenovnik) {
		this.cenovnik = cenovnik;
	}

	public ArrayList<Korisnik> getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(ArrayList<Korisnik> korisnik) {
		this.korisnik = korisnik;
	}

	public ArrayList<Kupon> getKupon() {
		return kupon;
	}

	public void setKupon(ArrayList<Kupon> kupon) {
		this.kupon = kupon;
	}

	public static void setInstance(Aplikacija instance) {
		Aplikacija.instance = instance;
	}

	
	public static void main(String args[]) throws IOException
	{
		//GlavniProzor gp = new GlavniProzor();
		NeregistrovaniKupacProzor nkp = new NeregistrovaniKupacProzor();
		//RegistrovaniKupacProzor rkp = new RegistrovaniKupacProzor();
		//MenadzerProzor mp = new MenadzerProzor();
		//AdminProzor ap = new AdminProzor();
	}

	
	

}
