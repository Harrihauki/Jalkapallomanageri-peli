/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.ottelulogiikka;

import jalkapallomanageri.domain.Joukkue;
import jalkapallomanageri.domain.Pelaaja;
import java.util.List;

/**
 *
 * @author lallimyl
 */
public class Ottelu {
    
    Joukkue koti;
    Joukkue vieras;
    List<Pelaaja> kotiAvaus;
    List<Pelaaja> vierasAvaus;
    Pelaaja kotiMV;
    Pelaaja vierasMV;
    
    public Ottelu(Joukkue koti, Joukkue vieras) {
        
        this.koti = koti;
        this.vieras = vieras;
        this.kotiAvaus = koti.getMuodostelma().getAvauskentallinen();
        this.vierasAvaus = vieras.getMuodostelma().getAvauskentallinen();
        this.kotiMV = koti.getMuodostelma().getMaalivahti();
        this.vierasMV = vieras.getMuodostelma().getMaalivahti();
    }
    
}
