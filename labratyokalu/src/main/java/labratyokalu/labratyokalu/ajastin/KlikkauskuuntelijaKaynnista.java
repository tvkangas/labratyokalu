package labratyokalu.labratyokalu.ajastin;

import java.awt.Component;
import java.awt.event.*;
import java.util.logging.*;

/**
 * @author Tuukka Kangas
 * @version 1.0
 * @since 2015-08-26
 */
/**
 * Luokka luo ActionListener-olion, jolla voidaan käynnistää ajastin
 */
public class KlikkauskuuntelijaKaynnista implements ActionListener {

    private AjastinLogiikka aLogiikka;
    private Component component;

    public KlikkauskuuntelijaKaynnista(AjastinLogiikka aLogiikka, Component c) {
        this.aLogiikka = aLogiikka;
        this.component = c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.aLogiikka.kaynnistaAjastin();
    }

}
