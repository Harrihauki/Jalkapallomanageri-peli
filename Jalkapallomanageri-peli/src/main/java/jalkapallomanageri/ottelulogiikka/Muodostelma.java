/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.ottelulogiikka;

import jalkapallomanageri.domain.Pelaaja;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Luokka tietää joukkueen avauskokoonpanon ja sen kautta voi muuttaa pelaajan
 * pelipaikkaa
 */
public class Muodostelma {

    private Pelaaja maalivahti;
    private List<Pelaaja> avauskentallinen;

    /**
     *
     */
    public Muodostelma() {

        this.avauskentallinen = new ArrayList<>();
        this.maalivahti = null;
    }

    /**
     * Metodi tarkistaa, onko asetettava pelaaja jo asetettu.
     *
     * @param pelaajat Joukkueen pelaajat
     * @param asetettavanPelaajanNimi Sen pelaajan nimi, joka halutaan asettaa
     * @return tieto siitä, onko pelaaja jo asetettu
     */
    public boolean pelaajaOnJoAsetettu(String asetettavanPelaajanNimi, Map<String, Pelaaja> pelaajat) {

        if (this.avauskentallinen.isEmpty()) {

            if (this.maalivahti == null) {

                return false;
            }
        }

        if (this.avauskentallinen.contains(pelaajat.get(asetettavanPelaajanNimi))) {

            return true;
        } else if (this.maalivahti != null) {

            if (this.maalivahti.equals(pelaajat.get(asetettavanPelaajanNimi))) {

                return true;

            }
        }

        return false;
    }

    /**
     * Asetetaan maalivahti
     *
     * @param nimi sen pelaajan nimi, joka halutaan asettaa
     * @param pelaajat joukkueen pelaajat
     */
    public void setMaalivahti(String nimi, Map<String, Pelaaja> pelaajat) {

        this.maalivahti = pelaajat.get(nimi);
    }
    
    public void poistaMaalivahti() {
        
        this.maalivahti = null;
    }

    /**
     * Metodi tarkistaa, onko pelipaikka jo varattu, jolle halutaan asettaa
     * pelaaja
     *
     * @param pelipaikka asema kentän pituussuunnassa
     * @param sijainti asema kentän leveyssuunnassa
     * @return tieto siitä, onko joku avauksen pelaaja jo kyseisellä paikalla
     */
    public boolean pelipaikkaOnVarattu(int pelipaikka, int sijainti) {

        for (Pelaaja pelaaja : this.avauskentallinen) {

            if (pelaaja.getPelipaikka() == pelipaikka) {

                if (pelaaja.getSijainti() == sijainti) {

                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Tarkistetaan, onko haluttu pelaaja joukkueessa
     *
     * @param asetettavanPelaajanNimi sen pelaajan nimi, joka halutaan asettaa
     * @param pelaajat joukkueen pelaajat
     * @return tieto siitä, onko pelaajaa olemassa
     */
    public boolean pelaajaaEiOle(String asetettavanPelaajanNimi, Map<String, Pelaaja> pelaajat) {

        if (pelaajat.containsKey(asetettavanPelaajanNimi)) {

            return false;
        }

        return true;
    }

    /**
     * Pelaaja lisätään avauskentällinen-listaan ja pelaajalle asetetaan tieto
     * omasta pelipaikastaan
     *
     * @param asetettavanPelaajanNimi sen pelaajan nimi, joka halutaan asettaa
     * @param pelipaikka haluttu asema kentän pituussuunnassa
     * @param sijainti haluttu asema kentän leveyssuunnassa
     * @param pelaajat joukkueen pelaajat
     */
    public void lisaaPelaajaPaikalleen(String asetettavanPelaajanNimi, int pelipaikka, int sijainti, Map<String, Pelaaja> pelaajat) {

        Pelaaja pelaaja = pelaajat.get(asetettavanPelaajanNimi);

        this.avauskentallinen.add(pelaaja);
        pelaaja.setPelipaikka(pelipaikka);
        pelaaja.setSijainti(sijainti);
    }

    /**
     *
     *
     * @return
     */
    public List<Pelaaja> getAvauskentallinen() {

        return this.avauskentallinen;
    }

    /**
     *
     * @return
     */
    public Pelaaja getMaalivahti() {

        return this.maalivahti;
    }

    /**
     * Tyhjentää vanhat tiedot uusien asettamista varten
     *
     */
    public void alustaMuodostelma() {

        this.avauskentallinen.clear();
        this.maalivahti = null;
    }

}
