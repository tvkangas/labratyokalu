
package labratyokalu.labratyokalu.muistiinpanot.klikkauskuuntelijat;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.Object.*;
import labratyokalu.labratyokalu.muistiinpanot.*;

public class KlikkauskuuntelijaPaavalikkoTarkasteleMuistiinpanoja implements ActionListener {
    
    private GraafinenKayttoliittymaMuistiinpanojenTarkastelu tarkasteluvalikko;
    private JButton nappi;  

    public KlikkauskuuntelijaPaavalikkoTarkasteleMuistiinpanoja(GraafinenKayttoliittymaMuistiinpanojenTarkastelu tarkasteluValikko, JButton nappi) {
        this.tarkasteluvalikko = tarkasteluValikko;
        this.nappi = nappi;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.tarkasteluvalikko.run();
        } catch (NumberFormatException ei) {
        }
    }
    
}
