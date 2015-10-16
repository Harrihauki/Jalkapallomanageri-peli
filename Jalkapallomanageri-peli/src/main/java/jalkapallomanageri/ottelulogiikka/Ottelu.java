/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.ottelulogiikka;

import jalkapallomanageri.domain.Joukkue;
import jalkapallomanageri.domain.Pelaaja;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Luokka sisältää ottelumekaniikan ja ylläpitää tiedon ottelun tilanteesta.
 */
public class Ottelu {
    
    //HUOM! Nyt ajateltuna voisi olla järkevää, että Ottelu-luokka tuntusu avauksien ja maalivahdin
    //sijaan vain molempien joukkueiden Muodostelmat. Täytyy funtsia.
    
    private Joukkue koti;
    private Joukkue vieras;
    private List<Pelaaja> kotiAvaus;
    private List<Pelaaja> vierasAvaus;
    private Pelaaja kotiMV;
    private Pelaaja vierasMV;
    private Random arpoja;
    private int vierasmaalit;
    private int kotimaalit;
    private Pelaaja pallonhaltija;
    private Pelaaja edellinenPallonhaltija;
    
    /**
     *
     * @param koti
     * @param vieras
     * @param arpoja
     */
    public Ottelu(Joukkue koti, Joukkue vieras, Random arpoja) {
        
        this.koti = koti;
        this.vieras = vieras;
        this.kotiAvaus = koti.getMuodostelma().getAvauskentallinen();
        this.vierasAvaus = vieras.getMuodostelma().getAvauskentallinen();
        this.kotiMV = koti.getMuodostelma().getMaalivahti();
        this.vierasMV = vieras.getMuodostelma().getMaalivahti();
        this.arpoja = arpoja;
        this.vierasmaalit = 0;
        this.kotimaalit = 0;
        this.pallonhaltija = kotiAvaus.get(0);
    }
    
    /**
     *
     * @return 
     */
    public Joukkue getKoti() {
        
        return this.koti;
    }
    
    /**
     * Lisaa maalintehneelle joukkueelle maalin
     */
    public void lisaaMaali() {
        
        if (this.kotiAvaus.contains(this.pallonhaltija)) {
            this.kotimaalit = this.kotimaalit + 1;
        } else {
            this.vierasmaalit = this.vierasmaalit + 1;
        }
    }
    
    /**
     *
     * @return
     */
    public int getKotimaalit() {
        
        return this.kotimaalit;
    }
    
    /**
     *
     * @return
     */
    public int getVierasmaalit() {
        
        return this.vierasmaalit;
    }
    
    /**
     *
     * @return
     */
    public Joukkue getVieras() {
        
        return this.vieras;
    }
    
    /**
     * Asettaa muuttujaan pelaajan, jolla tällä hetkellä on pallo
     * @param pelaaja syötön vastaanottanut tai pallon riistänyt pelaaja
     */
    public void setPallonhaltija(Pelaaja pelaaja) {
        
        this.edellinenPallonhaltija = this.pallonhaltija;
        this.pallonhaltija = pelaaja;
    }
    
    public Pelaaja getPallonhaltija() {
        
        return this.pallonhaltija;
    }
    
    public Pelaaja getEdellinenPallonhaltija() {
        
        return this.edellinenPallonhaltija;
    }
    
    /**
     * Laskee omien pelaajien etäisyydet pelaajasta
     * @param pelaaja 
     * @return Map avaimena pelaaja, arvona pelaajan etäisyys vertailtavasta pelaajasta
     */
    public Map<Pelaaja, Double> laskeOmienEtaisyydet(Pelaaja pelaaja) {
        
        List<Pelaaja> vertailtavatPelaajat = this.pallollisenJoukkueenPelaajat(pelaaja);
        
        Map<Pelaaja, Double> pelaajienEtaisyydet = new HashMap();
        
        for (Pelaaja vertailtava : vertailtavatPelaajat) {
            
            if (this.omanPelaajanEtaisyys(pelaaja, vertailtava) == 0.0) {
                
                continue;
            }
            
            pelaajienEtaisyydet.put(vertailtava, omanPelaajanEtaisyys(pelaaja, vertailtava));
        }
        
        return pelaajienEtaisyydet;
    }
    
