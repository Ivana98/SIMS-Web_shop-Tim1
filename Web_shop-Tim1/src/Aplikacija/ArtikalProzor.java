package Aplikacija;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class ArtikalProzor extends JFrame {
	ArtikalProzor() throws IOException {
		super();
		JFrame prozor = new JFrame("OVDE IDE NAZIV PROIZVODA"); // OVDE STAVITE DA SE DODA IME PROZIVODA
		prozor.setSize(900, 600);
		prozor.setLocationRelativeTo(null);
		prozor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		prozor.setResizable(true);
		prozor.setVisible(true);
		
		JButton dodajBtn = new JButton("Dodaj u korpu");
		//Dimension new = new Dimension(100, 100);
		dodajBtn.setSize(250, 250);
		JLabel nazivProizvoda = new JLabel("OVDE IDE NAZIV PROIZVODA");
		JLabel kolicinaLabela = new JLabel("Kolicina:");
		SpinnerModel kolicina =  new SpinnerNumberModel(1, 1, 10, 1);
		JSpinner kolicina1 = new JSpinner(kolicina);
		JLabel opisLabela = new JLabel("OPIS: ");
		
		JTextArea opisProizvoda = new JTextArea("OVDE IDE opis artikla..."
				+ "hjashdjhasjldhashdlhlashdhashdhas;dahsdpasd]"
		);
		
		BufferedImage myPicture = ImageIO.read(new File("src/Aplikacija/pivo.jpg"));
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
		dugmePanel.setLayout(new BorderLayout());
		dugmePanel.add(dodajBtn,BorderLayout.WEST);
		opisPanel.add(dugmePanel);
		
		opisPanel.add(opisLabela);
		opisPanel.add(opisProizvoda);
		
		JPanel slikaPanel = new JPanel();
		slikaPanel.add(picLabel);
		
		
		picLabel.addMouseListener(new MouseAdapter() 
		{
		    @Override
		    public void mouseClicked(MouseEvent e) 
		    {
		    	JFrame prozor = new JFrame("OVDE IDE NAZIV PROIZVODA"); // OVDE STAVITE DA SE DODA IME PROZIVODA
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
					myPicture = ImageIO.read(new File("src/Aplikacija/pivo.jpg"));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				Image newImage = myPicture.getScaledInstance(800, 800, Image.SCALE_DEFAULT);
				JLabel picLabel = new JLabel(new ImageIcon(newImage));
				
				prozor.add(panel);
				
				panel.add(prevBtn, BorderLayout.WEST);
				panel.add(picLabel, BorderLayout.CENTER);
				panel.add(nextBtn,BorderLayout.EAST);
				
				nextBtn.addMouseListener(new MouseAdapter() 
				{
				    @Override
				    public void mouseClicked(MouseEvent e) 
				    {
				    	System.out.println("Sledeca slika");
				    }
				});
				
				prevBtn.addMouseListener(new MouseAdapter() 
				{
				    @Override
				    public void mouseClicked(MouseEvent e) 
				    {
				    	System.out.println("Prethodna slika");
				    }
				});
		    }
		    
		    
		});
		

		

		panel.add(slikaPanel);
		panel.add(opisPanel);
		prozor.add(panel);
	}
}
