package labratyokalu.labratyokalu.yksikkomuunnin;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.Object.*;

/**
 * @author      Tuukka Kangas 
 * @version     1.0                 
 * @since       2015-08-18          
 */

/**
 * Luokka luo ActionListener-olion, jolla voidaan toteuttaa yksikkömuunnos
 */

public class KlikkausKuuntelijaMuunnin implements ActionListener {

    private Yksikkomuunnin yksikkomuunnin;
    private JTextField tekstikentta;
    private JTextField tuloskentta;

    public KlikkausKuuntelijaMuunnin(Yksikkomuunnin yksikkomuunnin, JTextField tekstikentta, JTextField tuloskentta) {
        this.yksikkomuunnin = yksikkomuunnin;
        this.tekstikentta = tekstikentta;
        this.tuloskentta = tuloskentta;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String teksti = tekstikentta.getText();
        try {
            double luku = Double.parseDouble(teksti);
            double muunnettu = this.yksikkomuunnin.muunna(luku);
            this.tuloskentta.setText("" + muunnettu + " " + this.yksikkomuunnin.getYksikko());
        } catch (NumberFormatException ei) {
            this.tekstikentta.setText("");
        }
    }

}
