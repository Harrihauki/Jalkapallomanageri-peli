/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.domain;

/**
 *
 * @author lallimyl
 */
public class Maalivahti implements Pelaaja {
    
    String nimi;
    int torjuminen;
    boolean loukkaantunut;
    
    public Maalivahti(String nimi, int torjuminen) {
        
        this.nimi = nimi;
        this.torjuminen = torjuminen;
        this.loukkaantunut = false;
    }
    
    public String getNimi() {
        
        return this.nimi;
    }
    
    public int getTorjuminen() {
        
        return this.torjuminen;
    }
    
    public boolean getLoukkaantunut() {
        
        return this.loukkaantunut;
    }
    
    @Override
    public String toString() {
        
        return this.nimi + "\nTorjuminen: " + this.torjuminen + "\nLoukkaantunut: " + this.loukkaantunut;
    }

    @Override
    public void loukkaannu() {
        
        this.loukkaantunut = true;
    }

    @Override
    public void parane() {
        
        this.loukkaantunut = false;
    }
    
}
