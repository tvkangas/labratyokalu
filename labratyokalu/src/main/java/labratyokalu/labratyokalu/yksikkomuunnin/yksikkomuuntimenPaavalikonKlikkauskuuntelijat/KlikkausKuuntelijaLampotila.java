
package labratyokalu.labratyokalu.yksikkomuunnin.paavalikonKlikkauskuuntelijat;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.Object.*;
import labratyokalu.labratyokalu.yksikkomuunnin.muunnosluokat.GraafinenYksikkomuunninLampotila;

public class KlikkausKuuntelijaLampotila implements ActionListener {
    
    private GraafinenYksikkomuunninLampotila yksikkomuunninValikko;
    private JButton nappi;
    
    public KlikkausKuuntelijaLampotila(GraafinenYksikkomuunninLampotila yksikkomuunninValikko, JButton nappi) {
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
