package POJO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Locale;

public class Cenovnik {

	protected int brojCenovnika;
	protected LocalDateTime vaziOdDatuma;
	protected ArrayList<StavkaCenovnika>proizvodi;
	
	public Cenovnik() {
		this.setBrojCenovnika(0);
		this.setVaziOdDatuma(null);
		this.setProizvodi(new ArrayList<StavkaCenovnika>());
	}
	
	public Cenovnik(int brojCenovnika, LocalDateTime vaziOdDatuma, ArrayList<StavkaCenovnika>proizvodi) {
		this.setBrojCenovnika(brojCenovnika);
		this.setVaziOdDatuma(vaziOdDatuma);
		this.setProizvodi(proizvodi);
	}

	public Cenovnik(Cenovnik c) {
		this.setBrojCenovnika(c.getBrojCenovnika());
		this.setVaziOdDatuma(c.getVaziOdDatuma());
		this.setProizvodi(c.getProizvodi());
	}
	
	public int getBrojCenovnika() {
		return brojCenovnika;
	}

	public void setBrojCenovnika(int brojCenovnika) {
		this.brojCenovnika = brojCenovnika;
	}

	public LocalDateTime getVaziOdDatuma() {
		return vaziOdDatuma;
	}

	public void setVaziOdDatuma(LocalDateTime vaziOdDatuma) {
		this.vaziOdDatuma = vaziOdDatuma;
	}
	
	
	
	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}else if(o instanceof Cenovnik){
			Cenovnik c = (Cenovnik)o;
			if(c.getBrojCenovnika() == this.getBrojCenovnika() ) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	@Override 
	public String toString() {
		return "";
	}

	public ArrayList<StavkaCenovnika> getProizvodi() {
		return proizvodi;
	}

	public void setProizvodi(ArrayList<StavkaCenovnika> proizvodi) {
		this.proizvodi = proizvodi;
	}
		
}
