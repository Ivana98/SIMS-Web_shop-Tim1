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
import POJO.Registrovan_korisnik;

public class StanjaNarudzbenicaProzor extends JFrame {
	protected JPanel glavniPanel;
	protected JPanel desniPanel;
	protected JPanel leviPanel;
	protected JLabel imeLabela;
	protected JLabel prezimeLabela;
	protected JLabel adresaLabela;
	protected JLabel datumLabela;
	protected JLabel idLabela;
	protected JButton proizvodiBtn;
	protected JLabel pitanjeLabela;
	protected JButton prvoBtn;
	protected JButton drugoBtn;

	StanjaNarudzbenicaProzor() {
	};

	StanjaNarudzbenicaProzor(int i) {
		JFrame prozor = new JFrame("STANJA NARUDZBENICA");
		prozor.setSize(650, 650);
		prozor.setLocationRelativeTo(null);
		prozor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		prozor.setResizable(true);
		prozor.setVisible(true);

		glavniPanel = new JPanel();
		leviPanel = new JPanel();
		desniPanel = new JPanel();

		leviPanel.setLayout(new GridLayout(10, 1));
		leviPanel.setBackground(Color.decode("#BDD8EE"));
		glavniPanel.setLayout(new GridLayout(1, 2));

		// idLabela = new JLabel("ID: " + aplikaca.getinstance().getNarudzbenice().get(i).getID());
		// OVAKO NEKAKO TREBA DA IZLGEDA LABELA
		idLabela = new JLabel("ID: ");
		imeLabela = new JLabel("IME: ");
		prezimeLabela = new JLabel("PREZIME: ");
		adresaLabela = new JLabel("ADRESA: ");
		datumLabela = new JLabel("DATUM: ");
		proizvodiBtn = new JButton("PROIZVODI");

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
		dodajUDesniPanel(2, "DA", "NE",
				"<html> nestonestonestonestonestonestonesto<br> drugo <br>nesto <br>drugo<br>nesto<br>drugo<br>nesto<br>drugo<br> </html>");
		
		proizvodiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proizvodiBtnPressed();
			}
		});

	}
	public void proizvodiBtnPressed() {
		JOptionPane.showMessageDialog(null, "Ovde treba da bude tabela narucenih proizvoda iz narudzbenice!", "Stanje narudzbenice", 			JOptionPane.INFORMATION_MESSAGE);
	}

	public void dodajUDesniPanel(int i, String prvoStr, String drugoStr, String pitanje) {// DODATI I STANJE
		pitanjeLabela = new JLabel(pitanje);
		pitanjeLabela.setBorder(new CompoundBorder(pitanjeLabela.getBorder(), new EmptyBorder(20, 20, 10, 10)));
		JPanel dugmici = new JPanel();
		desniPanel.setLayout(new GridLayout(3, 1));

		if (i == 2) {
			prvoBtn = new JButton(prvoStr);
			drugoBtn = new JButton(drugoStr);
			dugmici.add(prvoBtn);
			dugmici.add(drugoBtn);

		} else {
			prvoBtn = new JButton(prvoStr);
			dugmici.add(prvoBtn);
		}
		desniPanel.add(pitanjeLabela);
		desniPanel.add(dugmici);

	
		prvoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prvoBtnPressed();
			}
		});

		drugoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drugoBtnPressed();
			}
		});
	}

	public void prvoBtnPressed() {// POZVATI FUNKCIJU SA TRUE
		// TREBA DODATI IF DA SE OVO POZIVA SAMO AKO JE STANJE NARUDZBENICE MALVERZACIJA
		// (TJ 1. STANJE)S
		
		// OVO POZOVI PRE ISCRTAVANJA  
		desniPanel.removeAll();
		desniPanel.repaint();
		desniPanel.revalidate();
		 
		// TREBA DODATI IF ZA ONA 2 POSLEDNJA STANJA
		// JOptionPane.showMessageDialog(null, "Narudzbenica je u redu!", "Stanje narudzbenice", JOptionPane.INFORMATION_MESSAGE);
		// JOptionPane.showMessageDialog(null, "Narudzbenica otkazana!", "Stanje narudzbenice", JOptionPane.ERROR_MESSAGE);

	}

	public void drugoBtnPressed() {// POZVATI FUNKCIJU SA FALSE
		// TREBA DODATI IF DA SE OVO POZIVA SAMO AKO JE STANJE NARUDZBENICE MALVERZACIJA
				// (TJ 1. STANJE)
		desniPanel.removeAll();
		desniPanel.repaint();
		desniPanel.revalidate();
	}
}
