
package labratyokalu.labratyokalu.laskin;

import java.text.*;

public class Laskin {
    private double arvo;
        
    public Laskin(double alkuarvo) {
        this.arvo = alkuarvo;
    }
    
    public Laskin() {
        this.arvo = 0;
    }
    
    public void lisaa(double lisattava) {
        this.arvo += lisattava;
    }
    
    public void vahenna(double vahennettava) {
        this.arvo -= vahennettava;
    }
    
    public void kerro(double kertoja) {
        this.arvo = this.arvo * kertoja;
    }
    
    public void jaa(double jakaja) {
        this.arvo = this.arvo / jakaja;
    }
    
    public void korotaPotenssiin(double potenssi) {
        this.arvo = Math.pow(this.arvo, potenssi);
    }
        
    public void pyorista(int monella) {
        String arvoApu = "1";
        for (int i = 0; i < monella; i++) {
            arvoApu = arvoApu + "0";
        }
        int apu = Integer.parseInt(arvoApu);
        this.arvo = (double)(Math.round(this.arvo * apu)) / apu;
        
//        String apuMonella = "#.";
//        for (int i = 0; i < monella; i++) {
//            apuMonella = apuMonella + "0";
//        }
//        
//        DecimalFormat df = new DecimalFormat(apuMonella);
    }
    
    public double getArvo() {
        return this.arvo;
    }
    
    public void nollaa() {
        this.arvo = 0;
    }
    
}