/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.kayttoliittyma;

import jalkapallomanageri.domain.Pelaaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextArea;

/**
 *
 * @author lallimyl
 */
public class PelaajaNappi extends JButton implements ActionListener {

    public String nimi;
    private Pelaaja pelaaja;
    private JTextArea tekstikentta;
    
    public PelaajaNappi(Pelaaja pelaaja, JTextArea tekstikentta) {
        this.setText(pelaaja.getNimi());
        this.pelaaja = pelaaja;
        this.tekstikentta = tekstikentta;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        this.tekstikentta.setText(this.pelaaja.toString());
    }
    
}
