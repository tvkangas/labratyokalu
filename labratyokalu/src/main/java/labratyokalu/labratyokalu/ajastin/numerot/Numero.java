package labratyokalu.labratyokalu.ajastin.numerot;

import java.awt.*;

/**
 * @author Tuukka Kangas
 * @version 1.0
 * @since 2015-09-02
 */
/**
 * Luokka luo abstraktin luokan Numero, jonka avulla voidaan piirtää erilaisia
 * numeroita
 */
public abstract class Numero {

    private int alkuX;
    private int alkuY;
    private int koko;
    Color vari;

    public Numero(int x, int y, int koko, Color vari) {
        this.alkuX = x;
        this.alkuY = y;
        this.koko = koko;
        this.vari = vari;
    }

    public int getAlkuX() {
        return this.alkuX;
    }

    public int getAlkuY() {
        return this.alkuY;
    }
    
    /**
     * Palauttaa yhden neliön koon
     * @return palauttaa koon
     */

    public int getKoko() {
        return this.koko;
    }
    
    /**
     * Abstrakti metodi, jonka piirretään luokan toteuttavien olioiden kuvio
     * @param graphics kertoo, että kyseessä on piirrettävä olio
     */

    public abstract void piirra(Graphics graphics);

}
