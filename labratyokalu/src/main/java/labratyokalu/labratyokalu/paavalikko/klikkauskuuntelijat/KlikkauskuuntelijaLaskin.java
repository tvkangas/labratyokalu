
package labratyokalu.labratyokalu.paavalikko.klikkauskuuntelijat;

import java.awt.event.*;
import labratyokalu.labratyokalu.laskin.*;

/**
 * @author      Tuukka Kangas 
 * @version     1.0                 
 * @since       2015-08-18          
 */

/**
 * Luokka luo ActionListener-olion, jolla päästään selaamaan laskinta
 */


public class KlikkauskuuntelijaLaskin implements ActionListener {
    private GraafinenLaskin gLaskin;

    public KlikkauskuuntelijaLaskin(GraafinenLaskin gLaskin) {
        this.gLaskin = gLaskin;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.gLaskin.run();
    }
    
}
