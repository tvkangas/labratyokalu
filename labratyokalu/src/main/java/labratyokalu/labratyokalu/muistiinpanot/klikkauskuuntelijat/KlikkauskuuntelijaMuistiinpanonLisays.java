package labratyokalu.labratyokalu.muistiinpanot.klikkauskuuntelijat;

import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import labratyokalu.labratyokalu.muistiinpanot.*;
import labratyokalu.labratyokalu.muistiinpanot.MuistiinpanoVarasto;


/**
 * @author      Tuukka Kangas 
 * @version     1.0                 
 * @since       2015-08-18          
 */

/**
 * Luokka luo ActionListener-olion, jolla voidaan lisätä muistiinpano
 */

public class KlikkauskuuntelijaMuistiinpanonLisays implements ActionListener {

    private MuistiinpanoVarasto muistiinpanoVarasto;
    private JTextField paivamaaraKentta;
    private JTextField muistiinpanoKentta;
    private JFrame frame;

    public KlikkauskuuntelijaMuistiinpanonLisays(MuistiinpanoVarasto muistiinpanoVarasto, JTextField paivamaaraKentta, JTextField muistiinpanoKentta, JFrame frame) {
        this.muistiinpanoVarasto = muistiinpanoVarasto;
        this.paivamaaraKentta = paivamaaraKentta;
        this.muistiinpanoKentta = muistiinpanoKentta;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Muistiinpano mpApu = new Muistiinpano(muistiinpanoKentta.getText(), paivamaaraKentta.getText());
        this.muistiinpanoVarasto.lisaaMuistiinpano(mpApu);
        try {
            paivitaMuistiinpanotiedosto();
        } catch (Exception ex) {
            Logger.getLogger(KlikkauskuuntelijaMuistiinpanonLisays.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.frame.dispose();
    }
    
    /**
     * Metodi, joka päivittää muistiinpanoihin käytetyn tiedoston
     *
     */

    public void paivitaMuistiinpanotiedosto() throws Exception {
        ArrayList<Muistiinpano> apuLista = this.muistiinpanoVarasto.palautaMuistiinpanotListana();
        try (Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/main/java/labratyokalu/tiedostot/muistiinpanot.txt"), "UTF-8"))) {
            for (int i = 0; i < this.muistiinpanoVarasto.palautaMuistiinpanoVarastonKoko(); i++) {
                out.write(apuLista.get(i).getMuistiinpano() + ";" + apuLista.get(i).getJattopaiva() + "\n");
            }
        }
    }

}