    /**
     * Laskee vastustajan pelaajien etäisyydet halutusta pelaajasta
     *
     * @param pelaaja
     * @return Map, avaimena vastustajan pelaaja ja arvona etäisyys halutusta pelaajasta
     */
    public Map<Pelaaja, Double> laskeVastustajienEtaisyydet(Pelaaja pelaaja) {
        
        List<Pelaaja> vertailtavatPelaajat = this.pallottomanJoukkueenPelaajat(pelaaja);
        
        Map<Pelaaja, Double> pelaajienEtaisyydet = new HashMap();
        
        for (Pelaaja vertailtava : vertailtavatPelaajat) {
            
            pelaajienEtaisyydet.put(vertailtava, vastustajanEtaisyys(pelaaja, vertailtava));
        }
        
        return pelaajienEtaisyydet;
    }

    /**
     * Palautetaan listana sen joukkueen pelaajat, jonka pelaaja nykyinen 
     * pallonhaltija on.
     *
     * @param pallollinenPelaaja
     * @return lista joukkueen pelaajista
     */
    public List<Pelaaja> pallollisenJoukkueenPelaajat(Pelaaja pallollinenPelaaja) {
        
        if (this.kotiAvaus.contains(pallollinenPelaaja)) {
            
            return this.kotiAvaus;
        }
        
        return this.vierasAvaus;
    }
    
    /**
     * Palautetaan listana sen joukkueen pelaajat, jonka pelaaja nykyinen 
     * pallonhaltija ei ole.
     *
     * @param pallollinenPelaaja
     * @return lista joukkueen pelaajista
     */
    public List<Pelaaja> pallottomanJoukkueenPelaajat(Pelaaja pallollinenPelaaja) {
        
        if (this.kotiAvaus.contains(pallollinenPelaaja)) {
            
            return this.vierasAvaus;
        }
        
        return this.kotiAvaus;
    }

    /**
     * Laskee oman yksittäisen pelaajan etäisyyden halutusta pelaajasta
     *
     * @param pelaaja
     * @param vertailtava
     * @return eäisyys desimaalilukuna
     */
    public double omanPelaajanEtaisyys(Pelaaja pelaaja, Pelaaja vertailtava) {
        
        double etaisyys = Math.pow((pelaaja.getPelipaikka()-vertailtava.getPelipaikka()), 2) + Math.pow(pelaaja.getSijainti() - vertailtava.getSijainti(), 2);
        
        return Math.sqrt(etaisyys);
    }
    
    /**
     * Laskee vastustajan pelaajan etäisyyden halutusta pelaajasta.
     *
     * @param pelaaja haluttu pelaaja
     * @param vertailtava vastustajan pelaaja
     * @return etäisyys desimaalilukuna
     */
    public double vastustajanEtaisyys(Pelaaja pelaaja, Pelaaja vertailtava) {
        
        double etaisyys = Math.pow((pelaaja.getPelipaikka()- (6 - vertailtava.getPelipaikka())), 2) + Math.pow(pelaaja.getSijainti() - (6 - vertailtava.getSijainti()), 2);
        
        return Math.sqrt(etaisyys);
    }
    
    /**
     * Arpoo kolmesta lähimmästä vastustajasta, ketä vastaan pallollinen pelaaja
     * pelaa
     *
     * @return pelaaja vastustaja
     */
    public Pelaaja ketaVastaan() {
        
        Map<Pelaaja, Double> mahdollisetVastustajat = laskeVastustajienEtaisyydet(this.pallonhaltija);
        
        List<Etaisyydenhaltija> vastustajatJarjestyksessa = etaisyydetJarjestyksessa(mahdollisetVastustajat);
        
        Pelaaja vastustaja = arvoKohde(vastustajatJarjestyksessa, 3);
        
        return vastustaja;
    }
    
    /**
     * Arpoo etäisyyden mukaan painotetusti, kenelle pallollinen pelaaja yrittää
     * syöttää
     *
     * @return pelaaja, syötön kohde
     */
    public Pelaaja kenelleSyotetaan() {
        
        Map<Pelaaja, Double> mahdollisetSyotonKohteet = laskeOmienEtaisyydet(this.pallonhaltija);
        
        List<Etaisyydenhaltija> omatJarjestyksessa = etaisyydetJarjestyksessa(mahdollisetSyotonKohteet);
        
        Pelaaja syotonKohde = arvoKohde(omatJarjestyksessa, 9);
        
        return syotonKohde;
    }

