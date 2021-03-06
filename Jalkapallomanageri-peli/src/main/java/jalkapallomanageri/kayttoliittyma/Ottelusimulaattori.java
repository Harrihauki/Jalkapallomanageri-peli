/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.kayttoliittyma;

import jalkapallomanageri.domain.Pelaaja;
import jalkapallomanageri.kello.Kello;
import jalkapallomanageri.ottelulogiikka.Ottelu;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

/**
 * Ottelusimulaattori simuloi parametrinä saadun ottelun.
 *
 * @author lallimyl
 */
public class Ottelusimulaattori {

    private Ottelu ottelu;
    private JTextArea raportti;
    private Kello kello;
    private boolean tulosteet;
    private JTextPane aika;
    private JTextPane joukkueet;
    private JLabel tilanne;
    private CardLayout cl;
    private JPanel jPanel4;
    private Map<String, String> tulostus;
    private Map<String, String> maalitulostus;

    public Ottelusimulaattori(Ottelu ottelu, JTextArea raportti, JTextPane aika, JTextPane joukkueet, JLabel tilanne, boolean tulosteet, CardLayout cl, JPanel jPanel4) {

        this.ottelu = ottelu;
        this.raportti = raportti;
        this.kello = new Kello();
        this.tulosteet = tulosteet;
        this.aika = aika;
        this.joukkueet = joukkueet;
        this.tilanne = tilanne;
        this.cl = cl;
        this.jPanel4 = jPanel4;
        this.tulostus = new HashMap();
        this.maalitulostus = new HashMap();
    }

    /**
     * Metodi sisältää ottelutapahtumista vastaavan while-luupin, joka pyörii 
     * niin kauan, kuin peliaikaa on jäljellä. Jokainen tapahtuma siirtää kelloa
     * puoli minuuttia eteenpäin.
     * 
     */
    public void pelaa() {
        cl.show(jPanel4, "card4");  
        if (this.tulosteet) {
            this.joukkueet.setText(ottelu.getKoti().getNimi() + " - " + ottelu.getVieras().getNimi());
            this.tilanne.setText("0 - 0");
            this.alkuSpiikki();
        }

        while (onkoAikaa()) {

             
            Pelaaja puolustaja = this.ottelu.ketaVastaan();

            if (this.ottelu.lahteekoHarhauttamaan()) {
                this.harhautus(puolustaja);
            } else {
                this.syotto(puolustaja);
            }
        }
        
        this.suoritaTulostus();
    }

    /**
     * Metodi laskee eri pelipaikoilla olevien pelaajien määrät ja tulostaa 
     * muodostelman "numeroesityksen".
     * 
     */
    private void alkuSpiikki() {

        int kotipuolustajat = 0;
        int kotikeskikenttapelaajat = 0;
        int kotihyokkaajat = 0;
        int vieraspuolustajat = 0;
        int vieraskeskikenttapelaajat = 0;
        int vierashyokkaajat = 0;

        for (Pelaaja pelaaja : this.ottelu.getKoti().getMuodostelma().getAvauskentallinen()) {

            if (pelaaja.getPelipaikka() == 1) {
                kotipuolustajat++;
            } else if (pelaaja.getPelipaikka() == 5) {
                kotihyokkaajat++;
            } else {
                kotikeskikenttapelaajat++;
            }
        }

        for (Pelaaja pelaaja : this.ottelu.getVieras().getMuodostelma().getAvauskentallinen()) {

            if (pelaaja.getPelipaikka() == 1) {
                vieraspuolustajat++;
            } else if (pelaaja.getPelipaikka() == 5) {
                vierashyokkaajat++;
            } else {
                vieraskeskikenttapelaajat++;
            }
        }

        this.tulostus.put(this.kello.toString(), this.ottelu.getKoti().getNimi() + " lähti tänään otteluun " + kotipuolustajat + "-" + kotikeskikenttapelaajat + "-" + kotihyokkaajat + "-ryhmiteyksellä.\nVierasjoukkue asettui kentälle " + vieraspuolustajat + "-" + vieraskeskikenttapelaajat + "-" + vierashyokkaajat + "-muodostelmaan.");

    }

