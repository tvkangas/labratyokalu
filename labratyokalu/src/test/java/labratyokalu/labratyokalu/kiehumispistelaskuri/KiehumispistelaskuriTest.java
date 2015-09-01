
package labratyokalu.labratyokalu.kiehumispistelaskuri;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KiehumispistelaskuriTest {
    
    Kiehumispistelaskuri kpl;
    
    public KiehumispistelaskuriTest() {
        this.kpl = new Kiehumispistelaskuri(1.0, 100.0, 0.3, 406600.0);
    }
    
    @Test
    public void getKaasuvakioToimii() {
       assertEquals(8.31446, kpl.getKaasuvakio(), 0.0001);
    }
    
    @Test
    public void palautaKaanteisarvoToimii() {
        assertEquals(0.5, kpl.palautaKaanteisarvo(2.0), 0.0001);
    }
    
    @Test
    public void palautaLuonnollinenLogaritmiToimii() {
        assertEquals(8, kpl.palautaLuonnollinenLogaritmi(2980.957987), 0.0001);
    }
    
    @Test
    public void palautaKaasuvakionJaHoyrynpaineenSuhdeToimii() {
        assertEquals(0.00002044875, kpl.palautaKaasuvakionJaHoyrynpaineenSuhde(), 0.0001);
    }
    
    @Test
    public void muutaCelsiusKelviniksiToimii() {
        assertEquals(273.15, kpl.muutaCelsiusKelviniksi(0.0), 0.0001);
    }
    
    @Test
    public void muutaKelvinCelsiukseksiToimii() {
        assertEquals(0.0, kpl.muutaKelvinCelsiukseksi(273.15), 0.0001);
    }
        
    @Test
    public void laskeUusiKiehumispisteToimii() {
        assertEquals(96.6031321, kpl.laskeUusiKiehumispiste(), 0.0001);
    }
    
}
