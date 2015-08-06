
package labratyokalu.labratyokalu.ajastin;

public class Ajastin {
    int tunnit;
    int minuutit;
    int sekunnit;
    
    public Ajastin () {
        this.tunnit = 0;
        this.minuutit = 0;
        this.sekunnit = 0;
    }
    
    public Ajastin (int tunnit, int minuutit, int sekunnit) {
        this.tunnit = tunnit;
        this.minuutit = minuutit;
        this.sekunnit = sekunnit;
    }

    public int getTunnit() {
        return tunnit;
    }

    public int getMinuutit() {
        return minuutit;
    }

    public int getSekunnit() {
        return sekunnit;
    }

    public void setTunnit(int tunnit) {
        this.tunnit = tunnit;
    }

    public void setMinuutit(int minuutit) {
        this.minuutit = minuutit;
    }

    public void setSekunnit(int sekunnit) {
        this.sekunnit = sekunnit;
    }
        
    public boolean onkoSekunnitNolla() {
        if (this.sekunnit == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean onkoSekunnitAlleNolla() {
        if (this.sekunnit < 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean onkoMinuutitAlleNolla() {
        if (this.minuutit < 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean onkoMinuutitNolla() {
        if (this.minuutit == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean onkoTunnitNolla() {
        if (this.tunnit == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean onkoAjastinNolla() {
        if (onkoSekunnitNolla() && onkoMinuutitNolla() && onkoTunnitNolla()) {
            return true;
        } else {
            return false;
        }
    }
    
    public void sekuntiKuluu() {
        this.sekunnit--;
        if (onkoAjastinNolla()) {
            tulostaLopetus();
        } else {
            if (onkoSekunnitAlleNolla()) {
                this.sekunnit = 59;
                this.minuutit--;
            }
            if (onkoMinuutitAlleNolla()) {
                this.minuutit = 59;
                if (this.tunnit > 0) {
                    this.tunnit--;
                }                
            }
        }        
    }
    
    public void tulostaLopetus() {
        System.out.println("Aika!");
    }
    
    public void kaynnistaAjastin() throws InterruptedException {
        while (!onkoAjastinNolla()) {
            System.out.println(toString());
            sekuntiKuluu();
            Thread.sleep(1000);            
        }
    }
    
    @Override
    public String toString() {
        if (this.tunnit >= 10 && this.minuutit >= 10 && this.sekunnit >=10) {
            return getTunnit() + ":" + getMinuutit() + ":" + getSekunnit();
        } else if (this.tunnit < 10 && this.minuutit >=10 && this.sekunnit >= 10) {
            return "0" + getTunnit() + ":" + getMinuutit() + ":" + getSekunnit();
        } else if (this.tunnit < 10 && this.minuutit <10 && this.sekunnit >= 10) {
            return "0" + getTunnit() + ":0" + getMinuutit() + ":" + getSekunnit();
        } else if (this.tunnit < 10 && this.minuutit <10 && this.sekunnit < 10) {
            return "0" + getTunnit() + ":0" + getMinuutit() + ":0" + getSekunnit();
        }        
        return getTunnit() + ":" + getMinuutit() + ":" + getSekunnit();
    }
}