    /**
     * Järjestää halutut pelaajat etäisyyden mukaan järjestykseen
     *
     * @param jarjestettavatPelaajat
     * @return järjestetty lista pelaajien Etaisyydenhaltijoista
     */
    public List<Etaisyydenhaltija> etaisyydetJarjestyksessa(Map<Pelaaja, Double> jarjestettavatPelaajat) {
        
        List<Etaisyydenhaltija> etaisyydetJarjestyksessa = new ArrayList();
        
        for (Pelaaja pelaaja : jarjestettavatPelaajat.keySet()) {
            
            Etaisyydenhaltija haltija = new Etaisyydenhaltija(pelaaja, jarjestettavatPelaajat.get(pelaaja));
            
            etaisyydetJarjestyksessa.add(haltija);
        }
        
        Collections.sort(etaisyydetJarjestyksessa);
        
        return etaisyydetJarjestyksessa;
    }
    
    /**
     * Arpoo halutun listan parametrin mukaisesta määrästä ensimmäisiä pelaajia,
     * kuka otetaan kohteeksi. Esimerkiksi syötön kohteet ja puolustajat arvotaan
     * tällä.
     * 
     * @param pelaajatJarjestyksessa mahdolliset kohteet
     * @param kuinkaMonesta kuinka monesta ensimmäisestä kohde arvotaan
     * @return kohdepelaaja
     */

    private Pelaaja arvoKohde(List<Etaisyydenhaltija> pelaajatJarjestyksessa, int kuinkaMonesta) {
        
        List<Etaisyydenhaltija> arpoja = new ArrayList();
        
        for (int i = 0; i < kuinkaMonesta; i++) {
            
            for (int j = 0; j < kuinkaMonesta - i; j++) {
                
                arpoja.add(pelaajatJarjestyksessa.get(i));
            }
        }
        
        Collections.shuffle(arpoja);
        
        return arpoja.get(0).getPelaaja();
    }
    
    /**
     * Arpoo painotetusti pelaajien taitojen ja etäisyyksien mukaan, onnistuuko
     * syöttö
     *
     * @param syottaja pallollinen pelaaja
     * @param puolustaja puolustava pelaaja
     * @param kohde syötön kohde
     * @return tieto siitä, onnistuuko syöttö
     */
    public boolean onnistuukoSyotto(Pelaaja puolustaja, Pelaaja kohde) {
        
        double taitojenSumma = this.pallonhaltija.getSyottaminen() + kohde.getSijoittuminen() + puolustaja.getPuolustus() + puolustaja.getSijoittuminen() + omanPelaajanEtaisyys(this.pallonhaltija, kohde);
        double taitojenSuhde = (this.pallonhaltija.getSyottaminen() + kohde.getSijoittuminen()) / taitojenSumma;
        
        double onnistuminen = this.arpoja.nextDouble();
        
        if (taitojenSuhde > onnistuminen) {
            return true;
        }
        
        return false;
    }
    
    /**
     * Arpoo pelaajien taitojen ja sijaintien perusteella, pääseekö syötön 
     * vastaanottanut pelaaja maalipaikkaan syötön jälkeen
     *
     * @param puolustaja puolustaja
     * @return tieto siitä, pääseekö pelaaja maalipaikkaan
     */
    public boolean paaseekoMaalipaikkaanSyotosta(Pelaaja puolustaja) {

        double tekijoidenSumma = this.edellinenPallonhaltija.getSyottaminen() * (1 + this.edellinenPallonhaltija.getPelipaikka()/10) + omanPelaajanEtaisyys(this.pallonhaltija, this.edellinenPallonhaltija) + 30 + puolustaja.getSijoittuminen();
        double suhdeluku = (this.edellinenPallonhaltija.getSyottaminen() * (1 + this.edellinenPallonhaltija.getPelipaikka()/10) + omanPelaajanEtaisyys(this.pallonhaltija, this.edellinenPallonhaltija)) / tekijoidenSumma;
        
        double onnistuminen = this.arpoja.nextDouble();
        
        if (suhdeluku > onnistuminen) {
            return true;
        }
        
        return false;
    }
    
