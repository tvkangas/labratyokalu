
package labratyokalu.labratyokalu.ajastin;

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
    public void metodiOnkoMinuutitNollaToimiiTrue() {
        ajastin.setMinuutit(0);       
        assertEquals(true, ajastin.onkoMinuutitNolla());
    }
    
    @Test
    public void metodiOnkoMinuutitAlleNollaToimiiTrue() {
        ajastin.setMinuutit(-1);       
        assertEquals(true, ajastin.onkoMinuutitAlleNolla());
    }
    
    @Test
    public void metodiOnkoMinuutitNollaToimiiFalse() {
        assertEquals(false, ajastin.onkoMinuutitNolla());
    }
    
    @Test
    public void metodiOnkoTunnitNollaToimiiTrue() {
        ajastin.setTunnit(0);
        assertEquals(true, ajastin.onkoTunnitNolla());
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
    public void eteneminenToimiiKunSekunnitMeneeAlleNollan() {
        ajastin.setSekunnit(0);
        ajastin.sekuntiKuluu();
        assertEquals("1:9:59", ajastin.toString());
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
    
}
