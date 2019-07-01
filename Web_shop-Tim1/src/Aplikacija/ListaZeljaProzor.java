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

public class ListaZeljaProzor extends JFrame{
	
	ListaZeljaProzor(){
		setTitle("Moja lista zelja");
		setSize(600, 400);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel nazivLabel = new JLabel("Naziv proizvoda");
		JLabel cenaLabel = new JLabel("Cena");
		JLabel kolicinaLabel = new JLabel("Kolicina");
		JLabel ukupnoLabel = new JLabel("Ukupno");
		JLabel ukupnoCenaLabel = new JLabel("Ukupna cena: 2880 RSD");
		
		//komponente proizvoda
		ImageIcon icon = new ImageIcon("src/Aplikacija/proizvod.png");
		Image scaledImg = icon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		
		JLabel slika1 = new JLabel(new ImageIcon(scaledImg));
		JLabel naziv1 = new JLabel("Proizvod 3");
		JLabel cena1 = new JLabel("790");
		SpinnerModel vrednost1 =  new SpinnerNumberModel(1, 0, 10, 1);
		JSpinner kolicina1 = new JSpinner(vrednost1);
		JLabel ukupno1 = new JLabel("790 RSD");
		JButton dodajBtn1 = new JButton("Dodaj u korpu");
		
		JLabel slika2 = new JLabel(new ImageIcon(scaledImg));
		JLabel naziv2 = new JLabel("Proizvod 1");
		JLabel cena2 = new JLabel("990");
		SpinnerModel vrednost2 =  new SpinnerNumberModel(1, 0, 10, 1);
		JSpinner kolicina2 = new JSpinner(vrednost2);
		JLabel ukupno2 = new JLabel("990 RSD");
		JButton dodajBtn2 = new JButton("Dodaj u korpu");
		
		JLabel slika3 = new JLabel(new ImageIcon(scaledImg));
		JLabel naziv3 = new JLabel("Proizvod 4");
		JLabel cena3 = new JLabel("1100");
		SpinnerModel vrednost3 =  new SpinnerNumberModel(1, 0, 10, 1);
		JSpinner kolicina3 = new JSpinner(vrednost3);
		JLabel ukupno3 = new JLabel("1100 RSD");
		JButton dodajBtn3 = new JButton("Dodaj u korpu");
		
		//dodavanje komponenata
		
		setLayout(new GridBagLayout());	    
	    GridBagConstraints gc = new GridBagConstraints();
	    
		//// Prva kolona 
	    
	    gc.anchor = GridBagConstraints.LINE_END;
	    gc.weightx = 0.5;
	    gc.weighty = 0.5;
		
	    gc.gridx = 0;
	    gc.gridy = 0;
	    add(nazivLabel, gc);
	    
	    gc.gridx = 0;
	    gc.gridy = 1;
	    add(slika1, gc);
	    
	    gc.gridx = 0;
	    gc.gridy = 2;
	    add(slika2, gc);
	    
	    gc.gridx = 0;
	    gc.gridy = 3;
	    add(slika3, gc);
	    
	    //// Druga kolona
	    gc.gridx = 1;
	    gc.gridy = 1;
	    add(naziv1, gc);
	    
	    gc.gridx = 1;
	    gc.gridy = 2;
	    add(naziv2, gc);
	    
	    gc.gridx = 1;
	    gc.gridy = 3;
	    add(naziv3, gc);
	    
	    //// Treca kolona
	    gc.gridx = 2;
	    gc.gridy = 0;
	    add(cenaLabel, gc);
	    
	    gc.gridx = 2;
	    gc.gridy = 1;
	    add(cena1, gc);
	    
	    gc.gridx = 2;
	    gc.gridy = 2;
	    add(cena2, gc);
	    
	    gc.gridx = 2;
	    gc.gridy = 3;
	    add(cena3, gc);
	    
	    ////Cetvrta kolona
	    gc.gridx = 3;
	    gc.gridy = 0;
	    add(kolicinaLabel, gc);
	    
	    gc.gridx = 3;
	    gc.gridy = 1;
	    add(kolicina1, gc);
	    
	    gc.gridx = 3;
	    gc.gridy = 2;
	    add(kolicina2, gc);
	    
	    gc.gridx = 3;
	    gc.gridy = 3;
	    add(kolicina3, gc);
	    
	    //// Peta kolona
	    gc.anchor = GridBagConstraints.BELOW_BASELINE;
	    gc.gridx = 4;
	    gc.gridy = 0;
	    add(ukupnoLabel, gc);
	    
	    gc.gridx = 4;
	    gc.gridy = 1;
	    add(ukupno1, gc);
	    
	    gc.gridx = 4;
	    gc.gridy = 2;
	    add(ukupno2, gc);
	    
	    gc.gridx = 4;
	    gc.gridy = 3;
	    add(ukupno3, gc);
	    
	    // Sesta kolona
	    gc.anchor = GridBagConstraints.BELOW_BASELINE;
	    gc.gridx = 5;
	    gc.gridy = 1;
	    add(dodajBtn1, gc);
	    
	    gc.gridx = 5;
	    gc.gridy = 2;
	    add(dodajBtn2, gc);
	    
	    gc.gridx = 5;
	    gc.gridy = 3;
	    add(dodajBtn3, gc);
	    
	    //// Poslednji red 
	    gc.weighty = 10;
	    
	    gc.anchor = GridBagConstraints.FIRST_LINE_START;
	    gc.gridx = 4;
	    gc.gridy = 4;
	    add(ukupnoCenaLabel, gc);
	    
	    kolicina1.addChangeListener(new ChangeListener() {  
	        public void stateChanged(ChangeEvent e) { 
	        	// izracunavanje cena* br. komada
	        	int c1 = (int)kolicina1.getValue() * Integer.parseInt(cena1.getText());
	        	ukupno1.setText(c1 + " RSD"); 
	        	
	        	int c2 = (int)kolicina2.getValue() * Integer.parseInt(cena2.getText());
	        	int c3 = (int)kolicina3.getValue() * Integer.parseInt(cena3.getText());
	        	int sve = c1 + c2 + c3;
	        	//azuriranje donje cene
	        	ukupnoCenaLabel.setText(sve + " RSD");
	        }  
	     });  
	    
	    kolicina2.addChangeListener(new ChangeListener() {  
	        public void stateChanged(ChangeEvent e) { 
	        	// izracunavanje cena* br. komada
	        	int c2 = (int)kolicina2.getValue() * Integer.parseInt(cena2.getText());
	        	ukupno2.setText(c2 + " RSD"); 
	        	
	        	int c1 = (int)kolicina1.getValue() * Integer.parseInt(cena1.getText());
	        	int c3 = (int)kolicina3.getValue() * Integer.parseInt(cena3.getText());
	        	int sve = c1 + c2 + c3;
	        	//azuriranje donje cene
	        	ukupnoCenaLabel.setText(sve + " RSD");
	        }  
	     }); 
	    
	    kolicina3.addChangeListener(new ChangeListener() {  
	        public void stateChanged(ChangeEvent e) { 
	        	// izracunavanje cena* br. komada
	        	int c3 = (int)kolicina3.getValue() * Integer.parseInt(cena3.getText());
	        	ukupno3.setText(c3 + " RSD"); 
	        	
	        	int c2 = (int)kolicina2.getValue() * Integer.parseInt(cena2.getText());
	        	int c1 = (int)kolicina1.getValue() * Integer.parseInt(cena1.getText());
	        	int sve = c1 + c2 + c3;
	        	//azuriranje donje cene
	        	ukupnoCenaLabel.setText(sve + " RSD");
	        }  
	     }); 
	    
		setVisible(true);
	}
	
}
