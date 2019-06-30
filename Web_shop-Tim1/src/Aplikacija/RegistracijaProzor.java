package Aplikacija;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegistracijaProzor extends JFrame{
	
	RegistracijaProzor(){
		// inicijalizacija osnovnih parametara prozora za registraciju
		setTitle("Registracija korisnika");
		setSize(500, 300);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// inicijalizacija komponenti prozora
		JLabel imeLabel = new JLabel("Ime: ");
	    JLabel prezimeLabel = new JLabel("Prezime: ");
	    JLabel usernameLabel = new JLabel("Korisnicko ime: ");
	    JLabel adresaLabel = new JLabel("Adresa: ");
	    JLabel telefonLabel = new JLabel("Telefon: ");
	    JLabel mailLabel = new JLabel("E-mail adresa: ");
	    JLabel passwordLabel = new JLabel("Unesite lozinku: ");
	    JLabel passwordConfLabel = new JLabel("Potvrdite lozinku: ");
	    
	    //adresa username password telefon mail
	    //porudz-adresa datum id 
	    
	    JTextField imeField = new JTextField(12);
	    JTextField prezimeField = new JTextField(12);
	    JTextField usernameField = new JTextField(12);
	    JTextField adresaField = new JTextField(20);
	    JTextField telefonField = new JTextField(12);
	    JTextField mailField = new JTextField(20);
	    JPasswordField passwordField = new JPasswordField(12);
	    JPasswordField passwordConField = new JPasswordField(12); //polje za  ponavljanje lozinke
	    
	    JButton registracijaBtn = new JButton("Registruj se!");
	    
	    setLayout(new GridBagLayout());
	    
	    GridBagConstraints gc = new GridBagConstraints();
	    
	    //// Prva kolona 
	    
	    gc.anchor = GridBagConstraints.LINE_END;
	    gc.weightx = 0.5;
	    gc.weighty = 0.5;
	    
	    gc.gridx = 0;
	    gc.gridy = 0;
	    add(imeLabel, gc);
	    
	    gc.gridx = 0;
	    gc.gridy = 1;
	    add(prezimeLabel, gc);
	    
	    gc.gridx = 0;
	    gc.gridy = 2;
	    add(usernameLabel, gc);
	    
	    gc.gridx = 0;
	    gc.gridy = 3;
	    add(adresaLabel, gc);
	    
	    gc.gridx = 0;
	    gc.gridy = 4;
	    add(telefonLabel, gc);
	    
	    gc.gridx = 0;
	    gc.gridy = 5;
	    add(mailLabel, gc);
	    
	    gc.gridx = 0;
	    gc.gridy = 6;
	    add(passwordLabel, gc);
	    
	    gc.gridx = 0;
	    gc.gridy = 7;
	    add(passwordConfLabel, gc);
	    
	    //// Druga kolona
	    gc.anchor = GridBagConstraints.LINE_START;
	    
	    gc.gridx = 1;
	    gc.gridy = 0;
	    add(imeField, gc);
	    
	    gc.gridx = 1;
	    gc.gridy = 1;
	    add(prezimeField, gc);
	    
	    gc.gridx = 1;
	    gc.gridy = 2;
	    add(usernameField, gc);
	    
	    gc.gridx = 1;
	    gc.gridy = 3;
	    add(adresaField, gc);
	    
	    gc.gridx = 1;
	    gc.gridy = 4;
	    add(telefonField, gc);
	    
	    gc.gridx = 1;
	    gc.gridy = 5;
	    add(mailField, gc);
	    
	    gc.gridx = 1;
	    gc.gridy = 6;
	    add(passwordField, gc);
	    
	    gc.gridx = 1;
	    gc.gridy = 7;
	    add(passwordConField, gc);
	    
	    // Poslednji red
	    gc.weighty = 10;
	    
	    gc.anchor = GridBagConstraints.FIRST_LINE_START;
	    gc.gridx = 1;
	    gc.gridy = 8;
	    add(registracijaBtn, gc);
	    
	    // dijalog obavestava korisnika da je registracija uspesna
	    registracijaBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// pasvord je nepromenljiv pa moramo prvo da ga pokupimo ovako
				String password = String.valueOf(passwordField.getPassword());
				String passwordCon = String.valueOf(passwordConField.getPassword());
				
				// da li postoji prazno polje
				if(imeField.getText().isEmpty() || prezimeField.getText().isEmpty() || usernameField.getText().isEmpty() ||
						adresaField.getText().isEmpty() || telefonField.getText().isEmpty() || mailField.getText().isEmpty() ||
						password.isEmpty() || passwordCon.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Niste popunili sva polja!", "Greska", JOptionPane.ERROR_MESSAGE);
				}
				else if(!password.equals(passwordCon)) {
					JOptionPane.showMessageDialog(null, "Pogresna lozinka!", "Greska", JOptionPane.ERROR_MESSAGE);
					passwordField.setText("");
					passwordConField.setText("");
				}
				else {
					//setVisible(false);
					//videti kako da zatvorim prozor
					JOptionPane.showMessageDialog(null, "Uspesno ste se registrovali.", "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
				}
			}
	    	
	    });
		
		setVisible(true);
		}
	
}
