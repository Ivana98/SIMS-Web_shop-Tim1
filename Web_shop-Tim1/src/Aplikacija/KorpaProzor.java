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

import POJO.Narudzbenica;
import POJO.Proizvod;
import POJO.StavkaNarudzbenice;

public class KorpaProzor extends JFrame{

	KorpaProzor(int broj){
		int brojCenovnika = broj;
		setTitle("Moja korpa");
		setSize(500, 400);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel nazivLabel = new JLabel("Naziv proizvoda");
		JLabel cenaLabel = new JLabel("Cena");
		JLabel kolicinaLabel = new JLabel("Kolicina");
		JLabel ukupnoLabel = new JLabel("Ukupno");
		JButton poruciBtn = new JButton("Kupovina");
		JLabel ukupnoCenaLabel = new JLabel("");
		
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
	    Narudzbenica narudzbenica = Aplikacija.getInstance().trazenjeNaruzbeniceKojaSePravi();
	    int x = 0;
	    for(x = 0;x<Aplikacija.getInstance().getNarudzbenice().size();x++)
			{
				if(Aplikacija.getInstance().getNarudzbenice().get(x).equals(narudzbenica))
				{
					float sve = 0;
					for(StavkaNarudzbenice stavka : Aplikacija.getInstance().getNarudzbenice().get(x).getListaNarudzbina())
					{
						sve += stavka.getUkupno();
					}
					
					ukupnoCenaLabel.setText("Ukupna cena: "+sve+" RSD");
					break;
				}
			}
	    
	    int yy = -1;
		for(StavkaNarudzbenice stavkaNarudzbenice : narudzbenica.getListaNarudzbina())
		{
			yy++;
			ImageIcon icon = new ImageIcon(stavkaNarudzbenice.getProizvod().getSlikaLokacija().split("\\|")[0]);
			Image scaledImg = icon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
			
			JLabel slika1 = new JLabel(new ImageIcon(scaledImg));
			JLabel naziv1 = new JLabel(stavkaNarudzbenice.getProizvod().getNaziv());
			
			//trazenje csene
			float cena =Aplikacija.getInstance().trazenjeNajnovijeCene(stavkaNarudzbenice.getProizvod(), brojCenovnika);
			
			JLabel cena1 = new JLabel(Float.toString(cena));
			int kolicina = Aplikacija.getInstance().getProizvodi().get(stavkaNarudzbenice.getProizvod());
			int pocinje = stavkaNarudzbenice.getNarucenaKolicina();
			SpinnerModel vrednost1 =  new SpinnerNumberModel(pocinje, 0, kolicina, 1);
			JSpinner kolicina1 = new JSpinner(vrednost1);
			JLabel ukupno1 = new JLabel(Float.toString(cena * pocinje));
			
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
		    
		    final int lokacijaPozicijeListeProizvoda = yy;
		    kolicina1.addChangeListener(new ChangeListener() {  
		        public void stateChanged(ChangeEvent e) { 
		        	// izracunavanje cena* br. komada
		        	int a = (int) kolicina1.getValue();
		        	float c1 = Float.parseFloat(cena1.getText()) * a;
		        	ukupno1.setText(c1 + " RSD"); 
		        	
		        	 for(int x = 0;x<Aplikacija.getInstance().getNarudzbenice().size();x++)
		 			{
		 				if(Aplikacija.getInstance().getNarudzbenice().get(x).equals(narudzbenica))
		 				{
		 					Aplikacija.getInstance().getNarudzbenice().get(x).getListaNarudzbina().get(lokacijaPozicijeListeProizvoda).setNarucenaKolicina(a);
		 					Aplikacija.getInstance().getNarudzbenice().get(x).getListaNarudzbina().get(lokacijaPozicijeListeProizvoda).setUkupno(c1);
		 					
		 					float sve = 0;
		 					for(StavkaNarudzbenice stavka : Aplikacija.getInstance().getNarudzbenice().get(x).getListaNarudzbina())
		 					{
		 						sve += stavka.getUkupno();
		 					}
		 					
		 					ukupnoCenaLabel.setText("Ukupna cena: "+sve+" RSD");
		 				}
		 			}
		        	
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
	    
	    gc.anchor = GridBagConstraints.FIRST_LINE_START;
	    gc.gridx = 4;
	    gc.gridy = 5;
	    add(poruciBtn, gc);
	    
	    final int lokacijaNarudzbenice = x;
	    poruciBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				NarudzbenicaProzor np = new NarudzbenicaProzor(lokacijaNarudzbenice);
				setVisible(false);
				dispose();
			}
	    	
	    });
	    
		setVisible(true);
	}
	
}
