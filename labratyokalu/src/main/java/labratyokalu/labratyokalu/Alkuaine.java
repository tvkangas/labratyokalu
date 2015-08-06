
package labratyokalu.labratyokalu;

public class Alkuaine {
    private int jarjestysluku;
    private String nimi;
    private String lyhenne;
    private double massa;
    private double tiheys;    

    public Alkuaine(int jarjluku, String nimi, String lyhenne, double massa, double tiheys) {
        this.jarjestysluku = jarjluku;
        this.nimi = nimi;
        this.lyhenne = lyhenne;
        this.massa = massa;
        this.tiheys = tiheys;
    }
    
    public String getNimi() {
        return this.nimi;
    }

    public String getLyhenne() {
        return lyhenne;
    }

    public double getMassa() {
        return massa;
    }

    public double getTiheys() {
        return tiheys;
    }
    
    public int getJarjestysluku() {
        return this.jarjestysluku;
    }
    
    @Override
    public String toString() {
        return getJarjestysluku() + ". " + getNimi() + " (" + getLyhenne() + ") M = " + getMassa() + ", tiheys = " + getTiheys() + " x 10^3 kg/m^3";
    }
    
    
}
