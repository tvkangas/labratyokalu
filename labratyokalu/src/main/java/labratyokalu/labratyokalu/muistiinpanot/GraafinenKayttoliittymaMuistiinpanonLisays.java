package labratyokalu.labratyokalu.muistiinpanot;

import labratyokalu.labratyokalu.muistiinpanot.klikkauskuuntelijat.KlikkauskuuntelijaMuistiinpanonLisays;
import labratyokalu.labratyokalu.muistiinpanot.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.*;

// import statements
/**
 * @author Tuukka Kangas
 * @version 1.0
 * @since 2015-08-18
 */

/**
 * Luokan avulla luodaan käyttöliittymä muistiinpanojen lisäystä varten
 */

public class GraafinenKayttoliittymaMuistiinpanonLisays implements Runnable {

    private JFrame frame;
    private MuistiinpanoVarasto muistiinpanoVarasto;

    public GraafinenKayttoliittymaMuistiinpanonLisays(MuistiinpanoVarasto muistiinpanoVarasto) {
        this.muistiinpanoVarasto = muistiinpanoVarasto;
    } 

    @Override
    public void run() {
        frame = new JFrame("Muistiinpanon lisäys");
        frame.setPreferredSize(new Dimension(550, 200));
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * Metodi luo halutut komponentit käyttöliittymään
     *
     * @param container Piirrossa hyödynnetty säiliö, johon tallenetaan halutut asiat
     * 
     */

    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(3, 2);
        container.setLayout(layout);

        JLabel paivamaaraTeksti = new JLabel("Päivämäärä: ");
        JTextField paivamaaraKentta = new JTextField(haeTamaPaiva());

        JLabel muistiinpanoTeksti = new JLabel("Muistiinpano: ");
        JTextField muistiinpanoKentta = new JTextField();

        JButton tallennusNappi = new JButton("Lisää muistiinpano");
        tallennusNappi.addActionListener(new KlikkauskuuntelijaMuistiinpanonLisays(this.muistiinpanoVarasto, paivamaaraKentta, muistiinpanoKentta, this.frame));

        container.add(paivamaaraTeksti);
        container.add(paivamaaraKentta);
        container.add(muistiinpanoTeksti);
        container.add(muistiinpanoKentta);
        container.add(new JLabel(""));
        container.add(tallennusNappi);
    }
    
    /**
     * Metodi tuo halutun päivämäärän hyödyntäen Javan Date-metodia
     *
     * @return päivämäärän merkkijonona
     * 
     */

    private String haeTamaPaiva() {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");
        return ft.format(dNow);
    }

}
