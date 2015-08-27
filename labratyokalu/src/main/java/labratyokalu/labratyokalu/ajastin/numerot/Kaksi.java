package labratyokalu.labratyokalu.ajastin.numerot;

import java.awt.*;

public class Kaksi extends Numero {

    public Kaksi(int x, int y, int koko, Color vari) {
        super(x, y, koko, vari);
    }

    @Override
    public void piirra(Graphics graphics) {
        graphics.setColor(vari);
        graphics.fillRect(getAlkuX(), getAlkuY(), getKoko(), getKoko());
        graphics.fillRect(getAlkuX(), 2 * getKoko() + getAlkuY() + 2, getKoko(), getKoko());
        graphics.fillRect(getAlkuX(), 3 * getKoko() + getAlkuY() + 3, getKoko(), getKoko());
        graphics.fillRect(getAlkuX(), 4 * getKoko() + getAlkuY() + 4, getKoko(), getKoko());
        graphics.fillRect(getKoko() + getAlkuX() + 1, getAlkuY(), getKoko(), getKoko());
        graphics.fillRect(getKoko() + getAlkuX() + 1, 4 * getKoko() + getAlkuY() + 4, getKoko(), getKoko());
        graphics.fillRect(getKoko() + getAlkuX() + 1, 2 * getKoko() + getAlkuY() + 2, getKoko(), getKoko());
        graphics.fillRect(2 * getKoko() + getAlkuX() + 2, getAlkuY(), getKoko(), getKoko());
        graphics.fillRect(2 * getKoko() + getAlkuX() + 2, getKoko() + getAlkuY() + 1, getKoko(), getKoko());
        graphics.fillRect(2 * getKoko() + getAlkuX() + 2, 2 * getKoko() + getAlkuY() + 2, getKoko(), getKoko());
        graphics.fillRect(2 * getKoko() + getAlkuX() + 2, 4 * getKoko() + getAlkuY() + 4, getKoko(), getKoko());
    }

}
