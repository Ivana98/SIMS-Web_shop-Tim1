package Aplikacija;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdminProzor extends GlavniProzor {
	public AdminProzor() throws IOException {
		super();

		JButton logoutBtn = new JButton("Log Out");
		JButton dodajMenBtn = new JButton("Dodaj menadzera");
		JButton obrisiMenBtn = new JButton("Obrisi menadzera");
		JButton izmeniMenBtn = new JButton("Izmeni menadzera");

		headerPanel.add(dodajMenBtn);
		headerPanel.add(obrisiMenBtn);
		headerPanel.add(izmeniMenBtn);
		headerPanel.add(logoutBtn);

		scrollPane.setVisible(false);
		setVisible(true);

		dodajMenBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dodajMenButtonPressed();
			}
		});

		obrisiMenBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				obrisiMenButtonPressed();
			}
		});

		izmeniMenBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				izmeniMenButtonPressed();
			}
		});

	}

	public void izmeniMenButtonPressed() {
		JFrame prozor = new JFrame("IZMENI MENADZERA");
		prozor.setSize(300, 300);
		prozor.setLocationRelativeTo(null);
		prozor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		prozor.setResizable(true);
		prozor.setVisible(true);
		
		JPanel panel = new JPanel();
		
		
		prozor.add(panel);
	}

	public void obrisiMenButtonPressed() {
		JFrame prozor = new JFrame("OBRISI MENADZERA");
		prozor.setSize(300, 300);
		prozor.setLocationRelativeTo(null);
		prozor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		prozor.setResizable(true);
		prozor.setVisible(true);

		JLabel usernameLabela = new JLabel("Username menadzera: ");
		JTextField zaBrisanje = new JTextField(10);
		JButton obrisiBtn = new JButton("Obrisi menadzera");

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(8, 1));

		JPanel usernamePanel = new JPanel();
		usernamePanel.add(usernameLabela);
		usernamePanel.add(zaBrisanje);

		JPanel dugmePanel = new JPanel();
		dugmePanel.add(obrisiBtn);

		panel.add(usernamePanel);
		panel.add(dugmePanel);
		prozor.add(panel);
	}

	public void dodajMenButtonPressed() {
		JFrame prozor = new JFrame("DODAJ MENADZERA");
		prozor.setSize(650, 650);
		prozor.setLocationRelativeTo(null);
		prozor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		prozor.setResizable(true);
		prozor.setVisible(true);

		JLabel imeLabela = new JLabel("Ime menadzera: ");
		JTextField ime = new JTextField(10);
		JLabel przLabela = new JLabel("Prezime menadzera: ");
		JTextField prezime = new JTextField(10);
		JLabel usernameLabela = new JLabel("Username: ");
		JTextField username = new JTextField(10);
		JLabel passLabela = new JLabel("Password: ");
		JTextField password = new JTextField(10);
		JLabel telefonLabela = new JLabel("Telefon: ");
		JTextField telefon = new JTextField(10);
		JLabel emailLabela = new JLabel("E-mail: ");
		JTextField email = new JTextField(10);
		JLabel adresaLabela = new JLabel("Adresa: ");
		JTextField adresa = new JTextField(10);
		
		JButton dodajBtn = new JButton("Dodaj menadzera");
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(15, 1));

		JPanel imePanel = new JPanel();
		imePanel.add(imeLabela);
		imePanel.add(ime);

		JPanel prezimePanel = new JPanel();
		prezimePanel.add(przLabela);
		prezimePanel.add(prezime);

		JPanel usernamePanel = new JPanel();
		usernamePanel.add(usernameLabela);
		usernamePanel.add(username);

		JPanel passPanel = new JPanel();
		passPanel.add(passLabela);
		passPanel.add(password);

		JPanel telefonPanel = new JPanel();
		telefonPanel.add(telefonLabela);
		telefonPanel.add(telefon);
		
		JPanel emailPanel = new JPanel();
		emailPanel.add(emailLabela);
		emailPanel.add(email);

		JPanel adresaPanel = new JPanel();
		adresaPanel.add(adresaLabela);
		adresaPanel.add(adresa);

		
		JPanel dugmePanel = new JPanel();
		dugmePanel.add(dodajBtn);

		panel.add(imePanel);
		panel.add(prezimePanel);
		panel.add(usernamePanel);
		panel.add(passPanel);
		panel.add(telefonPanel);
		panel.add(emailPanel);
		panel.add(adresaPanel);
		panel.add(dugmePanel);

		prozor.add(panel);
	};
}
