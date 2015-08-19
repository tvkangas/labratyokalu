package labratyokalu.labratyokalu.ajastin;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PiirtoalustaAjastin extends JPanel {
    
    private GraafinenAika graafinenAika;

    public PiirtoalustaAjastin(GraafinenAika ga) {
        super.setBackground(Color.WHITE);
        this.graafinenAika = ga;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graafinenAika.piirra(graphics);
    }
    
}
