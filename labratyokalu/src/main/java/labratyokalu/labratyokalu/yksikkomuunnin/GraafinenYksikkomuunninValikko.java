
package labratyokalu.labratyokalu.yksikkomuunnin;

import labratyokalu.labratyokalu.yksikkomuunnin.yksikkomuuntimenPaavalikonKlikkauskuuntelijat.*;
import labratyokalu.labratyokalu.yksikkomuunnin.muunnosluokat.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// import statements
/**
 * @author Tuukka Kangas
 * @version 1.0
 * @since 2015-08-18
 */

/**
 * Luokka luo graafisen valikon, jossa voi valita halutun yksikkömuunninluokan
 */

public class GraafinenYksikkomuunninValikko implements Runnable {
    
    private JFrame frame;
    private GraafinenYksikkomuunninTilavuus tilavuusValikko;
    private GraafinenYksikkomuunninTiheys tiheysValikko;
    private GraafinenYksikkomuunninMassa massaValikko;
    private GraafinenYksikkomuunninPaine paineValikko;
    private GraafinenYksikkomuunninLampotila lampotilaValikko;
    private GraafinenYksikkomuunninAika aikaValikko;
    
    public GraafinenYksikkomuunninValikko() {
        this.tilavuusValikko = new GraafinenYksikkomuunninTilavuus();
        this.tiheysValikko = new GraafinenYksikkomuunninTiheys();
        this.massaValikko = new GraafinenYksikkomuunninMassa();
        this.paineValikko = new GraafinenYksikkomuunninPaine();
        this.lampotilaValikko = new GraafinenYksikkomuunninLampotila();
        this.aikaValikko = new GraafinenYksikkomuunninAika();
    }

    @Override
    public void run() {
        frame = new JFrame("Yksikkömuunnin");
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
        
    private void alustaValintanappaimet(Container container) {
        JPanel apupaneeli = new JPanel(new GridLayout(1, 6));
        JButton tilavuusNappain = new JButton("V");
        tilavuusNappain.addActionListener(new KlikkausKuuntelijaTilavuus(this.tilavuusValikko));
        JButton tiheysNappain = new JButton("rho");
        tiheysNappain.addActionListener(new KlikkausKuuntelijaTiheys(this.tiheysValikko));
        JButton massaNappain = new JButton("m");
        massaNappain.addActionListener(new KlikkausKuuntelijaMassa(this.massaValikko));
        JButton paineNappain = new JButton("p");
        paineNappain.addActionListener(new KlikkausKuuntelijaPaine(this.paineValikko));
        JButton lampotilaNappain = new JButton("T");
        lampotilaNappain.addActionListener(new KlikkausKuuntelijaLampotila(this.lampotilaValikko));
        JButton aikaNappain = new JButton("t");
        aikaNappain.addActionListener(new KlikkausKuuntelijaAika(this.aikaValikko));
        apupaneeli.add(tilavuusNappain);
        apupaneeli.add(tiheysNappain);
        apupaneeli.add(massaNappain);
        apupaneeli.add(paineNappain);
        apupaneeli.add(lampotilaNappain);
        apupaneeli.add(aikaNappain);
        container.add(apupaneeli);
    }    
    
}
