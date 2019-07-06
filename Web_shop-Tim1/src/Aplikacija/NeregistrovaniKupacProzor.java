package Aplikacija;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import POJO.Tip_korisnika;

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
		
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password =String.valueOf(passwordField.getPassword());
				try {
					logovanje(username,password);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				passwordField.setText("");
			}
		});
		
		registerBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RegistracijaProzor rp = new RegistracijaProzor();
			}
		});
		
		searchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String trazi = search.getText();
				trazenje(trazi);
			}
		});
		
		cartBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				KorpaProzor kp = new KorpaProzor();
			}
			
	    });
		
		setVisible(true);
	}
	
	public void logovanje(String username,String password) throws IOException
	{
		for(int i = 0;i<Aplikacija.getInstance().getKorisnik().size();i++)
		{
			if(username.toLowerCase().equals(Aplikacija.getInstance().getKorisnik().get(i).getUsername().toLowerCase()))
			{
				if(password.equals(Aplikacija.getInstance().getKorisnik().get(i).getPassword()))
				{
					if(Aplikacija.getInstance().getKorisnik().get(i).getTipKorisnika() == Tip_korisnika.registrovanKorisnik) {
						RegistrovaniKupacProzor rk = new RegistrovaniKupacProzor();
						Aplikacija.getInstance().setUsername(username);
						setVisible(false);
						dispose();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Pogresna lozinka!", "Greska", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

}
