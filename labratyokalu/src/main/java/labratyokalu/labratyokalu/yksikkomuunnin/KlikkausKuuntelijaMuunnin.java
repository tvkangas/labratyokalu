package labratyokalu.labratyokalu.yksikkomuunnin;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.Object.*;

public class KlikkausKuuntelijaMuunnin implements ActionListener {

    private Yksikkomuunnin yksikkomuunnin;
    private JButton nappi;
    private JTextField tekstikentta;
    private JTextField tuloskentta;

    public KlikkausKuuntelijaMuunnin(Yksikkomuunnin yksikkomuunnin, JTextField tekstikentta, JTextField tuloskentta, JButton nappi) {
        this.yksikkomuunnin = yksikkomuunnin;
        this.tekstikentta = tekstikentta;
        this.tuloskentta = tuloskentta;
        this.nappi = nappi;
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
