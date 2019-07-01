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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
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
	//metoda za trazenje proizvoda
	public void trazenje(String trazi)
	{
		midPanel.removeAll();
		
		int brojProdavnica = Aplikacija.getInstance().getProdavnica().size();
		for(int i = 0;i<brojProdavnica;i++)
			for(int j = 0;j<Aplikacija.getInstance().getProdavnica().get(i).getProizvodi().size();j++)
				{
					if(Aplikacija.getInstance().prodavnica.get(i).getProizvodi().get(j).getProizvod().getNaziv().toLowerCase().contains(trazi.toLowerCase())) {
						ImageIcon icon1 = new ImageIcon(Aplikacija.getInstance().prodavnica.get(i).getProizvodi().get(j).getProizvod().getSlikaLokacija());
						Image scaled1 = icon1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
						
						JButton proizvod0 = new JButton(Aplikacija.getInstance().prodavnica.get(i).getProizvodi().get(j).getProizvod().getNaziv(),new ImageIcon(scaled1));
						
						midPanel.add(proizvod0);
					}
				}
		midPanel.repaint();
		midPanel.revalidate();
		
	}

}
