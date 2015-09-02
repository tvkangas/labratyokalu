package labratyokalu.labratyokalu.ajastin;

/**
 * @author Tuukka Kangas
 * @version 1.0
 * @since 2015-08-25
 */
/**
 * Luokka luo ajastin-olioita
 */
public class Ajastin {

    private int tunnit;
    private int minuutit;
    private int sekunnit;

    public Ajastin(int tunnit, int minuutit, int sekunnit) {
        this.tunnit = tunnit;
        this.minuutit = minuutit;
        this.sekunnit = sekunnit;
        korjaaAjat();
    }

    public Ajastin() {
        this.tunnit = 0;
        this.minuutit = 0;
        this.sekunnit = 0;
    }

    public int getTunnit() {
        return this.tunnit;
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
    

    /**
     * Metodi palauttaa tuntien kymmenet
     */
    public int getTunnitKymmenet() {
        if (this.tunnit < 10) {
            return 0;
        } else {
            return (this.tunnit / 10);
        }
    }

    /**
     * Metodi palauttaa tuntien ykköset
     */
    public int getTunnitYkkoset() {
        if (this.tunnit < 10) {
            return this.tunnit;
        } else {
            return (this.tunnit % 10);
        }
    }

    /**
     * Metodi palauttaa minuuttien kymmenet
     */
    public int getMinuutitKymmenet() {
        if (this.minuutit < 10) {
            return 0;
        } else {
            return (this.minuutit / 10);
        }
    }

    /**
     * Metodi palauttaa minuuttien ykköset
     */
    public int getMinuutitYkkoset() {
        if (this.minuutit < 10) {
            return this.minuutit;
        } else {
            return (this.minuutit % 10);
        }
    }

    /**
     * Metodi palauttaa sekuntien kymmenet
     */
    public int getSekunnitKymmenet() {
        if (this.sekunnit < 10) {
            return 0;
        } else {
            return (this.sekunnit / 10);
        }
    }

    /**
     * Metodi palauttaa sekuntien ykköset
     */
    public int getSekunnitYkkoset() {
        if (this.sekunnit < 10) {
            return this.sekunnit;
        } else {
            return (this.sekunnit % 10);
        }
    }

    /**
     * Metodi palauttaa tiedon onko tunnit nolla
     */
    public boolean onkoTunnitNolla() {
        if (this.tunnit == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodi palauttaa tiedon onko minuutit nolla
     */
    public boolean onkoMinuutitNolla() {
        if (this.minuutit == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodi palauttaa tiedon onko sekunnit nolla
     */
    public boolean onkoSekunnitNolla() {
        if (this.sekunnit == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodi palauttaa tiedon onko ajastin nolla
     */
    public boolean onkoAjastinNolla() {
        if (onkoTunnitNolla() && onkoMinuutitNolla() && onkoSekunnitNolla()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodi palauttaa tiedon onko sekunnit alle nollan
     */
    public boolean onkoSekunnitAlleNolla() {
        if (this.sekunnit < 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodi palauttaa tiedon onko minuutit alle nollan
     */
    public boolean onkoMinuutitAlleNolla() {
        if (this.minuutit < 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodi vähentää sekunnin aikaa
     */
    public void sekuntiKuluu() {
        this.sekunnit--;
        if (!onkoAjastinNolla()) {
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

    @Override
    public String toString() {
        return getTunnit() + ":" + getMinuutit() + ":" + getSekunnit();
    }

    /**
     * Apumetodi, jonka tarkoituksena on korjata käyttäjän antamat väärät ajat
     */
    public void korjaaAjat() {
        if (this.tunnit > 99) {
            this.tunnit = 99;
        }
        if (this.tunnit < 0) {
            this.tunnit = 0;
        }
        if (this.minuutit >= 60 && this.sekunnit > 0) {
            this.sekunnit = 0;
            this.minuutit = 60;
        }
        if (this.minuutit > 60) {
            this.minuutit = 60;
        }
        if (this.minuutit < 0) {
            this.minuutit = 0;
        }
        if (this.sekunnit > 60) {
            this.sekunnit = 60;
        }
        if (this.sekunnit < 0) {
            this.sekunnit = 0;
        }
    }

}
