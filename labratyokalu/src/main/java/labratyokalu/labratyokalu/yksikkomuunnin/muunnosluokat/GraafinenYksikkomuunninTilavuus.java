
package labratyokalu.labratyokalu.yksikkomuunnin.muunnosluokat;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import labratyokalu.labratyokalu.yksikkomuunnin.*;

public class GraafinenYksikkomuunninTilavuus implements Runnable {
    
    private JFrame frame;
    private JTextField vasen;
    private JTextField oikea;
    
    public GraafinenYksikkomuunninTilavuus() {
        this.vasen = new JTextField("");
        this.oikea = new JTextField("");
    }
    
    @Override
    public void run() {
        frame = new JFrame("Tilavuusmuunnin");
        frame.setPreferredSize(new Dimension(500, 550));
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

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
        JPanel panel2 = new JPanel(new GridLayout(1, 2));        
        
        JButton mlToLitraNappi = new JButton ("ml >> l");
        mlToLitraNappi.addActionListener(new KlikkausKuuntelijaMuunnin(new Yksikkomuunnin(0.001, 0, "ml", "l"), this.vasen, this.oikea, mlToLitraNappi));
        panel2.add(mlToLitraNappi);      
      
        JButton litraToMlNappi = new JButton ("l >> ml");
        litraToMlNappi.addActionListener(new KlikkausKuuntelijaMuunnin(new Yksikkomuunnin(1000, 0, "l", "ml"), this.vasen, this.oikea, litraToMlNappi));
        panel2.add(litraToMlNappi);
        
        c.add(panel2);
    }
    
    private void asetaNayttojenKaytettavyys() {
        this.vasen.setEnabled(true);
        this.oikea.setEnabled(false);
    }
    
}
