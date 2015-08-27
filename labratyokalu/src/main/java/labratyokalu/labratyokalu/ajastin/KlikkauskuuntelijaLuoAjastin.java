
package labratyokalu.labratyokalu.ajastin;

import java.awt.event.*;
import javax.swing.*;

/**
 * @author      Tuukka Kangas 
 * @version     1.0                 
 * @since       2015-08-27         
 */

/**
 * Luokka luo ActionListener-olion, jolla voidaan luoda ajastin
 */

public class KlikkauskuuntelijaLuoAjastin implements ActionListener {
    private JTextField tuntiKentta;
    private JTextField minuttiKentta;
    private JTextField sekuntiKentta;

    public KlikkauskuuntelijaLuoAjastin(JTextField tuntiKentta, JTextField minuttiKentta, JTextField sekuntiKentta) {
        this.tuntiKentta = tuntiKentta;
        this.minuttiKentta = minuttiKentta;
        this.sekuntiKentta = sekuntiKentta;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        GraafinenAjastin gAj = new GraafinenAjastin(new Ajastin(Integer.parseInt(tuntiKentta.getText()), Integer.parseInt(minuttiKentta.getText()), Integer.parseInt(sekuntiKentta.getText())));
        gAj.run();
    }
    
}
