package POJO;

public class StavkaNarudzbenice {
	protected Proizvod proizvod;
	protected int narucenaKolicina;
	protected double jedinicnaCena;
	protected double ukupno;
	
	
	
	public StavkaNarudzbenice() {
		this.setProizvod(null);
		this.setNarucenaKolicina(0);
		this.setJedinicnaCena(0);
		this.setUkupno(0);
	}
	
	public StavkaNarudzbenice(Proizvod proizvod, int narucenaKolicina, double jedinicnaCena, double ukupno) {
		this.setProizvod(proizvod);
		this.setNarucenaKolicina(narucenaKolicina);
		this.setJedinicnaCena(jedinicnaCena);
		this.setUkupno(ukupno);
	}
	
	public StavkaNarudzbenice(StavkaNarudzbenice stav) {
		this.setProizvod(stav.getProizvod());
		this.setNarucenaKolicina(stav.getNarucenaKolicina());
		this.setJedinicnaCena(stav.getJedinicnaCena());
		this.setUkupno(stav.getUkupno());
	}
	
	
	public Proizvod getProizvod() {
		return proizvod;
	}
	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
	}
	public int getNarucenaKolicina() {
		return narucenaKolicina;
	}
	public void setNarucenaKolicina(int narucenaKolicina) {
		this.narucenaKolicina = narucenaKolicina;
	}
	public double getJedinicnaCena() {
		return jedinicnaCena;
	}
	public void setJedinicnaCena(double jedinicnaCena) {
		this.jedinicnaCena = jedinicnaCena;
	}
	public double getUkupno() {
		return ukupno;
	}
	public void setUkupno(double ukupno) {
		this.ukupno = ukupno;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}else if(o instanceof StavkaNarudzbenice){
			StavkaNarudzbenice s = (StavkaNarudzbenice)o;
			if(s.getProizvod() == this.getProizvod() ) {//NIJE JOS GOTOVO...PROVERITI SLEDECI PUT.
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
}
