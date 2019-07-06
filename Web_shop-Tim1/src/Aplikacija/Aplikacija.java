package Aplikacija;

import java.awt.Image;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

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
import POJO.Tip_korisnika;

public class Aplikacija {
	
	private static Aplikacija instance ;
	
	public static Aplikacija getInstance() {
		if(instance == null) {
			instance = new Aplikacija();
		}
		return instance;
	}
	
	protected ArrayList<Kolicina> kolicina;
	protected HashMap<Proizvod,Integer>proizvodi;
	protected ArrayList<StavkaCenovnika>ceneProizvoda;
	protected ArrayList<Prodavnica> prodavnica ;
	protected ArrayList<Cenovnik> cenovnik ;
	protected ArrayList<Registrovan_korisnik> korisnik ;
	protected String username;
	
	public Aplikacija(ArrayList<Prodavnica> prodavnica, ArrayList<Cenovnik> cenovnik, ArrayList<Registrovan_korisnik> korisnik, 
			HashMap<Proizvod,Integer>proizvodi,ArrayList<StavkaCenovnika>ceneProizvoda, String username) {
		this.setProdavnica(prodavnica);
		this.setCenovnik(cenovnik);
		this.setKorisnik(korisnik);
		this.setProizvodi(proizvodi);
		this.setCeneProizvoda(ceneProizvoda);
		this.setUsername(username);
	}
	
	public Aplikacija()
	{
		this.setProdavnica(new ArrayList<Prodavnica>());
		this.setCenovnik(new ArrayList<Cenovnik>());
		this.setKorisnik(new ArrayList<Registrovan_korisnik>());
		this.setProizvodi(new HashMap<Proizvod,Integer>());
		this.setCeneProizvoda(new ArrayList<StavkaCenovnika>());
		this.setUsername("");
	}
	
	public Aplikacija(Aplikacija a)
	{
		this.setProdavnica(a.getProdavnica());
		this.setCenovnik(a.getCenovnik());
		this.setKorisnik(a.getKorisnik());
		this.setProizvodi(a.getProizvodi());
		this.setCeneProizvoda(a.getCeneProizvoda());
		this.setUsername(a.getUsername());
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
	
	public float trazenjeNajnovijeCene(Proizvod proizvod,int brojCenovnika)
	{
		float cena = 0;
		for(int i = 0;i<Aplikacija.getInstance().getCeneProizvoda().size();i++)
		{
			if(Aplikacija.getInstance().getCeneProizvoda().get(i).getProizvod().getNaziv().equals(proizvod.getNaziv()) && Aplikacija.getInstance().getCeneProizvoda().get(i).getCenovnik().getBrojCenovnika()==brojCenovnika)
			{
				cena = Aplikacija.getInstance().getCeneProizvoda().get(i).getJedinicnaCena();
				break;
			}
		}
		return cena;
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
		
		Aplikacija.getInstance().getProizvodi().put(new Proizvod("Stolica","Materijal : Plastika|Polozaj : Ravan","src/Aplikacija/Stolica.jpg"),20);
		Aplikacija.getInstance().getProizvodi().put(new Proizvod("Sto","Drvo : Breza|Polozaj : Ravan","src/Aplikacija/sto.jpg"),20);
		Aplikacija.getInstance().getProizvodi().put(new Proizvod("Pivo","Boja : Zuta","src/Aplikacija/pivo.jpg|src/Aplikacija/pivo2.jpg"),40);
		
		//korisnik
		Aplikacija.getInstance().getKorisnik().add(new Registrovan_korisnik("a", "a", "a", "a", "a", new ArrayList<Kupon>(), Tip_korisnika.registrovanKorisnik, "a", "a",new ArrayList<Proizvod>()));
		
		//cenovnik i cene
		LocalDateTime randomDatum = LocalDateTime.of(2015, 4, 21, 05, 20);
		LocalDateTime randomDatum2 = LocalDateTime.of(2014, 4, 21, 05, 20);
		Aplikacija.getInstance().getCenovnik().add(new Cenovnik(0, randomDatum));
		Aplikacija.getInstance().getCenovnik().add(new Cenovnik(1, randomDatum2));
		Aplikacija.getInstance().getCeneProizvoda().add(new StavkaCenovnika(50, Aplikacija.getInstance().getCenovnik().get(0), 
				(Proizvod)Aplikacija.getInstance().getProizvodi().keySet().toArray()[2]));
		Aplikacija.getInstance().getCeneProizvoda().add(new StavkaCenovnika(100, Aplikacija.getInstance().getCenovnik().get(0), 
				(Proizvod)Aplikacija.getInstance().getProizvodi().keySet().toArray()[1]));
		Aplikacija.getInstance().getCeneProizvoda().add(new StavkaCenovnika(500, Aplikacija.getInstance().getCenovnik().get(0), 
				(Proizvod)Aplikacija.getInstance().getProizvodi().keySet().toArray()[0]));
	}

	

	public ArrayList<StavkaCenovnika> getCeneProizvoda() {
		return ceneProizvoda;
	}

	public void setCeneProizvoda(ArrayList<StavkaCenovnika> ceneProizvoda) {
		this.ceneProizvoda = ceneProizvoda;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public HashMap<Proizvod, Integer> getProizvodi() {
		return proizvodi;
	}

	public void setProizvodi(HashMap<Proizvod, Integer> proizvodi) {
		this.proizvodi = proizvodi;
	}

}
