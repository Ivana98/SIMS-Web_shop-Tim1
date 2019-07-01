package Aplikacija;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class NarudzbenicaProzor extends JFrame{

	NarudzbenicaProzor(){
		setTitle("Narudzbenica");
		setSize(400, 200);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// inicijalizacija komponenti prozora
		JLabel imeLabel = new JLabel("Ime: ");
	    JLabel prezimeLabel = new JLabel("Prezime: ");
	    JLabel adresaLabel = new JLabel("Adresa: ");
	    JLabel telefonLabel = new JLabel("Telefon: ");
	    
	    JTextField imeField = new JTextField(12);
	    JTextField prezimeField = new JTextField(12);
	    JTextField adresaField = new JTextField(20);
	    JTextField telefonField = new JTextField(12);
	    
	    //opcionalono
	    String [] placanjeString = {"Pouzecem", "PayPal"};
	    JComboBox placanjeOpcije = new JComboBox(placanjeString);
	    
	    JButton poruciBtn = new JButton("Potvrdite Vasu porudzbinu");
	    
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
	    add(adresaLabel, gc);
	    
	    gc.gridx = 0;
	    gc.gridy = 3;
	    add(telefonLabel, gc);
	    
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
	    add(adresaField, gc);
	    
	    gc.gridx = 1;
	    gc.gridy = 3;
	    add(telefonField, gc);
	    
	    gc.gridx = 1;
	    gc.gridy = 4;
	    add(placanjeOpcije, gc);
	    
	    // Poslednji red
	    gc.weighty = 10;
	    
	    gc.anchor = GridBagConstraints.FIRST_LINE_START;
	    gc.gridx = 1;
	    gc.gridy = 5;
	    add(poruciBtn, gc);
	    
	    poruciBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(imeField.getText().isEmpty() || prezimeField.getText().isEmpty() ||
						adresaField.getText().isEmpty() || telefonField.getText().isEmpty() ) {
					JOptionPane.showMessageDialog(null, "Niste popunili sva polja!", "Greska", JOptionPane.ERROR_MESSAGE);
				}
				else {
				//setVisible(false);
				//videti kako da zatvorim prozor
				JOptionPane.showMessageDialog(null, "Vasa porudzbina je primljena i potrudicemo se da je dostavimo u"
						+ "najkracem mogucem roku.\nHvala sto kupujete kod nas!", "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
				}
			}
	    });
	     
	    setVisible(true);   
	}
	
}
