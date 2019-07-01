package POJO;

public class StavkaCenovnika {
	protected float jedinicnaCena;
	protected Proizvod p;
	protected Cenovnik c;
	
	public StavkaCenovnika() {
		this.setJedinicnaCena(0);
		this.setC(null);
		this.setP(null);
	}
	
	public StavkaCenovnika(float jedinicnaCena,Cenovnik c , Proizvod p) {
		this.setJedinicnaCena(jedinicnaCena);
		this.setC(c);
		this.setP(p);
	
	
	}

	public StavkaCenovnika(StavkaCenovnika c) {
		this.setJedinicnaCena(c.getJedinicnaCena());
		this.setC(c.getC());
		this.setP(c.getP());
	
	}
	
	
	
	
	public Proizvod getP() {
		return p;
	}

	public void setP(Proizvod p) {
		this.p = p;
	}

	public Cenovnik getC() {
		return c;
	}

	public void setC(Cenovnik c) {
		this.c = c;
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
			if(c.getC().equals(this.getC()) && c.getP().equals(this.getP()) && c.getJedinicnaCena() == this.getJedinicnaCena()) {
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
