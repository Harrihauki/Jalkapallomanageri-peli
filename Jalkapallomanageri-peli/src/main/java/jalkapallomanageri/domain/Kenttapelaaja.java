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
public class Kenttapelaaja implements Pelaaja {
    
    String nimi;
    int paikanhaku;
    int nopeus;
    int maalinteko;
    int syottaminen;
    int puolustus;
    int harhauttaminen;
    boolean loukkaantunut;
    
    public Kenttapelaaja(String nimi, int paikanhaku, int nopeus, int maalinteko, int syottaminen, int puolustus, int harhauttaminen) {
        
        this.nimi = nimi;
        this.paikanhaku = paikanhaku;
        this.nopeus = nopeus;
        this.maalinteko = maalinteko;
        this.syottaminen = syottaminen;
        this.puolustus = puolustus;
        this.harhauttaminen = harhauttaminen;
        this.loukkaantunut = false;
    }
    
    public String getNimi() {
        
        return this.nimi;
    }
    
    public int getPaikanhaku() {
        
        return this.paikanhaku;
    }
    
    public int getNopeus() {
        
        return this.nopeus;
    }
    
    public int getMaalinteko() {
        
        return this.maalinteko;
    }
    
    public int getSyottaminen() {
        
        return this.syottaminen;
    }
    
    public int getPuolustus() {
        
        return this.puolustus;
    }
    
    public int getHarhauttaminen() {
        
        return this.harhauttaminen;
    }
    
    public boolean getLoukkaantunut() {
        
        return this.loukkaantunut;
    }
    
    @Override
    public String toString() {
        
        return this.nimi + "\nPaikanhaku: " + this.paikanhaku + "\nNopeus: " + this.nopeus + "\nMaalinteko: " + this.maalinteko + "\nSyöttäminen: " + this.syottaminen + "\nPuolustus: " + this.puolustus + "\nHarhauttaminen: " + this.harhauttaminen + "\nLoukkaantunut: " + this.loukkaantunut;
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
