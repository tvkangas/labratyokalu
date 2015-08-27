package labratyokalu.labratyokalu.ajastin.numerot;

import java.awt.*;

public class Kaksoispiste extends Numero {

    public Kaksoispiste(int x, int y, int koko, Color vari) {
        super(x, y, koko, vari);
    }
    
    @Override
    public void piirra(Graphics graphics) {
        graphics.setColor(vari);
        graphics.fillRect(getKoko() + getAlkuX() + 1, getKoko() + getAlkuY() + 2, getKoko(), getKoko());
        graphics.fillRect(getKoko() + getAlkuX() + 1, 3 * getKoko() + getAlkuY() + 4, getKoko(), getKoko());

    }

}
