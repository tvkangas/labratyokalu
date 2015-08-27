
package labratyokalu.labratyokalu.ajastin;

import labratyokalu.labratyokalu.ajastin.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class AjastinTest {
    
    Ajastin ajastin;
    
    public AjastinTest() {
        ajastin = new Ajastin(1,10,15);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriToimii() {
        assertEquals("1:10:15", ajastin.toString());
    }
        
    @Test
    public void parametritonKonstruktoriToimii() {
        Ajastin a = new Ajastin();
        assertEquals("0:0:0", a.toString());
    }
    
    @Test
    public void metodiOnkoSekunnitNollaToimiiTrue() {
        for (int i = 0; i < 15; i++) {
            ajastin.sekuntiKuluu();
        }
        assertEquals(true, ajastin.onkoSekunnitNolla());
    }
    
    @Test
    public void metodiOnkoSekunnitNollaToimiiFalse() {
        for (int i = 0; i < 14; i++) {
            ajastin.sekuntiKuluu();
        }
        assertEquals(false, ajastin.onkoSekunnitNolla());
    }
    
    @Test
    public void metodiOnkoMinuutitNollaToimiiFalse() {
        assertEquals(false, ajastin.onkoMinuutitNolla());
    }
    
    @Test
    public void metodiOnkoTunnitNollaToimiiFalse() {
        for (int i = 0; i < 14; i++) {
            ajastin.sekuntiKuluu();
        }
        assertEquals(false, ajastin.onkoTunnitNolla());
    }
    
    @Test
    public void eteneminenToimiiYhdenAskeleen() {
        ajastin.sekuntiKuluu();
        assertEquals("1:10:14", ajastin.toString());
    }
    
    @Test
    public void eteneminenToimiiKunMinuutitMeneeAlleNollan() {
        Ajastin a = new Ajastin(1,0,0);
        a.sekuntiKuluu();
        assertEquals("0:59:59", a.toString());
    }
    
    @Test
    public void eteneminenToimiiKunMinuutitMeneeAlleNollanJaTuntejaYliNolla() {
        Ajastin a = new Ajastin(3,0,0);
        a.sekuntiKuluu();
        assertEquals("2:59:59", a.toString());
    }
    
    @Test
    public void eteneminenPysahtyyKunKaikkiNolla() {
        Ajastin a = new Ajastin(0,0,1);
        a.sekuntiKuluu();
        assertEquals(true, a.onkoAjastinNolla());
    }
    
    @Test
    public void getTunnitKymmenetToimiiVahintaanKymmenen() {
        Ajastin a = new Ajastin (12,34,56);
        assertEquals(1, a.getTunnitKymmenet());
    }
    
    @Test
    public void getTunnitKymmenetToimiiAlleKymmenen() {
        Ajastin a = new Ajastin (2,34,56);
        assertEquals(0, a.getTunnitKymmenet());
    }
    
    @Test
    public void getTunnitYkkosetToimii() {
        Ajastin a = new Ajastin (12,34,56);
        assertEquals(2, a.getTunnitYkkoset());
    }
    
    @Test
    public void getMinuutitKymmenetToimiiVahintaanKymmenen() {
        Ajastin a = new Ajastin (12,34,56);
        assertEquals(3, a.getMinuutitKymmenet());
    }
    
    @Test
    public void getMinuutitKymmenetToimiiAlleKymmenen() {
        Ajastin a = new Ajastin (12,4,56);
        assertEquals(0, a.getMinuutitKymmenet());
    }
    
    @Test
    public void getMinuutitYkkosetToimii() {
        Ajastin a = new Ajastin (12,34,56);
        assertEquals(4, a.getMinuutitYkkoset());
    }
    
    @Test
    public void getSekunnitKymmenetToimiiVahintaanKymmenen() {
        Ajastin a = new Ajastin (12,34,56);
        assertEquals(5, a.getSekunnitKymmenet());
    }
    
    @Test
    public void getSekunnitKymmenetToimiiAlleKymmenen() {
        Ajastin a = new Ajastin (12,34,6);
        assertEquals(0, a.getSekunnitKymmenet());
    }
    
    @Test
    public void getSekunnitYkkosetToimii() {
        Ajastin a = new Ajastin (12,34,56);
        assertEquals(6, a.getSekunnitYkkoset());
    }
    
    @Test
    public void getTunnitKymmenetToimiiKymmenella() {
        Ajastin a = new Ajastin (10,10,10);
        assertEquals(1, a.getTunnitKymmenet());
    }
    
    @Test
    public void getMinuutitKymmenetToimiiKymmenella() {
        Ajastin a = new Ajastin (10,10,10);
        assertEquals(1, a.getMinuutitKymmenet());
    }
    
    @Test
    public void getSekunnitKymmenetToimiiKymmenella() {
        Ajastin a = new Ajastin (10,10,10);
        assertEquals(1, a.getSekunnitKymmenet());
    }
    
    @Test
    public void getTunnitYkkosetToimiiKymmenella() {
        Ajastin a = new Ajastin (10,10,10);
        assertEquals(0, a.getTunnitYkkoset());
    }
    
    @Test
    public void getMinuutitYkkosetToimiiKymmenella() {
        Ajastin a = new Ajastin (10,10,10);
        assertEquals(0, a.getMinuutitYkkoset());
    }
    
    @Test
    public void getSekunnitYkkosetToimiiKymmenella() {
        Ajastin a = new Ajastin (10,10,10);
        assertEquals(0, a.getSekunnitYkkoset());
    }
    
    @Test
    public void getSekunnitYkkosetToimiiNollalla() {
        Ajastin a = new Ajastin (10,10,0);
        assertEquals(0, a.getSekunnitYkkoset());
    }
    
    @Test
    public void getMinuutitYkkosetToimiiNollalla() {
        Ajastin a = new Ajastin (10,0,10);
        assertEquals(0, a.getMinuutitYkkoset());
    }
    
    @Test
    public void getTunnitYkkosetToimiiNollalla() {
        Ajastin a = new Ajastin (0,10,10);
        assertEquals(0, a.getTunnitYkkoset());
    }
    
    @Test
    public void setTunnitToimii() {
        ajastin.setTunnit(3);
        assertEquals(3, ajastin.getTunnit());
    }
    
    @Test
    public void setMinuutitToimii() {
        ajastin.setMinuutit(3);
        assertEquals(3, ajastin.getMinuutit());
    }
    
    @Test
    public void setSekunnitToimii() {
        ajastin.setSekunnit(3);
        assertEquals(3, ajastin.getSekunnit());
    }
    
    @Test
    public void metodiOnkoMinuutitAlleNollaToimiiNollalla() {
        ajastin.setMinuutit(0);
        assertEquals(false, ajastin.onkoMinuutitAlleNolla());
    }
    
    @Test
    public void metodiKorjaaAjatTomiiiLiianSuurillaNumeroilla() {
        Ajastin a = new Ajastin(199,99,99);
        assertEquals("99:60:0", a.toString());
    }
    
    @Test
    public void metodiKorjaaAjatToimiiMinuuteilleSekuntienOllessaNolla() {
        Ajastin a = new Ajastin(10,67,0);
        assertEquals("10:60:0", a.toString());
    }
    
    @Test
    public void metodiKorjaaAjatToimiiLiianPienillaNumeroilla() {
        Ajastin a = new Ajastin(-1,-1,-1);
        assertEquals("0:0:0", a.toString());
    }
    
    @Test
    public void metodiKorjaaAjatToimiiNollalla() {
        Ajastin a = new Ajastin(0,0,0);
        assertEquals("0:0:0", a.toString());
    }
    
    @Test
    public void metodiKorjaaAjatToimiiRajoilla() {
        Ajastin a = new Ajastin(99,59,60);
        assertEquals("99:59:60", a.toString());
    }
    
    @Test
    public void metodiKorjaaAjatToimiiMinuuteilleSekuntienOllessaYliNolla() {
        Ajastin a = new Ajastin(0,60,2);
        assertEquals("0:60:0", a.toString());
    }
    
}
