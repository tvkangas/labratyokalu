
package labratyokalu.labratyokalu.paavalikko;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import labratyokalu.labratyokalu.paavalikko.klikkauskuuntelijat.*;
import labratyokalu.labratyokalu.muistiinpanot.MuistiinpanotPaavalikko;
import labratyokalu.labratyokalu.laskin.*;
import labratyokalu.labratyokalu.yksikkomuunnin.*;
import labratyokalu.labratyokalu.yhdisteet.Alkuaine;
import labratyokalu.labratyokalu.yhdisteet.GraafinenMoolimassalaskuri;
import labratyokalu.labratyokalu.ajastin.*;

// import statements
/**
 * @author Tuukka Kangas
 * @version 1.0
 * @since 2015-08-18
 */

/**
 * Luokka luo päävalikon, jossa voi selata haluttuja toimintoja
 */

public class Paavalikko implements Runnable {
    private JFrame frame;
    private MuistiinpanotPaavalikko muistiinpanotPaavalikko;
    private GraafinenLaskin gLaskin;
    private GraafinenYksikkomuunninValikko gYmValikko;
    private ArrayList<Alkuaine> alkuaineet;
    private GraafinenMoolimassalaskuri gMoolimassalaskuri;
    private AjastimenValikko ajastimenValikko;

    public Paavalikko() {
        try {
            this.muistiinpanotPaavalikko = new MuistiinpanotPaavalikko();
        } catch (Exception ex) {
            Logger.getLogger(Paavalikko.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.gLaskin = new GraafinenLaskin();
        this.gYmValikko = new GraafinenYksikkomuunninValikko();        
        try {
            this.alkuaineet = alustaAlkuaineet();
        } catch (Exception ex) {
            Logger.getLogger(Paavalikko.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.gMoolimassalaskuri = new GraafinenMoolimassalaskuri();
        this.ajastimenValikko = new AjastimenValikko();
    }
    
    @Override
    public void run() {
        frame = new JFrame("Päävalikko");
        frame.setPreferredSize(new Dimension(300, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);        
    }
    
    /**
     * Metodi luo halutut komponentit käyttöliittymään
     *
     * @param container Piirrossa hyödynnetty säiliö, johon tallenetaan halutut asiat
     *
     */
    
    public void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(1, 1);
        container.setLayout(layout);
        alustaValikkonappaimet(container);
    }
    
    /**
     * Apumetodi luo halutut valikkonapit käyttöliittymään
     *
     * @param container Piirrossa hyödynnetty säiliö, johon tallenetaan halutut asiat
     *
     */
    
    public void alustaValikkonappaimet(Container container) {
        JPanel apupaneeli = new JPanel(new GridLayout(5, 1));
        JButton mpNappain = new JButton("Muistiinpanot");
        mpNappain.addActionListener(new KlikkauskuuntelijaMuistiinpanot(muistiinpanotPaavalikko));
        JButton laskinNappain = new JButton("Laskin");
        laskinNappain.addActionListener(new KlikkauskuuntelijaLaskin(gLaskin));
        JButton yksikkomuunninNappain = new JButton("Yksikkömuunnin");
        yksikkomuunninNappain.addActionListener(new KlikkauskuuntelijaYksikkomuunnin(this.gYmValikko));
        JButton moolimassalaskuriNappain = new JButton("Moolimassalaskuri");
        moolimassalaskuriNappain.addActionListener(new KlikkauskuuntelijaMoolimassalaskuri(this.gMoolimassalaskuri));
        JButton ajastinNappain = new JButton("Ajastin");
        ajastinNappain.addActionListener(new KlikkauskuuntelijaAjastin(this.ajastimenValikko));
        
        apupaneeli.add(mpNappain);
        apupaneeli.add(laskinNappain);
        apupaneeli.add(yksikkomuunninNappain);
        apupaneeli.add(moolimassalaskuriNappain);
        apupaneeli.add(ajastinNappain);
        container.add(apupaneeli);
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
    
}
