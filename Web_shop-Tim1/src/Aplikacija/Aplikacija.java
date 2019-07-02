package Aplikacija;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import POJO.Cenovnik;
import POJO.Kolicina;
import POJO.Korisnik;
import POJO.Kupon;
import POJO.Prodavnica;
import POJO.Proizvod;
import POJO.Registrovan_korisnik;
import POJO.StavkaCenovnika;

public class Aplikacija {
	
	private static Aplikacija instance ;
	
	public static Aplikacija getInstance() {
		if(instance == null) {
			instance = new Aplikacija();
		}
		return instance;
	}
	
	protected ArrayList<Kolicina>proizvodi;
	protected ArrayList<StavkaCenovnika>ceneProizvoda;
	protected ArrayList<Prodavnica> prodavnica ;
	protected ArrayList<Cenovnik> cenovnik ;
	protected ArrayList<Registrovan_korisnik> korisnik ;
	
	public Aplikacija(ArrayList<Prodavnica> prodavnica, ArrayList<Cenovnik> cenovnik, ArrayList<Registrovan_korisnik> korisnik, 
			ArrayList<Kolicina>proizvodi,ArrayList<StavkaCenovnika>ceneProizvoda) {
		this.setProdavnica(prodavnica);
		this.setCenovnik(cenovnik);
		this.setKorisnik(korisnik);
		this.setProizvodi(proizvodi);
		this.setCeneProizvoda(ceneProizvoda);
	}
	
	public Aplikacija()
	{
		this.setProdavnica(new ArrayList<Prodavnica>());
		this.setCenovnik(new ArrayList<Cenovnik>());
		this.setKorisnik(new ArrayList<Registrovan_korisnik>());
		this.setProizvodi(new ArrayList<Kolicina>());
		this.setCeneProizvoda(new ArrayList<StavkaCenovnika>());
	}
	
	public Aplikacija(Aplikacija a)
	{
		this.setProdavnica(a.getProdavnica());
		this.setCenovnik(a.getCenovnik());
		this.setKorisnik(a.getKorisnik());
		this.setProizvodi(a.getProizvodi());
		this.setCeneProizvoda(a.getCeneProizvoda());
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

	public ArrayList<Registrovan_korisnik> getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(ArrayList<Registrovan_korisnik> korisnik) {
		this.korisnik = korisnik;
	}

	public static void setInstance(Aplikacija instance) {
		Aplikacija.instance = instance;
	}

	
	public static void main(String args[]) throws IOException
	{
		inicijalizacija();
		//GlavniProzor gp = new GlavniProzor();
		NeregistrovaniKupacProzor nkp = new NeregistrovaniKupacProzor();
		//RegistrovaniKupacProzor rkp = new RegistrovaniKupacProzor();
		//MenadzerProzor mp = new MenadzerProzor();
		//AdminProzor ap = new AdminProzor();
	}
	
	static void inicijalizacija()
	{
		//dodati proizvodi radi testiranja
		
		Aplikacija.getInstance().getProdavnica().add(new Prodavnica(1, "Titanik", "Cara Lazara1", "01112"));
		Aplikacija.getInstance().getProdavnica().add(new Prodavnica(2, "Kraus", "Cara Milosa1", "3339"));
		
		Aplikacija.getInstance().getProizvodi().add(new Kolicina(20, Aplikacija.getInstance().prodavnica.get(0), 
				new Proizvod("Stolica","Drvena","src/Aplikacija/Stolica.jpg")));
		Aplikacija.getInstance().getProizvodi().add(new Kolicina(20, Aplikacija.getInstance().prodavnica.get(0), 
						new Proizvod("Sto","Drven","src/Aplikacija/sto.jpg")));
		Aplikacija.getInstance().getProizvodi().add(new Kolicina(20, Aplikacija.getInstance().prodavnica.get(0), 
						new Proizvod("Pivo","Drven","src/Aplikacija/pivo.jpg")));
		Aplikacija.getInstance().getProizvodi().add(new Kolicina(20, Aplikacija.getInstance().prodavnica.get(1), 
				new Proizvod("Pivo","Drven","src/Aplikacija/pivo.jpg")));
	}

	public ArrayList<Kolicina> getProizvodi() {
		return proizvodi;
	}

	public void setProizvodi(ArrayList<Kolicina> proizvodi) {
		this.proizvodi = proizvodi;
	}

	public ArrayList<StavkaCenovnika> getCeneProizvoda() {
		return ceneProizvoda;
	}

	public void setCeneProizvoda(ArrayList<StavkaCenovnika> ceneProizvoda) {
		this.ceneProizvoda = ceneProizvoda;
	}

}
