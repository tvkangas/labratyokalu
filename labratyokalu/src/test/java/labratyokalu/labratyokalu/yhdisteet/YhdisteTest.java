
package labratyokalu.labratyokalu.yhdisteet;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class YhdisteTest {
    
    Yhdiste yhd;
    
    public YhdisteTest() {
        yhd = new Yhdiste("C100H12O32S1");
    }
    
    @Test    
    public void getMoolimassaToimii() {
        assertEquals(1757.23, yhd.getMoolimassa(), 0.0001);
    }
    
    @Test
    public void hajautustaulukossaOikeaMaaraAvaimia() {
        assertEquals(4, yhd.getYhdisteenAlkuaineet().keySet().size());
    }
    
    @Test
    public void metodiOnkoMerkkiNumeroToimii() {
        char apu = '2';
        assertEquals(true, yhd.onkoMerkkiNumero(apu));
    }
    
    @Test
    public void metodiOnkoMerkkiKirjainToimii() {
        char apu = 'k';
        assertEquals(true, yhd.onkoMerkkiKirjain(apu));
    }
    
    @Test
    public void eiOikeitaAlkuaineita() {
        Yhdiste apu = new Yhdiste("Hy");
        assertEquals(0.0, apu.getMoolimassa(), 0.0001);
    }
    
    @Test
    public void alkuaineenTunnistusPalauttaaNull() {
        assertEquals(null, yhd.tunnistaAlkuaine("TääEiOoAlkuaine"));
    }
    
}
