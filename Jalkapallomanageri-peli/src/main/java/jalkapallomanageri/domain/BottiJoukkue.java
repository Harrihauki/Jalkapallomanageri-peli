/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.domain;

import jalkapallomanageri.ottelulogiikka.Hyokkaajavertailu;
import jalkapallomanageri.ottelulogiikka.Keskikenttavertailu;
import jalkapallomanageri.ottelulogiikka.Maalivahtivertailu;
import jalkapallomanageri.ottelulogiikka.Puolustajavertailu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *Luokka määrittelee bottijoukkueiden toimintaa
 * 
 */
public class BottiJoukkue extends Joukkue {

    /**
     *
     * @param nimi
     */
    public BottiJoukkue(String nimi) {
        super(nimi);
    }
    
    @Override
    public void setMuodostelma() {
        
        List<Maalivahtivertailu> maalivahdit = this.maalivahtienVertailu();
        List<Puolustajavertailu> puolustajat = this.puolustajienVertailu();
        List<Keskikenttavertailu> keskikenttapelaajat = this.keskikenttaVertailu();
        List<Hyokkaajavertailu> hyokkaajat = this.hyokkaajienVertailu();
        
        
    }

    private List<Maalivahtivertailu> maalivahtienVertailu() {
        
        List<Maalivahtivertailu> vertailu = new ArrayList();
        
        for (Pelaaja pelaaja : super.getPelaajat().values()) {
            
            Maalivahtivertailu maalivahti = new Maalivahtivertailu(pelaaja);
            vertailu.add(maalivahti);
        }
        
        Collections.sort(vertailu);
        
        return vertailu;
    }

    private List<Puolustajavertailu> puolustajienVertailu() {
        
        List<Puolustajavertailu> vertailu = new ArrayList();
        
        for (Pelaaja pelaaja : super.getPelaajat().values()) {
            
            Puolustajavertailu puolustaja = new Puolustajavertailu(pelaaja);
            vertailu.add(puolustaja);
        }
        
        Collections.sort(vertailu);
        
        return vertailu;
    }

    private List<Keskikenttavertailu> keskikenttaVertailu() {
        
        List<Keskikenttavertailu> vertailu = new ArrayList();
        
        for (Pelaaja pelaaja : super.getPelaajat().values()) {
            
            Keskikenttavertailu keskikentta = new Keskikenttavertailu(pelaaja);
            vertailu.add(keskikentta);
        }
        
        Collections.sort(vertailu);
        
        return vertailu;
    }

    private List<Hyokkaajavertailu> hyokkaajienVertailu() {
        
        List<Hyokkaajavertailu> vertailu = new ArrayList();
        
        for (Pelaaja pelaaja : super.getPelaajat().values()) {
            
            Hyokkaajavertailu hyokkaaja = new Hyokkaajavertailu(pelaaja);
            vertailu.add(hyokkaaja);
        }
        
        Collections.sort(vertailu);
        
        return vertailu;
    }
    
}
