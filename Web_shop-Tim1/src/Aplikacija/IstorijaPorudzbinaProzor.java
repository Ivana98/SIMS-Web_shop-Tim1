package Aplikacija;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class IstorijaPorudzbinaProzor extends JFrame{
	protected JTable tabelaPorudzbina;
	protected String[] imenaKolona;
	protected Object[][] podaci;
	protected JScrollPane scrollBar;
	
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
		
	}
	
	public void addComponents() {
		add(scrollBar);
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
