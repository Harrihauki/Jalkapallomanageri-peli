/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.sarja;

import jalkapallomanageri.domain.Joukkue;

/**
 * Pisteenlaskija pitää huolta yksittäisen joukkueen pisteistä
 * @author lallimyl
 */
public class Pisteenlaskija implements Comparable {
    
    private String nimi;
    private Joukkue joukkue;
    private int pisteet;
    private int tehdytMaalit;
    private int paastetytMaalit;
    
    public Pisteenlaskija(Joukkue joukkue) {
        
        this.joukkue = joukkue;
        this.nimi = joukkue.getNimi();
        this.pisteet = 0;
        this.paastetytMaalit = 0;
        this.tehdytMaalit = 0;
    }
    
    public Joukkue getJoukkue() {
        
        return this.joukkue;
    }
    
    /**
     * Lisaa parametrin mukaisen määrän pisteitä joukkueelle
     * @param pisteet lisättävät pisteet
     */
    public void lisaaPisteita(int pisteet) {
        
        this.pisteet = this.pisteet + pisteet;
    }
    
    /**
     * Lisää parametrin mukaisen määrän tehtyjä maaleja joukkueelle
     * @param maalit tehdyt maalit
     */
    
    public void lisaaTehtyjaMaaleja(int maalit) {
        
        this.tehdytMaalit += maalit;
    }
    
    /**
     * Lisää parametrin mukaisen määrän päästettyjä maaleja joukkueelle
     * @param maalit päästetyt maalit
     */
    public void lisaaPaastettyjaMaaleja(int maalit) {
        
        this.paastetytMaalit+= maalit;
    }
    
    @Override
    public String toString() {
        
        int maaliero = this.tehdytMaalit - this.paastetytMaalit;
        
        return this.nimi + "  " + this.tehdytMaalit + "  " + this.paastetytMaalit + "  " + maaliero + "  " + this.pisteet;
    }
    
    public int getPisteet() {
        
        return this.pisteet;
    }
    
    public int getMaaliero() {
        
        return this.tehdytMaalit-this.paastetytMaalit;
    }
    
    public int getTehdytMaalit() {
        
        return this.tehdytMaalit;
    }
    
    /**
     * Vertaa joukkueita keskenään ensin pisteiden, sitten maalieron ja lopuksi
     * tehtyjen maalien mukaan
     * @param o toinen Pisteenlaskija
     * @return 
     */
    @Override
    public int compareTo(Object o) {
        
        Pisteenlaskija vertailtava = (Pisteenlaskija) o;
        
        if (vertailtava.getPisteet() == this.pisteet) {
            if (vertailtava.getMaaliero() == this.tehdytMaalit - this.paastetytMaalit) {
                if (vertailtava.getTehdytMaalit() == this.tehdytMaalit) {
                    
                    return 0;
                }
                
                return vertailtava.tehdytMaalit - this.tehdytMaalit;
            }
            
            if (vertailtava.getMaaliero() < 0 && this.getMaaliero() < 0) {
                return vertailtava.getMaaliero() - this.getMaaliero();
            } else if (vertailtava.getMaaliero() < 0) {
                return -1;
            } else if (this.getMaaliero() < 0) {
                return 1;
            }
            
            return vertailtava.getMaaliero() - this.getMaaliero();
        }
        
        return vertailtava.getPisteet() - this.pisteet;
    }
}
