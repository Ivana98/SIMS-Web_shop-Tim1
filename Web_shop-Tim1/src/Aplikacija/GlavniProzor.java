package Aplikacija;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import POJO.Kolicina;
import POJO.Prodavnica;
import POJO.Proizvod;



public class GlavniProzor extends JFrame {
	protected JPanel headerPanel;
	protected JPanel midPanel;
	protected JPanel footerPanel;
	protected JScrollPane scrollPane;
	
	GlavniProzor() throws IOException{
		setTitle("Globus Web Shop");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(true);
		
		
		//panels
		headerPanel = new JPanel();
		midPanel = new JPanel();
		footerPanel = new JPanel();
		
		//header
		headerPanel.setBackground(Color.decode("#BDD8EE"));
		
		//footer
		footerPanel.setBackground(Color.decode("#BDD8EE"));
		JButton facebookBtn = new JButton("Facebook");
		JButton instagramBtn = new JButton("Instagram");
		JButton mailBtn = new JButton("Mail");
		JButton locationsBtn = new JButton("Locations");
		
		footerPanel.add(facebookBtn);
		footerPanel.add(instagramBtn);
		footerPanel.add(mailBtn);
		footerPanel.add(locationsBtn);
		
		//middle panel
		scrollPane = new JScrollPane(midPanel);
	
		midPanel.setBackground(Color.GRAY);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		GridLayout glayout = new GridLayout(3,2);
		midPanel.setLayout(glayout);
		
		//pravljenje primera
		ArrayList<String>nazivi = new ArrayList<String>();
		midPanel.removeAll();
		for(int j = 0;j<Aplikacija.getInstance().getProizvodi().size();j++)
			{
				if(nazivi.contains(Aplikacija.getInstance().getProizvodi().get(j).getProizvod().getNaziv().toLowerCase()))
					continue;
				nazivi.add(Aplikacija.getInstance().getProizvodi().get(j).getProizvod().getNaziv().toLowerCase());
				dodavanjeDugmetaUMiddlePanelu(j);
			}
		midPanel.repaint();
		midPanel.revalidate();
		
		//dodavanje na glavni panel
		BorderLayout layout = new BorderLayout();
		setLayout(layout);
		add(headerPanel, BorderLayout.PAGE_START);
		add(scrollPane,BorderLayout.CENTER);
		add(footerPanel,BorderLayout.PAGE_END);
		
		//Slika proizvoda
		ImageIcon icon = new ImageIcon("src/Aplikacija/proizvod.png");
		Image scaled = icon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		
		
		
		//ova dugmad nisu proizvodi i time nisu obuhvaceni search-om
		JButton proizvod2 = new JButton("Nista 2",new ImageIcon(scaled));
		JButton proizvod3 = new JButton("Nista 3",new ImageIcon(scaled));
		JButton proizvod4 = new JButton("Nista 1",new ImageIcon(scaled));
		JButton proizvod5 = new JButton("Nista 2",new ImageIcon(scaled));
		JButton proizvod6 = new JButton("Nista 3",new ImageIcon(scaled));
		
		midPanel.add(proizvod2);
		midPanel.add(proizvod3);
		midPanel.add(proizvod4);
		midPanel.add(proizvod5);
		midPanel.add(proizvod6);
		
		facebookBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Otvara se nasa facebook stranica u pretrazivacu.", 
						"Prozor u izradi", JOptionPane.INFORMATION_MESSAGE);
			}
			
	    });
		
		instagramBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Otvara se nasa instagram stranica u pretrazivacu.", 
						"Prozor u izradi", JOptionPane.INFORMATION_MESSAGE);
			}
			
	    });
		
		mailBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Otvara se prozor za slanje mejla sa popunjenom nasom mejl adresom u polju primaoca.", 
						"Prozor u izradi", JOptionPane.INFORMATION_MESSAGE);
			}
			
	    });
		
		locationsBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Otvara se prozor sa informacijama o nasim prodajnim mestima.", 
						"Prozor u izradi", JOptionPane.INFORMATION_MESSAGE);
			}
			
	    });
		
		setVisible(true);
	}
	
	//metoda za trazenje proizvoda
		public void trazenje(String trazi)
		{
			midPanel.removeAll();
			ArrayList<String>nazivi = new ArrayList<String>();
			
			int brojProdavnica = Aplikacija.getInstance().getProdavnica().size();
			for(int j = 0;j<Aplikacija.getInstance().getProizvodi().size();j++)
				{
					if(Aplikacija.getInstance().getProizvodi().get(j).getProizvod().getNaziv().toLowerCase().contains(trazi.toLowerCase())) {
						if(nazivi.contains(Aplikacija.getInstance().getProizvodi().get(j).getProizvod().getNaziv().toLowerCase()))
							continue;
						nazivi.add(Aplikacija.getInstance().getProizvodi().get(j).getProizvod().getNaziv().toLowerCase());
						dodavanjeDugmetaUMiddlePanelu(j);
						
					}
				}
			midPanel.repaint();
			midPanel.revalidate();
			
		}
		
		public void dodavanjeDugmetaUMiddlePanelu(int j)
		{
			ImageIcon icon1 = new ImageIcon(Aplikacija.getInstance().getProizvodi().get(j).getProizvod().getSlikaLokacija());
			Image scaled1 = icon1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
			
			JButton proizvod0 = new JButton(Aplikacija.getInstance().getProizvodi().get(j).getProizvod().getNaziv(),new ImageIcon(scaled1));
				
			midPanel.add(proizvod0);
		}
	
};
