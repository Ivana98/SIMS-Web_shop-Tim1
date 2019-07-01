package POJO;

public class Kolicina {
	protected int kolicina;
	protected Prodavnica prodavnica;
	protected Proizvod proizvod;
	
	
	public Kolicina() {
		this.setKolicina(0);
		this.setProdavnica(new Prodavnica());
		this.setProizvod(new Proizvod());
	}
	
	public Kolicina(int kolicina, Prodavnica prodavnica, Proizvod proizvod) {
		
		this.setKolicina(kolicina);
		this.setProdavnica(prodavnica);
		this.setProizvod(proizvod);
	}
	
	
	public Kolicina(Kolicina k) {
		
		this.setKolicina(k.getKolicina());
		this.setProizvod(k.getProizvod());
		this.setProdavnica(k.getProdavnica());
	}
	
	public int getKolicina() {
		return kolicina;
	}
	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}
	public Prodavnica getProdavnica() {
		return prodavnica;
	}
	public void setProdavnica(Prodavnica prodavnica) {
		this.prodavnica = prodavnica;
	}
	public Proizvod getProizvod() {
		return proizvod;
	}
	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}else if(o instanceof Kolicina){
			Kolicina k = (Kolicina)o;
			if(k.getProdavnica().equals(this.getProdavnica()) && this.getProizvod().equals(k.getProizvod())) {
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
