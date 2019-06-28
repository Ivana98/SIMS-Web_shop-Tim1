package Aplikacija;

import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
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
		
		setVisible(true);
	}

}
