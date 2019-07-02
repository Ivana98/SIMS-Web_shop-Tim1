package POJO;

public class Prodavnica {
	protected int sifraPreduzeca;
	protected String nazivPreduzeca;
	protected String adresa;
	protected String kontakt;
	
	public Prodavnica() {
		this.setAdresa("");
		this.setKontakt("");
		this.setNazivPreduzeca("");
		this.setSifraPreduzeca(0);
	}
	
	public Prodavnica(int sifraPreduzeca, String nazivPreduzeca, String adresa, String kontakt) {
		
		this.setSifraPreduzeca(sifraPreduzeca);
		this.setNazivPreduzeca(nazivPreduzeca);
		this.setAdresa(adresa);
		this.setKontakt(kontakt);
	}
	
	public Prodavnica(Prodavnica p) {
		
		this.setSifraPreduzeca(p.getSifraPreduzeca());
		this.setNazivPreduzeca(p.getNazivPreduzeca());
		this.setAdresa(p.getAdresa());
		this.setKontakt(p.getKontakt());
	}
	public int getSifraPreduzeca() {
		return sifraPreduzeca;
	}
	public void setSifraPreduzeca(int sifraPreduzeca) {
		this.sifraPreduzeca = sifraPreduzeca;
	}
	public String getNazivPreduzeca() {
		return nazivPreduzeca;
	}
	public void setNazivPreduzeca(String nazivPreduzeca) {
		this.nazivPreduzeca = nazivPreduzeca;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getKontakt() {
		return kontakt;
	}
	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}else if(o instanceof Prodavnica){
			Prodavnica p = (Prodavnica)o;
			if(p.getSifraPreduzeca() == this.getSifraPreduzeca()) {
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
