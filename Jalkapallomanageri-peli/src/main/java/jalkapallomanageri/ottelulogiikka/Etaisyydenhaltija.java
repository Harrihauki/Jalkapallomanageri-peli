/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.ottelulogiikka;

import jalkapallomanageri.domain.Pelaaja;

/**
 * Luokka on apuluokka pelaajien etäisyyksien vertailua varten
 * 
 */
public class Etaisyydenhaltija implements Comparable {
    
    private Pelaaja pelaaja;
    private Double etaisyys;
    
    /**
     *
     * @param pelaaja
     * @param etaisyys
     */
    public Etaisyydenhaltija(Pelaaja pelaaja, double etaisyys) {
        
        this.pelaaja = pelaaja;
        this.etaisyys = etaisyys;
    }
    
    /**
     *
     * @return
     */
    public Pelaaja getPelaaja() {
        
        return this.pelaaja;
    }
    
    /**
     *
     * @return
     */
    public double getEtaisyys() {
        
        return this.etaisyys;
    }
    
    /**
     * Pelaajat asetetaan compareTo-metodin avulla etäisyyden mukaan pienimmästä
     * suurimpaan. Luokan tärkein ominaisuus.
     * 
     * @param o toinen Etaisyydenhaltija-luokan olio
     * @return vertailu
     */

    @Override
    public int compareTo(Object o) {
        
        if (o.getClass() == this.getClass()) {
            
            Etaisyydenhaltija haltija = (Etaisyydenhaltija) o;
            
            return this.etaisyys.compareTo(haltija.getEtaisyys());
        }
        
        return 0;
    }
    
    
    
}
