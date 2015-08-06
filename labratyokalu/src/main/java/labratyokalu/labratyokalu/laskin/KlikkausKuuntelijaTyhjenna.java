
package labratyokalu.labratyokalu.laskin;

import java.awt.event.*;
import javax.swing.*;

public class KlikkausKuuntelijaTyhjenna implements ActionListener {
    
    private Laskin laskin;
    private JTextField tekstikentta;
    private JTextField tuloskentta;
    private JButton nappi;

    public KlikkausKuuntelijaTyhjenna(Laskin laskin, JTextField tekstikentta, JTextField tuloskentta, JButton nappi) {
        this.laskin = laskin;
        this.tekstikentta = tekstikentta;
        this.tuloskentta = tuloskentta;
        this.nappi = nappi;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.laskin.nollaa();
        this.tuloskentta.setText("" + this.laskin.getArvo());
        this.tekstikentta.setText("");
        String teksti2 = this.tuloskentta.getText();
        
        if (!teksti2.equals("0")) {
            this.nappi.setEnabled(true);
        } else {
            this.nappi.setEnabled(false);
        }
    }
    
}
