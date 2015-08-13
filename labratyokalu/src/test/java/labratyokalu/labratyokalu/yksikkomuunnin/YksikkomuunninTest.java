/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labratyokalu.labratyokalu.yksikkomuunnin;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tuukka
 */
public class YksikkomuunninTest {
    
    Yksikkomuunnin muunnin;
    
    public YksikkomuunninTest() {
        muunnin = new Yksikkomuunnin(2.5, 0, "kaks", "yks");
    }
    
    @Test
    public void konstruktoriToimii() {
        assertEquals(2.5, muunnin.getKerroin(), 0.00001);
        assertEquals("yks", muunnin.getYksikko());
    }
    
    @Test
    public void muunnosToimii() {
        double muunnettu = muunnin.muunna(5);
        assertEquals(12.5, muunnettu, 0.00001);
    }
    
    @Test
    public void getKerroinToimii() {
        assertEquals(2.5, muunnin.getKerroin(), 0.00001);
    }
    
    @Test
    public void getYksikkoToimii() {
        assertEquals("yks", muunnin.getYksikko());
    }
    
    @Test
    public void getMistaToimii() {
        assertEquals("kaks", muunnin.getMista());
    }
    
    @Test
    public void muunnosToimiiNollastaPoikkeavallaPositiivisellaVakiotermilla() {
        Yksikkomuunnin apu = new Yksikkomuunnin(2.5, 4, "kaks", "yks");
        double muunnettu = apu.muunna(5);
        assertEquals(16.5, muunnettu, 0.00001);
    }
    
    @Test
    public void muunnosToimiiNollastaPoikkeavallaNegatiivisellaVakiotermilla() {
        Yksikkomuunnin apu = new Yksikkomuunnin(2.5, -4, "kaks", "yks");
        double muunnettu = apu.muunna(5);
        assertEquals(8.5, muunnettu, 0.00001);
    }

}
