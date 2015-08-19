
package labratyokalu.labratyokalu.paavalikko.klikkauskuuntelijat;

import java.awt.event.*;
import javax.swing.*;
import labratyokalu.labratyokalu.muistiinpanot.*;

public class KlikkauskuuntelijaMuistiinpanot implements ActionListener {
    private MuistiinpanotPaavalikko mpValikko;

    public KlikkauskuuntelijaMuistiinpanot(MuistiinpanotPaavalikko mpValikko) {
        this.mpValikko = mpValikko;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.mpValikko.run();
    }
    
}
