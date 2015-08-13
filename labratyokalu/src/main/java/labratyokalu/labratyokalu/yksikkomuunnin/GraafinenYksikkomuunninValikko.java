
package labratyokalu.labratyokalu.yksikkomuunnin;

import labratyokalu.labratyokalu.yksikkomuunnin.muunnosluokat.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import labratyokalu.labratyokalu.yksikkomuunnin.paavalikonKlikkauskuuntelijat.*;

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
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
        JPanel panel3 = new JPanel(new GridLayout(1, 6));
        JButton tilavuusNappain = new JButton("V");
        tilavuusNappain.addActionListener(new KlikkausKuuntelijaTilavuus(this.tilavuusValikko, tilavuusNappain));
        JButton tiheysNappain = new JButton("rho");
        tiheysNappain.addActionListener(new KlikkausKuuntelijaTiheys(this.tiheysValikko, tiheysNappain));
        JButton massaNappain = new JButton("m");
        massaNappain.addActionListener(new KlikkausKuuntelijaMassa(this.massaValikko, massaNappain));
        JButton paineNappain = new JButton("p");
        paineNappain.addActionListener(new KlikkausKuuntelijaPaine(this.paineValikko, paineNappain));
        JButton lampotilaNappain = new JButton("T");
        lampotilaNappain.addActionListener(new KlikkausKuuntelijaLampotila(this.lampotilaValikko, lampotilaNappain));
        JButton aikaNappain = new JButton("t");
        aikaNappain.addActionListener(new KlikkausKuuntelijaAika(this.aikaValikko, aikaNappain));
        panel3.add(tilavuusNappain);
        panel3.add(tiheysNappain);
        panel3.add(massaNappain);
        panel3.add(paineNappain);
        panel3.add(lampotilaNappain);
        panel3.add(aikaNappain);
        container.add(panel3);
    }    
    
}
