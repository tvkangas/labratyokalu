package labratyokalu.labratyokalu.ajastin.numerot;

import java.awt.*;

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
    
    public int getKoko() {
        return this.koko;
    }
    
    public abstract void piirra(Graphics graphics);

}
