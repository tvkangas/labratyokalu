package labratyokalu.labratyokalu.yksikkomuunnin;

public class Yksikkomuunnin {

    double kerroin;
    double vakiotermi;
    String mista;
    String mihin;

    public Yksikkomuunnin(double k, double vk, String mista, String mihin) {
        this.kerroin = k;
        this.vakiotermi = vk;
        this.mista = mista;
        this.mihin = mihin;
    }

    public double muunna(double muunnettava) {
        return muunnettava * this.kerroin + this.vakiotermi;
    }


    public String getYksikko() {
        return this.mihin;
    }

    public String getMista() {
        return this.mista;
    }

    public double getKerroin() {
        return this.kerroin;
    }

}
