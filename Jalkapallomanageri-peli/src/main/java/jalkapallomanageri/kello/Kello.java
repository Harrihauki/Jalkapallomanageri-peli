/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.kello;

/**
 * Kello pelikellon etenemisen seurantaa varten
 * 
 * @author lallimyl
 */
public class Kello {
    private YlhaaltaRajoitettuLaskuri minuutit;
    private YlhaaltaRajoitettuLaskuri sekunnit;
    
    public Kello() {
        
        minuutit = new YlhaaltaRajoitettuLaskuri(91, 1);
        sekunnit = new YlhaaltaRajoitettuLaskuri(30, 30);
    }
    
    /**
     * 
     * Kello etenee 30sekuntia joka "askeleella" ja lisää joka toisella askeleella
     * minuutin.
     */
    public void etene() {
        
        sekunnit.seuraava();
        if (sekunnit.getArvo() == 0) {
            minuutit.seuraava();
        }
    }
     
    public String toString() {
        
        return minuutit.toString() + ":" + sekunnit.toString();
    }
}
