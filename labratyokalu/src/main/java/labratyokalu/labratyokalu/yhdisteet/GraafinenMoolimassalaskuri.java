package labratyokalu.labratyokalu.yhdisteet;

import labratyokalu.labratyokalu.yhdisteet.*;
import java.awt.*;
import javax.swing.*;

/**
 * @author Tuukka Kangas
 * @version 1.0
 * @since 2015-08-23
 */
/**
 * Luokka luo graafisen valikon, jossa voi suorittaa moolimassan laskemisen
 */
public class GraafinenMoolimassalaskuri implements Runnable {

    private JFrame frame;
    private JTextField tekstikentta;
    private JTextField massakentta;
    
    public GraafinenMoolimassalaskuri() {
        this.tekstikentta = new JTextField("Kirjoita tähän yhdisteesi. Huomioi, että merkitset numeron 1 (esim. vesi H2O1)");
        this.massakentta = new JTextField("");
    }

    @Override
    public void run() {
        frame = new JFrame("Moolimassalaskuri");
        frame.setPreferredSize(new Dimension(550, 200));
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);     
    }
    
    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(3, 1);
        container.setLayout(layout);
        this.massakentta.setEnabled(false);          
        container.add(this.massakentta);        
        container.add(this.tekstikentta);
        JButton laskuNappain = new JButton("Laske massa");
        laskuNappain.addActionListener(new KlikkauskuuntelijaLaskeMassa(this.tekstikentta, this.massakentta));
        container.add(laskuNappain);
    }
    
    public JFrame getFrame() {
        return frame;
    }

}
