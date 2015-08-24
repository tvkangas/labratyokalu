package labratyokalu.labratyokalu.yhdisteet;

import labratyokalu.labratyokalu.yhdisteet.Alkuaine;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Yhdiste {

    private HashMap<Alkuaine, Integer> yhdisteenAlkuaineet;
    private String yhdisteenNimi;
    private ArrayList<Alkuaine> alkuaineet;
    private double moolimassa;

    public Yhdiste(String yhdiste) {
        this.yhdisteenAlkuaineet = new HashMap();
        this.yhdisteenNimi = yhdiste;
        try {
            this.alkuaineet = new AlkuaineidenLuku().alustaAlkuaineet();
        } catch (Exception ex) {
            Logger.getLogger(Yhdiste.class.getName()).log(Level.SEVERE, null, ex);
        }
        lueYhdisteenAlkuaineetJaKertoimet();
        laskeMoolimassa();
    }
    
    public void lueYhdisteenAlkuaineetJaKertoimet() {
        String apu = "";
        for (int i = 0; i < this.yhdisteenNimi.length(); i++) {
            if (onkoMerkkiKirjain(this.yhdisteenNimi.charAt(i))) {                
                apu += this.yhdisteenNimi.charAt(i);
            } else if (onkoMerkkiNumero(this.yhdisteenNimi.charAt(i))) {
                int kerroin = palautaKerroin(i);
                if (kuinkaMontaMerkkiaLuvussa(kerroin) > 1) {
                    i += kuinkaMontaMerkkiaLuvussa(kerroin)-1;
                }
                Alkuaine aa = tunnistaAlkuaine(apu);
                if (!onkoAlkuaineJoMolekyylikaavassa(aa)) {
                    this.yhdisteenAlkuaineet.put(aa, kerroin);
                } else {
                    lisaysKunAlkuaineOnJoYhdisteessa(aa, kerroin);
                }
                apu = "";
            }
        }
    }
    
    public int palautaKerroin(int aloituspaikka) {
        String kerroin = "";
        int laskuri = 0;
        while (true) {
            kerroin += this.yhdisteenNimi.charAt(aloituspaikka + laskuri);
            laskuri++;
            if ((laskuri + aloituspaikka) == this.yhdisteenNimi.length() || !onkoMerkkiNumero(this.yhdisteenNimi.charAt(aloituspaikka + laskuri))) {
                break;
            }
        }
        return Integer.parseInt(kerroin);
    }
    
    public int kuinkaMontaMerkkiaLuvussa(int luku) {
        String kuinkamontaMerkkiaKertoimessaMerkkijono = luku + "";
        return kuinkamontaMerkkiaKertoimessaMerkkijono.length();
    }

    public Alkuaine tunnistaAlkuaine(String etsittava) {
        for (Alkuaine aa : this.alkuaineet) {
            if (etsittava.equals(aa.getLyhenne())) {
                return aa;
            }
        }
        return null;
    }

    public boolean onkoMerkkiKirjain(Character c) {
        if (Character.isLetter(c)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean onkoMerkkiNumero(Character c) {
        if (Character.isDigit(c)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean onkoAlkuaineJoMolekyylikaavassa(Alkuaine aa) {
        if (this.yhdisteenAlkuaineet.containsKey(aa)) {
            return true;
        } else {
            return false;
        }
    }

    public void lisaysKunAlkuaineOnJoYhdisteessa(Alkuaine aa, int lisakerroin) {
        int alkuKerroin = this.yhdisteenAlkuaineet.get(aa);
        this.yhdisteenAlkuaineet.remove(aa);
        this.yhdisteenAlkuaineet.put(aa, (lisakerroin + alkuKerroin));
    }

    public void laskeMoolimassa() {
        Moolimassalaskuri mmLaskuri = new Moolimassalaskuri(this.yhdisteenAlkuaineet);
        this.moolimassa = mmLaskuri.palautaYhdisteenMassa();
    }

    public double getMoolimassa() {
        if (this.moolimassa == 0) {
            System.out.println("Et syöttänyt kunnollista yhdistettä!");
        }
        return moolimassa;
    }

    public HashMap<Alkuaine, Integer> getYhdisteenAlkuaineet() {
        return yhdisteenAlkuaineet;
    }
    
}