    /**
     * Metodi true, jos peliaikaa on vielä jäljellä, ja false, jos peliaika on 
     * täynnä.
     * 
     * @return  boolean     onko aikaa vielä jäljellä
     */
    private boolean onkoAikaa() {

        if (this.kello.toString().equals("90:00")) {
            return false;
        }

        return true;
    }

    /**
     * Metodia kutsutaan, jos pelaa()-metodissa pelaaja päättää lähteä harhauttamaan.
     * Päätöksestä tehdään tuloste, ja tarkistetaan, onnistuuko harhautus.
     * 
     * @param puolustaja    pelaajaa vastaan asettuva vastustajan pelaaja
     */
    private void harhautus(Pelaaja puolustaja) {

        this.kello.etene();

        if (tulosteet) {
            tulosta(this.ottelu.getPallonhaltija().getNimi() + " lähtee kuljettamaan palloa");
        }

        if (!onkoAikaa()) {
            return;
        }

        if (this.ottelu.onnistuukoHarhautus(puolustaja)) {
            onnistunutHarhautus(puolustaja);
        } else {
            pallonriisto(puolustaja);
        }
    }

    /**
     * Metodia kutsutaan, jos pelaa()-metodissa pelaaja päättää lähteä syöttämään.
     * Päätöksestä tehdään tuloste, arvotaan syötön kohde ja tarkistetaan, onnistuuko
     * syöttö.
     * 
     * @param puolustaja    Pelaaja     vastaan asettuva vastustajan pelaaja
     */
    private void syotto(Pelaaja puolustaja) {

        this.kello.etene();

        if (tulosteet) {
            tulosta(this.ottelu.getPallonhaltija().getNimi() + " hakee katseellaan syöttösuuntia.");
        }

        if (!onkoAikaa()) {
            return;
        }

        Pelaaja kohde = this.ottelu.kenelleSyotetaan();

        if (this.ottelu.onnistuukoSyotto(puolustaja, kohde)) {
            this.ottelu.setPallonhaltija(kohde);
            onnistunutSyotto(puolustaja);
        } else {
            pallonriisto(puolustaja);
        }
    }

    /**
     * Asettaa tapahtumaa vastaavan kellonajan ja tulosteen HashMapiin.
     * 
     * @param uusiTuloste   String  tuloste, joka asetetaan Mapiin.
     */
    private void tulosta(String uusiTuloste) {

        this.tulostus.put(this.kello.toString(), uusiTuloste);
    }

    /**
     * Kutsutaan, jos harhautus onnistuu. Suoritetaan tuloste ja tarkistetaan,
     * pääseekö pelaaja harhautuksestaan maalipaikkaan. Jos ei, palataan pelaa-
     * metodin while-loopiin.
     * 
     * @param puolustaja 
     */
    private void onnistunutHarhautus(Pelaaja puolustaja) {

        this.kello.etene();
        String tuloste = "";

        if (tulosteet) {
            tuloste = this.ottelu.getPallonhaltija().getNimi() + " harhauttaa komeasti!";
        }

        if (!onkoAikaa()) {
            return;
        }

        if (this.ottelu.paaseekoMaalipaikkaanHarhautuksesta(puolustaja)) {
            tulosta(tuloste);
            maalipaikka();
        } else {
            if (tulosteet) {
                tulosta(tuloste + "\nMaalipaikkaa ei kuitenkaan synny");
            }
        }
    }

