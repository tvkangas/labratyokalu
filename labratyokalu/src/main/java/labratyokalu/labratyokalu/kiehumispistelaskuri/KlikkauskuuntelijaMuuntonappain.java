package labratyokalu.labratyokalu.kiehumispistelaskuri;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * @author Tuukka Kangas
 * @version 1.0
 * @since 2015-09-01
 */
/**
 * Luokka luo ActionListener-olion, jolla voidaan toteuttaa uuden
 * kiehumispisteen laskeminen
 */
public class KlikkauskuuntelijaMuuntonappain implements ActionListener {

    private JTextField alkupaine;
    private JTextField loppupaine;
    private JTextField alkukiehumispiste;
    private JTextField hoyrynpaine;
    private JTextField loppukiehumispiste;

    public KlikkauskuuntelijaMuuntonappain(JTextField alkupaine, JTextField loppupaine, JTextField alkukiehumispiste, JTextField hoyrynpaine, JTextField loppukiehumispiste) {
        this.alkupaine = alkupaine;
        this.loppupaine = loppupaine;
        this.alkukiehumispiste = alkukiehumispiste;
        this.hoyrynpaine = hoyrynpaine;
        this.loppukiehumispiste = loppukiehumispiste;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        try {
            Kiehumispistelaskuri kpl = new Kiehumispistelaskuri(Double.parseDouble(this.alkupaine.getText()), Double.parseDouble(this.alkukiehumispiste.getText()),
                    Double.parseDouble(this.loppupaine.getText()), Double.parseDouble(this.hoyrynpaine.getText()));

            this.loppukiehumispiste.setText("" + kpl.laskeUusiKiehumispiste());
        } catch (NumberFormatException e) {
            System.out.println("Ei onnistunut!");
        }

    }

}
