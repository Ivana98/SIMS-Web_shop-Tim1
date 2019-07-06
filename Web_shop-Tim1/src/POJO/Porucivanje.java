package POJO;

public class Porucivanje extends Stanje{

	public Porucivanje(Narudzbenica n) {
		super(n);
		
	}

	@Override
	public void zavrsenaKupovina() {
		if(narudzbenica.porudzbinaURedu()) {
			narudzbenica.azurirajMalverzaciju(false);
			narudzbenica.promeniStanje(new Obradjivanje(narudzbenica));
		}
		else {
			narudzbenica.azurirajMalverzaciju(true);
			narudzbenica.promeniStanje(new Otkazivanje(narudzbenica));
		}
		
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
