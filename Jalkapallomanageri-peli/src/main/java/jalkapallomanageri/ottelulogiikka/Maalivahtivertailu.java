/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.ottelulogiikka;

import jalkapallomanageri.domain.Pelaaja;

/**
 *
 * @author lallimyl
 */
public class Maalivahtivertailu implements Comparable {
    
    private Pelaaja pelaaja;
    private Double merkitsevienTaitojenKeskiarvo;
    
    public Maalivahtivertailu(Pelaaja pelaaja) {
        
        this.pelaaja = pelaaja;
        this.merkitsevienTaitojenKeskiarvo = (double)(pelaaja.getMaalivahti() + pelaaja.getSijoittuminen()) / 2;
    }
    
    public Pelaaja getPelaaja() {
        
        return this.pelaaja;
    }
    
    public double getMerkitsevienTaitojenKeskiarvo() {
        
        return this.merkitsevienTaitojenKeskiarvo;
    }

    @Override
    public int compareTo(Object o) {
        
        if (o.getClass() == this.getClass()) {
            
            Maalivahtivertailu mv = (Maalivahtivertailu) o;
            
            return this.merkitsevienTaitojenKeskiarvo.compareTo(mv.getMerkitsevienTaitojenKeskiarvo());
        }
        
        return 0;
    }
    
}
