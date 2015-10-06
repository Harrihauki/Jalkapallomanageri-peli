/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.ottelulogiikka;

import jalkapallomanageri.domain.Pelaaja;

/**
 * Vertailee joukkueen pelaajia hyökkääjille merkitsevien taitojen keskiarvon avulla.
 * @author lallimyl
 */
public class Hyokkaajavertailu implements Comparable {
    
    private Pelaaja pelaaja;
    private Double merkitsevienTaitojenKeskiarvo;
    
    /**
     * Konstruktori laskee keskiarvon taidoille, jotka ovat merkitseviä hyökkääjän
     * pelaamisessa. Tätä käytetään pelaajien vertailussa
     *
     * @param pelaaja
     */
    public Hyokkaajavertailu(Pelaaja pelaaja) {
        
        this.pelaaja = pelaaja;
        this.merkitsevienTaitojenKeskiarvo = (double)(pelaaja.getHarhauttaminen() + pelaaja.getMaalinteko() + pelaaja.getNopeus() + pelaaja.getSijoittuminen() + pelaaja.getSyottaminen() / 5);
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
            
            Hyokkaajavertailu hyokkaaja = (Hyokkaajavertailu) o;
            
            return -this.merkitsevienTaitojenKeskiarvo.compareTo(hyokkaaja.getMerkitsevienTaitojenKeskiarvo());
        }
        
        return 0;
    }
    
}
