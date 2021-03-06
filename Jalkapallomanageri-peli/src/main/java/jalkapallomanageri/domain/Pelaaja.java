/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.domain;

/**
 * Luokka pitää yllä pelaajan tiedot.
 * 
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
    private int tehdytMaalit;
    
    /**
     *
     * @param nimi
     * @param sijoittuminen
     * @param nopeus
     * @param maalinteko
     * @param syottaminen
     * @param puolustus
     * @param harhauttaminen
     * @param maalivahti
     */
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
        this.tehdytMaalit = 0;
    }
    
    /**
     *
     * @return
     */
    public String getNimi() {
        
        return this.nimi;
    }
    
    public int getTehdytMaalit() {
        
        return this.tehdytMaalit;
    }
    
    /**
     * Metodi lisää pelaajalle yhden maalin lisää kutsuttaessa. Näin pidetään
     * kirjaa pelaajien maalimääristä kauden aikana.
     */
    public void lisaaMaali() {
        
        this.tehdytMaalit++;
    }
    
    /**
     *
     * @return
     */
    public int getSijoittuminen() {
        
        return this.sijoittuminen;
    }
    
    /**
     *
     * @return
     */
    public int getNopeus() {
        
        return this.nopeus;
    }
    
    /**
     *
     * @return
     */
    public int getMaalinteko() {
        
        return this.maalinteko;
    }
    
    /**
     *
     * @return
     */
    public int getSyottaminen() {
        
        return this.syottaminen;
    }
    
    /**
     *
     * @return
     */
    public int getPuolustus() {
        
        return this.puolustus;
    }
    
    /**
     *
     * @return
     */
    public int getHarhauttaminen() {
        
        return this.harhauttaminen;
    }
    
    /**
     *
     * @return
     */
    public int getMaalivahti() {
        
        return this.maalivahti;
    }
    
    /**
     *
     * @return
     */
    public boolean getLoukkaantunut() {
        
        return this.loukkaantunut;
    }
    
    @Override
    public String toString() {
        
        return this.nimi + "\nSijoittuminen: " + this.sijoittuminen + "\nNopeus: " + this.nopeus + "\nMaalinteko: " + this.maalinteko + "\nSyöttäminen: " + this.syottaminen + "\nPuolustus: " + this.puolustus + "\nHarhauttaminen: " + this.harhauttaminen + "\nMaalivahti: " + this.maalivahti + "\nLoukkaantunut: " + this.loukkaantunut + "\n" + "\nTehdyt maalit: " + this.tehdytMaalit;
    }

    /**
     * Muuttaa pelaajan loukkaantunut-attribuutin arvoksi "true", jolloin pelaaja
     * ei voi pelata seuraavassa ottelussa
     *
     */
    public void loukkaannu() {
        
        this.loukkaantunut = true;
    }

    /**
     * Muuttaa pelaajan loukkaantunut-attribuutin arvoksi "false", jolloin pelaaja
     * voi taas pelata
     *
     */
    public void parane() {
        
        this.loukkaantunut = false;
    }

    /**
     *
     * @param pelipaikka
     */
    public void setPelipaikka(int pelipaikka) {
        
        this.pelipaikka = pelipaikka;
    }

    /**
     *
     * @param sijainti
     */
    public void setSijainti(int sijainti) {
        
        this.sijainti = sijainti;
    }
    
    /**
     *
     * @return
     */
    public int getPelipaikka() {
        
        return this.pelipaikka;
    }
    
    /**
     *
     * @return
     */
    public int getSijainti() {
        
        return this.sijainti;
    }
    
    /**
     * Palauttaa pelaajan sijainnin kentällä.
     *
     * @return String   sijainti muodossa "x,y"
     */
    public String koordinaattiEsitys() {
        
        return "" + this.pelipaikka + "," + this.sijainti;
    }
    
}
