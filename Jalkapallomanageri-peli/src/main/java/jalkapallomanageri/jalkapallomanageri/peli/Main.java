/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.jalkapallomanageri.peli;

import jalkapallomanageri.domain.Joukkue;
import jalkapallomanageri.pelaajaGeneraattori.Pelaajageneraattori;
import java.util.Random;

/**
 *
 * @author lallimyl
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Random arpoja = new Random();
        Pelaajageneraattori generaattori = new Pelaajageneraattori(arpoja);
        Joukkue joukkue = new Joukkue("PuiU");
        
        joukkue.generoiPelaajat(generaattori);
        System.out.println(joukkue.getPelaajat().size());
    }
    
}
