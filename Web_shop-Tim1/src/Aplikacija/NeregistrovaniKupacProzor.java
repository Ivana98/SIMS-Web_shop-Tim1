package Aplikacija;

import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class NeregistrovaniKupacProzor extends GlavniProzor {
	
	NeregistrovaniKupacProzor() throws IOException {
		super();
		//Dodavanje komponenti u headerpanel
		JTextField usernameField = new JTextField(10);
		JPasswordField passwordField = new JPasswordField(10);
		JTextField search = new JTextField(10);
		
		JButton loginBtn = new JButton("Log In");
		JButton registerBtn = new JButton("Sign Up");
		JButton searchBtn = new JButton("Search");
		JButton cartBtn = new JButton("Shopping Cart");
		
		JLabel usernameLabel = new JLabel("Username: ");
		JLabel passwordLabel = new JLabel("Password: ");
		
		
		headerPanel.add(usernameLabel);
		headerPanel.add(usernameField);
		headerPanel.add(passwordLabel);
		headerPanel.add(passwordField);
		headerPanel.add(loginBtn);
		headerPanel.add(registerBtn);
		headerPanel.add(search);
		headerPanel.add(searchBtn);
		headerPanel.add(cartBtn);
		
		setVisible(true);
	}

}
