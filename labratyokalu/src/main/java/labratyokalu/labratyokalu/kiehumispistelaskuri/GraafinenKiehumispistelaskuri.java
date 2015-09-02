package labratyokalu.labratyokalu.kiehumispistelaskuri;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Tuukka Kangas
 * @version 1.0
 * @since 2015-09-01
 */
/**
 * Luokka luo kiehumispistelaskurin, jota voi käyttää graafisesti
 */
public class GraafinenKiehumispistelaskuri implements Runnable {

    private JFrame frame;
    private JTextField alkupaine;
    private JTextField loppupaine;
    private JTextField alkukiehumispiste;
    private JTextField hoyrynpaine;
    private JTextField loppukiehumispiste;

    public GraafinenKiehumispistelaskuri() {
        this.alkupaine = new JTextField("");
        this.loppupaine = new JTextField("");
        this.alkukiehumispiste = new JTextField("");
        this.hoyrynpaine = new JTextField("406600.0");
        this.loppukiehumispiste = new JTextField("");
    }

    @Override
    public void run() {
        frame = new JFrame("Kiehumispistelaskuri");
        frame.setPreferredSize(new Dimension(600, 300));
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true); 
    }
    
    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(2, 2);
        container.setLayout(layout);
        alustaAputekstit(container);
        alustaNaytot(container);
        JButton muuntoNappain = new JButton("Laske uusi kiehumispiste");
        muuntoNappain.addActionListener(new KlikkauskuuntelijaMuuntonappain(this.alkupaine, this.loppupaine, this.alkukiehumispiste, this.hoyrynpaine, this.loppukiehumispiste));
       
        container.add(muuntoNappain);
        container.add(new JLabel("<html>Paineet on annettava samassa yksikössä. <br /><br /> Höyrynpaineita [J/mol] <br /> Vesi 406600.0 <br /> Butaani 210000.0 <br /> Asetoni 313000.0</html>"));
        asetaNayttojenKaytettavyys();
    }
    
    private void alustaAputekstit(Container c) {
        JPanel apuPanel = new JPanel(new GridLayout(5, 1));
        JLabel alkupaineApu = new JLabel("Syötä alkuperäinen paine");
        JLabel loppupaineApu = new JLabel("Syötä haluttu paine");
        JLabel alkulampotilaApu = new JLabel("Syötä kiehumispiste tiedetyssä paineessa [C]");
        JLabel hoyrynpaineApu = new JLabel("Syötä höyrynpaine [J/mol]");
        JLabel loppulampotilaApu = new JLabel("Kiehumispiste uudessa paineessa [C]");
        apuPanel.add(alkupaineApu);
        apuPanel.add(loppupaineApu);
        apuPanel.add(alkulampotilaApu);
        apuPanel.add(hoyrynpaineApu);
        apuPanel.add(loppulampotilaApu);
        c.add(apuPanel);
    }
    
    private void alustaNaytot(Container c) {
        JPanel apuPanel = new JPanel(new GridLayout(5, 1));
        apuPanel.add(this.alkupaine);
        apuPanel.add(this.loppupaine);
        apuPanel.add(this.alkukiehumispiste);
        apuPanel.add(this.hoyrynpaine);
        apuPanel.add(this.loppukiehumispiste);
        
        c.add(apuPanel);
    }
    
    private void asetaNayttojenKaytettavyys() {
        this.loppukiehumispiste.setEnabled(false);
    }

}
