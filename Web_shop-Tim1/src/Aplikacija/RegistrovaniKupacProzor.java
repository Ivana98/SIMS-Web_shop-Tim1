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
		
		cartBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				KorpaProzor kp = new KorpaProzor();
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
				ListaZeljaProzor lz = new ListaZeljaProzor();
			}
			
	    });
		
		historyBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Ovde ce biti prikazana tabela porudzbina sa datumima kada su napravljene.", 
						"Prozor u izradi", JOptionPane.INFORMATION_MESSAGE);
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
