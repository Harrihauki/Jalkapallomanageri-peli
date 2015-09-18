/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.ottelulogiikka;

import jalkapallomanageri.domain.Joukkue;
import jalkapallomanageri.domain.Pelaaja;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
    Random arpoja;
    int vierasmaalit;
    int kotimaalit;
    Pelaaja pallonhaltija;
    
    public Ottelu(Joukkue koti, Joukkue vieras, Random arpoja) {
        
        this.koti = koti;
        this.vieras = vieras;
        this.kotiAvaus = koti.getMuodostelma().getAvauskentallinen();
        this.vierasAvaus = vieras.getMuodostelma().getAvauskentallinen();
        this.kotiMV = koti.getMuodostelma().getMaalivahti();
        this.vierasMV = vieras.getMuodostelma().getMaalivahti();
        this.arpoja = arpoja;
        this.vierasmaalit = 0;
        this.kotimaalit = 0;
        this.pallonhaltija = kotiAvaus.get(0);
    }
    
    public Joukkue getKoti() {
        
        return this.koti;
    }
    
    public Joukkue getVieras() {
        
        return this.vieras;
    }
    
    public void setPallonhaltija(Pelaaja pelaaja) {
        
        this.pallonhaltija = pelaaja;
    }
    
    public Map<Double, Pelaaja> laskeOmienEtaisyydet(Pelaaja pelaaja) {
        
        List<Pelaaja> vertailtavatPelaajat = this.kummanPelaaja(pelaaja);
        
        Map<Double, Pelaaja> pelaajienEtaisyydet = new HashMap();
        
        for (Pelaaja vertailtava : vertailtavatPelaajat) {
            
            if (this.etaisyys(pelaaja, vertailtava) == 0.0) {
                
                continue;
            }
            
            pelaajienEtaisyydet.put(etaisyys(pelaaja, vertailtava), vertailtava);
        }
    }

    private List<Pelaaja> kummanPelaaja(Pelaaja pelaaja) {
        
        if (this.kotiAvaus.contains(pelaaja)) {
            
            return this.kotiAvaus;
        }
        
        return this.vierasAvaus;
    }

    public double etaisyys(Pelaaja pelaaja, Pelaaja vertailtava) {
        
        double etaisyys = Math.pow((pelaaja.getPelipaikka()-vertailtava.getPelipaikka()), 2) + Math.pow(pelaaja.getSijainti() - vertailtava.getSijainti(), 2);
        
        return Math.sqrt(etaisyys);
    }
}
