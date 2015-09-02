
package labratyokalu.labratyokalu.paavalikko.klikkauskuuntelijat;

import java.awt.event.*;
import labratyokalu.labratyokalu.yksikkomuunnin.*;

/**
 * @author      Tuukka Kangas 
 * @version     1.0                 
 * @since       2015-08-18          
 */

/**
 * Luokka luo ActionListener-olion, jolla päästään selaamaan yksikkömuunninta
 */

public class KlikkauskuuntelijaYksikkomuunnin implements ActionListener {
    private GraafinenYksikkomuunninValikko gYmValikko;

    public KlikkauskuuntelijaYksikkomuunnin(GraafinenYksikkomuunninValikko gYmValikko) {
        this.gYmValikko = gYmValikko;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.gYmValikko.run();
    }
    
}
