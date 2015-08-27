
package labratyokalu.labratyokalu.ajastin;

import java.awt.*;
import javax.swing.*;

/**
 * @author Tuukka Kangas
 * @version 1.0
 * @since 2015-08-25
 */

/**
 * Luokka luo valikon, josta voi luoda ajastimen
 */

public class AjastimenValikko implements Runnable {
    private JFrame frame;
    private JTextField tunnitKentta;
    private JTextField minuutitKentta;
    private JTextField sekunnitKentta;
    
    @Override
    public void run() {
        frame = new JFrame("Ajastin");
        frame.setPreferredSize(new Dimension(550, 200));
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(4, 2);
        lisaaAikakyselykentat(container);
        JButton luoAjastinNappi = new JButton("Luo Ajastin");
        luoAjastinNappi.addActionListener(new KlikkauskuuntelijaLuoAjastin(this.tunnitKentta, this.minuutitKentta, this.sekunnitKentta));
        container.add(luoAjastinNappi);
    }
    
    private void lisaaAikakyselykentat(Container container) {
        GridLayout layout = new GridLayout(4, 2);
        container.setLayout(layout);
        JLabel tunnitTeksti = new JLabel("Tunnit (0-99)");
        this.tunnitKentta = new JTextField("0");
        JLabel minuutitTeksti = new JLabel("Minuutit (0-60)");
        this.minuutitKentta = new JTextField("0");
        JLabel sekunnitTeksti = new JLabel("Sekunnit (0-60)");
        this.sekunnitKentta = new JTextField("0");  
        container.add(tunnitTeksti);
        container.add(tunnitKentta);
        container.add(minuutitTeksti);
        container.add(minuutitKentta);
        container.add(sekunnitTeksti);
        container.add(sekunnitKentta); 
    }
    
}
