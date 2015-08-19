
package labratyokalu.labratyokalu.muistiinpanot.klikkauskuuntelijat;

import java.awt.event.*;
import javax.swing.*;
import labratyokalu.labratyokalu.muistiinpanot.*;
import labratyokalu.labratyokalu.muistiinpanot.Muistiinpano;
import labratyokalu.labratyokalu.muistiinpanot.MuistiinpanoVarasto;

public class KlikkauskuuntelijaPoistaKaikki implements ActionListener {
    
    private MuistiinpanoVarasto muistiinpanoVarasto;

    public KlikkauskuuntelijaPoistaKaikki(MuistiinpanoVarasto muistiinpanoVarasto) {
        this.muistiinpanoVarasto = muistiinpanoVarasto;
    }

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.muistiinpanoVarasto.tyhjennaMuistiinpanot();
    }
    
}
