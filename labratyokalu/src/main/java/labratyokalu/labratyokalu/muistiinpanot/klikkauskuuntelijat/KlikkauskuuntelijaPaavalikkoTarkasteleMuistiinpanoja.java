
package labratyokalu.labratyokalu.muistiinpanot.klikkauskuuntelijat;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.Object.*;
import labratyokalu.labratyokalu.muistiinpanot.*;

// import statements

/**
 * @author      Tuukka Kangas 
 * @version     1.0                 
 * @since       2015-08-18          
 */

/**
 * Luokka luo ActionListener-olion, jolla päästään valikkoon, jotta voidaan tarkastella muistiinpanoja
 */

public class KlikkauskuuntelijaPaavalikkoTarkasteleMuistiinpanoja implements ActionListener {
    
    private GraafinenKayttoliittymaMuistiinpanojenTarkastelu tarkasteluvalikko;
    private JButton nappi;  

    public KlikkauskuuntelijaPaavalikkoTarkasteleMuistiinpanoja(GraafinenKayttoliittymaMuistiinpanojenTarkastelu tarkasteluValikko, JButton nappi) {
        this.tarkasteluvalikko = tarkasteluValikko;
        this.nappi = nappi;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.tarkasteluvalikko.run();
        } catch (NumberFormatException ei) {
        }
    }
    
}
