/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.ottelulogiikka;

import jalkapallomanageri.domain.Pelaaja;

/**
 * Vertailee joukkueen pelaajia keskikenttäpelaajille merkitsevien taitojen keskiarvon avulla.
 * @author lallimyl
 */
public class Keskikenttavertailu implements Comparable {
    
    private Pelaaja pelaaja;
    private Double merkitsevienTaitojenKeskiarvo;
    
    /**
     *Konstruktori laskee keskiarvon taidoille, jotka ovat merkitseviä keskikenttapelaajien
     * pelaamisessa. Tätä käytetään pelaajien vertailussa
     * 
     * @param pelaaja
     */
    public Keskikenttavertailu(Pelaaja pelaaja) {
        
        this.pelaaja = pelaaja;
        this.merkitsevienTaitojenKeskiarvo = (double)(pelaaja.getHarhauttaminen() + pelaaja.getNopeus() + pelaaja.getPuolustus() + pelaaja.getSijoittuminen() + pelaaja.getSyottaminen()) / 5;
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
            
            Keskikenttavertailu kk = (Keskikenttavertailu) o;
            
            return -this.merkitsevienTaitojenKeskiarvo.compareTo(kk.getMerkitsevienTaitojenKeskiarvo());
        }
        
        return 0;
    }
    
}
