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
import java.util.Random;

/**
 * Luokka määrittelee bottijoukkueiden toimintaa
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

    /**
     * Metodi asettaa joukkueelle automaattisesti fiksuhkon muodustelman
     */
    @Override
    public void setMuodostelma() {
        
        super.getMuodostelma().alustaMuodostelma();

        List<Maalivahtivertailu> maalivahdit = this.maalivahtienVertailu();
        List<Puolustajavertailu> puolustajat = this.puolustajienVertailu();
        List<Keskikenttavertailu> keskikenttapelaajat = this.keskikenttaVertailu();
        List<Hyokkaajavertailu> hyokkaajat = this.hyokkaajienVertailu();

        int puolustajia = 0;
        int keskikenttapelaajia = 0;
        int hyokkaajia = 0;
        Random arpoja = new Random();

        this.lisaaMaalivahti(maalivahdit);

        while (puolustajia + keskikenttapelaajia + hyokkaajia < 7) {

            int pelipaikka = arpoja.nextInt(3);

            if (pelipaikka == 0 && puolustajia < 3) {

                this.lisaaPuolustaja(puolustajat, arpoja);
                puolustajia++;
            } else if (pelipaikka == 1 && keskikenttapelaajia < 3) {

                this.lisaaKeskikenttapelaaja(keskikenttapelaajat, arpoja);
                keskikenttapelaajia++;
            } else if (pelipaikka == 2 && hyokkaajia < 1) {

                this.lisaaHyokkaaja(hyokkaajat, arpoja);
                hyokkaajia++;
            }
        }

        while (puolustajia + keskikenttapelaajia + hyokkaajia < 10) {

            int pelipaikka = arpoja.nextInt(3);

            if (pelipaikka == 0 && puolustajia < 5) {

                this.lisaaPuolustaja(puolustajat, arpoja);
                puolustajia++;
            } else if (pelipaikka == 1 && keskikenttapelaajia < 5) {

                this.lisaaKeskikenttapelaaja(keskikenttapelaajat, arpoja);
                keskikenttapelaajia++;
            } else if (pelipaikka == 2) {

                this.lisaaHyokkaaja(hyokkaajat, arpoja);
                hyokkaajia++;
            }
        }

    }
    
    /** 
     * Asettaa pelaajat parhausjärjestykseen maalivahtitaitojen perusteella
     * 
     * @return lista pelaajien soveltuvuudesta maalivahdeiksi
     */

    private List<Maalivahtivertailu> maalivahtienVertailu() {

        List<Maalivahtivertailu> vertailu = new ArrayList();

        for (Pelaaja pelaaja : super.getPelaajat().values()) {

            Maalivahtivertailu maalivahti = new Maalivahtivertailu(pelaaja);
            vertailu.add(maalivahti);
        }

        Collections.sort(vertailu);

        return vertailu;
    }
    
    /**
     * Asettaa pelaajat järjestykseen puolustajalle merkitsevien taitojen perusteella
     * 
     * @return lista pelaajien soveltuvuudesta puolustajiksi
     */

    private List<Puolustajavertailu> puolustajienVertailu() {

        List<Puolustajavertailu> vertailu = new ArrayList();

        for (Pelaaja pelaaja : super.getPelaajat().values()) {

            Puolustajavertailu puolustaja = new Puolustajavertailu(pelaaja);
            vertailu.add(puolustaja);
        }

        Collections.sort(vertailu);

        return vertailu;
    }
    
    /**
     * Asettaa pelaajat järjestykseen keskikenttapelaajille merkitsevien taitojen perusteella
     * 
     * @return lista pelaajien soveltuvuudesta keskikenttäpelaajiksi
     */

    private List<Keskikenttavertailu> keskikenttaVertailu() {

        List<Keskikenttavertailu> vertailu = new ArrayList();

        for (Pelaaja pelaaja : super.getPelaajat().values()) {

            Keskikenttavertailu keskikentta = new Keskikenttavertailu(pelaaja);
            vertailu.add(keskikentta);
        }

        Collections.sort(vertailu);

        return vertailu;
    }
    
    /**
     * Asettaa pelaajat järjestykseen hyökkääjille merkitsevien taitojen perusteella
     * 
     * @return lista pelaajien soveltuvuudesta hyökkääjiksi
     */

    private List<Hyokkaajavertailu> hyokkaajienVertailu() {

        List<Hyokkaajavertailu> vertailu = new ArrayList();

        for (Pelaaja pelaaja : super.getPelaajat().values()) {

            Hyokkaajavertailu hyokkaaja = new Hyokkaajavertailu(pelaaja);
            vertailu.add(hyokkaaja);
        }

        Collections.sort(vertailu);

        return vertailu;
    }
    
    /**
     * Metodi asettaa parhaan, vielä asettamattoman ja loukkaantumattoman pelaajan
     * puolustajaksi
     * 
     * @param puolustajat järjestetty lista pelaajien soveltuvuudesta puolustajiksi
     * @param arpoja satunnaislukugeneraattori, jolla arvotaan pelaajan sijainti
     * kentällä leveyssuunnassa
     */

    private void lisaaPuolustaja(List<Puolustajavertailu> puolustajat, Random arpoja) {

        int kuka = 0;

        while (true) {

            Pelaaja pelaaja = puolustajat.get(kuka).getPelaaja();

            if (super.getMuodostelma().pelaajaOnJoAsetettu(pelaaja.getNimi(), super.getPelaajat())) {
                kuka++;
                continue;
            } else if (pelaaja.getLoukkaantunut()) {
                kuka++;
                continue;
            }

            while (true) {

                int sijainti = arpoja.nextInt(5) + 1;

                if (super.getMuodostelma().pelipaikkaOnVarattu(1, sijainti)) {
                    continue;
                }

                super.getMuodostelma().lisaaPelaajaPaikalleen(pelaaja.getNimi(), 1, sijainti, super.getPelaajat());
                break;
            }

            break;
        }
    }
    
    /**
     * Metodi asettaa parhaan, vielä asettamattoman ja loukkaantumattoman pelaajan
     * keskikenttapelaajaksi
     * 
     * @param keskikenttapelaajat järjestetty lista pelaajien soveltuvuudesta keskikenttäpelaajiksi
     * @param arpoja satunnaislukugeneraattori, jolla arvotaan pelaajan sijainti
     * keskikentällä
     */

    private void lisaaKeskikenttapelaaja(List<Keskikenttavertailu> keskikenttapelaajat, Random arpoja) {

        int kuka = 0;

        while (true) {

            Pelaaja pelaaja = keskikenttapelaajat.get(kuka).getPelaaja();

            if (super.getMuodostelma().pelaajaOnJoAsetettu(pelaaja.getNimi(), super.getPelaajat())) {
                kuka++;
                continue;
            } else if (pelaaja.getLoukkaantunut()) {
                kuka++;
                continue;
            }

            int pelipaikka;

            if ((pelaaja.getHarhauttaminen() + pelaaja.getSyottaminen()) - pelaaja.getPuolustus() - pelaaja.getSijoittuminen() > 2) {
                pelipaikka = 4;
            } else if ((pelaaja.getHarhauttaminen() + pelaaja.getSyottaminen()) - pelaaja.getPuolustus() - pelaaja.getSijoittuminen() < -2) {
                pelipaikka = 2;
            } else {
                pelipaikka = 3;
            }

            while (true) {

                int sijainti = arpoja.nextInt(5) + 1;

                if (super.getMuodostelma().pelipaikkaOnVarattu(pelipaikka, sijainti)) {
                    continue;
                }

                super.getMuodostelma().lisaaPelaajaPaikalleen(pelaaja.getNimi(), pelipaikka, sijainti, super.getPelaajat());
                break;
            }

            break;
        }
    }
    
    /**
     * Metodi asettaa parhaan, vielä asettamattoman ja loukkaantumattoman pelaajan
     * hyökkääjäksi
     * 
     * @param hyokkaajat järjestetty lista pelaajien soveltuvuudesta hyökkääjiksi
     * @param arpoja satunnaislukugeneraattori, jolla arvotaan pelaajan sijainti
     * hyökkäyssektorilla
     */

    private void lisaaHyokkaaja(List<Hyokkaajavertailu> hyokkaajat, Random arpoja) {

        int kuka = 0;

        while (true) {

            Pelaaja pelaaja = hyokkaajat.get(kuka).getPelaaja();

            if (super.getMuodostelma().pelaajaOnJoAsetettu(pelaaja.getNimi(), super.getPelaajat())) {
                kuka++;
                continue;
            } else if (pelaaja.getLoukkaantunut()) {
                kuka++;
                continue;
            }

            while (true) {

                int sijainti = arpoja.nextInt(5) + 1;

                if (super.getMuodostelma().pelipaikkaOnVarattu(5, sijainti)) {
                    continue;
                }

                super.getMuodostelma().lisaaPelaajaPaikalleen(pelaaja.getNimi(), 5, sijainti, super.getPelaajat());
                break;
            }

            break;
        }
    }
    
    /**
     * Metodi asettaa parhaan loukkaantumattoman pelaajan
     * maalivahdiksi
     * 
     * @param maalivahdit järjestetty lista pelaajien soveltuvuudesta maalivahdeiksi
     */

    private void lisaaMaalivahti(List<Maalivahtivertailu> maalivahdit) {
        
        int kuka = 0;
        
        while (true) {
            
            if (maalivahdit.get(kuka).getPelaaja().getLoukkaantunut()) {
                kuka++;
                continue;
            }
            
            super.getMuodostelma().setMaalivahti(maalivahdit.get(kuka).getPelaaja().getNimi(), super.getPelaajat());
            break;
        }
    }

}
