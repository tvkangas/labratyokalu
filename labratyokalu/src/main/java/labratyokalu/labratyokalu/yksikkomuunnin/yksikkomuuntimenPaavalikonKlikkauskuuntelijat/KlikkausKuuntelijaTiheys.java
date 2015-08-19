
package labratyokalu.labratyokalu.yksikkomuunnin.yksikkomuuntimenPaavalikonKlikkauskuuntelijat;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.Object.*;
import labratyokalu.labratyokalu.yksikkomuunnin.muunnosluokat.GraafinenYksikkomuunninTiheys;

public class KlikkausKuuntelijaTiheys implements ActionListener {
    
    private GraafinenYksikkomuunninTiheys yksikkomuunninValikko;
    private JButton nappi;
    
    public KlikkausKuuntelijaTiheys(GraafinenYksikkomuunninTiheys yksikkomuunninValikko, JButton nappi) {
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
