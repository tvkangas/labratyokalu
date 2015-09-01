package labratyokalu.labratyokalu.yhdisteet;

import labratyokalu.labratyokalu.yhdisteet.Alkuaine;
import java.util.*;

/**
 * @author Tuukka Kangas
 * @version 1.0
 * @since 2015-08-21
 */
/**
 * Luokka luo moolimassalaskuri-olion. Sen avulla voidaan laskea jonkin
 * yhdisteen moolimassa
 */
public class Moolimassalaskuri {

    private HashMap<Alkuaine, Integer> yhdisteenAlkuaineet;

    public Moolimassalaskuri(HashMap<Alkuaine, Integer> alkuaineet) {
        this.yhdisteenAlkuaineet = alkuaineet;
    }

    /**
     * Metodi suoritta kertolaskun
     *
     *
     * @param kerroin, kuinka monta kertaa ko massa pitää kertoa
     * @param kerrottavaMassa, kerrottava massa
     * @return tulo
     */
    public double suoritaKertolasku(int kerroin, double kerrottavaMassa) {
        return 1.0 * kerroin * kerrottavaMassa;
    }

    /**
     * Metodi suoritta kertolaskun
     *
     *
     * @return moolimassa
     */
    public double palautaYhdisteenMassa() {
        double moolimassa = 0;
        for (Alkuaine aa : this.yhdisteenAlkuaineet.keySet()) {
            moolimassa += suoritaKertolasku(this.yhdisteenAlkuaineet.get(aa), aa.getMassa());
        }
        return moolimassa;
    }

}
