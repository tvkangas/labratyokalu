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
 * Luokka luo graafisen yksikkömuuntimen, joka koskee tiheyden yksikkömuunnoksia
 */
public class GraafinenYksikkomuunninTiheys implements Runnable {

    private JFrame frame;
    private JTextField vasen;
    private JTextField oikea;

    public GraafinenYksikkomuunninTiheys() {
        this.vasen = new JTextField("");
        this.oikea = new JTextField("");
    }

    @Override
    public void run() {
        frame = new JFrame("Tiheysmuunnin");
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
        JPanel panel2 = new JPanel(new GridLayout(2, 2));

        JButton kgM3ToMgLNappi = new JButton("kg/m3 >> mg/l");
        kgM3ToMgLNappi.addActionListener(new KlikkausKuuntelijaMuunnin(new Yksikkomuunnin(1000, 0, "kg/m3", "mg/l"), this.vasen, this.oikea));
        panel2.add(kgM3ToMgLNappi);

        JButton mgLToKgM3Nappi = new JButton("mg/l >> kg/m3");
        mgLToKgM3Nappi.addActionListener(new KlikkausKuuntelijaMuunnin(new Yksikkomuunnin((1.0 / 1000.0), 0, "mg/l", "kg/m3"), this.vasen, this.oikea));
        panel2.add(mgLToKgM3Nappi);

        JButton gLToKgM3Nappi = new JButton("g/l >> kg/m3");
        gLToKgM3Nappi.addActionListener(new KlikkausKuuntelijaMuunnin(new Yksikkomuunnin(1.0, 0, "g/l", "kg/m3"), this.vasen, this.oikea));
        panel2.add(gLToKgM3Nappi);

        JButton kgM3ToGLNappi = new JButton("kg/m3 >> g/l");
        kgM3ToGLNappi.addActionListener(new KlikkausKuuntelijaMuunnin(new Yksikkomuunnin(1.0, 0, "kg/m3", "g/l"), this.vasen, this.oikea));
        panel2.add(kgM3ToGLNappi);

        c.add(panel2);
    }

    private void asetaNayttojenKaytettavyys() {
        this.vasen.setEnabled(true);
        this.oikea.setEnabled(false);
    }

}
