package POJO;

public class Urucivanje extends Stanje{

	public Urucivanje(Narudzbenica n) {
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
		if(narudzbenica.isNoviPokusaj() && !narudzbenica.isZadovoljan()) {
			//...
		}
		else {//Kraj...
			
		}
		
	}

}
