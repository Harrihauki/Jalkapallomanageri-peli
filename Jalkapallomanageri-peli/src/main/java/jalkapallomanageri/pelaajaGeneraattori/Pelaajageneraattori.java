/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.pelaajaGeneraattori;

import jalkapallomanageri.domain.Pelaaja;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Luo satunnaisesti pelaajat joukkueita varten.
 */
public class Pelaajageneraattori {

    private Random arpoja;
    private Scanner lukija;
    private List<String> etunimet;
    private List<String> sukunimet;

    /**
     *
     * @param arpoja
     */
    public Pelaajageneraattori(Random arpoja) {

        this.arpoja = arpoja;
        this.lukija = null;
        this.etunimet = new ArrayList();
        this.sukunimet = new ArrayList();
        
        this.luoNimet();
    }

    /**
     * Luo pelaajan satunnaisesti. Saattaa luoda "erikoispelaajan", tai sitten
     * arpoo pelaajalle nimen ja taidot.
     *
     * @return luotu pelaaja
     */
    public Pelaaja luoPelaaja() {

        int luodaankoErikoispelaaja = this.arpoja.nextInt(100);

        if (luodaankoErikoispelaaja == 0) {

            int kumpiPelaaja = this.arpoja.nextInt(2);

            if (kumpiPelaaja == 1) {
                Pelaaja litmanen = new Pelaaja("Jari Litmanen", 10, 6, 10, 10, 4, 10, 3);

                return litmanen;
            } else {
                Pelaaja oravainen = new Pelaaja("Pexi Oravainen", 9, 8, 8, 9, 6, 9, 1);
                
                return oravainen;
            }

        }
        
        String nimi = this.etunimet.get(this.arpoja.nextInt(this.etunimet.size())) + " " + this.sukunimet.get(this.arpoja.nextInt(this.sukunimet.size()));

        Pelaaja pelaaja = new Pelaaja(nimi, this.arvoArvo(), this.arvoArvo(), this.arvoArvo(), this.arvoArvo(), this.arvoArvo(), this.arvoArvo(), this.arvoArvo());

        return pelaaja;
    }

    /**
     * Arpoo painotetusti, minkä arvosanan pelaaja saa taidolleen.
     *
     * @return arvottu arvosana
     */
    public int arvoArvo() {

        int taso = this.arpoja.nextInt(111);

        if (taso < 10) {
            return 1;
        } else if (taso < 21) {
            return 2;
        } else if (taso < 33) {
            return 3;
        } else if (taso < 48) {
            return 4;
        } else if (taso < 63) {
            return 5;
        } else if (taso < 76) {
            return 6;
        } else if (taso < 87) {
            return 7;
        } else if (taso < 98) {
            return 8;
        } else if (taso < 105) {
            return 9;
        } else {
            return 10;
        }
    }

    private void luoNimet() {
        
        File etunimet = new File("etunimet.txt");
        File sukunimet = new File("sukunimet.txt");
        
        try {
            this.lukija = new Scanner(etunimet);
        } catch (FileNotFoundException ex) {
            System.out.println("tiedostoa ei löydy");
        }
        
        while(lukija.hasNextLine()) {
            this.etunimet.add(lukija.nextLine());
        }
        
        this.lukija.close();
        
        try {
            this.lukija = new Scanner(sukunimet);
        } catch (FileNotFoundException ex) {
            System.out.println("Tiedostoa ei löydy");
        }
        
        while(lukija.hasNextLine()) {
            this.sukunimet.add(lukija.nextLine());
        }
        
        
    }

}
