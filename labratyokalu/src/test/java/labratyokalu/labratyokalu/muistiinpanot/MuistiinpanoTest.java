
package labratyokalu.labratyokalu.muistiinpanot;

import org.junit.*;
import static org.junit.Assert.*;

public class MuistiinpanoTest {
    
    Muistiinpano mp;
    
    public MuistiinpanoTest() {
        mp = new Muistiinpano("Moi", "13.8.");
    }
    
    @Test
    public void parametritonKonstruktoriToimii() {
        assertEquals("Moi", mp.getMuistiinpano());
        assertEquals("13.8.", mp.getJattopaiva());
    }
    
    @Test
    public void muistiinpanonMuuttaminenToimii() {
        mp.muutaMuistiinpano("Terve", "18.8.");
        assertEquals("Terve", mp.getMuistiinpano());
        assertEquals("18.8.", mp.getJattopaiva());
    }
    
    @Test
    public void getMuistiinpanoToimii() {
        assertEquals("Moi", mp.getMuistiinpano());
    }
    
    @Test
    public void getJattopaivaToimii() {
        assertEquals("13.8.", mp.getJattopaiva());
    }
    
}
