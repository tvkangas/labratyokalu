
package labratyokalu.labratyokalu.muistiinpanot;

import java.util.*;
import labratyokalu.labratyokalu.muistiinpanot.*;

public class MuistiinpanoVarasto {
    private ArrayList<Muistiinpano> muistiinpanot;
    
    public MuistiinpanoVarasto() {
        this.muistiinpanot = new ArrayList();
    }
    
    public void lisaaMuistiinpano(Muistiinpano mp) {
        this.muistiinpanot.add(mp);
    }
    
    public ArrayList<Muistiinpano> palautaMuistiinpanotListana() {
        return this.muistiinpanot;
    }
    
    public int palautaMuistiinpanoVarastonKoko() {
        return this.muistiinpanot.size();
    }
    
    public void tyhjennaMuistiinpanot() {
        this.muistiinpanot.clear();
    }
    
    public void poistaMuistiinpano(Muistiinpano poisto) {
        this.muistiinpanot.remove(poisto);
    }
}
