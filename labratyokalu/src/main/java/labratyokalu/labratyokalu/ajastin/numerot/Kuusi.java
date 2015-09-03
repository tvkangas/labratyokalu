package labratyokalu.labratyokalu.ajastin.numerot;

import java.awt.*;

/**
 * @author Tuukka Kangas
 * @version 1.0
 * @since 2015-09-02
 */
/**
 * Luokka luo Numero luokan toteuttavan olion, joka piirtää numeron kuusi
 */
public class Kuusi extends Numero {

    public Kuusi(int x, int y, int koko, Color vari) {
        super(x, y, koko, vari);
    }

    @Override
    public void piirra(Graphics graphics) {
        graphics.setColor(vari);
        graphics.fillRect(getAlkuX(), getAlkuY(), getKoko(), getKoko());
        graphics.fillRect(getAlkuX(), getKoko() + getAlkuY() + 1, getKoko(), getKoko());
        graphics.fillRect(getAlkuX(), 2 * getKoko() + getAlkuY() + 2, getKoko(), getKoko());
        graphics.fillRect(getAlkuX(), 3 * getKoko() + getAlkuY() + 3, getKoko(), getKoko());
        graphics.fillRect(getAlkuX(), 4 * getKoko() + getAlkuY() + 4, getKoko(), getKoko());
        graphics.fillRect(getKoko() + getAlkuX() + 1, getAlkuY(), getKoko(), getKoko());
        graphics.fillRect(getKoko() + getAlkuX() + 1, 2 * getKoko() + getAlkuY() + 2, getKoko(), getKoko());
        graphics.fillRect(getKoko() + getAlkuX() + 1, 4 * getKoko() + getAlkuY() + 4, getKoko(), getKoko());
        graphics.fillRect(2 * getKoko() + getAlkuX() + 2, getAlkuY(), getKoko(), getKoko());
        graphics.fillRect(2 * getKoko() + getAlkuX() + 2, 2 * getKoko() + getAlkuY() + 2, getKoko(), getKoko());
        graphics.fillRect(2 * getKoko() + getAlkuX() + 2, 3 * getKoko() + getAlkuY() + 3, getKoko(), getKoko());
        graphics.fillRect(2 * getKoko() + getAlkuX() + 2, 4 * getKoko() + getAlkuY() + 4, getKoko(), getKoko());

    }

}
