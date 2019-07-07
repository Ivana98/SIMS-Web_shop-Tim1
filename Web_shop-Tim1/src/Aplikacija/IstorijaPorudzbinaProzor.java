package Aplikacija;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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
		uvidBtn = new JButton("Uvid u porudzbinu");
		
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
