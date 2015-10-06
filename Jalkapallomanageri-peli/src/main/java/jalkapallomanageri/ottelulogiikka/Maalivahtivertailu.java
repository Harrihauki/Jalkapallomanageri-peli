/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.ottelulogiikka;

import jalkapallomanageri.domain.Pelaaja;

/**
 * Vertailee joukkueen pelaajia maalivahdille merkitsevien taitojen keskiarvon avulla.
 * @author lallimyl
 */
public class Maalivahtivertailu implements Comparable {
    
    private Pelaaja pelaaja;
    private Double merkitsevienTaitojenKeskiarvo;
    
    /**
     *Konstruktori laskee keskiarvon taidoille, jotka ovat merkitseviä hyökkääjän
     * pelaamisessa. Tätä käytetään pelaajien vertailussa
     * 
     * @param pelaaja
     */
    public Maalivahtivertailu(Pelaaja pelaaja) {
        
        this.pelaaja = pelaaja;
        this.merkitsevienTaitojenKeskiarvo = (double)(pelaaja.getMaalivahti() + pelaaja.getSijoittuminen()) / 2;
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
    public double getMerkitsevienTaitojenKeskiarvo() {
        
        return this.merkitsevienTaitojenKeskiarvo;
    }
    
    /**
     * Vertaillaan pelaajia merkitsevien taitojen keskiarvon perusteella.
     * 
     * @param o Toinen Hyokkaajavertailu-luokan olio
     * @return 
     */

    @Override
    public int compareTo(Object o) {
        
        if (o.getClass() == this.getClass()) {
            
            Maalivahtivertailu mv = (Maalivahtivertailu) o;
            
            return -this.merkitsevienTaitojenKeskiarvo.compareTo(mv.getMerkitsevienTaitojenKeskiarvo());
        }
        
        return 0;
    }
    
}
