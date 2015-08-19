
package labratyokalu.labratyokalu.ajastin;

import java.awt.*;
import java.util.*;
import labratyokalu.labratyokalu.ajastin.numerot.*;

public class GraafinenAika extends Numero {
    private ArrayList<Numero> numerot;
    
    public GraafinenAika(int x, int y, int koko, Color vari) {
        super(x, y, koko, vari);
        this.numerot = new ArrayList();
        lisaaNumero();
    }

    @Override
    public void piirra(Graphics graphics) {
        for (Numero n : this.numerot) {
            n.piirra(graphics);
        }
    }
    
    public void lisaaNumero() {
        this.numerot.add(new Yksi(30, 30, 30, Color.RED));
    }
    
}
