package POJO;

public class Slanje extends Stanje{

	public Slanje(Narudzbenica n) {
		super(n);
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	public void zavrsenaKupovina() {
		// TODO Auto-generated method stub
		
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
		narudzbenica.azurirajPokusaj(true);
		narudzbenica.promeniStanje(new Otkazivanje(narudzbenica));
		
	}

	@Override
	public void posaljiPorudzbinu() {
		narudzbenica.azurirajPokusaj(true);
		narudzbenica.promeniStanje(new Urucivanje(narudzbenica));
		
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
