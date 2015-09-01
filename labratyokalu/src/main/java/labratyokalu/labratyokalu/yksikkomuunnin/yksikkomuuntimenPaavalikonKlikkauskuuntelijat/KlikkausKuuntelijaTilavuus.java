
package labratyokalu.labratyokalu.yksikkomuunnin.yksikkomuuntimenPaavalikonKlikkauskuuntelijat;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.Object.*;
import labratyokalu.labratyokalu.yksikkomuunnin.muunnosluokat.GraafinenYksikkomuunninTilavuus;

// import statements

/**
 * @author      Tuukka Kangas 
 * @version     1.0                 
 * @since       2015-08-18          
 */

/**
 * Luokka luo ActionListener-olion, jolla päästään selaamaan tilavuuteen liittyviä yksikkömuuntimia
 */

public class KlikkausKuuntelijaTilavuus implements ActionListener {
    
    private GraafinenYksikkomuunninTilavuus yksikkomuunninValikko;
    
    public KlikkausKuuntelijaTilavuus(GraafinenYksikkomuunninTilavuus yksikkomuunninValikko) {
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
