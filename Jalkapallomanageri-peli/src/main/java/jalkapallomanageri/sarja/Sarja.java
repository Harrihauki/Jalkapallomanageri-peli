/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.sarja;

import jalkapallomanageri.domain.BottiJoukkue;
import jalkapallomanageri.domain.Joukkue;
import jalkapallomanageri.domain.KayttajanJoukkue;
import jalkapallomanageri.ottelulogiikka.Ottelu;
import jalkapallomanageri.pelaajaGeneraattori.Pelaajageneraattori;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Luo peliin liittyvät joukkueet ja ylläpitää tiedon niistä, sekä niiden pelaa-
 * mista otteluista.
 */
public class Sarja {
    
    private List<Joukkue> joukkueet;
    private int moneskoKierros;
    private Random arpoja;
    private Pelaajageneraattori generaattori;
    
    /**
     *
     * @param joukkueenNimi
     * @param arpoja
     */
    public Sarja(String joukkueenNimi, Random arpoja) {
        
        this.arpoja = arpoja;
        this.generaattori = new Pelaajageneraattori(this.arpoja);
        this.joukkueet = luoJoukkueet(joukkueenNimi);
        this.moneskoKierros = 1;
    }
    
    /**
     *
     * @return
     */
    public List<Joukkue> getJoukkueet() {
        
        return this.joukkueet;
    }
    
    /**
     *
     * @return
     */
    public int getKierrokset() {
        
        return this.moneskoKierros;
    }
    
    /**
     * Kasvattaa kierroslukua.
     *
     */
    public void seuraavaKierros() {
        
        this.moneskoKierros = this.moneskoKierros + 1;
    }
    
    /**
     * Luo sarjaan joukkueet.
     * 
     * @param nimi käyttäjän valitsema nimi joukkueelleen.
     * @return lista luoduista joukkueista
     */

    private List<Joukkue> luoJoukkueet(String nimi) {
        
        List<Joukkue> joukkueetTest = new ArrayList();
        List<String> bottienNimet = bottienNimet();
        
        joukkueetTest.add(new KayttajanJoukkue(nimi));
        
        if (bottienNimet.contains(nimi)) {
            
            bottienNimet.remove(nimi);
        }
        
        for (int i = 0; i < 9; i++) {
            
            joukkueetTest.add(new BottiJoukkue(bottienNimet.get(i)));
        }
        
        for (Joukkue joukkue : joukkueetTest) {
            
            joukkue.generoiPelaajat(this.generaattori);
        }
        return joukkueetTest;
    }
    
    /**
     * Bottijoukkueiden mahdolliset nimet.
     * 
     * @return Lista bottijoukkueiden nimistä.
     */

    private List<String> bottienNimet() {
        
        List<String> nimet = new ArrayList();
        
        nimet.add("HJK");
        nimet.add("VPS");
        nimet.add("VIFK");
        nimet.add("MIFK");
        nimet.add("KTP");
        nimet.add("HIFK");
        nimet.add("PuiU");
        nimet.add("Ilves");
        nimet.add("RoPS");
        nimet.add("Reipas");
        
        return nimet;
    }

    /**
     * Luo kullekin kierrokselle ottelut siten, että joka kierroksella pelataan
     * uutta joukkuetta vastaan.
     *
     * @return lista otteluista
     */
    public List<Ottelu> luoKierroksenOttelut() {
        
        List<Ottelu> ottelut = new ArrayList();
        int seuraavanKotiJoukkueenIndeksi = 0;
        
        for (int i = 0; i < this.joukkueet.size() / 2; i++) {
            
            ottelut.add(new Ottelu(this.joukkueet.get(seuraavanKotiJoukkueenIndeksi), this.joukkueet.get((seuraavanKotiJoukkueenIndeksi+this.moneskoKierros) % this.joukkueet.size()), this.arpoja));
            seuraavanKotiJoukkueenIndeksi = (seuraavanKotiJoukkueenIndeksi + this.moneskoKierros*2) % this.joukkueet.size();
        }
        
        return ottelut;
    }
    
}
