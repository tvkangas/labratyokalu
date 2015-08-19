
package labratyokalu.labratyokalu.muistiinpanot.klikkauskuuntelijat;

import java.awt.event.*;
import javax.swing.*;
import labratyokalu.labratyokalu.muistiinpanot.*;
import labratyokalu.labratyokalu.muistiinpanot.Muistiinpano;
import labratyokalu.labratyokalu.muistiinpanot.MuistiinpanoVarasto;

public class KlikkauskuuntelijaMuistiinpanonPoisto implements ActionListener {
    
    private Muistiinpano muistiinpano;
    private MuistiinpanoVarasto muistiinpanoVarasto;

    public KlikkauskuuntelijaMuistiinpanonPoisto(Muistiinpano muistiinpano, MuistiinpanoVarasto muistiinpanoVarasto) {
        this.muistiinpano = muistiinpano;
        this.muistiinpanoVarasto = muistiinpanoVarasto;
    }

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.muistiinpanoVarasto.poistaMuistiinpano(muistiinpano);
    }
    
}
