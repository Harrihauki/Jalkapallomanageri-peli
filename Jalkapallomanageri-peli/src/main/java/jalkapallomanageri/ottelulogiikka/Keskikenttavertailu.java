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
    
    public Keskikenttavertailu(Pelaaja pelaaja) {
        
        this.pelaaja = pelaaja;
        this.merkitsevienTaitojenKeskiarvo = (double)(pelaaja.getHarhauttaminen() + pelaaja.getNopeus() + pelaaja.getPuolustus() + pelaaja.getSijoittuminen() + pelaaja.getSyottaminen()) / 5;
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
            
            Keskikenttavertailu kk = (Keskikenttavertailu) o;
            
            return -this.merkitsevienTaitojenKeskiarvo.compareTo(kk.getMerkitsevienTaitojenKeskiarvo());
        }
        
        return 0;
    }
    
}
