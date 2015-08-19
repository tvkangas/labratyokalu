
package labratyokalu.labratyokalu.paavalikko.klikkauskuuntelijat;

import java.awt.event.*;
import javax.swing.*;
import labratyokalu.labratyokalu.laskin.*;

public class KlikkauskuuntelijaLaskin implements ActionListener {
    private GraafinenLaskin gLaskin;

    public KlikkauskuuntelijaLaskin(GraafinenLaskin gLaskin) {
        this.gLaskin = gLaskin;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.gLaskin.run();
    }
    
}
