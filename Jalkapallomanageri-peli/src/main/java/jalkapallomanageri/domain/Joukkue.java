/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.domain;

import jalkapallomanageri.ottelulogiikka.Muodostelma;
import jalkapallomanageri.pelaajaGeneraattori.Pelaajageneraattori;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author lallimyl
 */
public abstract class Joukkue {
    
    Map<String, Pelaaja> pelaajat;
    String nimi;
    Muodostelma muodostelma;
    
    public Joukkue(String nimi) {
        
        this.nimi = nimi;
        this.pelaajat = new HashMap<>();
        this.muodostelma = new Muodostelma();
    }
    
    public String getNimi() {
        
        return this.nimi;
    }
    
    public void generoiPelaajat(Pelaajageneraattori generaattori) {
        
        for (int i = 0; i < 16; i++) {
            
            Pelaaja pelaaja = generaattori.luoPelaaja();
            
            this.pelaajat.put(pelaaja.getNimi(), pelaaja);
        }
    }
    
    public Map<String, Pelaaja> getPelaajat() {
        
        return this.pelaajat;
    }
    
    public Muodostelma getMuodostelma() {
        
        return this.muodostelma;
    }
    
}
