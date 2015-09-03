package labratyokalu.labratyokalu.yksikkomuunnin;

/**
 * @author Tuukka Kangas
 * @version 1.0
 * @since 2015-08-18
 */
/**
 * Luokka luo Yksikkömuunnin-olioita, joiden avulla voidaan suorittaa
 * yksikkömuunnoksia sekä kertoimilla että vakiotermein
 */

public class Yksikkomuunnin {

    double kerroin;
    double vakiotermi;
    String mista;
    String mihin;

    public Yksikkomuunnin(double k, double vk, String mista, String mihin) {
        this.kerroin = k;
        this.vakiotermi = vk;
        this.mista = mista;
        this.mihin = mihin;
    }

    /**
     * Metodi muuntaa luvun annettujen oliomuuttujien mukaan
     *
     * @param muunnettava metodi saa parametrin arvona muunnettava luvun
     * @return palauttaa muunnetun luvun
     */
    public double muunna(double muunnettava) {
        return muunnettava * this.kerroin + this.vakiotermi;
    }

    public String getYksikko() {
        return this.mihin;
    }

    public String getMista() {
        return this.mista;
    }

    public double getKerroin() {
        return this.kerroin;
    }

}
