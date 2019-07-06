package POJO;

public abstract class Stanje {
	protected Narudzbenica narudzbenica;//kontekst
	
	public abstract void zavrsenaKupovina();
	public abstract void proveraPorudzbine();
	public abstract void proveraLagera();
	public abstract void problemiUTransportu();
	public abstract void posaljiPorudzbinu();
	public abstract void krajPorudzbine();
	public abstract void novaPorudzbina();
	
	public Stanje(Narudzbenica n) {
		narudzbenica = n;
	}
	
}
