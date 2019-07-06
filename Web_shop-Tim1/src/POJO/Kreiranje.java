package POJO;

public class Kreiranje extends Stanje{
	
	public Kreiranje(Narudzbenica n) {
		super(n);
		
	}

	@Override
	public void zavrsenaKupovina() {
		narudzbenica.promeniStanje(new Porucivanje(narudzbenica));
		
	}

	@Override
	public void proveraPorudzbine() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void proveraLagera() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void problemiUTransportu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void posaljiPorudzbinu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void krajPorudzbine() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void novaPorudzbina() {
		// TODO Auto-generated method stub
		
	}
	
}
