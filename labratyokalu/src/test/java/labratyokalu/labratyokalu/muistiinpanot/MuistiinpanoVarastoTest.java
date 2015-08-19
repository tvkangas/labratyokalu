package labratyokalu.labratyokalu.muistiinpanot;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

public class MuistiinpanoVarastoTest {

    MuistiinpanoVarasto mpVarasto;
    Muistiinpano mp;

    public MuistiinpanoVarastoTest() {
        this.mpVarasto = new MuistiinpanoVarasto();
        this.mp = new Muistiinpano("Testi", "Tanaan");
    }

    @Test
    public void konstruktoriToimii() {
        assertEquals(0, mpVarasto.palautaMuistiinpanoVarastonKoko());
    }

    @Test
    public void muistiinpanonLisaysToimii() {
        mpVarasto.lisaaMuistiinpano(mp);
        assertEquals(1, mpVarasto.palautaMuistiinpanoVarastonKoko());
    }

    @Test
    public void muistiinpanojenPalautusListanaToimii() {
        mpVarasto.lisaaMuistiinpano(mp);
        ArrayList<Muistiinpano> apu = mpVarasto.palautaMuistiinpanotListana();
        assertEquals(1, apu.size());
    }

    @Test
    public void palautaMuistiinpanoVarastonKokoToimii() {
        mpVarasto.lisaaMuistiinpano(mp);
        assertEquals(1, mpVarasto.palautaMuistiinpanoVarastonKoko());
    }
    
    @Test
    public void muistiinpanoVarastonTyhjennysToimii() {
        mpVarasto.lisaaMuistiinpano(mp);
        mpVarasto.tyhjennaMuistiinpanot();
        assertEquals(0, mpVarasto.palautaMuistiinpanoVarastonKoko());
    }
    
    @Test
    public void poistaMuistiinpanoToimii() {
        mpVarasto.lisaaMuistiinpano(mp);
        mpVarasto.poistaMuistiinpano(mp);
        assertEquals(0, mpVarasto.palautaMuistiinpanoVarastonKoko());
    }

}
