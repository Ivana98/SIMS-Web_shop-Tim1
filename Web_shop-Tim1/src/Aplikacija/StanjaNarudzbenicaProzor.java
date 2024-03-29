package Aplikacija;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.text.LabelView;

import POJO.Korisnik;
import POJO.Narudzbenica;
import POJO.Registrovan_korisnik;

public class StanjaNarudzbenicaProzor extends JFrame {
	protected JPanel glavniPanel;
	protected DesniPanel desniPanel;
	protected JPanel leviPanel;
	protected JLabel imeLabela;
	protected JLabel prezimeLabela;
	protected JLabel adresaLabela;
	protected JLabel datumLabela;
	protected JLabel idLabela;
	protected JButton proizvodiBtn;
	protected Narudzbenica narudzbenica;


	StanjaNarudzbenicaProzor() {
	};

	StanjaNarudzbenicaProzor(int i, Narudzbenica nar) {
		JFrame prozor = new JFrame("STANJA NARUDZBENICA");
		prozor.setSize(650, 650);
		prozor.setLocationRelativeTo(null);
		prozor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		prozor.setResizable(true);
		prozor.setVisible(true);
		narudzbenica = nar;
		

		glavniPanel = new JPanel();
		leviPanel = new JPanel();
		desniPanel = new DesniPanel(2, "DA", "NE",
				"<html> Da li je narudzbenica u redu?</html>", narudzbenica);
		narudzbenica.addListener(desniPanel);
		leviPanel.setLayout(new GridLayout(10, 1));
		leviPanel.setBackground(Color.decode("#BDD8EE"));
		glavniPanel.setLayout(new GridLayout(1, 2));

		// idLabela = new JLabel("ID: " + aplikaca.getinstance().getNarudzbenice().get(i).getID());
		// OVAKO NEKAKO TREBA DA IZLGEDA LABELA
		idLabela = new JLabel("ID: "+ Aplikacija.getInstance().getNarudzbenice().get(0).getId());
		imeLabela = new JLabel("IME: " + Aplikacija.getInstance().getNarudzbenice().get(0).getIme());
		prezimeLabela = new JLabel("PREZIME: " + Aplikacija.getInstance().getNarudzbenice().get(0).getPrezime());
		adresaLabela = new JLabel("ADRESA: " + Aplikacija.getInstance().getNarudzbenice().get(0).getAdresa());
		datumLabela = new JLabel("DATUM: " + Aplikacija.getInstance().getNarudzbenice().get(0).getDatum());
		proizvodiBtn = new JButton("PROIZVODI");
		
		idLabela.setBorder(new CompoundBorder(idLabela.getBorder(), new EmptyBorder(20, 20, 10, 10)));
		imeLabela.setBorder(new CompoundBorder(imeLabela.getBorder(), new EmptyBorder(20, 20, 10, 10)));
		prezimeLabela.setBorder(new CompoundBorder(prezimeLabela.getBorder(), new EmptyBorder(20, 20, 10, 10)));
		adresaLabela.setBorder(new CompoundBorder(adresaLabela.getBorder(), new EmptyBorder(20, 20, 10, 10)));
		datumLabela.setBorder(new CompoundBorder(datumLabela.getBorder(), new EmptyBorder(20, 20, 10, 10)));
		
		JPanel dugmePanel = new JPanel();
		dugmePanel.setBackground(Color.decode("#BDD8EE"));
		dugmePanel.add(proizvodiBtn);

		leviPanel.add(idLabela);
		leviPanel.add(imeLabela);
		leviPanel.add(prezimeLabela);
		leviPanel.add(adresaLabela);
		leviPanel.add(datumLabela);
		leviPanel.add(dugmePanel);

		glavniPanel.add(leviPanel);
		glavniPanel.add(desniPanel);

		prozor.add(glavniPanel);
		
		
		proizvodiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proizvodiBtnPressed();
			}
		});

	}
	public void proizvodiBtnPressed() {
		JOptionPane.showMessageDialog(null, "Ovde treba da bude tabela narucenih proizvoda iz narudzbenice!", "Stanje narudzbenice", 			JOptionPane.INFORMATION_MESSAGE);
	}


	
}
