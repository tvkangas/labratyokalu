package labratyokalu.labratyokalu.yksikkomuunnin.muunnosluokat;

import java.awt.*;
import javax.swing.*;
import labratyokalu.labratyokalu.yksikkomuunnin.*;

/**
 * @author Tuukka Kangas
 * @version 1.0
 * @since 2015-08-18
 */
/**
 * Luokka luo graafisen yksikkömuuntimen, joka koskee paineen yksikkömuunnoksia
 */
public class GraafinenYksikkomuunninPaine implements Runnable {

    private JFrame frame;
    private JTextField vasen;
    private JTextField oikea;

    public GraafinenYksikkomuunninPaine() {
        this.vasen = new JTextField("");
        this.oikea = new JTextField("");
    }

    @Override
    public void run() {
        frame = new JFrame("Painemuunnin");
        frame.setPreferredSize(new Dimension(500, 550));
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(3, 1);
        container.setLayout(layout);
        alustaAputekstit(container);
        alustaNaytot(container);
        alustaMuuntoNappaimet(container);

    }

    private void alustaAputekstit(Container c) {
        JPanel panelApu = new JPanel(new GridLayout(1, 2));
        JLabel vasen = new JLabel("Syötä tähän lukusi");
        JLabel oikea = new JLabel("Tässä näet muutetun luvun");
        panelApu.add(vasen);
        panelApu.add(oikea);
        c.add(panelApu);
    }

    private void alustaNaytot(Container container) {
        JPanel panel1 = new JPanel(new GridLayout(1, 2));
        panel1.add(this.vasen);
        panel1.add(this.oikea);
        container.add(panel1);
        asetaNayttojenKaytettavyys();
    }

    private void alustaMuuntoNappaimet(Container c) {
        JPanel panel2 = new JPanel(new GridLayout(1, 2));

        JButton barToPsiNappi = new JButton("bar >> psi");
        barToPsiNappi.addActionListener(new KlikkausKuuntelijaMuunnin(new Yksikkomuunnin(14.5037738, 0, "bar", "psi"), this.vasen, this.oikea));
        panel2.add(barToPsiNappi);

        JButton psiToBarNappi = new JButton("min >> sek");
        psiToBarNappi.addActionListener(new KlikkausKuuntelijaMuunnin(new Yksikkomuunnin((1.0 / 14.5037738), 0, "psi", "bar"), this.vasen, this.oikea));
        panel2.add(psiToBarNappi);

        c.add(panel2);
    }

    private void asetaNayttojenKaytettavyys() {
        this.vasen.setEnabled(true);
        this.oikea.setEnabled(false);
    }

}
