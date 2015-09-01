
package labratyokalu.labratyokalu.yksikkomuunnin.muunnosluokat;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import labratyokalu.labratyokalu.yksikkomuunnin.*;

// import statements
/**
 * @author Tuukka Kangas
 * @version 1.0
 * @since 2015-08-18
 */

/**
 * Luokka luo graafisen yksikkömuuntimen, joka koskee lämpötilan yksikkömuunnoksia
 */

public class GraafinenYksikkomuunninLampotila implements Runnable {
    
    private JFrame frame;
    private JTextField vasen;
    private JTextField oikea;
    
    public GraafinenYksikkomuunninLampotila() {
        this.vasen = new JTextField("");
        this.oikea = new JTextField("");
    }
    
    @Override
    public void run() {
        frame = new JFrame("Lämpötilamuunnin");
        frame.setPreferredSize(new Dimension(500, 550));
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

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
    
    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(3, 1);
        container.setLayout(layout);
        alustaAputekstit(container);
        alustaNaytot(container);       
        alustaMuuntoNappaimet(container);
    }
    
    private void alustaAputekstit(Container c) {
        JPanel panelApu = new JPanel(new GridLayout(1, 2));
        JLabel vasen = new JLabel("Syötä tähän lukusi");
        JLabel oikea = new JLabel("Tässä näet muutetun luvun");
        panelApu.add(vasen);
        panelApu.add(oikea);
        c.add(panelApu);
    }

    
    private void alustaNaytot(Container container) {
        JPanel panel1 = new JPanel(new GridLayout(1, 2));
        panel1.add(this.vasen);
        panel1.add(this.oikea);
        container.add(panel1);   
        asetaNayttojenKaytettavyys();
    }
        
    private void alustaMuuntoNappaimet(Container c) {
        JPanel panel2 = new JPanel(new GridLayout(2, 2));        
        
        JButton celToFahNappi = new JButton ("C >> F");
        celToFahNappi.addActionListener(new KlikkausKuuntelijaMuunnin(new Yksikkomuunnin(1.8, 32, "C", "F"), this.vasen, this.oikea));
        panel2.add(celToFahNappi);      
      
        JButton fahToCelNappi = new JButton ("F >> C");
        fahToCelNappi.addActionListener(new KlikkausKuuntelijaMuunnin(new Yksikkomuunnin((1.0/1.8), (-32.0 / 1.8), "F", "C"), this.vasen, this.oikea));
        panel2.add(fahToCelNappi);
        
        JButton celToKNappi = new JButton ("C >> K");
        celToKNappi.addActionListener(new KlikkausKuuntelijaMuunnin(new Yksikkomuunnin(1.0, 273.15, "C", "K"), this.vasen, this.oikea));
        panel2.add(celToKNappi); 
        
        JButton kToCelNappi = new JButton ("C >> K");
        kToCelNappi.addActionListener(new KlikkausKuuntelijaMuunnin(new Yksikkomuunnin(1.0, -273.15, "C", "K"), this.vasen, this.oikea));
        panel2.add(kToCelNappi); 
        
        c.add(panel2);
    }
    
    private void asetaNayttojenKaytettavyys() {
        this.vasen.setEnabled(true);
        this.oikea.setEnabled(false);
    }
    
}
