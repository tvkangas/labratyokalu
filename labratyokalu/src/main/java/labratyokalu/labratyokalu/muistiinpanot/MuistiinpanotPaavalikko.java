package labratyokalu.labratyokalu.muistiinpanot;

import labratyokalu.labratyokalu.muistiinpanot.*;
import labratyokalu.labratyokalu.muistiinpanot.klikkauskuuntelijat.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

/**
 * @author Tuukka Kangas
 * @version 1.0
 * @since 2015-08-18
 */
/**
 * Luokka luo pohjan, jossa voidaan selata eri vaihtoehtoja muistiinpanojen
 * tekemisessä
 */
public class MuistiinpanotPaavalikko implements Runnable {

    private JFrame frame;
    private MuistiinpanoVarasto muistiinpanoVarasto;
    private GraafinenKayttoliittymaMuistiinpanonLisays lisaysValikko;
    private GraafinenKayttoliittymaMuistiinpanojenTarkastelu tarkasteluValikko;

    public MuistiinpanotPaavalikko() throws Exception {
        this.muistiinpanoVarasto = luoMuistiinpanoVarasto();
        this.lisaysValikko = new GraafinenKayttoliittymaMuistiinpanonLisays(this.muistiinpanoVarasto);
        this.tarkasteluValikko = new GraafinenKayttoliittymaMuistiinpanojenTarkastelu(this.muistiinpanoVarasto);
    }

    @Override
    public void run() {
        frame = new JFrame("Muistiinpano");
        frame.setPreferredSize(new Dimension(550, 200));
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(1, 1);
        container.setLayout(layout);
        alustaValintanappaimet(container);
    }

    private void alustaValintanappaimet(Container c) {
        JPanel panelApu = new JPanel(new GridLayout(2, 1));
        JButton lisaysNappain = new JButton("Lisää muistiinpano");
        lisaysNappain.addActionListener(new KlikkauskuuntelijaPaavalikkoLisaaMuistiinpano(lisaysValikko, lisaysNappain));

        JButton tarkasteluNappain = new JButton("Tarkastele muistiinpanoja");
        tarkasteluNappain.addActionListener(new KlikkauskuuntelijaPaavalikkoTarkasteleMuistiinpanoja(tarkasteluValikko, tarkasteluNappain));

        panelApu.add(lisaysNappain);
        panelApu.add(tarkasteluNappain);
        c.add(panelApu);
    }

    /**
     * Metodi, joka lukee tallennetut muistiinpanot
     *
     * @return apuVarasto joka palauttaa konstruktorille luetuista
     * muistiinpanoista koostuvan listan
     *
     */
    public MuistiinpanoVarasto luoMuistiinpanoVarasto() throws Exception {
        MuistiinpanoVarasto apuVarasto = new MuistiinpanoVarasto();
        InputStream in = getClass().getResourceAsStream("/muistiinpanot.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String rivi = null;
        while ((rivi = br.readLine()) != null) {
            if (rivi.length() == 0) {
                break;
            }
            Scanner apu = new Scanner(rivi);
            apu.useDelimiter(";");
            String mp = apu.next();
            String jattopaiva = apu.next();
            apuVarasto.lisaaMuistiinpano(new Muistiinpano(mp, jattopaiva));
        }
        br.close();
        return apuVarasto;
    }
}
