package labratyokalu.labratyokalu.yhdisteet;

import org.junit.*;
import static org.junit.Assert.*;

public class AlkuaineTest {

    Alkuaine aa;

    public AlkuaineTest() {
        aa = new Alkuaine(1, "Tuukkanium", "Tu", 89.2, 2.9);
    }

    @Test
    public void getNimiToimii() {
        assertEquals("Tuukkanium", aa.getNimi());
    }
    
    @Test
    public void getLyhenneToimii() {
        assertEquals("Tu", aa.getLyhenne());        
    }
    
    @Test
    public void getMassaToimii() {
        assertEquals(89.2, aa.getMassa(), 0.001);        
    }
    
    @Test
    public void getTiheysToimii() {
        assertEquals(2.9, aa.getTiheys(), 0.001);
    }
    
    @Test
    public void getJarjestyslukuToimii() {
        assertEquals(1, aa.getJarjestysluku());
    }
    
    @Test
    public void toStringToimii() {
        assertEquals("1. Tuukkanium (Tu) M = 89.2, tiheys = 2.9 x 10^3 kg/m^3", aa.toString());
    }

}
