package Aplikacija;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import POJO.Proizvod;
import POJO.Registrovan_korisnik;
import POJO.StavkaCenovnika;

public class ListaZeljaProzor extends JFrame{
	
	ListaZeljaProzor(int broj){
		int brojCenovnika = broj;
		//postavljanje korisnika
		Registrovan_korisnik korisnik = new Registrovan_korisnik();
		for(Registrovan_korisnik reg : Aplikacija.getInstance().getKorisnik())
		{
			if(reg.getUsername().equals(Aplikacija.getInstance().getUsername()))
			{
				korisnik = reg;
				break;
			}
		}
		
		setTitle("Moja lista zelja");
		setSize(600, 400);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel nazivLabel = new JLabel("Naziv proizvoda");
		JLabel cenaLabel = new JLabel("Cena");
		JLabel kolicinaLabel = new JLabel("Kolicina");
		JLabel ukupnoLabel = new JLabel("Ukupno");
		JLabel ukupnoCenaLabel = new JLabel("Koriscena valuta : RSD");
		
		//dodavanje komentara
		setLayout(new GridBagLayout());	    
	    GridBagConstraints gc = new GridBagConstraints();
	    
		//// prvo
	    
	    gc.anchor = GridBagConstraints.LINE_END;
	    gc.weightx = 0.5;
	    gc.weighty = 0.5;
	    
	    gc.gridx = 0;
	    gc.gridy = 0;
	    add(nazivLabel, gc);
	    
	    gc.gridx = 2;
	    gc.gridy = 0;
	    add(cenaLabel, gc);
	    
	    gc.gridx = 3;
	    gc.gridy = 0;
	    add(kolicinaLabel, gc);
	    
	    gc.anchor = GridBagConstraints.BELOW_BASELINE;
	    gc.gridx = 4;
	    gc.gridy = 0;
	    add(ukupnoLabel, gc);
		
		//komponente proizvoda
	    int i = 1;
		for(Proizvod proizvod : korisnik.getWishlista())
		{
			ImageIcon icon = new ImageIcon(proizvod.getSlikaLokacija().split("\\|")[0]);
			Image scaledImg = icon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
			
			JLabel slika1 = new JLabel(new ImageIcon(scaledImg));
			JLabel naziv1 = new JLabel(proizvod.getNaziv());
			
			//trazenje csene
			float cena =Aplikacija.getInstance().trazenjeNajnovijeCene(proizvod, brojCenovnika);
			
			JLabel cena1 = new JLabel(Float.toString(cena));
			int kolicina = Aplikacija.getInstance().getProizvodi().get(proizvod);
			SpinnerModel vrednost1 =  new SpinnerNumberModel(1, 0, kolicina, 1);
			JSpinner kolicina1 = new JSpinner(vrednost1);
			JLabel ukupno1 = new JLabel(Float.toString(cena));
			JButton dodajBtn1 = new JButton("Dodaj u korpu");
			
			gc.gridx = 0;
		    gc.gridy = i;
		    add(slika1, gc);
		    
		    gc.gridx = 1;
		    gc.gridy = i;
		    add(naziv1, gc);
			
		    gc.gridx = 2;
		    gc.gridy = i;
		    add(cena1, gc);
		    
		    gc.gridx = 3;
		    gc.gridy = i;
		    add(kolicina1, gc);
		    
		    gc.gridx = 4;
		    gc.gridy = i;
		    add(ukupno1, gc);
		    
		    gc.anchor = GridBagConstraints.BELOW_BASELINE;
		    gc.gridx = 5;
		    gc.gridy = i;
		    add(dodajBtn1, gc);
		    
		    kolicina1.addChangeListener(new ChangeListener() {  
		        public void stateChanged(ChangeEvent e) { 
		        	// izracunavanje cena* br. komada
		        	int a = (int) kolicina1.getValue();
		        	float c1 = Float.parseFloat(cena1.getText()) * a;
		        	ukupno1.setText(c1 + " RSD"); 
		        }  
		     });
		    i++;
		}
		
	    
	    //// Poslednji red
		gc.weighty = 10;
	    
	    gc.anchor = GridBagConstraints.FIRST_LINE_START;
	    gc.gridx = 4;
	    gc.gridy = 4;
	    add(ukupnoCenaLabel, gc);
	    
		setVisible(true);
	}
	
}
