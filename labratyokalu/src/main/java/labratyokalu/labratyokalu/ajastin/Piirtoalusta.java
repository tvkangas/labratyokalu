
package labratyokalu.labratyokalu.ajastin;

import java.awt.*;
import javax.swing.JPanel;
import labratyokalu.labratyokalu.ajastin.numerot.*;

/**
 * @author Tuukka Kangas
 * @version 1.0
 * @since 2015-08-25
 */

/**
 * Luokka luo piirtoalustan ajastimen piirtämistä varten
 */

public class Piirtoalusta extends JPanel {
    private Numero numerosarja;
    
    public Piirtoalusta(Numero numerosarja) {
        super.setBackground(Color.BLACK);
        this.numerosarja = numerosarja;
    }
    
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        numerosarja.piirra(graphics);
    }
    
}
