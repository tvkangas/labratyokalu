
package labratyokalu.labratyokalu.yhdisteet;
import java.io.File;
import java.util.*;


public class AlkuaineidenLuku {
    
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
    
}
