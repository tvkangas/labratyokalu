
package labratyokalu.labratyokalu.yksikkomuunnin.yksikkomuuntimenPaavalikonKlikkauskuuntelijat;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.Object.*;
import labratyokalu.labratyokalu.yksikkomuunnin.muunnosluokat.GraafinenYksikkomuunninAika;

public class KlikkausKuuntelijaAika implements ActionListener {
    
    private GraafinenYksikkomuunninAika yksikkomuunninValikko;
    private JButton nappi;
    
    public KlikkausKuuntelijaAika(GraafinenYksikkomuunninAika yksikkomuunninValikko, JButton nappi) {
        this.yksikkomuunninValikko = yksikkomuunninValikko;
        this.nappi = nappi;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.yksikkomuunninValikko.run();
        } catch (NumberFormatException ei) {
        }
    }
    
}
