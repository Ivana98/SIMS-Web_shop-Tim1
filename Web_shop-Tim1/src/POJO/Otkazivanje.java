package POJO;

import Aplikacija.Aplikacija;

public class Otkazivanje extends Stanje{

	public Otkazivanje(Narudzbenica n) {
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
		int ukupno = 0;
		for(Proizvod p : Aplikacija.getInstance().getProizvodi().keySet()) {
			ukupno = Aplikacija.getInstance().ukupnaKolicina(p);//Treba Proizvod
			if(ukupno <-5) {
				//Kraj...
			}
			
		}
		//int ukupno =  ukupnaKolicina();
		
		if(narudzbenica.isMalverzacija() || !narudzbenica.isNoviPokusaj()) {
			//...kraj
		}
		
	}

	@Override
	public void novaPorudzbina() {
		
		int ukupno = 0;
		boolean b = false;
		for(Proizvod p : Aplikacija.getInstance().getProizvodi().keySet()) {
			ukupno = Aplikacija.getInstance().ukupnaKolicina(p);//Treba Proizvod
			if(ukupno < -5) {
				//narudzbenica.azurirajPokusaj(false);
				//narudzbenica.promeniStanje(new Kreiranje(narudzbenica));
				b = true;
			}
			
		}
		if(b) {
			krajPorudzbine();
		}
		else {
			if (narudzbenica.isNoviPokusaj()) {
				narudzbenica.promeniStanje(new Kreiranje(narudzbenica));
				
			}
			else {
				krajPorudzbine();
			}
		}
		
	}

}
