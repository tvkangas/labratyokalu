
package labratyokalu.labratyokalu.laskin;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.Object.*;

// import statements

/**
 * @author      Tuukka Kangas 
 * @version     1.0                 
 * @since       2015-08-18          
 */

/**
 * Luokka luo ActionListener-olion, jolla voidaan korottaa potenssiin
 */

public class KlikkausKuuntelijaPotenssi implements ActionListener {

    private Laskin laskin;
    private JTextField tekstikentta;
    private JTextField tuloskentta;
    private JButton nappi;

    public KlikkausKuuntelijaPotenssi(Laskin laskin, JTextField tekstikentta, JTextField tuloskentta, JButton nappi) {
        this.laskin = laskin;
        this.tekstikentta = tekstikentta;
        this.tuloskentta = tuloskentta;
        this.nappi = nappi;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String teksti = tekstikentta.getText();
        try {
            double luku = Double.parseDouble(teksti);
            this.laskin.korotaPotenssiin(luku);
            this.tuloskentta.setText("" + this.laskin.getArvo());
            this.tekstikentta.setText("");
        } catch (NumberFormatException ei) {
            this.tekstikentta.setText("");
        }

        String teksti2 = this.tuloskentta.getText();
        if (!teksti2.equals("0")) {
            this.nappi.setEnabled(true);
        } else {
            this.nappi.setEnabled(false);
        }
    }

}