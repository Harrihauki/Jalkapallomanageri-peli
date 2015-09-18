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
    
    //HUOM! Nyt ajateltuna voisi olla järkevää, että Ottelu-luokka tuntusu avauksien ja maalivahdin
    //sijaan vain molempien joukkueiden Muodostelmat. Täytyy funtsia.
    
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
    
    public Map<Pelaaja, Double> laskeOmienEtaisyydet(Pelaaja pelaaja) {
        
        List<Pelaaja> vertailtavatPelaajat = this.pallollisenJoukkueenPelaajat(pelaaja);
        
        Map<Pelaaja, Double> pelaajienEtaisyydet = new HashMap();
        
        for (Pelaaja vertailtava : vertailtavatPelaajat) {
            
            if (this.etaisyys(pelaaja, vertailtava) == 0.0) {
                
                continue;
            }
            
            pelaajienEtaisyydet.put(vertailtava, etaisyys(pelaaja, vertailtava));
        }
        
        return pelaajienEtaisyydet;
    }
    
    public Map<Pelaaja, Double> laskeVastustajienEtaisyydet(Pelaaja pelaaja) {
        
        List<Pelaaja> vertailtavatPelaajat = this.pallottomanJoukkueenPelaajat(pelaaja);
        
        Map<Pelaaja, Double> pelaajienEtaisyydet = new HashMap();
        
        for (Pelaaja vertailtava : vertailtavatPelaajat) {
            
            pelaajienEtaisyydet.put(vertailtava, etaisyys(pelaaja, vertailtava));
        }
        
        return pelaajienEtaisyydet;
    }

    public List<Pelaaja> pallollisenJoukkueenPelaajat(Pelaaja pallollinenPelaaja) {
        
        if (this.kotiAvaus.contains(pallollinenPelaaja)) {
            
            return this.kotiAvaus;
        }
        
        return this.vierasAvaus;
    }
    
    public List<Pelaaja> pallottomanJoukkueenPelaajat(Pelaaja pallollinenPelaaja) {
        
        if (this.kotiAvaus.contains(pallollinenPelaaja)) {
            
            return this.vierasAvaus;
        }
        
        return this.kotiAvaus;
    }

    public double etaisyys(Pelaaja pelaaja, Pelaaja vertailtava) {
        
        double etaisyys = Math.pow((pelaaja.getPelipaikka()-vertailtava.getPelipaikka()), 2) + Math.pow(pelaaja.getSijainti() - vertailtava.getSijainti(), 2);
        
        return Math.sqrt(etaisyys);
    }
    
    
}
