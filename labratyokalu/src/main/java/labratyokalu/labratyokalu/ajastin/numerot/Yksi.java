package labratyokalu.labratyokalu.ajastin.numerot;

import java.awt.*;

public class Yksi extends Numero {

    public Yksi(int x, int y, int koko, Color vari) {
        super(x, y, koko, vari);
    }
    
    @Override
    public void piirra(Graphics graphics) {
        graphics.setColor(vari);
        graphics.fillRect(3 * getAlkuX() + 2, getAlkuY(), getKoko(), getKoko());
        graphics.fillRect(3 * getAlkuX() + 2, 2 * getAlkuY() + 1, getKoko(), getKoko());
        graphics.fillRect(3 * getAlkuX() + 2, 3 * getAlkuY() + 2, getKoko(), getKoko());
        graphics.fillRect(3 * getAlkuX() + 2, 4 * getAlkuY() + 3, getKoko(), getKoko());
        graphics.fillRect(3 * getAlkuX() + 2, 5 * getAlkuY() + 4, getKoko(), getKoko());
    }

}
