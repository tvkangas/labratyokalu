package labratyokalu.labratyokalu.laskin;

import java.text.*;

// import statements
/**
 * @author Tuukka Kangas
 * @version 1.0
 * @since 2015-08-18
 */

/**
 * Luokka luo laskin-olioita, joille on erilaisia toiminnallisuuksia
 */

public class Laskin {

    private double arvo;

    public Laskin(double alkuarvo) {
        this.arvo = alkuarvo;
    }

    public Laskin() {
        this.arvo = 0;
    }

    /**
     * Metodi lisaa attribuutin arvoon annetun parametrin arvon
     *
     * @param lisattava Käyttäjän antama lisättävä luku
     *
     */
    public void lisaa(double lisattava) {
        this.arvo += lisattava;
    }

    /**
     * Metodi vahenaa attribuutin arvosta annetun parametrin arvon
     *
     * @param vahennettava Käyttäjän antama vähennettävä luku
     *
     */
    public void vahenna(double vahennettava) {
        this.arvo -= vahennettava;
    }
    
    /**
     * Metodi kertoo attribuutin arvon annetun parametrin arvolla
     *
     * @param kertoja Käyttäjän antama kertoja
     *
     */

    public void kerro(double kertoja) {
        this.arvo = this.arvo * kertoja;
    }
    
    /**
     * Metodi jakaa attribuutin arvon annetulla parametrin arvolla
     *
     * @param jakaja Käyttäjän antama jakaja
     *
     */

    public void jaa(double jakaja) {
        this.arvo = this.arvo / jakaja;
    }
    
    /**
     * Metodi korottaa attribuutin arvon annettuun potenssiin
     *
     * @param potenssi Käyttäjän antama potenssi
     *
     */

    public void korotaPotenssiin(double potenssi) {
        this.arvo = Math.pow(this.arvo, potenssi);
    }
    
    /**
     * Metodin avulla voidaan pyöristää luku
     *
     * @param monella Käyttäjän antama luku, jonka tarkkuudella pyöristys tapahtuu
     *
     */

    public void pyorista(int monella) {
        String arvoApu = "1";
        for (int i = 0; i < monella; i++) {
            arvoApu = arvoApu + "0";
        }
        int apu = Integer.parseInt(arvoApu);
        this.arvo = (double) (Math.round(this.arvo * apu)) / apu;

//        String apuMonella = "#.";
//        for (int i = 0; i < monella; i++) {
//            apuMonella = apuMonella + "0";
//        }
//        
//        DecimalFormat df = new DecimalFormat(apuMonella);
    }

    public double getArvo() {
        return this.arvo;
    }
    
    /**
     * Metodi nollaa attribuutin arvon
     *
     */

    public void nollaa() {
        this.arvo = 0;
    }

}
