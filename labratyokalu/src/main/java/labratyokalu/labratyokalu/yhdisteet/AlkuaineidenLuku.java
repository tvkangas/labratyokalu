package labratyokalu.labratyokalu.yhdisteet;

import java.io.*;
import java.util.*;

/**
 * @author Tuukka Kangas
 * @version 1.0
 * @since 2015-08-18
 */
/**
 * Luokka luo olion, jolla voidaan lukea alkuaineet tiedostosta
 */
public class AlkuaineidenLuku {

    public ArrayList<Alkuaine> alustaAlkuaineet() throws Exception {
        ArrayList<Alkuaine> apuLista = new ArrayList();
        InputStream in = getClass().getResourceAsStream("/alkuaineet.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String rivi = null;
        while ((rivi = br.readLine()) != null) {
            Scanner apu = new Scanner(rivi);
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
        br.close();

        return apuLista;
    }

}
