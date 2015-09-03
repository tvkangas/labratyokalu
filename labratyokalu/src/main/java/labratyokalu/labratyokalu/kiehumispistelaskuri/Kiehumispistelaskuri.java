package labratyokalu.labratyokalu.kiehumispistelaskuri;

/**
 * @author Tuukka Kangas
 * @version 1.0
 * @since 2015-09-01
 */
/**
 * Luokka luo kiehumispistelaskurin
 */
public class Kiehumispistelaskuri {

    private static final double kaasuvakio = 8.31446;
    private double alkupaine;
    private double alkulampotila;
    private double loppupaine;
    private double hoyrynpaine;

    public Kiehumispistelaskuri(double alkupaine, double alkulampotila, double loppupaine, double hoyrynpaine) {
        this.alkupaine = alkupaine;
        this.alkulampotila = alkulampotila;
        this.loppupaine = loppupaine;
        this.hoyrynpaine = hoyrynpaine;
    }

    public double getKaasuvakio() {
        return this.kaasuvakio;
    }

    /**
     * Metodi palauttaa arvon käänteisluvun
     *
     * @param arvo luku, josta käänteisluku halutaan
     * @return käänteisluku
     */
    public double palautaKaanteisarvo(double arvo) {
        return 1 / arvo;
    }

    /**
     * Metodi palauttaa luvun luonnollisen logaritmin
     * @param luku luku, jonka logaritmi etsitään
     * @return luonnollinen logaritmi
     */
    public double palautaLuonnollinenLogaritmi(double luku) {
        return Math.log(luku);
    }

    /**
     * Metodi palauttaa uuden kiehumispisteen
     *
     * @return uusi kiehusmipiste
     */
    public double laskeUusiKiehumispiste() {
        double uusiKiehumispiste = palautaKaanteisarvo(-palautaLuonnollinenLogaritmi(this.loppupaine / this.alkupaine) * palautaKaasuvakionJaHoyrynpaineenSuhde()
                + palautaKaanteisarvo(muutaCelsiusKelviniksi(this.alkulampotila)));
        return muutaKelvinCelsiukseksi(uusiKiehumispiste);
    }

    /**
     * Metodi palauttaa kaasuvakion ja höyrynpaineen suhteen R/dH
     *
     * @return suhde R/dH
     */
    public double palautaKaasuvakionJaHoyrynpaineenSuhde() {
        return getKaasuvakio() / this.hoyrynpaine;
    }

    /**
     * Metodi muuttaa Celsius-asteet Kelvineiksi
     *
     * @param luku muutettava luku
     * @return muutettu luku
     */
    public double muutaCelsiusKelviniksi(double luku) {
        return luku + 273.15;
    }

    /**
     * Metodi muuttaa Kelvin-asteeet Celsius-asteeksi
     *
     * @param luku muutettava luku
     * @return muutettu luku
     */
    public double muutaKelvinCelsiukseksi(double luku) {
        return luku - 273.15;
    }

}
