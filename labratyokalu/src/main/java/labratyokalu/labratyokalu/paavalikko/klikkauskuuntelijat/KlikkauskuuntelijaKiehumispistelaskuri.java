
package labratyokalu.labratyokalu.paavalikko.klikkauskuuntelijat;

import java.awt.event.*;
import labratyokalu.labratyokalu.kiehumispistelaskuri.GraafinenKiehumispistelaskuri;

/**
 * @author      Tuukka Kangas 
 * @version     1.0                 
 * @since       2015-09-01        
 */

/**
 * Luokka luo ActionListener-olion, jolla päästään selaamaan kiehumispistelaskuria
 */

public class KlikkauskuuntelijaKiehumispistelaskuri implements ActionListener {
    private GraafinenKiehumispistelaskuri gKpl;

    public KlikkauskuuntelijaKiehumispistelaskuri(GraafinenKiehumispistelaskuri gKpl) {
        this.gKpl = gKpl;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.gKpl.run();
    }
    
}
