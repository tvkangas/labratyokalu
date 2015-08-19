
package labratyokalu.labratyokalu.muistiinpanot;

// import statements
/**
 * @author Tuukka Kangas
 * @version 1.0
 * @since 2015-08-18
 */

/**
 * Luokka luo muistiinpanoja
 */

public class Muistiinpano {
    private String muistiinpano;
    private String jattopaiva;
    
    public Muistiinpano(String mp, String jp) {
        this.muistiinpano = mp;
        this.jattopaiva = jp;
    }
    
    public String getMuistiinpano() {
        return this.muistiinpano;
    }

    public String getJattopaiva() {
        return jattopaiva;
    }
    
    /**
     * Metodi muuttaa atribuuttien arvot uusiin
     *
     * @param uusiMP Käyttäjän antama uusi muistiinpano
     * @param uusiJP Käyttäjän antama uusi jättöpäivä
     *
     */
    
    public void muutaMuistiinpano(String uusiMP, String uusiJP) {
        this.muistiinpano = uusiMP;
        this.jattopaiva = uusiJP;
    }   
    
}
