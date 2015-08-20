package labratyokalu.labratyokalu;
import java.io.*;
import java.util.*;

public class Kayttoliittyma {
    private ArrayList<Alkuaine> alkuaineet;
    
    public Kayttoliittyma() throws Exception {
        this.alkuaineet = alustaAlkuaineet();
    }
    
    public void kaynnista() {
        tulostaAlkuaineetListana();
    }
    
    public ArrayList<Alkuaine> alustaAlkuaineet() throws Exception {
        ArrayList<Alkuaine> apuLista = new ArrayList();
        File tiedosto = new File("src/main/java/labratyokalu/tiedostot/alkuaineet.txt");
        Scanner skanneri = new Scanner(tiedosto, "UTF-8");
        while (skanneri.hasNextLine()) {
            Scanner apu = new Scanner(skanneri.nextLine());
            apu.useDelimiter(";");
            int jarjluku = Integer.parseInt(apu.next());
            String nimi = apu.next();
            if (nimi.equals("Rontgenium")) {
                nimi = "Röntgenium";
            }
            String lyhenne = apu.next();
            double massa = Double.parseDouble(apu.next());
            double tiheys = Double.parseDouble(apu.next());
            apuLista.add(new Alkuaine(jarjluku, nimi, lyhenne, massa, tiheys));
        }
        skanneri.close();
        
        return apuLista;        
    }
    
    public void tulostaAlkuaineetListana() {
        for (int i = 0; i < this.alkuaineet.size(); i++) {
            System.out.println(this.alkuaineet.get(i));
        }
    }
    
}

