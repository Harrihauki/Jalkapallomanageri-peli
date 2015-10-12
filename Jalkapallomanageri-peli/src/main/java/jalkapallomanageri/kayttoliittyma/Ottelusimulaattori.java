/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.kayttoliittyma;

import jalkapallomanageri.domain.Pelaaja;
import jalkapallomanageri.kello.Kello;
import jalkapallomanageri.ottelulogiikka.Ottelu;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

/**
 *
 * @author lallimyl
 */
public class Ottelusimulaattori implements Runnable {

    private Ottelu ottelu;
    private int viive;
    private JTextArea raportti;
    private Kello kello;
    private boolean tulosteet;
    private JTextPane aika;
    private JTextPane joukkueet;
    private JLabel tilanne;
    private String tulosterivi1;
    private String tulosterivi2;
    private String tulosterivi3;
    private String tulosterivi4;
    private String tulosterivi5;

    public Ottelusimulaattori(Ottelu ottelu, int viive, JTextArea raportti, JTextPane aika, JTextPane joukkueet, JLabel tilanne, boolean tulosteet) {

        this.ottelu = ottelu;
        this.viive = viive;
        this.raportti = raportti;
        this.kello = new Kello();
        this.tulosteet = tulosteet;
        this.aika = aika;
        this.joukkueet = joukkueet;
        this.tilanne = tilanne;
        this.tulosterivi1 = "";
        this.tulosterivi2 = "";
        this.tulosterivi3 = "";
        this.tulosterivi4 = "";
        this.tulosterivi5 = "";
    }

    @Override
    public void run() {

        if (this.tulosteet) {
            this.joukkueet.setText(ottelu.getKoti().getNimi() + " - " + ottelu.getVieras().getNimi());
            this.aika.setText(this.kello.toString());
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
        
        
    }

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

        this.raportti.setText(this.ottelu.getKoti().getNimi() + " lähti tänään otteluun " + kotipuolustajat + "-" + kotikeskikenttapelaajat + "-" + kotihyokkaajat + "-ryhmiteyksellä.\nVierasjoukkue asettui kentälle " + vieraspuolustajat + "-" + vieraskeskikenttapelaajat + "-" + vierashyokkaajat + "-muodostelmaan.");

    }

    private boolean onkoAikaa() {

        if (this.kello.toString().equals("90:00")) {
            return false;
        }

        return true;
    }

    private void harhautus(Pelaaja puolustaja) {

        try {
            Thread.sleep(this.viive);
        } catch (InterruptedException ex) {
            this.raportti.setText("Ohjelma on kohdannut virheen ja se suljetaan");
            Thread.currentThread().interrupt();
        }

        this.kello.etene();

        if (tulosteet) {
            this.aika.setText(this.kello.toString());
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

    private void syotto(Pelaaja puolustaja) {

        try {
            Thread.sleep(this.viive);
        } catch (InterruptedException ex) {
            this.raportti.setText("Ohjelma on kohdannut virheen ja se suljetaan");
            Thread.currentThread().interrupt();
        }

        this.kello.etene();

        if (tulosteet) {
            this.aika.setText(this.kello.toString());
            tulosta(this.ottelu.getPallonhaltija().getNimi() + " hakee katseellaan syöttösuuntia.");
        }

        if (!onkoAikaa()) {
            return;
        }

        Pelaaja kohde = this.ottelu.kenelleSyotetaan();

        if (this.ottelu.onnistuukoSyotto(puolustaja, kohde)) {
            onnistunutSyotto(puolustaja);
        } else {
            pallonriisto(puolustaja);
        }
    }

    private void tulosta(String uusiTuloste) {

        this.tulosterivi5 = this.tulosterivi4;
        this.tulosterivi4 = this.tulosterivi3;
        this.tulosterivi3 = this.tulosterivi2;
        this.tulosterivi2 = this.tulosterivi1;
        this.tulosterivi1 = uusiTuloste;

        this.raportti.setText(this.tulosterivi5 + "\n" + "\n" + this.tulosterivi4 + "\n" + "\n" + this.tulosterivi3 + "\n" + "\n" + this.tulosterivi2 + "\n" + "\n" + this.tulosterivi1);
    }

    private void onnistunutHarhautus(Pelaaja puolustaja) {

        try {
            Thread.sleep(this.viive);
        } catch (InterruptedException ex) {
            this.raportti.setText("Ohjelma on kohdannut virheen ja se suljetaan");
            Thread.currentThread().interrupt();
        }

        this.kello.etene();

        if (tulosteet) {
            this.aika.setText(this.kello.toString());
            tulosta(this.ottelu.getPallonhaltija().getNimi() + " harhauttaa komeasti!");
        }

        if (!onkoAikaa()) {
            return;
        }

        if (this.ottelu.paaseekoMaalipaikkaanHarhautuksesta(puolustaja)) {
            maalipaikka();
        } else {
            if (tulosteet) {
                tulosta("Maalipaikkaa ei kuitenkaan synny");
            }
        }
    }

    private void pallonriisto(Pelaaja puolustaja) {

        try {
            Thread.sleep(this.viive);
        } catch (InterruptedException ex) {
            this.raportti.setText("Ohjelma on kohdannut virheen ja se suljetaan");
            Thread.currentThread().interrupt();
        }

        this.kello.etene();

        if (tulosteet) {
            this.aika.setText(this.kello.toString());
            tulosta("Pallonriisto! " + puolustaja.getNimi() + " pyrkii nopeaan vastahyökkäykseen.");
        }

        if (!onkoAikaa()) {
            return;
        }

        this.ottelu.setPallonhaltija(puolustaja);

        if (this.ottelu.tuleekoVastahyokkays()) {
            maalipaikka();
        } else {
            if (tulosteet) {
                tulosta("Vastahyökkäys tyrehtyy alkuunsa.");
            }
        }
    }

    private void maalipaikka() {

        try {
            Thread.sleep(this.viive);
        } catch (InterruptedException ex) {
            this.raportti.setText("Ohjelma on kohdannut virheen ja se suljetaan");
            Thread.currentThread().interrupt();
        }

        this.kello.etene();

        if (tulosteet) {
            this.aika.setText(this.kello.toString());
            tulosta(this.ottelu.getPallonhaltija().getNimi() + " on maalipaikassa!");
        }

        if (!onkoAikaa()) {
            return;
        }

        if (this.ottelu.tuleekoMaali()) {

            this.ottelu.lisaaMaali();
            this.tilanne.setText("" + this.ottelu.getKotimaalit() + " - " + this.ottelu.getVierasmaalit());
            tulosta("Maali! " + this.ottelu.getPallonhaltija() + " venyttää maaliverkkoa!");
        } else {
            if (tulosteet) {
                tulosta("Maali jää kuitenkin haaveeksi.");
            }

        }

        this.ottelu.setPallonhaltija(this.ottelu.ketaVastaan());
    }

    private void onnistunutSyotto(Pelaaja puolustaja) {

        try {
            Thread.sleep(this.viive);
        } catch (InterruptedException ex) {
            this.raportti.setText("Ohjelma on kohdannut virheen ja se suljetaan");
            Thread.currentThread().interrupt();
        }

        this.kello.etene();

        if (tulosteet) {
            this.aika.setText(this.kello.toString());
            tulosta(this.ottelu.getPallonhaltija().getNimi() + " lähtee kuljettamaan palloa");
        }

        if (!onkoAikaa()) {
            return;
        }
        
        if (this.ottelu.paaseekoMaalipaikkaanSyotosta(puolustaja)) {
            maalipaikka();
        }
    }

}
