package labratyokalu.labratyokalu.muistiinpanot.klikkauskuuntelijat;

import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import labratyokalu.labratyokalu.muistiinpanot.*;

/**
 * @author Tuukka Kangas
 * @version 1.0
 * @since 2015-08-18
 */
/**
 * Luokka luo ActionListener-olion, jolla voidaan poistaa muistiinpano
 */
public class KlikkauskuuntelijaMuistiinpanonPoisto implements ActionListener {

    private Muistiinpano muistiinpano;
    private MuistiinpanoVarasto muistiinpanoVarasto;
    private JFrame frame;

    public KlikkauskuuntelijaMuistiinpanonPoisto(Muistiinpano muistiinpano, MuistiinpanoVarasto muistiinpanoVarasto, JFrame frame) {
        this.muistiinpano = muistiinpano;
        this.muistiinpanoVarasto = muistiinpanoVarasto;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.muistiinpanoVarasto.poistaMuistiinpano(muistiinpano);
        try {
            paivitaMuistiinpanotiedosto();
        } catch (Exception ex) {
            Logger.getLogger(KlikkauskuuntelijaMuistiinpanonLisays.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.frame.dispose();
    }

    /**
     * Metodi, joka päivittää muistiinpanoihin käytetyn tiedoston
     * @throws Exception heittää virheen, jos ei onnistu
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
