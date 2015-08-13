
package labratyokalu.labratyokalu.yksikkomuunnin.muunnosluokat;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import labratyokalu.labratyokalu.yksikkomuunnin.*;

public class GraafinenYksikkomuunninAika implements Runnable {
    
    private JFrame frame;
    private JTextField vasen;
    private JTextField oikea;
    
    public GraafinenYksikkomuunninAika() {
        this.vasen = new JTextField("");
        this.oikea = new JTextField("");
    }
    
    @Override
    public void run() {
        frame = new JFrame("Aikamuunnin");
        frame.setPreferredSize(new Dimension(500, 550));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true); 
    }
    
    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(3, 1);
        container.setLayout(layout);
        alustaAputekstit(container);
        alustaNaytot(container);        
        alustaMuuntoNappaimet(container);
    }
    
    private void alustaNaytot(Container container) {
        JPanel panel1 = new JPanel(new GridLayout(1, 2));
        panel1.add(this.vasen);
        panel1.add(this.oikea);
        container.add(panel1);  
        asetaNayttojenKaytettavyys();
    }
    
    private void alustaAputekstit(Container c) {
        JPanel panelApu = new JPanel(new GridLayout(1, 2));
        JLabel vasen = new JLabel("Syötä tähän lukusi");
        JLabel oikea = new JLabel("Tässä näet muutetun luvun");
        panelApu.add(vasen);
        panelApu.add(oikea);
        c.add(panelApu);
    }
        
    private void alustaMuuntoNappaimet(Container c) {
        JPanel panel2 = new JPanel(new GridLayout(1, 2));        
        
        JButton sekToMinNappi = new JButton ("s >> min");
        sekToMinNappi.addActionListener(new KlikkausKuuntelijaMuunnin(new Yksikkomuunnin(1.0 / 60.0, 0, "s", "min"), this.vasen, this.oikea, sekToMinNappi));
        panel2.add(sekToMinNappi);      
      
        JButton minToSekNappi = new JButton ("min >> sek");
        minToSekNappi.addActionListener(new KlikkausKuuntelijaMuunnin(new Yksikkomuunnin(60, 0, "min", "sek"), this.vasen, this.oikea, minToSekNappi));
        panel2.add(minToSekNappi);
        
        c.add(panel2);
    }
    
    private void asetaNayttojenKaytettavyys() {
        this.vasen.setEnabled(true);
        this.oikea.setEnabled(false);
    }
    
}
