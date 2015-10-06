/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.pelaajaGeneraattori;

import jalkapallomanageri.domain.Pelaaja;
import java.util.Random;

/**
 * Luo satunnaisesti pelaajat joukkueita varten.
 */
public class Pelaajageneraattori {

    private Random arpoja;

    /**
     *
     * @param arpoja
     */
    public Pelaajageneraattori(Random arpoja) {

        this.arpoja = arpoja;
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

        Pelaaja pelaaja = new Pelaaja("" + this.arpoja.nextInt(1000), this.arvoArvo(), this.arvoArvo(), this.arvoArvo(), this.arvoArvo(), this.arvoArvo(), this.arvoArvo(), this.arvoArvo());

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
        } else if (taso < 46) {
            return 4;
        } else if (taso < 60) {
            return 5;
        } else if (taso < 73) {
            return 6;
        } else if (taso < 85) {
            return 7;
        } else if (taso < 96) {
            return 8;
        } else if (taso < 104) {
            return 9;
        } else {
            return 10;
        }
    }

}
