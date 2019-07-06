package Aplikacija;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import POJO.Kolicina;
import POJO.Korisnik;
import POJO.Proizvod;
import POJO.Registrovan_korisnik;
import POJO.Tip_korisnika;

public class ArtikalProzor extends JFrame {
	
	private int i;
	
	ArtikalProzor(Proizvod proizvod, float broj2) throws IOException {
		super();
		float cena = broj2;
		//koji je korisnik
		Registrovan_korisnik korisnik = new Registrovan_korisnik();
		
		int koji = -1;
		for(int i = 0;i<Aplikacija.getInstance().getKorisnik().size();i++)
		{
			koji++;
			if(Aplikacija.getInstance().getKorisnik().get(i).getUsername().equals(Aplikacija.getInstance().getUsername()))
			{
				korisnik = Aplikacija.getInstance().getKorisnik().get(i);
				break;
			}
		}
		final int kojiJeKorisnik = koji;
		
		JFrame prozor = new JFrame(proizvod.getNaziv()); // OVDE STAVITE DA SE DODA IME PROZIVODA
		prozor.setSize(900, 600);
		prozor.setLocationRelativeTo(null);
		prozor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		prozor.setResizable(true);
		prozor.setVisible(true);
		
		JButton dodajBtn = new JButton("Dodaj u korpu");
		
		JButton natrag = new JButton("Natrag");
		//Dimension new = new Dimension(100, 100);
		dodajBtn.setSize(250, 250);
		natrag.setSize(250, 250);
		
		//dodavanje naziva i cene proizvoda
		JLabel nazivProizvoda = new JLabel(proizvod.getNaziv()+"          "+Float.toString(cena)+"din",JLabel.CENTER);
		JLabel kolicinaLabela = new JLabel("Kolicina:");
		
		//stavljanje kolicine proizvoda ukupno iz svih prodavnica
		int kolicinaProizvoda = Aplikacija.getInstance().getProizvodi().get(proizvod);
		
		SpinnerModel kolicina =  new SpinnerNumberModel(1, 1, kolicinaProizvoda, 1);
		JSpinner kolicina1 = new JSpinner(kolicina);
		JLabel opisLabela = new JLabel("OPIS: ");
		
		/*JTextArea opisProizvoda = new JTextArea("OVDE IDE opis artikla..."
				+ "hjashdjhasjldhashdlhlashdhashdhas;dahsdpasd]"
		);*/
		
		BufferedImage myPicture = ImageIO.read(new File(proizvod.getSlikaLokacija().split("\\|")[0]));
		Image newImage = myPicture.getScaledInstance(400, 500, Image.SCALE_DEFAULT);
		JLabel picLabel = new JLabel(new ImageIcon(newImage));
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));

		JPanel opisPanel = new JPanel();
		opisPanel.setLayout(new GridLayout(15, 1));
		opisPanel.add(nazivProizvoda);
		
		JPanel spinnerPanel = new JPanel();
		spinnerPanel.setLayout(new BorderLayout());
		spinnerPanel.add(kolicinaLabela, BorderLayout.WEST);
		spinnerPanel.add(kolicina1,BorderLayout.WEST, -1);
		
		opisPanel.add(spinnerPanel);
		JPanel dugmePanel = new JPanel();
		dugmePanel.setLayout(new FlowLayout());
		dugmePanel.add(dodajBtn);
		dugmePanel.add(Box.createHorizontalStrut(30));
		
		//wishlista opcije
		if(!Aplikacija.getInstance().getUsername().equals(""))
			if(korisnik.getTipKorisnika()==Tip_korisnika.registrovanKorisnik)
			{
				if(korisnik.getWishlista().contains(proizvod))
				{
					JLabel vecUWishlisti = new JLabel("Proizvod je u vishlisti.", SwingConstants.CENTER);
					dugmePanel.add(vecUWishlisti);
					dugmePanel.add(Box.createHorizontalStrut(30));
				}
				else
				{
					JButton wishListBtn = new JButton("Dodaj u vishlistu");
					wishListBtn.setSize(250,250);
					dugmePanel.add(wishListBtn);
					dugmePanel.add(Box.createHorizontalStrut(30));
					
					wishListBtn.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							Aplikacija.getInstance().getKorisnik().get(kojiJeKorisnik).getWishlista().add(proizvod);
							wishListBtn.setVisible(false);
							dugmePanel.remove(1);
							
							JLabel vecUWishlisti = new JLabel("Proizvod je stavljen u vislistu!");
							natrag.setVisible(false);
							dugmePanel.remove(1);
							dugmePanel.add(vecUWishlisti);
							dugmePanel.add(Box.createHorizontalStrut(30));
							dugmePanel.add(natrag);
							natrag.setVisible(true);
							
							repaint();
					    	revalidate();
						}
					});
					
				}
			}
		
		//nazad 
		dugmePanel.add(natrag);
		opisPanel.add(dugmePanel);
		
		opisPanel.add(opisLabela);
		
		//dodavanje opisa proizvoda
		
		String [] opisi = proizvod.getOpis().split("\\|");
		for(String opis : opisi)
		{
			JLabel labela = new JLabel();
			labela.setText(opis);
			opisPanel.add(labela);
		}
		
		//opisPanel.add(opisProizvoda);
		
		JPanel slikaPanel = new JPanel();
		slikaPanel.add(picLabel);
		
		natrag.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				prozor.setVisible(false);
				prozor.dispose();
			}
			
	    });
		
		picLabel.addMouseListener(new MouseAdapter() 
		{
		    @Override
		    public void mouseClicked(MouseEvent e) 
		    {
		    	JFrame prozor = new JFrame(proizvod.getNaziv()); // OVDE STAVITE DA SE DODA IME PROZIVODA
				prozor.setSize(1200, 800);
				prozor.setLocationRelativeTo(null);
				prozor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				prozor.setResizable(true);
				prozor.setVisible(true);
				
				JButton prevBtn = new JButton("<");
				JButton nextBtn = new JButton(">");
				
				JPanel panel = new JPanel();
				panel.setLayout(new BorderLayout());
				BufferedImage myPicture = null;
				try {
					myPicture = ImageIO.read(new File(proizvod.getSlikaLokacija().split("\\|")[0]));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				Image newImage = myPicture.getScaledInstance(800, 800, Image.SCALE_DEFAULT);
				JLabel picLabel = new JLabel(new ImageIcon(newImage));
				
				prozor.add(panel);
				
				panel.add(prevBtn, BorderLayout.WEST);
				panel.add(nextBtn,BorderLayout.EAST);
				panel.add(picLabel, BorderLayout.CENTER);
				
				picLabel.addMouseListener(new MouseAdapter() 
				{
				    @Override
				    public void mouseClicked(MouseEvent e) 
				    {
				    	prozor.setVisible(false);
				    	prozor.dispose();
				    }
				});
				
				String[] slike = proizvod.getSlikaLokacija().split("\\|");
				int velicina = slike.length;
				i=0;
				
				//kada ima vise slika
				
				nextBtn.addMouseListener(new MouseAdapter() 
				{
				    @Override
				    public void mouseClicked(MouseEvent e) 
				    {
				    	//System.out.println("Sledeca slika");
				    	if((i+1)<velicina)
				    	{
				    		i++;
				    		BufferedImage myPicture = null;
							try {
								myPicture = ImageIO.read(new File(proizvod.getSlikaLokacija().split("\\|")[i]));
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							Image newImage = myPicture.getScaledInstance(800, 800, Image.SCALE_DEFAULT);
							JLabel picLabel = new JLabel(new ImageIcon(newImage));
							panel.remove(2);
							panel.add(picLabel, BorderLayout.CENTER);
							
							prozor.repaint();
					    	prozor.revalidate();
					    	
					    	picLabel.addMouseListener(new MouseAdapter() 
							{
							    @Override
							    public void mouseClicked(MouseEvent e) 
							    {
							    	prozor.setVisible(false);
							    	prozor.dispose();
							    }
							});
					    	
				    	}
				    	
				    }
				});
				
				prevBtn.addMouseListener(new MouseAdapter() 
				{
				    @Override
				    public void mouseClicked(MouseEvent e) 
				    {
				    	//System.out.println("Prethodna slika");
				    	if((i-1)>-1)
				    	{
				    		i--;
				    		BufferedImage myPicture = null;
							try {
								myPicture = ImageIO.read(new File(proizvod.getSlikaLokacija().split("\\|")[i]));
								
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							Image newImage = myPicture.getScaledInstance(800, 800, Image.SCALE_DEFAULT);
							JLabel picLabel = new JLabel(new ImageIcon(newImage));
							panel.remove(2);
							panel.add(picLabel, BorderLayout.CENTER);
							
							prozor.repaint();
					    	prozor.revalidate();
					    	
					    	picLabel.addMouseListener(new MouseAdapter() 
							{
							    @Override
							    public void mouseClicked(MouseEvent e) 
							    {
							    	prozor.setVisible(false);
							    	prozor.dispose();
							    }
							});
					    	
				    	}
				    	
				    }
				});
		    }
		    
		    
		});

		panel.add(slikaPanel);
		panel.add(opisPanel);
		prozor.add(panel);
	}
}
