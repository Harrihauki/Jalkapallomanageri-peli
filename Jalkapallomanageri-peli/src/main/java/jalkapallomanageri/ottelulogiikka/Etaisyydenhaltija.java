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
public class Etaisyydenhaltija implements Comparable {
    
    private Pelaaja pelaaja;
    private Double etaisyys;
    
    public Etaisyydenhaltija(Pelaaja pelaaja, double etaisyys) {
        
        this.pelaaja = pelaaja;
        this.etaisyys = etaisyys;
    }
    
    public Pelaaja getPelaaja() {
        
        return this.pelaaja;
    }
    
    public double getEtaisyys() {
        
        return this.etaisyys;
    }

    @Override
    public int compareTo(Object o) {
        
        if (o.getClass() == this.getClass()) {
            
            Etaisyydenhaltija haltija = (Etaisyydenhaltija) o;
            
            return this.etaisyys.compareTo(haltija.getEtaisyys());
        }
        
        return 0;
    }
    
    
    
}
