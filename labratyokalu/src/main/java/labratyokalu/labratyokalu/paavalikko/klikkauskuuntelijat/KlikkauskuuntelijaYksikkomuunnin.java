
package labratyokalu.labratyokalu.paavalikko.klikkauskuuntelijat;

import java.awt.event.*;
import javax.swing.*;
import labratyokalu.labratyokalu.yksikkomuunnin.*;

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
