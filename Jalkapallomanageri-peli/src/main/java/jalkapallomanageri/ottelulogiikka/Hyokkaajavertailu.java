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
    
    public Hyokkaajavertailu(Pelaaja pelaaja) {
        
        this.pelaaja = pelaaja;
        this.merkitsevienTaitojenKeskiarvo = (double)(pelaaja.getHarhauttaminen() + pelaaja.getMaalinteko() + pelaaja.getNopeus() + pelaaja.getSijoittuminen() + pelaaja.getSyottaminen() / 5);
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
            
            Hyokkaajavertailu hyokkaaja = (Hyokkaajavertailu) o;
            
            return -this.merkitsevienTaitojenKeskiarvo.compareTo(hyokkaaja.getMerkitsevienTaitojenKeskiarvo());
        }
        
        return 0;
    }
    
}
