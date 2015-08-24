
package labratyokalu.labratyokalu.paavalikko.klikkauskuuntelijat;

import java.awt.event.*;
import javax.swing.*;
import labratyokalu.labratyokalu.yhdisteet.*;

    /**
 * @author      Tuukka Kangas 
 * @version     1.0                 
 * @since       2015-08-18          
 */

/**
 * Luokka luo ActionListener-olion, jolla päästään selaamaan moolimassalaskuria
 */

public class KlikkauskuuntelijaMoolimassalaskuri implements ActionListener {
    private GraafinenMoolimassalaskuri gMlaskuri;

    public KlikkauskuuntelijaMoolimassalaskuri(GraafinenMoolimassalaskuri gMlaskuri) {
        this.gMlaskuri = gMlaskuri;
    }

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.gMlaskuri.run();
    }
    
}
