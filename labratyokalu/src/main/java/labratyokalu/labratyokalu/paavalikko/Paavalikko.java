
package labratyokalu.labratyokalu.paavalikko;

import java.awt.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import labratyokalu.labratyokalu.paavalikko.klikkauskuuntelijat.*;
import labratyokalu.labratyokalu.muistiinpanot.MuistiinpanotPaavalikko;
import labratyokalu.labratyokalu.laskin.*;
import labratyokalu.labratyokalu.yksikkomuunnin.*;
import labratyokalu.labratyokalu.yhdisteet.Alkuaine;
import labratyokalu.labratyokalu.yhdisteet.GraafinenMoolimassalaskuri;
import labratyokalu.labratyokalu.ajastin.*;
import labratyokalu.labratyokalu.kiehumispistelaskuri.GraafinenKiehumispistelaskuri;

// import statements
/**
 * @author Tuukka Kangas
 * @version 1.0
 * @since 2015-08-18
 */

/**
 * Luokka luo päävalikon, jossa voi selata haluttuja toimintoja
 */

public class Paavalikko implements Runnable {
    private JFrame frame;
    private MuistiinpanotPaavalikko muistiinpanotPaavalikko;

    public Paavalikko() {
        try {
            this.muistiinpanotPaavalikko = new MuistiinpanotPaavalikko();
        } catch (Exception ex) {
            Logger.getLogger(Paavalikko.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    @Override
    public void run() {
        frame = new JFrame("Päävalikko");
        frame.setPreferredSize(new Dimension(300, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
        GridLayout layout = new GridLayout(1, 1);
        container.setLayout(layout);
        alustaValikkonappaimet(container);
    }
    
    /**
     * Apumetodi luo halutut valikkonapit käyttöliittymään
     *
     * @param container Piirrossa hyödynnetty säiliö, johon tallenetaan halutut asiat
     *
     */
    
    private void alustaValikkonappaimet(Container container) {
        JPanel apupaneeli = new JPanel(new GridLayout(6, 1));
        JButton mpNappain = new JButton("Muistiinpanot");
        mpNappain.addActionListener(new KlikkauskuuntelijaMuistiinpanot(muistiinpanotPaavalikko));
        JButton laskinNappain = new JButton("Laskin");
        laskinNappain.addActionListener(new KlikkauskuuntelijaLaskin(new GraafinenLaskin()));
        JButton yksikkomuunninNappain = new JButton("Yksikkömuunnin");
        yksikkomuunninNappain.addActionListener(new KlikkauskuuntelijaYksikkomuunnin(new GraafinenYksikkomuunninValikko()));
        JButton moolimassalaskuriNappain = new JButton("Moolimassalaskuri");
        moolimassalaskuriNappain.addActionListener(new KlikkauskuuntelijaMoolimassalaskuri(new GraafinenMoolimassalaskuri()));
        JButton ajastinNappain = new JButton("Ajastin");
        ajastinNappain.addActionListener(new KlikkauskuuntelijaAjastin(new AjastimenValikko()));
        JButton kiehumispisteNappain = new JButton("Kiehumispistelaskuri");
        kiehumispisteNappain.addActionListener(new KlikkauskuuntelijaKiehumispistelaskuri(new GraafinenKiehumispistelaskuri()));
        
        apupaneeli.add(mpNappain);
        apupaneeli.add(laskinNappain);
        apupaneeli.add(yksikkomuunninNappain);
        apupaneeli.add(moolimassalaskuriNappain);
        apupaneeli.add(ajastinNappain);
        apupaneeli.add(kiehumispisteNappain);
        container.add(apupaneeli);
    }
    
}
