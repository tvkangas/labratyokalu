package labratyokalu.labratyokalu.yksikkomuunnin.yksikkomuuntimenPaavalikonKlikkauskuuntelijat;

import java.awt.event.*;
import labratyokalu.labratyokalu.yksikkomuunnin.muunnosluokat.GraafinenYksikkomuunninPaine;

/**
 * @author Tuukka Kangas
 * @version 1.0
 * @since 2015-08-18
 */
/**
 * Luokka luo ActionListener-olion, jolla päästään selaamaan paineeseen
 * liittyviä yksikkömuuntimia
 */
public class KlikkausKuuntelijaPaine implements ActionListener {

    private GraafinenYksikkomuunninPaine yksikkomuunninValikko;

    public KlikkausKuuntelijaPaine(GraafinenYksikkomuunninPaine yksikkomuunninValikko) {
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
