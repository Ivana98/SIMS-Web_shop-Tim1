package POJO;

import java.util.ArrayList;

public class Proizvod {
	protected String naziv;
	protected String opis;
	
	
	protected String slikaLokacija;
	
	public Proizvod() {
		this.setNaziv("");
		this.setOpis("");
		this.setSlikaLokacija("");
	}
	
	public Proizvod(String naziv, String opis, String slikaLokacija) {
		this.setNaziv(naziv);
		this.setOpis(opis);
		this.setSlikaLokacija(slikaLokacija);
	}
	
	public Proizvod(Proizvod p) {
		this.setNaziv(p.getNaziv());
		this.setOpis(p.getOpis());
		this.setSlikaLokacija(p.getSlikaLokacija());
	}
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}else if(o instanceof Proizvod){
			Proizvod c = (Proizvod)o;
			if(c.getNaziv().equals(this.getNaziv())) {
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


	public String getSlikaLokacija() {
		return slikaLokacija;
	}

	public void setSlikaLokacija(String slikaLokacija) {
		this.slikaLokacija = slikaLokacija;
	}

	
}	
