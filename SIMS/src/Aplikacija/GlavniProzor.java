package Aplikacija;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class GlavniProzor extends JFrame {
	protected JPanel headerPanel;
	protected JPanel midPanel;
	protected JPanel footerPanel;
	
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
		JScrollPane scrollPane = new JScrollPane(midPanel);
	
		midPanel.setBackground(Color.GRAY);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		GridLayout glayout = new GridLayout(3,2);
		midPanel.setLayout(glayout);
		
		
		//dodavanje na glavni panel
		BorderLayout layout = new BorderLayout();
		setLayout(layout);
		add(headerPanel, BorderLayout.PAGE_START);
		add(scrollPane,BorderLayout.CENTER);
		add(footerPanel,BorderLayout.PAGE_END);
		
		
		midPanel.remove(instagramBtn);
		setVisible(true);
	}
	
};
