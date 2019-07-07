package Aplikacija;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import POJO.Kreiranje;
import POJO.Narudzbenica;
import POJO.Obradjivanje;
import POJO.Otkazivanje;
import POJO.Porucivanje;
import POJO.Slanje;
import POJO.UpdateEvent;
import POJO.UpdateListener;
import POJO.Urucivanje;

//dodajUDesniPanel(2, "DA", "NE",
//		"<html> nestonestonestonestonestonestonesto<br> drugo <br>nesto <br>drugo<br>nesto<br>drugo<br>nesto<br>drugo<br> </html>");

public class DesniPanel extends JPanel implements UpdateListener {
	protected JLabel pitanjeLabela;
	protected JButton prvoBtn;
	protected JButton drugoBtn;
	protected Narudzbenica narudzbenica;

	public DesniPanel(int i, String prvoStr, String drugoStr, String pitanje, Narudzbenica nar) {
		narudzbenica = nar;
		System.out.println(narudzbenica.getTekuceStanje());
		pitanjeLabela = new JLabel(pitanje);
		pitanjeLabela.setBorder(new CompoundBorder(pitanjeLabela.getBorder(), new EmptyBorder(20, 20, 10, 10)));
		JPanel dugmici = new JPanel();
		this.setLayout(new GridLayout(3, 1));

		if (i == 2) {
			prvoBtn = new JButton(prvoStr);
			drugoBtn = new JButton(drugoStr);
			dugmici.add(prvoBtn);
			dugmici.add(drugoBtn);

		} else {
			prvoBtn = new JButton(prvoStr);
			dugmici.add(prvoBtn);
		}
		this.add(pitanjeLabela);
		this.add(dugmici);

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

	public void dodajUPanel(int i, String prvoStr, String drugoStr, String pitanje, Narudzbenica nar) {
		this.removeAll();
		this.repaint();
		this.revalidate();
		narudzbenica = nar;
		System.out.println(narudzbenica.getTekuceStanje());
		pitanjeLabela = new JLabel(pitanje);
		pitanjeLabela.setBorder(new CompoundBorder(pitanjeLabela.getBorder(), new EmptyBorder(20, 20, 10, 10)));
		JPanel dugmici = new JPanel();
		this.setLayout(new GridLayout(3, 1));

		if (i == 2) {
			prvoBtn = new JButton(prvoStr);
			drugoBtn = new JButton(drugoStr);
			dugmici.add(prvoBtn);
			dugmici.add(drugoBtn);

		} else {
			prvoBtn = new JButton(prvoStr);
			dugmici.add(prvoBtn);
		}
		this.add(pitanjeLabela);
		this.add(dugmici);

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
		if (narudzbenica.getTekuceStanje() instanceof Porucivanje) {
			narudzbenica.zavrsenaKupovina();
		} else if (narudzbenica.getTekuceStanje() instanceof Obradjivanje) {
			narudzbenica.proveraLagera();
		} else if (narudzbenica.getTekuceStanje() instanceof Slanje) {
			narudzbenica.posaljiPorudzbinu();
		} else if (narudzbenica.getTekuceStanje() instanceof Urucivanje ) {
			JOptionPane.showMessageDialog(null, "Narudzbenica je u redu!", "Stanje narudzbenice",
					JOptionPane.INFORMATION_MESSAGE);
			this.removeAll();
			this.repaint();
			this.revalidate();
			
			
		} else if (narudzbenica.getTekuceStanje() instanceof Otkazivanje) {
			JOptionPane.showMessageDialog(null, "Narudzbenica otkazana!", "Stanje narudzbenice",
					JOptionPane.ERROR_MESSAGE);
		}

		// OVO POZOVI PRE ISCRTAVANJA

		// TREBA DODATI IF ZA ONA 2 POSLEDNJA STANJA

	}

	public void drugoBtnPressed() {// POZVATI FUNKCIJU SA FALSE
		// TREBA DODATI IF DA SE OVO POZIVA SAMO AKO JE STANJE NARUDZBENICE MALVERZACIJA
		// (TJ 1. STANJE)
		if (narudzbenica.getTekuceStanje() instanceof Porucivanje) {
			JOptionPane.showMessageDialog(null, "Narudzbenica otkazana!", "Stanje narudzbenice",
					JOptionPane.ERROR_MESSAGE);
			narudzbenica.setTekuceStanje(new Otkazivanje(narudzbenica));
		} else if (narudzbenica.getTekuceStanje() instanceof Obradjivanje) {
			JOptionPane.showMessageDialog(null, "Narudzbenica otkazana!", "Stanje narudzbenice",
					JOptionPane.ERROR_MESSAGE);
			narudzbenica.setTekuceStanje(new Otkazivanje(narudzbenica));
		} else if (narudzbenica.getTekuceStanje() instanceof Slanje) {
			JOptionPane.showMessageDialog(null, "Problem u transportu, narucite ponovo!", "Stanje narudzbenice",
					JOptionPane.ERROR_MESSAGE);
			narudzbenica.problemiUTransportu();
			narudzbenica.setTekuceStanje(new Otkazivanje(narudzbenica));
		} else if (narudzbenica.getTekuceStanje() instanceof Urucivanje) {
			
			JOptionPane.showMessageDialog(null, "Narudzbenica otkazana!", "Stanje narudzbenice",
					JOptionPane.ERROR_MESSAGE);
			narudzbenica.setTekuceStanje(new Otkazivanje(narudzbenica));
			narudzbenica.krajPorudzbine();
			//System.out.println(narudzbenica.getTekuceStanje());
		}

	}

	public void updatePerformed(UpdateEvent e) {

		System.out.println(e.getStanje());
		if (narudzbenica.getTekuceStanje() instanceof Obradjivanje) {
			//System.out.println("RADi");
			dodajUPanel(2, "DA", "NE", "<html> Proveri da li ima na lageru? </html>", narudzbenica);
		}
		if (narudzbenica.getTekuceStanje() instanceof Slanje) {
			dodajUPanel(2, "DA", "NE", "<html> Da li je narudzbina uspesno transportovana? </html>", narudzbenica);
		}
		if (narudzbenica.getTekuceStanje() instanceof Urucivanje) {
			dodajUPanel(2, "DA", "NE", "<html> Da li narudzbina urucena? </html>", narudzbenica);
		}
		if (narudzbenica.getTekuceStanje() instanceof Otkazivanje) {
			if(narudzbenica.isNoviPokusaj()) {
				narudzbenica.setTekuceStanje(new Porucivanje(narudzbenica));
				System.out.println(narudzbenica.getTekuceStanje());
			}else {
				JOptionPane.showMessageDialog(null, "Nema dovoljno proizvoda na stanju!", "Stanje narudzbenice",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if(narudzbenica.getTekuceStanje() instanceof Porucivanje) {
			dodajUPanel(2, "DA", "NE",
					"<html> Posto ima dovoljno na stanju <br> da li zelite da porucite ponovo??</html>", narudzbenica);
		}

	}

}
