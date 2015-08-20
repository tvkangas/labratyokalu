
package labratyokalu.labratyokalu.paavalikko.klikkauskuuntelijat;

import java.awt.event.*;
import javax.swing.*;
import labratyokalu.labratyokalu.muistiinpanot.*;

// import statements

/**
 * @author      Tuukka Kangas 
 * @version     1.0                 
 * @since       2015-08-18          
 */

/**
 * Luokka luo ActionListener-olion, jolla päästään selaamaan muistiinpanoja
 */

public class KlikkauskuuntelijaMuistiinpanot implements ActionListener {
    private MuistiinpanotPaavalikko mpValikko;

    public KlikkauskuuntelijaMuistiinpanot(MuistiinpanotPaavalikko mpValikko) {
        this.mpValikko = mpValikko;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.mpValikko.run();
    }
    
}
