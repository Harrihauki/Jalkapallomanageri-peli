/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.sarja;

import jalkapallomanageri.domain.Joukkue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Sarjataulukko pitää huolta sarjan pistetilanteesta
 * @author lallimyl
 */
public class Sarjataulukko {
    
    List<Pisteenlaskija> pisteet;
    
    public Sarjataulukko(List<Joukkue> joukkueet) {
        
        this.pisteet = new ArrayList();
        
        for (Joukkue joukkue : joukkueet) {
            
            this.pisteet.add(new Pisteenlaskija(joukkue));
        }
    }
    
    
    /**
     * Järjestää joukkueet pisteiden mukaiseen järjestykseen suurimmasta pienimpään
     */
    public void jarjesta() {
        
        Collections.sort(this.pisteet);
    }
    
    @Override
    public String toString() {
        
        String tuloste = "";
        
        for (Pisteenlaskija laskija : this.pisteet) {
            
            tuloste += laskija.toString() + "\n";
        }
        
        return tuloste; 
    }
    
}
