
package labratyokalu.labratyokalu.paavalikko;

import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import labratyokalu.labratyokalu.paavalikko.klikkauskuuntelijat.*;
import labratyokalu.labratyokalu.muistiinpanot.MuistiinpanotPaavalikko;
import labratyokalu.labratyokalu.laskin.*;
import labratyokalu.labratyokalu.yksikkomuunnin.*;

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
    private GraafinenLaskin gLaskin;
    private GraafinenYksikkomuunninValikko gYmValikko;

    public Paavalikko() {
        try {
            this.muistiinpanotPaavalikko = new MuistiinpanotPaavalikko();
        } catch (Exception ex) {
            Logger.getLogger(Paavalikko.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.gLaskin = new GraafinenLaskin();
        this.gYmValikko = new GraafinenYksikkomuunninValikko();
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
    
    public void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(3, 1);
        container.setLayout(layout);
        alustaValikkonappaimet(container);
    }
    
    /**
     * Apumetodi luo halutut valikkonapit käyttöliittymään
     *
     * @param container Piirrossa hyödynnetty säiliö, johon tallenetaan halutut asiat
     *
     */
    
    public void alustaValikkonappaimet(Container container) {
        JPanel apupaneeli = new JPanel(new GridLayout(3, 1));
        JButton mpNappain = new JButton("Muistiinpanot");
        mpNappain.addActionListener(new KlikkauskuuntelijaMuistiinpanot(muistiinpanotPaavalikko));
        JButton laskinNappain = new JButton("Laskin");
        laskinNappain.addActionListener(new KlikkauskuuntelijaLaskin(gLaskin));
        JButton yksikkomuunninNappain = new JButton("Yksikkömuunnin");
        yksikkomuunninNappain.addActionListener(new KlikkauskuuntelijaYksikkomuunnin(this.gYmValikko));
        
        apupaneeli.add(mpNappain);
        apupaneeli.add(laskinNappain);
        apupaneeli.add(yksikkomuunninNappain);
        container.add(apupaneeli);
    }
    
}
