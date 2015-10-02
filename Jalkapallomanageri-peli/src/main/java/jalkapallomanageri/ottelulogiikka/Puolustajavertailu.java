/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.ottelulogiikka;

import jalkapallomanageri.domain.Pelaaja;

/**
 * Vertailee joukkueen pelaajia puolustajille merkitsevien taitojen keskiarvon avulla.
 * @author lallimyl
 */
public class Puolustajavertailu implements Comparable {
    
    private Pelaaja pelaaja;
    private Double merkitsevienTaitojenKeskiarvo;
    
    /**
     *
     * @param pelaaja
     */
    public Puolustajavertailu(Pelaaja pelaaja) {
        
        this.pelaaja = pelaaja;
        this.merkitsevienTaitojenKeskiarvo = (double)(pelaaja.getNopeus() + pelaaja.getPuolustus() + pelaaja.getSijoittuminen() + pelaaja.getSyottaminen()) / 4;
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
            
            Puolustajavertailu puolustaja = (Puolustajavertailu) o;
            
            return -this.merkitsevienTaitojenKeskiarvo.compareTo(puolustaja.getMerkitsevienTaitojenKeskiarvo());
        }
        
        return 0;
    }
    
}
