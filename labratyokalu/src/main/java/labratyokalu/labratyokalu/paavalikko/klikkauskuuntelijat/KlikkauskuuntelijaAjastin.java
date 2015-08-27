
package labratyokalu.labratyokalu.paavalikko.klikkauskuuntelijat;

import java.awt.event.*;
import labratyokalu.labratyokalu.ajastin.*;

/**
 * @author      Tuukka Kangas 
 * @version     1.0                 
 * @since       2015-08-27         
 */

/**
 * Luokka luo ActionListener-olion, jolla päästään selaamaan ajastinta
 */

public class KlikkauskuuntelijaAjastin implements ActionListener {
    private AjastimenValikko aValikko;

    public KlikkauskuuntelijaAjastin(AjastimenValikko aValikko) {
        this.aValikko = aValikko;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.aValikko.run();
    }
    
}
