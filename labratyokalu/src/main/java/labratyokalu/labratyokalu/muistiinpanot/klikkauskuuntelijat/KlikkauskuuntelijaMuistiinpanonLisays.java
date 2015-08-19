
package labratyokalu.labratyokalu.muistiinpanot.klikkauskuuntelijat;

import java.awt.event.*;
import javax.swing.*;
import labratyokalu.labratyokalu.muistiinpanot.*;
import labratyokalu.labratyokalu.muistiinpanot.Muistiinpano;
import labratyokalu.labratyokalu.muistiinpanot.MuistiinpanoVarasto;

public class KlikkauskuuntelijaMuistiinpanonLisays implements ActionListener {
    
    private MuistiinpanoVarasto muistiinpanoVarasto;
    private JTextField paivamaaraKentta;
    private JTextField muistiinpanoKentta;

    public KlikkauskuuntelijaMuistiinpanonLisays(MuistiinpanoVarasto muistiinpanoVarasto, JTextField paivamaaraKentta, JTextField muistiinpanoKentta) {
        this.muistiinpanoVarasto = muistiinpanoVarasto;
        this.paivamaaraKentta = paivamaaraKentta;
        this.muistiinpanoKentta = muistiinpanoKentta;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Muistiinpano mpApu = new Muistiinpano(muistiinpanoKentta.getText(), paivamaaraKentta.getText());
        this.muistiinpanoVarasto.lisaaMuistiinpano(mpApu);
    }
    
}
