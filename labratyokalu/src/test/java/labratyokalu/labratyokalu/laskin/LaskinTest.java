package labratyokalu.labratyokalu.laskin;

import java.text.DecimalFormat;
import labratyokalu.labratyokalu.laskin.*;
import labratyokalu.labratyokalu.laskin.Laskin;
import labratyokalu.labratyokalu.laskin.Laskin;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Tuukka
 */
public class LaskinTest {

    Laskin laskin;

    public LaskinTest() {
        laskin = new Laskin(1.0);
    }
    
    @Test
    public void parametritonKonstruktoriToimii() {
        Laskin testiLaskin = new Laskin();
        assertEquals(0.0, testiLaskin.getArvo(), 0.00001);
    }

    @Test
    public void alkuArvoOikein() {
        assertEquals(1.0, laskin.getArvo(), 0.00001);
    }

    @Test
    public void positiivisenNumeronLisaysOnnistuu() {
        laskin.lisaa(1.0);
        assertEquals(2.0, laskin.getArvo(), 0.00001);
    }

    @Test
    public void negatiivisenNumeronLisaysOnnistuu() {
        laskin.lisaa(-2.0);
        assertEquals(-1.0, laskin.getArvo(), 0.00001);
    }

    @Test
    public void nollanLisaysOnnistuu() {
        laskin.lisaa(0);
        assertEquals(1.0, laskin.getArvo(), 0.00001);
    }

    @Test
    public void positiivisenNumeronVahennysOnnistuu() {
        laskin.vahenna(2.0);
        assertEquals(-1.0, laskin.getArvo(), 0.00001);
    }

    @Test
    public void negatiivisenNumeronVahennysOnnistuu() {
        laskin.vahenna(-1.0);
        assertEquals(2.0, laskin.getArvo(), 0.00001);
    }

    @Test
    public void nollaVahennysOnnistuu() {
        laskin.vahenna(0);
        assertEquals(1.0, laskin.getArvo(), 0.00001);
    }

    @Test
    public void positiivisenNumeronKertominenOnnistuu() {
        laskin.kerro(2);
        assertEquals(2.0, laskin.getArvo(), 0.00001);
    }

    @Test
    public void negatiivisenNumeronKertominenOnnistuu() {
        laskin.kerro(-2);
        assertEquals(-2.0, laskin.getArvo(), 0.00001);
    }

    @Test
    public void nollaKertominenOnnistuu() {
        laskin.kerro(0);
        assertEquals(0.0, laskin.getArvo(), 0.00001);
    }

    @Test
    public void positiivinenNumeroJakaminenOnnistuu() {
        laskin.jaa(0.5);
        assertEquals(2.0, laskin.getArvo(), 0.00001);
    }

    @Test
    public void negatiivinenNumeroJakaminenOnnistuu() {
        laskin.jaa(-0.5);
        assertEquals(-2.0, laskin.getArvo(), 0.00001);
    }

    @Test
    public void positiivinenNumeroPotenssiinKorotusOnnistuu() {
        laskin.lisaa(1.0);
        laskin.korotaPotenssiin(2);
        assertEquals(4, laskin.getArvo(), 0.00001);
    }

    @Test
    public void negatiivinenNumeroPotenssiinKorotusOnnistuu() {
        laskin.lisaa(1.0);
        laskin.korotaPotenssiin(-2);
        assertEquals(0.25, laskin.getArvo(), 0.00001);
    }

    @Test
    public void nollaPotenssiinKorotusOnnistuu() {
        laskin.lisaa(1.0);
        laskin.korotaPotenssiin(0);
        assertEquals(1.0, laskin.getArvo(), 0.00001);
    }

    @Test
    public void pyoristysOnnistuu() {
        laskin.lisaa(0.001);
        laskin.pyorista(2);
        assertEquals(1.00, laskin.getArvo(), 0.00001);
    }

    @Test
    public void pyoristysOnnistuu2() {
        laskin.lisaa(0.007);
        laskin.pyorista(2);
        assertEquals(1.01, laskin.getArvo(), 0.00001);
    }

    @Test
    public void nollausOnnistuu() {
        laskin.nollaa();
        assertEquals(0.0, laskin.getArvo(), 0.00001);
    }

    @Test
    public void monivaiheinenLaskuonnistuu() {
        laskin.lisaa(1.0);
        laskin.kerro(3.0);
        laskin.vahenna(2);
        laskin.jaa(5);
        assertEquals(0.8, laskin.getArvo(), 0.00001);
    }

}
