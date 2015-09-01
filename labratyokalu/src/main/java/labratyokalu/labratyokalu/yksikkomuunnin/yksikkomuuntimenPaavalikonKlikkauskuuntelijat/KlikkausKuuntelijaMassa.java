
package labratyokalu.labratyokalu.yksikkomuunnin.yksikkomuuntimenPaavalikonKlikkauskuuntelijat;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.Object.*;
import labratyokalu.labratyokalu.yksikkomuunnin.muunnosluokat.GraafinenYksikkomuunninMassa;

// import statements

/**
 * @author      Tuukka Kangas 
 * @version     1.0                 
 * @since       2015-08-18          
 */

/**
 * Luokka luo ActionListener-olion, jolla päästään selaamaan massaan liittyviä yksikkömuuntimia
 */

public class KlikkausKuuntelijaMassa implements ActionListener {
    
    private GraafinenYksikkomuunninMassa yksikkomuunninValikko;
    
    public KlikkausKuuntelijaMassa(GraafinenYksikkomuunninMassa yksikkomuunninValikko) {
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
