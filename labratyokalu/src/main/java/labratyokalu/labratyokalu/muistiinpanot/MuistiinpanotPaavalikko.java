
package labratyokalu.labratyokalu.muistiinpanot;

import labratyokalu.labratyokalu.muistiinpanot.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import labratyokalu.labratyokalu.muistiinpanot.klikkauskuuntelijat.*;

public class MuistiinpanotPaavalikko implements Runnable {
    
    private JFrame frame;
    private MuistiinpanoVarasto muistiinpanoVarasto;
    private GraafinenKayttoliittymaMuistiinpanonLisays lisaysValikko;
    private GraafinenKayttoliittymaMuistiinpanojenTarkastelu tarkasteluValikko;    
    
    public MuistiinpanotPaavalikko() {
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
    
    public void alustaValintanappaimet(Container c) {
        JPanel panelApu = new JPanel(new GridLayout(2, 1));
        JButton lisaysNappain = new JButton("Lisää muistiinpano");
        lisaysNappain.addActionListener(new KlikkauskuuntelijaPaavalikkoLisaaMuistiinpano(lisaysValikko, lisaysNappain));
        
        JButton tarkasteluNappain = new JButton("Tarkastele muistiinpanoja");
        tarkasteluNappain.addActionListener(new KlikkauskuuntelijaPaavalikkoTarkasteleMuistiinpanoja(tarkasteluValikko, tarkasteluNappain));
        
        panelApu.add(lisaysNappain);
        panelApu.add(tarkasteluNappain);
        c.add(panelApu);
    }
    
    public MuistiinpanoVarasto luoMuistiinpanoVarasto() {
        MuistiinpanoVarasto apuVarasto = new MuistiinpanoVarasto();
        return apuVarasto;
    }
    
}
