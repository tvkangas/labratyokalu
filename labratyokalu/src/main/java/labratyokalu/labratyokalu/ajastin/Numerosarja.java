package labratyokalu.labratyokalu.ajastin;

/**
 * @author Tuukka Kangas
 * @version 1.0
 * @since 2015-08-25
 */
/**
 * Luokan tarkoituksena on luoda olio, joka koostuu Numero-olioista
 */
import java.awt.*;
import java.util.*;
import labratyokalu.labratyokalu.ajastin.*;
import labratyokalu.labratyokalu.ajastin.numerot.*;

public class Numerosarja extends Numero {

    private ArrayList<Numero> numerot;
    private Ajastin ajastin;

    public Numerosarja(Ajastin a) {
        super(100, 100, 100, Color.WHITE);
        this.numerot = new ArrayList();
        this.ajastin = a;
    }

    /**
     * Metodin avulla voidaan lisätä numero numerosarjaan
     * @param nro annettu numero
     */
    
    public void lisaaNumero(Numero nro) {
        this.numerot.add(nro);
    }
    
    /**
     * Metodin avulla voidaan piirtää numero
     * @param graphics kertoo, että kyseessä on piirrettävä olio
     */

    @Override
    public void piirra(Graphics graphics) {
        paivitaNumerot();
        for (Numero nro : this.numerot) {
            nro.piirra(graphics);
        }
    }

    /**
     * Metodin avulla päivitetään numerot
     */
    
    public void paivitaNumerot() {
        tyhjennaNumerot();
        int koko = 20;
        Color vari = Color.RED;
        lisaaNumero(muutaNumeroksi(this.ajastin.getTunnitKymmenet(), 20, 20, koko, vari));
        lisaaNumero(muutaNumeroksi(this.ajastin.getTunnitYkkoset(), 90, 20, koko, vari));
        lisaaNumero(new Kaksoispiste(140, 20, koko, vari));
        lisaaNumero(muutaNumeroksi(this.ajastin.getMinuutitKymmenet(), 190, 20, koko, vari));
        lisaaNumero(muutaNumeroksi(this.ajastin.getMinuutitYkkoset(), 260, 20, koko, vari));
        lisaaNumero(new Kaksoispiste(310, 20, koko, vari));
        lisaaNumero(muutaNumeroksi(this.ajastin.getSekunnitKymmenet(), 360, 20, koko, vari));
        lisaaNumero(muutaNumeroksi(this.ajastin.getSekunnitYkkoset(), 430, 20, koko, vari));
    }
    
    /**
     * Metodi muuttaa numeron luvuksi
     */

    public Numero muutaNumeroksi(int luku, int x, int y, int koko, Color vari) {
        if (luku == 1) {
            return new Yksi(x, y, koko, vari);
        } else if (luku == 2) {
            return new Kaksi(x, y, koko, vari);
        } else if (luku == 3) {
            return new Kolme(x, y, koko, vari);
        } else if (luku == 4) {
            return new Nelja(x, y, koko, vari);
        } else if (luku == 5) {
            return new Viisi(x, y, koko, vari);
        } else if (luku == 6) {
            return new Kuusi(x, y, koko, vari);
        } else if (luku == 7) {
            return new Seitseman(x, y, koko, vari);
        } else if (luku == 8) {
            return new Kahdeksan(x, y, koko, vari);
        } else if (luku == 9) {
            return new Yhdeksan(x, y, koko, vari);
        } else if (luku == 0) {
            return new Nolla(x, y, koko, vari);
        } else {
            return null;
        }
    }
    
    /**
     * Metodin avulla poistaa edelliset numerot pois listasta
     */

    public void tyhjennaNumerot() {
        this.numerot.clear();
    }

}