    /**
     * Arpoo pelaajien taitojen perusteella, onnistuuko pelaaja maalinteossa.
     *
     * @return tieto siitä, syntyykö maali
     */
    public boolean tuleekoMaali() {
        
        Pelaaja maalivahti;
        
        if (this.kotiAvaus.contains(this.pallonhaltija)) {
            maalivahti = this.vierasMV;
        } else {
            maalivahti = this.kotiMV;
        }
        
        double taitojenSumma = this.pallonhaltija.getMaalinteko() + this.pallonhaltija.getHarhauttaminen() + maalivahti.getSijoittuminen() + maalivahti.getMaalivahti();
        double taitojenSuhde = (this.pallonhaltija.getMaalinteko() + this.pallonhaltija.getHarhauttaminen()) / taitojenSumma;
        
        double onnistuminen = this.arpoja.nextDouble();
        
        if (taitojenSuhde > onnistuminen) {
            return true;
        }
        
        return false;
    }
    
    /**
     * Arpoo pelaajien taitojen ja sijainnin perusteella, pääseekö riiston tehnyt pelaaja
     * vastahyökkäykseen
     *
     * @return tieto siitä, tuleeko vastahyökkäys
     */
    public boolean tuleekoVastahyokkays() {
        
        double summa = this.pallonhaltija.getNopeus() / this.edellinenPallonhaltija.getPelipaikka() + 5;
        double suhdeluku = (this.pallonhaltija.getNopeus() / this.edellinenPallonhaltija.getPelipaikka()) / summa;
        
        double onnistuminen = this.arpoja.nextDouble();
        
        if (suhdeluku > onnistuminen) {
            return true;
        }
        
        return false;
    }
    
    /**
     * Arpoo painotetusti pelaajan sijainnin perusteella, lähteekö pelaaja 
     * harhauttamaan vai syöttämään
     *
     * @return tieto päätöksestä
     */
    public boolean lahteekoHarhauttamaan() {
        
        int tekijoidenSumma = this.pallonhaltija.getPelipaikka() + 10;
        double suhdeluku = this.pallonhaltija.getPelipaikka() / tekijoidenSumma;
        
        double paatos = this.arpoja.nextDouble();
        
        if (suhdeluku > paatos) {
            return true;
        }
        
        return false;
    }
    
    /**
     * Arpoo pelaajien taitojen perusteella, onnistuuko harhautus.
     *
     * @param puolustaja
     * @return tieto onnistumisesta
     */
    public boolean onnistuukoHarhautus(Pelaaja puolustaja) {
        
        double taitojenSumma = this.pallonhaltija.getHarhauttaminen() + this.pallonhaltija.getNopeus() + puolustaja.getNopeus() + puolustaja.getPuolustus();
        double suhdeluku = (this.pallonhaltija.getHarhauttaminen() + this.pallonhaltija.getNopeus()) / taitojenSumma;
        
        double onnistuminen = this.arpoja.nextDouble();
        
        if (suhdeluku > onnistuminen) {
            return true;
        }
        
        return false;
    }
    
    /**
     * Arpoo painotetusti pelaajien sijaintien perusteella, pääseekö pelaaja
     * maalipaikkaan onnistuneesta harhautuksesta
     *
     * @param puolustaja
     * @return tieto onnistumisesta
     */
    public boolean paaseekoMaalipaikkaanHarhautuksesta(Pelaaja puolustaja) {
        
        double tekijoidenSumma = (this.pallonhaltija.getPelipaikka() / 2) + vastustajanEtaisyys(this.pallonhaltija, puolustaja) + 5;
        double suhdeluku = ((this.pallonhaltija.getPelipaikka() / 2) + vastustajanEtaisyys(this.pallonhaltija, puolustaja)) / tekijoidenSumma;
        
        double onnistuminen = this.arpoja.nextDouble();
        
        if (suhdeluku > onnistuminen) {
            return true;
        }
        
        return false;
    }
    
    @Override
    public String toString() {
        
        return this.koti.getNimi() + " " + this.kotimaalit + " - " + this.vierasmaalit + " " + this.vieras.getNimi();
    }
    
    
}
