package labratyokalu.labratyokalu.muistiinpanot;

import labratyokalu.labratyokalu.muistiinpanot.klikkauskuuntelijat.*;
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
 * Luokan avulla luodaan käyttöliittymä muistiinpanojen tarkastelua varten
 */

public class GraafinenKayttoliittymaMuistiinpanojenTarkastelu implements Runnable {

    private JFrame frame;
    private MuistiinpanoVarasto muistiinpanoVarasto;

    public GraafinenKayttoliittymaMuistiinpanojenTarkastelu(MuistiinpanoVarasto muistiinpanoVarasto) {
        this.muistiinpanoVarasto = muistiinpanoVarasto;
    }

    @Override
    public void run() {
        frame = new JFrame("Muistiinpanojen tarkastelu");
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
     * @see GraafinenKayttoliittymaMuistiinpanojenTarkastelu#tuoMuistiinpanot(Container container, ArrayList<Muistiinpano> muistiinpanot)
     *
     */

    private void luoKomponentit(Container container) {
        int kuinkaMontaMuistiinpanoa = this.muistiinpanoVarasto.palautaMuistiinpanoVarastonKoko();
        if (kuinkaMontaMuistiinpanoa > 0) {
            GridLayout layout = new GridLayout(kuinkaMontaMuistiinpanoa + 1, 3);
            container.setLayout(layout);

            tuoMuistiinpanot(container, this.muistiinpanoVarasto.palautaMuistiinpanotListana());

            JButton poistaKaikki = new JButton("Poista kaikki");
            poistaKaikki.addActionListener(new KlikkauskuuntelijaPoistaKaikki(this.muistiinpanoVarasto));
            container.add(poistaKaikki);
        } else {
            GridLayout layout = new GridLayout(1, 1);
            container.add(new JLabel("Ei muistiipanoja"));
        }
    }
    
    /**
     * Metodi tuo muistiinpanot muistista
     *
     * @param container Piirrossa hyödynnetty säiliö, johon tallenetaan halutut asiat
     * @param muistiinpanot Lista, joka sisältää muistiinpanot
     * 
     * @see labratyokalu.labratyokalu.muistiinpanot.Muistiinpano#getMuistiinpano() 
     * @see labratyokalu.labratyokalu.muistiinpanot.Muistiinpano#getJattopaiva() 
     */

    private void tuoMuistiinpanot(Container container, ArrayList<Muistiinpano> muistiinpanot) {
        for (int i = 0; i < muistiinpanot.size(); i++) {
            JLabel mp = new JLabel(muistiinpanot.get(i).getJattopaiva() + " " + muistiinpanot.get(i).getMuistiinpano());
            JButton poistoNappi = new JButton("Poista");
            poistoNappi.addActionListener(new KlikkauskuuntelijaMuistiinpanonPoisto(muistiinpanot.get(i), this.muistiinpanoVarasto));
            JButton muokkaaNappi = new JButton("Muokkaa");
            container.add(mp);
            container.add(poistoNappi);
            container.add(muokkaaNappi);
        }
    }

}
