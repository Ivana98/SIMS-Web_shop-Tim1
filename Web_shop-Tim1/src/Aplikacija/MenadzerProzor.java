package Aplikacija;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.temporal.JulianFields;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class MenadzerProzor extends GlavniProzor {
	MenadzerProzor() throws IOException {
		super();

		// Dodavanjee komponenti u headeePanel
		// JLabel cenovnikLabela = new JLabel("Trenutni cenovnik:");
		// String[] petStrings = { "Bozicni", "Novogodisnji", "Obicni" };
		// JComboBox<String> trenutniCenovnik = new JComboBox<>(petStrings);

		JButton logoutBtn = new JButton("Log Out");
		JButton izvestaji = new JButton("Izvestaji i statistika");
		JButton cenovnik = new JButton("Cenovnik");
		JButton kuponi = new JButton("Kuponi");
		JButton dodajArtikal = new JButton("Dodaj artikal");
		JButton porudzbineBtn = new JButton("Porudzbine");

		headerPanel.setLayout(new FlowLayout());
		headerPanel.add(dodajArtikal);

		headerPanel.add(cenovnik);
		headerPanel.add(kuponi);
		headerPanel.add(izvestaji);
		headerPanel.add(porudzbineBtn);
		headerPanel.add(logoutBtn);
	
		setVisible(true);
		izvestaji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				izvestajiButtonPressed();
			}
		});

		cenovnik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cenovnikButtonPressed();
			}
		});

		kuponi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kuponiButtonPressed();
			}
		});
		dodajArtikal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dodajArtikalButtonPressed();
			}
		});
		
		porudzbineBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				porudzbineButtonPressed();
			}
		});

	}

	public void dodajArtikalButtonPressed() {
		JFrame prozor = new JFrame("DODAJ ARTIKAL");
		prozor.setSize(400, 400);
		prozor.setLocationRelativeTo(null);
		prozor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		prozor.setResizable(true);
		prozor.setVisible(true);

		JLabel opisArtLab = new JLabel("Opis artikla:");
		JLabel nazArtLab = new JLabel("Naziv artikla:");
		JTextField opisArt = new JTextField(10);
		JTextField nazArt = new JTextField(10);
		JButton dodajBtn = new JButton("Dodaj artikal");

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(10, 1));

		JPanel opisPanel = new JPanel();
		opisPanel.add(opisArtLab);
		opisPanel.add(opisArt);

		JPanel nazivPanel = new JPanel();
		nazivPanel.add(nazArtLab);
		nazivPanel.add(nazArt);

		JPanel dugmePanel = new JPanel();
		dugmePanel.add(dodajBtn);

		panel.add(nazivPanel);
		panel.add(opisPanel);
		panel.add(dugmePanel);

		prozor.add(panel);
	};

	public void kuponiButtonPressed() {
		JFrame prozor = new JFrame("KUPONI");
		prozor.setSize(400, 400);
		prozor.setLocationRelativeTo(null);
		prozor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		prozor.setResizable(true);
		prozor.setVisible(true);

		JButton dodajKupon = new JButton("Dodaj kupon");
		JButton obrisiKupon = new JButton("Obrisi kupon");

		JPanel headerPanel = new JPanel();
		headerPanel.add(obrisiKupon);
		headerPanel.add(dodajKupon);

		prozor.add(headerPanel);
		dodajKupon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dodajKuponButtonPressed();
			}
		});

		obrisiKupon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				obrisiKuponButtonPressed();
			}
		});
	}

	public void obrisiKuponButtonPressed() {
		JFrame prozor = new JFrame("OBRISI KUPON");
		prozor.setSize(300, 300);
		prozor.setLocationRelativeTo(null);
		prozor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		prozor.setResizable(true);
		prozor.setVisible(true);

		JLabel nazKupona = new JLabel("Naziv kupona: ");
		JTextField zaBrisanje = new JTextField(10);
		JButton obrisi = new JButton("Obrisi kupon");

		JPanel panel = new JPanel();
		panel.add(nazKupona);
		panel.add(zaBrisanje);
		panel.add(obrisi);
		prozor.add(panel);
	};

	public void dodajKuponButtonPressed() {
		JFrame prozor = new JFrame("DODAJ KUPON");
		prozor.setSize(300, 300);
		prozor.setLocationRelativeTo(null);
		prozor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		prozor.setResizable(true);
		prozor.setVisible(true);

		// KOMPONENTE
		JLabel nazKupLab = new JLabel("Naziv kupona:");
		JTextField nazKupona = new JTextField(10);
		JLabel procenatLabela = new JLabel("Procenat popusta:");
		JTextField procenatKupona = new JTextField(10);
		JButton dodaj = new JButton("Dodaj kupon");

		JPanel headerPanel = new JPanel();
		headerPanel.setLayout(new GridLayout(5, 1));

		JPanel nazivPanel = new JPanel();
		nazivPanel.add(nazKupLab);
		nazivPanel.add(nazKupona);

		JPanel procenatPanel = new JPanel();
		procenatPanel.add(procenatLabela);
		procenatPanel.add(procenatKupona);

		headerPanel.add(nazivPanel);
		headerPanel.add(procenatPanel);

		JPanel dugmePanel = new JPanel();
		dugmePanel.add(dodaj);
		headerPanel.add(dugmePanel);

		prozor.add(headerPanel);
	}

	public void izvestajiButtonPressed() {
		JFrame prozor = new JFrame("IZVESTAJI I STATISTIKA");
		prozor.setSize(300, 300);
		prozor.setLocationRelativeTo(null);
		prozor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		prozor.setResizable(true);
		prozor.setVisible(true);

		// Komponente prozora
		JButton izv1 = new JButton("izvestaj1");
		JButton izv2 = new JButton("izvestaj2");
		JButton izv3 = new JButton("izvestaj3");
		JButton sta1 = new JButton("Statistika prodaje");

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(7, 1));

		JPanel panel1 = new JPanel();
		panel1.add(izv1);

		JPanel panel2 = new JPanel();
		panel2.add(izv2);

		JPanel panel3 = new JPanel();
		panel3.add(izv3);

		JPanel panel4 = new JPanel();
		panel4.add(sta1);

		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		prozor.add(panel);
	}

	public void cenovnikButtonPressed() {
		JFrame prozor = new JFrame("CENOVNIK");
		prozor.setSize(300, 300);
		prozor.setLocationRelativeTo(null);
		prozor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		prozor.setResizable(true);
		prozor.setVisible(true);

		// Komponente prozora
		JLabel cenovnikLabela = new JLabel("Trenutni cenovnik:");
		String[] petStrings = { "Bozicni", "Novogodisnji", "Obicni" };
		JComboBox<String> trenutniCenovnik = new JComboBox<>(petStrings);
		JButton dodajCenovnik = new JButton("Dodaj cenovnik");
		JButton obrisiCenovnik = new JButton("Obrisi cenovnik");

		JPanel headerPanel = new JPanel();
		headerPanel.add(dodajCenovnik);
		headerPanel.add(obrisiCenovnik);
		headerPanel.add(cenovnikLabela);
		headerPanel.add(trenutniCenovnik);
		prozor.add(headerPanel);

		// Akcije na klik tastera
		dodajCenovnik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dodajCenovnikButtonPressed();
			}
		});
		obrisiCenovnik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				obrisiCenovnikButtonPressed();
			}
		});
	}

	public void obrisiCenovnikButtonPressed() {
		JFrame prozor = new JFrame("OBRISI CENOVNIK");
		prozor.setSize(400, 200);
		prozor.setLocationRelativeTo(prozor);
		prozor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		prozor.setResizable(true);
		prozor.setVisible(true);

		// Komponente prozora
		JLabel idCen = new JLabel("ID cenovnika: ");
		JTextField zaBrisanje = new JTextField(10);
		JButton obrisi = new JButton("Obrisi cenovnik");

		JPanel panel = new JPanel();
		headerPanel.setLayout(new GridLayout(9, 1));
		
		JPanel idPanel = new JPanel();
		idPanel.add(idCen);
		idPanel.add(zaBrisanje);
		
		JPanel dugmePanel = new JPanel();
		dugmePanel.add(obrisi);

		panel.add(idPanel);
		panel.add(dugmePanel);
		
		prozor.add(panel);

	}

	public void dodajCenovnikButtonPressed() {
		JFrame prozor = new JFrame("DODAJ CENOVNIK");
		prozor.setSize(300, 300);
		prozor.setLocationRelativeTo(prozor);
		prozor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		prozor.setResizable(true);
		prozor.setVisible(true);

		// Komponente
		JLabel NazivLabela = new JLabel("Naziv cenovika:");
		JTextField naziv = new JTextField(10);
		JLabel datumPocetkaLabela = new JLabel("Datum pocetka vazenja:");
		JTextField datumPocetka = new JTextField(10);
		JLabel datumKrajaLabela = new JLabel("Datum kraja vazenja:");
		JTextField datumKraja = new JTextField(10);
		JButton dodajBtn = new JButton("Dodaj cenovnik");

		JPanel headerPanel = new JPanel();
		headerPanel.setLayout(new GridLayout(9, 1));

		// Panel za svaku celiju layout-a
		JPanel nazivCell = new JPanel();
		JPanel datumPocetkaCell = new JPanel();
		JPanel datumKrajaCell = new JPanel();

		nazivCell.add(NazivLabela);
		nazivCell.add(naziv);

		datumPocetkaCell.add(datumPocetkaLabela);
		datumPocetkaCell.add(datumPocetka);

		datumKrajaCell.add(datumKrajaLabela);
		datumKrajaCell.add(datumKraja);

		JPanel dugmePanel = new JPanel();
		dugmePanel.add(dodajBtn);

		headerPanel.add(datumPocetkaCell);
		headerPanel.add(nazivCell);
		headerPanel.add(datumKrajaCell);

		headerPanel.add(dugmePanel);
		// headerPanel.setAlignmentY(LEFT_ALIGNMENT);

		prozor.add(headerPanel);
	}
	
	public void porudzbineButtonPressed() {
		String[] imenaKolona = {"Id porudzbine", "Ime", "Prezime", "Adresa", "Datum"};
		// Videti u istorijaNarudzbenicaProzor kako se popunjava ovo i izvuci podatke
		Object [][] podaci = {{"7", "Pera", "Peric", "Adresa", "datum"}, {"2", "Marko", "Markovic", 
			"Adresa", "Datum"}};
		IstorijaPorudzbinaProzor istorijaP = new IstorijaPorudzbinaProzor(imenaKolona, podaci);
	}

}