    /**
     * Kutsutaan, jos harhautus tai syöttö epäonnistuu. Asettaa pallollista pelaajaa
     * vastaan pelanneen puolustajan uudeksi pallonhaltijaksi, joka yrittää päästä
     * vastahyökkäykseen.
     * 
     * @param puolustaja Pelaaja    riiston tehnyt pelaaja
     */
    private void pallonriisto(Pelaaja puolustaja) {

        this.kello.etene();
        String tuloste = "";

        if (tulosteet) {
            tuloste = "Pallonriisto! " + puolustaja.getNimi() + " pyrkii nopeaan vastahyökkäykseen.";
        }

        if (!onkoAikaa()) {
            return;
        }

        this.ottelu.setPallonhaltija(puolustaja);

        if (this.ottelu.tuleekoVastahyokkays()) {
            tulosta(tuloste);
            maalipaikka();
        } else {
            if (tulosteet) {
                tulosta(tuloste + "\nVastahyökkäys kuitenkin tyrehtyy alkuunsa.");
            }
        }
    }

    /**
     * Kutsutaan, jos pelaaja pääsee harhautuksesta tai syötöstä maalipaikkaan.
     * Tarkistetaan, tuleeko maali. Jos tulee, niin ottelun tilannetta muutetaan,
     * ja maalin tehneelle pelaajalle lisätään maali. Jos ei, niin pallo siirtyy
     * vastustajalle ja palataan Pelaa-metodin luupiin. Pallo siirtyy vastustajalle.
     * 
     */
    private void maalipaikka() {

        this.kello.etene();

        if (tulosteet) {
            tulosta(this.ottelu.getPallonhaltija().getNimi() + " on maalipaikassa!");
        }

        if (!onkoAikaa()) {
            return;
        }

        if (this.ottelu.tuleekoMaali()) {

            this.ottelu.lisaaMaali();
            this.tulostaMaali();
            tulosta("Maali! " + this.ottelu.getPallonhaltija().getNimi() + " venyttää maaliverkkoa!");
            this.ottelu.getPallonhaltija().lisaaMaali();
        } else {
            if (tulosteet) {
                tulosta("Maali jää kuitenkin haaveeksi.");
            }
        }

        this.ottelu.setPallonhaltija(this.ottelu.ketaVastaan());
    }

    /**
     * Kutsutaan, jos syöttö onnistuu. Tarkistetaan, pääseekö pelaaja maalipaikkaan
     * syötöstä.
     * 
     * @param puolustaja    Pelaaja vastustajan pelaaja.
     */
    private void onnistunutSyotto(Pelaaja puolustaja) {

        this.kello.etene();

        if (tulosteet) {
            tulosta(this.ottelu.getPallonhaltija().getNimi() + " saa syötön haltuunsa.");
        }

        if (!onkoAikaa()) {
            return;
        }
        
        if (this.ottelu.paaseekoMaalipaikkaanSyotosta(puolustaja)) {
            tulosta("Oivaltava syöttö pelaajalta " + this.ottelu.getEdellinenPallonhaltija().getNimi() + "! Maali häämöttää.");
            maalipaikka();
        }
    }

    /**
     * Rakentaa maalille oman tulosteen.
     * 
     */
    private void tulostaMaali() {
        
        this.maalitulostus.put(this.kello.toString(), "" + this.ottelu.getKotimaalit() + " - " + this.ottelu.getVierasmaalit());
    }

    /**
     * Jos tulosteet-muuttuja on arvoltaan true, tulostetaan lopuksi ottelutapahtumat.
     * 
     */
    private void suoritaTulostus() {
        
        String tuloste = "";
        
        List<String> ajat = new ArrayList();
        for (String aika : this.tulostus.keySet()) {
            ajat.add(aika);
        }
        
        Collections.sort(ajat);
        
        for (String aika : ajat) {
            tuloste = tuloste + aika + ": " + this.tulostus.get(aika) + "\n" + "\n";
            
            if (this.maalitulostus.containsKey(aika)) {
                tuloste = tuloste + this.maalitulostus.get(aika) + "\n";
            }
        }
        
        this.tilanne.setText("" + this.ottelu.getKotimaalit() + " - " + this.ottelu.getVierasmaalit());
        this.raportti.setText(tuloste);
    }

}
