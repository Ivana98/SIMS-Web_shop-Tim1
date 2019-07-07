package Aplikacija;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Ovde ce biti prikazana tabela porudzbina sa datumima kada su napravljene.", 
						"Prozor u izradi", JOptionPane.INFORMATION_MESSAGE);
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
