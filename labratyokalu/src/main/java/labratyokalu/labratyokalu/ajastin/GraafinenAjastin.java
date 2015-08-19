package labratyokalu.labratyokalu.ajastin;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import labratyokalu.labratyokalu.ajastin.*;
import labratyokalu.labratyokalu.ajastin.numerot.Yksi;

public class GraafinenAjastin implements Runnable {
    
    private JFrame frame;
    private Ajastin ajastin;
    private PiirtoalustaAjastin piirtoalusta;
    private GraafinenAika graafinenAika;

    @Override
    public void run() {
        // ÄLÄ MUUTA TÄÄLLÄ OLEVAA KOODIA!!
        frame = new JFrame("Ajastin");
        frame.setPreferredSize(new Dimension(750, 220));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoKomponentit(Container container) {
        piirtoalusta = new PiirtoalustaAjastin(graafinenAika);
        container.add(piirtoalusta);
    }    

    public JFrame getFrame() {
        return frame;
    }

}
