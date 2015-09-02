
package labratyokalu.labratyokalu.muistiinpanot;

/**
 * @author Tuukka Kangas
 * @version 1.0
 * @since 2015-09-02
 */

/**
 * Luokan avulla luodaan muistiinpanovarasto, joka säästää muistiinpanot
 */

import java.util.*;
import labratyokalu.labratyokalu.muistiinpanot.*;

public class MuistiinpanoVarasto {
    private ArrayList<Muistiinpano> muistiinpanot;
    
    public MuistiinpanoVarasto() {
        this.muistiinpanot = new ArrayList();
    }
    
    /**
     * Metodin avulla voidaan lisätä uusi muistiinpano listaan
     * @param mp lisättävä muistiinpano
     */
    
    public void lisaaMuistiinpano(Muistiinpano mp) {
        this.muistiinpanot.add(mp);
    }
        
    public ArrayList<Muistiinpano> palautaMuistiinpanotListana() {
        return this.muistiinpanot;
    }
    
    /**
     * Metodi palauttaa listan koon
     * @return listan koko
     */
    
    public int palautaMuistiinpanoVarastonKoko() {
        return this.muistiinpanot.size();
    }
    
    /**
     * Tyhjentää listan, joka sisältää muistiinpanot
     */
    
    public void tyhjennaMuistiinpanot() {
        this.muistiinpanot.clear();
    }
    
    /**
     * Poistaa muistiinpanon listasta
     * @param poisto poistettava muistiinpano
     */
    
    public void poistaMuistiinpano(Muistiinpano poisto) {
        this.muistiinpanot.remove(poisto);
    }
}
