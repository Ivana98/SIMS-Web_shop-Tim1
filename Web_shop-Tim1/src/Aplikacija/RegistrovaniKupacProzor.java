package Aplikacija;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import POJO.Narudzbenica;

public class RegistrovaniKupacProzor extends GlavniProzor{

	RegistrovaniKupacProzor() throws IOException {
		super();
		
		//Dodavanje komponenti u headerpanel
		JLabel label = new JLabel("Welcome to Globus Shop!");
		JButton cartBtn = new JButton("My Shopping Cart");
		JButton wishBtn = new JButton("My WishList");
		JButton historyBtn = new JButton("My History");
		JTextField searchField = new JTextField(10);
		JButton searchBtn = new JButton("Search");
		JButton logoutBtn = new JButton("Log Out");
		
		headerPanel.add(label);
		headerPanel.add(cartBtn);
		headerPanel.add(wishBtn);
		headerPanel.add(historyBtn);
		headerPanel.add(searchField);
		headerPanel.add(searchBtn);
		headerPanel.add(logoutBtn);
		
		int brojCenovnika = trazenjeCenovnika();
		cartBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				KorpaProzor kp = new KorpaProzor(brojCenovnika);
			}
			
	    });
		
		searchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String trazi = searchField.getText();
				trazenje(trazi);
			}
		});
		
		wishBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ListaZeljaProzor lz = new ListaZeljaProzor(brojCenovnika);
			}
			
	    });
		
		historyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] imenaKolona = {"Id porudzbine", "Ime", "Prezime", "Adresa", "Datum"};
				// Videti u istorijaNarudzbenicaProzor kako se popunjava ovo i izvuci podatke
				ArrayList<Narudzbenica>narucio = new ArrayList<Narudzbenica>();
				for(Narudzbenica narudzbenica : Aplikacija.getInstance().getNarudzbenice())
				{
					if(narudzbenica.getReg_korisnik().getUsername().equals(Aplikacija.getInstance().getUsername())) {
						narucio.add(narudzbenica);
					}
				}
				Object podaci[][] = new Object[narucio.size()][5];
				for(int i = 0;i<narucio.size();i++)
				{
					podaci[i][0] = narucio.get(i).getId()+"";
					podaci[i][1] =narucio.get(i).getIme();
					podaci[i][2] =narucio.get(i).getPrezime();
					podaci[i][3] =narucio.get(i).getAdresa();
					podaci[i][4] =narucio.get(i).getDatum()+"";
				}
				IstorijaPorudzbinaProzor istorijaP = new IstorijaPorudzbinaProzor(imenaKolona, podaci);
			}
		});
		
		logoutBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					NeregistrovaniKupacProzor nr = new NeregistrovaniKupacProzor();
					Aplikacija.getInstance().setUsername("");
					setVisible(false);
					dispose();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
	    });
		
		setVisible(true);
	}

}
