package labratyokalu.labratyokalu.yhdisteet;

import java.util.*;
import java.util.logging.*;

/**
 * @author Tuukka Kangas
 * @version 1.0
 * @since 2015-08-27
 */
/**
 * Luokka luo yhdiste-olioita
 */
public class Yhdiste {

    private HashMap<Alkuaine, Integer> yhdisteenAlkuaineet;
    private String yhdisteenNimi;
    private ArrayList<Alkuaine> alkuaineet;
    private double moolimassa;

    public Yhdiste(String yhdiste) {
        this.yhdisteenAlkuaineet = new HashMap();
        this.yhdisteenNimi = yhdiste;
        try {
            this.alkuaineet = new AlkuaineidenLuku().alustaAlkuaineet();
        } catch (Exception ex) {
            Logger.getLogger(Yhdiste.class.getName()).log(Level.SEVERE, null, ex);
        }
        lueYhdisteenAlkuaineetJaKertoimet();
        laskeMoolimassa();
    }

    /**
     * Metodi yhdisteen alkuaineiden luvun. Metodin sisällä luetaan käyttäjän
     * antama merkkijono merkki kerrallaan läpi.
     */
    public void lueYhdisteenAlkuaineetJaKertoimet() {
        String apu = "";
        if (!onkoEnsimmainenMerkkiNumero()) {
            for (int i = 0; i < this.yhdisteenNimi.length(); i++) {
                if (onkoMerkkiKirjain(this.yhdisteenNimi.charAt(i))) {
                    apu += this.yhdisteenNimi.charAt(i);
                } else if (onkoMerkkiNumero(this.yhdisteenNimi.charAt(i))) {
                    int kerroin = palautaKerroin(i);
                    if (kuinkaMontaMerkkiaLuvussa(kerroin) > 1) {
                        i += kuinkaMontaMerkkiaLuvussa(kerroin) - 1;
                    }
                    Alkuaine aa = tunnistaAlkuaine(apu);
                    if (!onkoAlkuaineJoMolekyylikaavassa(aa)) {
                        this.yhdisteenAlkuaineet.put(aa, kerroin);
                    } else {
                        lisaysKunAlkuaineOnJoYhdisteessa(aa, kerroin);
                    }
                    apu = "";
                }
            }
        }
    }

    /**
     * Metodi palauttaa kertoimen minkä käyttäjä on antanut alkuaineelle
     *
     * @param aloituspaikka kertoo mistä kohdasta merkkijonoa metodi alkaa
     * tarkistamaan kerrointa
     * @return palauttaa kertoimen suuruuden
     */
    public int palautaKerroin(int aloituspaikka) {
        String kerroin = "";
        int laskuri = 0;
        while (true) {
            kerroin += this.yhdisteenNimi.charAt(aloituspaikka + laskuri);
            laskuri++;
            if ((laskuri + aloituspaikka) == this.yhdisteenNimi.length() || !onkoMerkkiNumero(this.yhdisteenNimi.charAt(aloituspaikka + laskuri))) {
                break;
            }
        }
        return Integer.parseInt(kerroin);
    }

    /**
     * Metodi palauttaa tiedon kuinka monta merkkiä luku sisältää
     *
     * @param luku metodille annettava parametri, jonka sisältämien merkkien
     * määrä selvitetään
     * @return palauttaa tiedon siitä kuinka monta merkkiä kerroin sisältää
     */
    public int kuinkaMontaMerkkiaLuvussa(int luku) {
        String kuinkamontaMerkkiaKertoimessaMerkkijono = luku + "";
        return kuinkamontaMerkkiaKertoimessaMerkkijono.length();
    }

    /**
     * Metodi palauttaa tiedon kuinka monta merkkiä luku sisältää
     *
     * @param etsittava on merkkijono, joka etsitään alkuaineden joukosta
     * @return palauttaa löydettyään halutun alkuaineen. Jos alkuainetta ei
     * löydy, palautetaan tyhjä olio
     */
    public Alkuaine tunnistaAlkuaine(String etsittava) {
        for (Alkuaine aa : this.alkuaineet) {
            if (etsittava.equals(aa.getLyhenne())) {
                return aa;
            }
        }
        return null;
    }

    /**
     * Metodi palauttaa tiedon onko merkki kirjain
     *
     * @param c tarkasteltava merkki
     * @return palauttaa tiedon onko annettu merkki kirjain
     */
    public boolean onkoMerkkiKirjain(Character c) {
        if (Character.isLetter(c)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodi palauttaa tiedon onko merkki numero
     *
     * @param c tarkasteltava merkki
     * @return palauttaa tiedon onko annettu merkki numero
     */
    public boolean onkoMerkkiNumero(Character c) {
        if (Character.isDigit(c)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodi palauttaa tiedon onko kyseinen alkuaine jo molekyylikaavassa
     *
     * @param aa tarkasteltava alkuaine
     * @return palauttaa tiedon onko kyseinen alkuaine jo molekyylikaavassa
     */
    public boolean onkoAlkuaineJoMolekyylikaavassa(Alkuaine aa) {
        if (this.yhdisteenAlkuaineet.containsKey(aa)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodin avulla voidaan lisätä alkuaine yhdisteen alkuaineet sisältävään
     * hajautustauluun jos se on jo aikaisemmin merkittynä.
     *
     * @param aa tarkasteltava alkuaine
     * @param lisakerroin kertoo alkuaineen stoikiometrisen kertoimen
     */
    public void lisaysKunAlkuaineOnJoYhdisteessa(Alkuaine aa, int lisakerroin) {
        int alkuKerroin = this.yhdisteenAlkuaineet.get(aa);
        this.yhdisteenAlkuaineet.remove(aa);
        this.yhdisteenAlkuaineet.put(aa, (lisakerroin + alkuKerroin));
    }

    /**
     * Metodi laskee yhdisteen moolimassan
     */
    public void laskeMoolimassa() {
        Moolimassalaskuri mmLaskuri = new Moolimassalaskuri(this.yhdisteenAlkuaineet);
        this.moolimassa = mmLaskuri.palautaYhdisteenMassa();
    }

    public double getMoolimassa() {
        if (this.moolimassa == 0) {
            System.out.println("Et syöttänyt kunnollista yhdistettä!");
        }
        return moolimassa;
    }

    public HashMap<Alkuaine, Integer> getYhdisteenAlkuaineet() {
        return yhdisteenAlkuaineet;
    }
    
    /**
     * Metodin avulla tarkistetaan onko yhdisteen ensimmäinen merkki numero
     * @return palauttaa totuusarvon
     */

    public boolean onkoEnsimmainenMerkkiNumero() {
        if (onkoMerkkiNumero(this.yhdisteenNimi.charAt(0))) {
            return true;
        } else {
            return false;
        }
    }

}
