package POJO;

import Aplikacija.Aplikacija;

public class StavkaCenovnika {
	protected float jedinicnaCena;
	protected Proizvod proizvod;
	protected Cenovnik cenovnik;
	
	public StavkaCenovnika() {
		this.setJedinicnaCena(0);
		this.setCenovnik(null);
		this.setProizvod(null);
	}
	
	public StavkaCenovnika(float jedinicnaCena,Cenovnik c , Proizvod p) {
		this.setJedinicnaCena(jedinicnaCena);
		this.setCenovnik(c);
		this.setProizvod(p);
	
	
	}

	public StavkaCenovnika(StavkaCenovnika c) {
		this.setJedinicnaCena(c.getJedinicnaCena());
		this.setCenovnik(c.getCenovnik());
		this.setProizvod(c.getProizvod());
	
	}
	
	

	public float getJedinicnaCena() {
		return jedinicnaCena;
	}

	public void setJedinicnaCena(float jedinicnaCena) {
		this.jedinicnaCena = jedinicnaCena;
	}

	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}else if(o instanceof StavkaCenovnika){
			StavkaCenovnika c = (StavkaCenovnika)o;
			if(c.getCenovnik().equals(this.getCenovnik()) && c.getProizvod().equals(this.getProizvod()) && c.getJedinicnaCena() == this.getJedinicnaCena()) {
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

	public Proizvod getProizvod() {
		return proizvod;
	}

	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
	}

	public Cenovnik getCenovnik() {
		return cenovnik;
	}

	public void setCenovnik(Cenovnik cenovnik) {
		this.cenovnik = cenovnik;
	}
}
