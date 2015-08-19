package labratyokalu.labratyokalu.laskin;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// import statements
/**
 * @author Tuukka Kangas
 * @version 1.0
 * @since 2015-08-18
 */

/**
 * Luokka luo graafisen laskimen, joka hyödyntää laskin-oliota
 */

public class GraafinenLaskin implements Runnable {

    private JFrame frame;
    private Laskin laskin;
    private JTextField yla;
    private JTextField keski;

    public GraafinenLaskin() {
        this.laskin = new Laskin();
        this.yla = new JTextField(this.laskin.getArvo() + "");
        this.keski = new JTextField("");
    }

    @Override
    public void run() {
        frame = new JFrame("Laskin");
        frame.setPreferredSize(new Dimension(300, 250));
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
        this.keski.requestFocus();
    }
    
    /**
     * Metodi luo halutut komponentit käyttöliittymään
     *
     * @param container Piirrossa hyödynnetty säiliö, johon tallenetaan halutut asiat
     *
     */

    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(4, 1);
        container.setLayout(layout);
        yla.setEnabled(false);        
        container.add(yla);
        
        container.add(keski);
        alustaNapit(container, yla, keski);
    }

    public JFrame getFrame() {
        return frame;
    }
    
    /**
     * Metodi luo kehykseen halutut toiminnot
     *
     * @param container Piirrossa hyödynnetty säiliö, johon tallenetaan halutut asiat
     * @param yla Tulostauluna käytetty tekstikenttä
     * @param keski Syöttökenttänä käytetty tekstikenttä
     */

    public void alustaNapit(Container container, JTextField yla, JTextField keski) {

        JPanel panel1 = new JPanel(new GridLayout(1, 3));
        JButton plus = new JButton("+");
        JButton miinus = new JButton("-");
        JButton tyhjennys = new JButton("Z");

        plus.addActionListener(new KlikkausKuuntelijaSummaus(this.laskin, keski, yla, tyhjennys));
        miinus.addActionListener(new KlikkausKuuntelijaVahennys(this.laskin, keski, yla, tyhjennys));
        tyhjennys.addActionListener(new KlikkausKuuntelijaTyhjenna(this.laskin, keski, yla, tyhjennys));

        panel1.add(plus);
        panel1.add(miinus);
        panel1.add(tyhjennys);
        container.add(panel1);

        JPanel panel2 = new JPanel(new GridLayout(1, 3));
        JButton kertominen = new JButton("x");
        JButton jakaminen = new JButton("/");
        JButton korotaPotenssiin = new JButton("^");
        
        kertominen.addActionListener(new KlikkausKuuntelijaKertominen(this.laskin, keski, yla, tyhjennys));
        jakaminen.addActionListener(new KlikkausKuuntelijaJakaminen(this.laskin, keski, yla, tyhjennys));
        korotaPotenssiin.addActionListener(new KlikkausKuuntelijaPotenssi(this.laskin, keski, yla, tyhjennys));
        
        panel2.add(kertominen);
        panel2.add(jakaminen);
        panel2.add(korotaPotenssiin);
        container.add(panel2);
    }

}