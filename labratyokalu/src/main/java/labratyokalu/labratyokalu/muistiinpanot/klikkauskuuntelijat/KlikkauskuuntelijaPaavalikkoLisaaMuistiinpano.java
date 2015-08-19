
package labratyokalu.labratyokalu.muistiinpanot.klikkauskuuntelijat;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.Object.*;
import labratyokalu.labratyokalu.muistiinpanot.*;

public class KlikkauskuuntelijaPaavalikkoLisaaMuistiinpano implements ActionListener {
    
    private GraafinenKayttoliittymaMuistiinpanonLisays lisaysvalikko;
    private JButton nappi;  

    public KlikkauskuuntelijaPaavalikkoLisaaMuistiinpano(GraafinenKayttoliittymaMuistiinpanonLisays lisaysvalikko, JButton nappi) {
        this.lisaysvalikko = lisaysvalikko;
        this.nappi = nappi;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.lisaysvalikko.run();
        } catch (NumberFormatException ei) {
        }
    }
    
}
