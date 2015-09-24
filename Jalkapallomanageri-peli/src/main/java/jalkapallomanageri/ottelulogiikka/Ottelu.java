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
 *
 * @author lallimyl
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
    
    public Joukkue getKoti() {
        
        return this.koti;
    }
    
    public Joukkue getVieras() {
        
        return this.vieras;
    }
    
    public void setPallonhaltija(Pelaaja pelaaja) {
        
        this.edellinenPallonhaltija = this.pallonhaltija;
        this.pallonhaltija = pelaaja;
    }
    
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
    
    public Map<Pelaaja, Double> laskeVastustajienEtaisyydet(Pelaaja pelaaja) {
        
        List<Pelaaja> vertailtavatPelaajat = this.pallottomanJoukkueenPelaajat(pelaaja);
        
        Map<Pelaaja, Double> pelaajienEtaisyydet = new HashMap();
        
        for (Pelaaja vertailtava : vertailtavatPelaajat) {
            
            pelaajienEtaisyydet.put(vertailtava, vastustajanEtaisyys(pelaaja, vertailtava));
        }
        
        return pelaajienEtaisyydet;
    }

    public List<Pelaaja> pallollisenJoukkueenPelaajat(Pelaaja pallollinenPelaaja) {
        
        if (this.kotiAvaus.contains(pallollinenPelaaja)) {
            
            return this.kotiAvaus;
        }
        
        return this.vierasAvaus;
    }
    
    public List<Pelaaja> pallottomanJoukkueenPelaajat(Pelaaja pallollinenPelaaja) {
        
        if (this.kotiAvaus.contains(pallollinenPelaaja)) {
            
            return this.vierasAvaus;
        }
        
        return this.kotiAvaus;
    }

    public double omanPelaajanEtaisyys(Pelaaja pelaaja, Pelaaja vertailtava) {
        
        double etaisyys = Math.pow((pelaaja.getPelipaikka()-vertailtava.getPelipaikka()), 2) + Math.pow(pelaaja.getSijainti() - vertailtava.getSijainti(), 2);
        
        return Math.sqrt(etaisyys);
    }
    
    public double vastustajanEtaisyys(Pelaaja pelaaja, Pelaaja vertailtava) {
        
        double etaisyys = Math.pow((pelaaja.getPelipaikka()- (6 - vertailtava.getPelipaikka())), 2) + Math.pow(pelaaja.getSijainti() - (6 - vertailtava.getSijainti()), 2);
        
        return Math.sqrt(etaisyys);
    }
    
    public Pelaaja ketaVastaan() {
        
        Map<Pelaaja, Double> mahdollisetVastustajat = laskeVastustajienEtaisyydet(this.pallonhaltija);
        
        List<Etaisyydenhaltija> vastustajatJarjestyksessa = etaisyydetJarjestyksessa(mahdollisetVastustajat);
        
        Pelaaja vastustaja = arvoKohde(vastustajatJarjestyksessa, 3);
        
        return vastustaja;
    }
    
    public Pelaaja kenelleSyotetaan() {
        
        Map<Pelaaja, Double> mahdollisetSyotonKohteet = laskeOmienEtaisyydet(this.pallonhaltija);
        
        List<Etaisyydenhaltija> omatJarjestyksessa = etaisyydetJarjestyksessa(mahdollisetSyotonKohteet);
        
        Pelaaja syotonKohde = arvoKohde(omatJarjestyksessa, 9);
        
        return syotonKohde;
    }

    public List<Etaisyydenhaltija> etaisyydetJarjestyksessa(Map<Pelaaja, Double> jarjestettavatPelaajat) {
        
        List<Etaisyydenhaltija> etaisyydetJarjestyksessa = new ArrayList();
        
        for (Pelaaja pelaaja : jarjestettavatPelaajat.keySet()) {
            
            Etaisyydenhaltija haltija = new Etaisyydenhaltija(pelaaja, jarjestettavatPelaajat.get(pelaaja));
            
            etaisyydetJarjestyksessa.add(haltija);
        }
        
        Collections.sort(etaisyydetJarjestyksessa);
        
        return etaisyydetJarjestyksessa;
    }

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
    
    public boolean onnistuukoSyotto(Pelaaja syottaja, Pelaaja puolustaja, Pelaaja kohde) {
        
        double taitojenSumma = syottaja.getSyottaminen() + kohde.getSijoittuminen() + puolustaja.getPuolustus() + puolustaja.getSijoittuminen() + omanPelaajanEtaisyys(syottaja, kohde);
        double taitojenSuhde = (syottaja.getSyottaminen() + kohde.getSijoittuminen()) / taitojenSumma;
        
        double onnistuminen = this.arpoja.nextDouble();
        
        if (taitojenSuhde > onnistuminen) {
            return true;
        }
        
        return false;
    }
    
    public boolean paaseekoMaalipaikkaanSyotosta(Pelaaja puolustaja) {
        
        double tekijoidenSumma = this.edellinenPallonhaltija.getSyottaminen() * (1 + this.edellinenPallonhaltija.getPelipaikka()/10) + omanPelaajanEtaisyys(this.pallonhaltija, this.edellinenPallonhaltija) + 30 + puolustaja.getSijoittuminen();
        double suhdeluku = (this.edellinenPallonhaltija.getSyottaminen() * (1 + this.edellinenPallonhaltija.getPelipaikka()/10) + omanPelaajanEtaisyys(this.pallonhaltija, this.edellinenPallonhaltija)) / tekijoidenSumma;
        
        double onnistuminen = this.arpoja.nextDouble();
        
        if (suhdeluku > onnistuminen) {
            return true;
        }
        
        return false;
    }
    
    public boolean tuleekoMaali() {
        
        Pelaaja maalivahti = null;
        
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
    
    public boolean tuleekoVastahyokkays() {
        
        double summa = this.pallonhaltija.getNopeus() / this.edellinenPallonhaltija.getPelipaikka() + 5;
        double suhdeluku = (this.pallonhaltija.getNopeus() / this.edellinenPallonhaltija.getPelipaikka()) / summa;
        
        double onnistuminen = this.arpoja.nextDouble();
        
        if (suhdeluku > onnistuminen) {
            return true;
        }
        
        return false;
    }
    
    
}
