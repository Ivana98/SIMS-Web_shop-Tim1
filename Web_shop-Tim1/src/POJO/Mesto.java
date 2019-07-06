package POJO;

public class Mesto {
	protected String nazivMesta;
	protected int pttBroj;
	
	public Mesto() {
		this.setNazivMesta("");
		this.setPttBroj(0);
	}
	
	
	
	public Mesto(String nazivMesta, int pttBroj) {
		this.setNazivMesta(nazivMesta);
		this.setPttBroj(pttBroj);
	}
	
	public Mesto(Mesto m) {
		this.setNazivMesta(m.getNazivMesta());
		this.setPttBroj(m.getPttBroj());
	}
	
	public String getNazivMesta() {
		return nazivMesta;
	}
	public void setNazivMesta(String nazivMesta) {
		this.nazivMesta = nazivMesta;
	}
	public int getPttBroj() {
		return pttBroj;
	}
	public void setPttBroj(int pttBroj) {
		this.pttBroj = pttBroj;
	}
}
