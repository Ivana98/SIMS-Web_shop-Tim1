package JUnitTests;

import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;

import Aplikacija.Aplikacija;
import POJO.Proizvod;

public class AplikacijaTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Aplikacija app = new Aplikacija();
		Aplikacija.setInstance(app);
		Aplikacija.inicijalizacija();
	}

	@Test
	public void testTrazenjeNajnovijeCene() {
		//Proizvod proizvod = new Proizvod("Stolica","Materijal : Plastika|Polozaj : Ravan","src/Aplikacija/Stolica.jpg");
		//System.out.println(app.trazenjeNajnovijeCene(proizvod,0)  );
		fail("Not yet implemented");
	}

	@Test
	public void testTrazenjeKorisnika() {
		fail("Not yet implemented");
	}

	@Test
	public void testTrazenjeNaruzbeniceKojaSePravi() {
		fail("Not yet implemented");
	}

	@Test
	public void testUkupnaKolicine() {
		fail("Not yet implemented");
	}

	@Test
	public void testUkupnaKolicina() {
		fail("Not yet implemented");
	}

	@Test
	public void testIzmeni() {
		fail("Not yet implemented");
	}

}
