
package labratyokalu.labratyokalu.yksikkomuunnin.yksikkomuuntimenPaavalikonKlikkauskuuntelijat;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.Object.*;
import labratyokalu.labratyokalu.yksikkomuunnin.muunnosluokat.GraafinenYksikkomuunninAika;

// import statements

/**
 * @author      Tuukka Kangas 
 * @version     1.0                 
 * @since       2015-08-18          
 */

/**
 * Luokka luo ActionListener-olion, jolla päästään selaamaan aikaan liittyviä yksikkömuuntimia
 */

public class KlikkausKuuntelijaAika implements ActionListener {
    
    private GraafinenYksikkomuunninAika yksikkomuunninValikko;
    
    public KlikkausKuuntelijaAika(GraafinenYksikkomuunninAika yksikkomuunninValikko) {
        this.yksikkomuunninValikko = yksikkomuunninValikko;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.yksikkomuunninValikko.run();
        } catch (NumberFormatException ei) {
        }
    }
    
}
