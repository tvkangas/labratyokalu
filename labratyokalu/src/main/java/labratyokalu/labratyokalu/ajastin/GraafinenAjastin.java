package labratyokalu.labratyokalu.ajastin;

import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import labratyokalu.labratyokalu.ajastin.*;
import labratyokalu.labratyokalu.ajastin.numerot.*;

/**
 * @author Tuukka Kangas
 * @version 1.0
 * @since 2015-08-25
 */
/**
 * Luokka luo graafisen ajastimen
 */
public class GraafinenAjastin implements Runnable {

    private JFrame frame;
    private Piirtoalusta piirtoalusta;
    private Numerosarja numerosarja;
    private Ajastin ajastin;
    private AjastinLogiikka aLogiikka;

    public GraafinenAjastin(Ajastin ajastin) {
        this.ajastin = ajastin;
        this.numerosarja = new Numerosarja(this.ajastin);
        this.piirtoalusta = new Piirtoalusta(this.numerosarja);
        this.aLogiikka = new AjastinLogiikka(this.ajastin, this.piirtoalusta, this.numerosarja);
    }

    @Override
    public void run() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(530, 300));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());
        lueAjastin();

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(1, 1);
        JPanel paaPanel = new JPanel(new GridLayout(2, 1));
        paaPanel.add(piirtoalusta);
        paaPanel.add(lisaaNapit(container));
        container.add(paaPanel);
    }

    private void lueAjastin() {
        int koko = 20;
        Color vari = Color.RED;
        this.numerosarja.lisaaNumero(muutaNumeroksi(this.ajastin.getTunnitKymmenet(), 20, 20, koko, vari));
        this.numerosarja.lisaaNumero(muutaNumeroksi(this.ajastin.getTunnitYkkoset(), 90, 20, koko, vari));
        this.numerosarja.lisaaNumero(new Kaksoispiste(140, 20, koko, vari));
        this.numerosarja.lisaaNumero(muutaNumeroksi(this.ajastin.getMinuutitKymmenet(), 190, 20, koko, vari));
        this.numerosarja.lisaaNumero(muutaNumeroksi(this.ajastin.getMinuutitYkkoset(), 260, 20, koko, vari));
        this.numerosarja.lisaaNumero(new Kaksoispiste(310, 20, koko, vari));
        this.numerosarja.lisaaNumero(muutaNumeroksi(this.ajastin.getSekunnitKymmenet(), 360, 20, koko, vari));
        this.numerosarja.lisaaNumero(muutaNumeroksi(this.ajastin.getSekunnitYkkoset(), 430, 20, koko, vari));
    }

    /**
     * Metodi muuttaa luvun piirrettäväksi numeroksi
     * 
     * @param luku Integer muodossa
     * @param x x-koordinaatti, josta piirtäminen aloitetaan
     * @param y y-koordinaatti, josta piirtäminen aloitetaan
     * @param koko yhden laatikon koko
     * @param vari laatikon väri
     * @return palauttaa Numeron
     */
    
    public Numero muutaNumeroksi(int luku, int x, int y, int koko, Color vari) {
        if (luku == 1) {
            return new Yksi(x, y, koko, vari);
        } else if (luku == 2) {
            return new Kaksi(x, y, koko, vari);
        } else if (luku == 3) {
            return new Kolme(x, y, koko, vari);
        } else if (luku == 4) {
            return new Nelja(x, y, koko, vari);
        } else if (luku == 5) {
            return new Viisi(x, y, koko, vari);
        } else if (luku == 6) {
            return new Kuusi(x, y, koko, vari);
        } else if (luku == 7) {
            return new Seitseman(x, y, koko, vari);
        } else if (luku == 8) {
            return new Kahdeksan(x, y, koko, vari);
        } else if (luku == 9) {
            return new Yhdeksan(x, y, koko, vari);
        } else if (luku == 0) {
            return new Nolla(x, y, koko, vari);
        } else {
            return null;
        }
    }

    private JPanel lisaaNapit(Container c) {
        JPanel panelApu = new JPanel(new GridLayout(1, 1));
        panelApu.setSize(new Dimension(100, 150));
        JButton kaynnista = new JButton("Käynnistä");
        kaynnista.setBackground(Color.BLACK);
        kaynnista.setForeground(Color.RED);
        kaynnista.setOpaque(true);
        kaynnista.addActionListener(new KlikkauskuuntelijaKaynnista(this.aLogiikka, this.piirtoalusta));

        panelApu.add(kaynnista);
        return panelApu;
    }

    public JFrame getFrame() {
        return frame;
    }

}
