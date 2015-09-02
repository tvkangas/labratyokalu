package labratyokalu.labratyokalu.yksikkomuunnin.yksikkomuuntimenPaavalikonKlikkauskuuntelijat;

import java.awt.event.*;
import labratyokalu.labratyokalu.yksikkomuunnin.muunnosluokat.GraafinenYksikkomuunninTilavuus;

/**
 * @author Tuukka Kangas
 * @version 1.0
 * @since 2015-08-18
 */
/**
 * Luokka luo ActionListener-olion, jolla päästään selaamaan tilavuuteen
 * liittyviä yksikkömuuntimia
 */
public class KlikkausKuuntelijaTilavuus implements ActionListener {

    private GraafinenYksikkomuunninTilavuus yksikkomuunninValikko;

    public KlikkausKuuntelijaTilavuus(GraafinenYksikkomuunninTilavuus yksikkomuunninValikko) {
        this.yksikkomuunninValikko = yksikkomuunninValikko;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.yksikkomuunninValikko.run();
        } catch (NumberFormatException ei) {
            System.out.println("Ei onnistunut!");
        }
    }

}
