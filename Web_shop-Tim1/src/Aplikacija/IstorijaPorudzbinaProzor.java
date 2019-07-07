package Aplikacija;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import POJO.Registrovan_korisnik;
import POJO.Tip_korisnika;

public class IstorijaPorudzbinaProzor extends JFrame{
	protected JTable tabelaPorudzbina;
	protected String[] imenaKolona;
	protected Object[][] podaci;
	protected JScrollPane scrollBar;
	protected JButton uvidBtn;
	
	/* 
	 * Kako inicijalizovati kolone i podatke
	 	String[] columnNames = {"First Name",
		                        "Last Name",
		                        "Sport",
		                        "# of Years",
		                        "Vegetarian"};
		Object[][] data = {
		    {"Kathy", "Smith",
		     "Snowboarding", new Integer(5), new Boolean(false)},
		    {"John", "Doe",
		     "Rowing", new Integer(3), new Boolean(true)},
		    {"Sue", "Black",
		     "Knitting", new Integer(2), new Boolean(false)},
		    {"Jane", "White",
		     "Speed reading", new Integer(20), new Boolean(true)},
		    {"Joe", "Brown",
		     "Pool", new Integer(10), new Boolean(false)}
		};
	 */

	 IstorijaPorudzbinaProzor() {
		initFrame();
		addComponents();
	}
	
	//poziva se ovaj konstruktor
	IstorijaPorudzbinaProzor(String[] imenaKolona, Object [][] podaci) {
		this.imenaKolona = imenaKolona;
		this.podaci = podaci;
		initFrame();
		addComponents();
		setVisible(true);
		
		uvidBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int brojReda = tabelaPorudzbina.getSelectedRow();
				//pozovi onaj prozor
				StanjaNarudzbenicaProzor stp = new StanjaNarudzbenicaProzor(brojReda, Aplikacija.getInstance().getNarudzbenice().get(0));
				//System.out.println(brojReda);
			}
		});
	}
	
	public void initFrame() {
		//osobine prozora
		setTitle("Istorija porudzbina");
		setSize(700, 500);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new FlowLayout());
		
		tabelaPorudzbina = new JTable(podaci, imenaKolona);
		tabelaPorudzbina.setPreferredScrollableViewportSize(new Dimension(600, 50));
		tabelaPorudzbina.setFillsViewportHeight(true);
		
		scrollBar = new JScrollPane(tabelaPorudzbina);
		Registrovan_korisnik reg = Aplikacija.getInstance().trazenjeKorisnika();
		uvidBtn = new JButton("Uvid u porudzbinu");
		if(reg.getTipKorisnika() == Tip_korisnika.registrovanKorisnik)
			uvidBtn.setVisible(false);
		
	}
	
	public void addComponents() {
		add(scrollBar);
		add(uvidBtn);
	}
	
	public String[] getImenaKolona() {
		return imenaKolona;
	}

	public Object[][] getPodaci() {
		return podaci;
	}

	public void setImenaKolona(String[] imenaKolona) {
		this.imenaKolona = imenaKolona;
	}

	public void setPodaci(Object[][] podaci) {
		this.podaci = podaci;
	}
	
}
