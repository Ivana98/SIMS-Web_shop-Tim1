package POJO;

import Aplikacija.Aplikacija;

public class Obradjivanje extends Stanje{

	public Obradjivanje(Narudzbenica n) {
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
		int ukupno = 0;
		for(Proizvod p : Aplikacija.getInstance().getMapa().keySet()) {
			ukupno = Aplikacija.getInstance().ukupnaKolicina(p);//Treba Proizvod
			if(ukupno <-5) {
				narudzbenica.azurirajPokusaj(false);
				narudzbenica.promeniStanje(new Otkazivanje(narudzbenica));
			}
			
		}
		
		/*int ukupno = Aplikacija.getInstance().ukupnaKolicina();//Treba Proizvod
		if(ukupno >=-5) {
			narudzbenica.azurirajPokusaj(true);
			narudzbenica.promeniStanje(new Slanje(narudzbenica));
		}*/
		narudzbenica.azurirajPokusaj(true);
		narudzbenica.promeniStanje(new Slanje(narudzbenica));
		
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
