package labratyokalu.labratyokalu.yhdisteet;

import java.awt.event.*;
import javax.swing.*;

/**
 * @author Tuukka Kangas
 * @version 1.0
 * @since 2015-08-23
 */
/**
 * Luokka luo ActionListener-olion, jolla voidaan suorittaa moolimassan
 * laskeminen
 */
public class KlikkauskuuntelijaLaskeMassa implements ActionListener {

    private Yhdiste yhdiste;
    private JTextField tekstikentta;
    private JTextField massakentta;

    public KlikkauskuuntelijaLaskeMassa(JTextField tekstikentta, JTextField massakentta) {
        this.tekstikentta = tekstikentta;
        this.massakentta = massakentta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String yhdisteTeksti = tekstikentta.getText();
        try {
            this.yhdiste = new Yhdiste(yhdisteTeksti);
            if (this.yhdiste.getMoolimassa() == 0.0) {
                tekstiEiKelvollinenYhdiste();
            } else {
                this.massakentta.setText("" + this.yhdiste.getMoolimassa());
            }            
        } catch (NumberFormatException ei) {
            tekstiEiKelvollinenYhdiste();
        }
    }
    
    /**
     * Asettaa halutun tekstin, jos annettu yhdiste ei ole kelvollinen
     */
    
    public void tekstiEiKelvollinenYhdiste() {
        this.massakentta.setText("Ei kelvollinen yhdiste");
    }

}
