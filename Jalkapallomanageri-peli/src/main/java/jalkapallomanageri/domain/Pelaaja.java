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
public class Pelaaja {
    
    private String nimi;
    private int sijoittuminen;
    private int nopeus;
    private int maalinteko;
    private int syottaminen;
    private int puolustus;
    private int harhauttaminen;
    private int maalivahti;
    private boolean loukkaantunut;
    private int pelipaikka;
    private int sijainti;
    
    public Pelaaja(String nimi, int sijoittuminen, int nopeus, int maalinteko, int syottaminen, int puolustus, int harhauttaminen, int maalivahti) {
        
        this.nimi = nimi;
        this.sijoittuminen = sijoittuminen;
        this.nopeus = nopeus;
        this.maalinteko = maalinteko;
        this.syottaminen = syottaminen;
        this.puolustus = puolustus;
        this.harhauttaminen = harhauttaminen;
        this.maalivahti = maalivahti;
        this.loukkaantunut = false;
        this.pelipaikka = 0;
        this.sijainti = 0;
    }
    
    public String getNimi() {
        
        return this.nimi;
    }
    
    public int getSijoittuminen() {
        
        return this.sijoittuminen;
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
    
    public int getMaalivahti() {
        
        return this.maalivahti;
    }
    
    public boolean getLoukkaantunut() {
        
        return this.loukkaantunut;
    }
    
    @Override
    public String toString() {
        
        return this.nimi + "\nSijoittuminen: " + this.sijoittuminen + "\nNopeus: " + this.nopeus + "\nMaalinteko: " + this.maalinteko + "\nSyöttäminen: " + this.syottaminen + "\nPuolustus: " + this.puolustus + "\nHarhauttaminen: " + this.harhauttaminen + "\nMaalivahti: " + this.maalivahti + "\nLoukkaantunut: " + this.loukkaantunut;
    }

    public void loukkaannu() {
        
        this.loukkaantunut = true;
    }

    public void parane() {
        
        this.loukkaantunut = false;
    }

    public void setPelipaikka(int pelipaikka) {
        
        this.pelipaikka = pelipaikka;
    }

    public void setSijainti(int sijainti) {
        
        this.sijainti = sijainti;
    }
    
    public int getPelipaikka() {
        
        return this.pelipaikka;
    }
    
    public int getSijainti() {
        
        return this.sijainti;
    }
    
    public String koordinaattiEsitys() {
        
        return "" + this.pelipaikka + "," + this.sijainti;
    }
    
}
