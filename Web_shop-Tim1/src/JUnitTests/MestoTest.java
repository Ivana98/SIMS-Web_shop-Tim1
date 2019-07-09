package JUnitTests;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import POJO.Mesto;

public class MestoTest {

	static Mesto mesto1;
	static Mesto mesto2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		mesto1 = new Mesto("Novi Sad" , 11200);
		mesto2 = new Mesto("Beograd" , 11000);
	}


	@Test
	public void test1() { // Test: Provera getera
		
		assertEquals("Novi Sad" , mesto1.getNazivMesta());
		assertEquals(11200, mesto1.getPttBroj());
		
	}
	
	@Test
	public void test2(){ // Test: Provera setara pa zatim i getera 
		
		mesto1.setNazivMesta(mesto2.getNazivMesta());
		mesto1.setPttBroj(mesto2.getPttBroj());
		
		assertEquals("Beograd" , mesto1.getNazivMesta());
		assertEquals(11000, mesto1.getPttBroj());
		
	}
	
	@Test
	public void test3(){ // Test: Provera metode equals()
		
		boolean rezultat = mesto1.equals(mesto2);
		assertEquals(true , rezultat);
		
		mesto1.setNazivMesta("Nis");
		rezultat = mesto1.equals(mesto2);
		assertEquals(false , rezultat);
		
	}
	
}

