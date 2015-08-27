package labratyokalu.labratyokalu.ajastin;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javafx.scene.media.*;
import javax.sound.sampled.*;

/**
 * @author Tuukka Kangas
 * @version 1.0
 * @since 2015-08-27
 */

/**
 * Luokka luo olion, jonka avulla voidaan kontrolloida ajastimen toimintaa
 */

public class AjastinLogiikka implements ActionListener {

    private Ajastin ajastin;
    private Timer timer;
    private Component component;
    private Numerosarja nroSarja;

    public AjastinLogiikka(Ajastin a, Component c, Numerosarja nroSarja) {
        this.ajastin = a;
        this.timer = new Timer(1000, this);
        this.component = c;
        this.nroSarja = nroSarja;
    }

    /**
     * Metodi käynnistää ajastimen
     */
    public void kaynnistaAjastin() {
        timer.start();
    }

    /**
     * Metodi käynnistää vähentää ajastimesta sekunnin 1000 ms välein
     * @param e avulla voidaan päätellä mikä on aiheuttanut tapahtuman
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            this.ajastin.sekuntiKuluu();
            this.component.repaint();
            if (this.ajastin.onkoAjastinNolla()) {
                this.timer.stop();
                soitaAani();
            }
        }
    }
    
    /**
     * Metodin avulla voidaan soittaa hälytysääni
     */

    public void soitaAani() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/java/labratyokalu/tiedostot/halytysaani.wav").getAbsoluteFile());
            Clip aani = AudioSystem.getClip();
            aani.open(audioInputStream);
            aani.start();
        } catch (Exception ex) {
            System.out.println("Virhe.");
        }
    }

}
