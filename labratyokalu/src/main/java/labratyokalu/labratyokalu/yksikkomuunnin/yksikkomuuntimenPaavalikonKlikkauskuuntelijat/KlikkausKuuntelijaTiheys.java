package labratyokalu.labratyokalu.yksikkomuunnin.yksikkomuuntimenPaavalikonKlikkauskuuntelijat;

import java.awt.event.*;
import labratyokalu.labratyokalu.yksikkomuunnin.muunnosluokat.GraafinenYksikkomuunninTiheys;

/**
 * @author Tuukka Kangas
 * @version 1.0
 * @since 2015-08-18
 */
/**
 * Luokka luo ActionListener-olion, jolla päästään selaamaan tiheyteen liittyviä
 * yksikkömuuntimia
 */
public class KlikkausKuuntelijaTiheys implements ActionListener {

    private GraafinenYksikkomuunninTiheys yksikkomuunninValikko;

    public KlikkausKuuntelijaTiheys(GraafinenYksikkomuunninTiheys yksikkomuunninValikko) {
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
