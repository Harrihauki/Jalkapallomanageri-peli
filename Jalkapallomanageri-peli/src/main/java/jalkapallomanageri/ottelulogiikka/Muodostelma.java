/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.ottelulogiikka;

import jalkapallomanageri.domain.Pelaaja;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author lallimyl
 */
public class Muodostelma {

    Pelaaja maalivahti;
    Map<Integer, Map> pelipaikat;

    public Muodostelma() {

        this.pelipaikat = new HashMap<>();
        this.maalivahti = null;
    }

    public void asetaMuodostelma(Scanner lukija, Map<String, Pelaaja> pelaajat) {

        this.maalivahti = null;
        this.pelipaikat.clear();
        List<String> asetetutPelaajat = new ArrayList<>();

        this.tulostaOhjeet(pelaajat);

        this.setMaalivahti(lukija, pelaajat, asetetutPelaajat);

        for (int i = 0; i < 10; i++) {

            String asetettavanPelaajanNimi = this.kysyPelaajaa(lukija, pelaajat, asetetutPelaajat);

            int pelipaikka = this.kysyPelipaikkaa(lukija);

            int sijainti = kysySijaintia(lukija);

            while (pelipaikkaOnVarattu(pelipaikka, sijainti)) {

                System.out.println("Sijainnissa on jo pelaaja.");

                sijainti = kysySijaintia(lukija);
            }
            
            this.lisaaPelaajaPaikalleen(asetettavanPelaajanNimi, pelipaikka, sijainti, pelaajat);
            asetetutPelaajat.add(asetettavanPelaajanNimi);

        }
    }

    public void tulostaOhjeet(Map<String, Pelaaja> pelaajat) {

        System.out.println("Pelaajat:");

        for (Pelaaja pelaaja : pelaajat.values()) {

            System.out.println(pelaaja.getNimi());
        }

        System.out.println("");
        System.out.println("Pelaajat asetetaan antamalla vuorotellen 11:lle pelaajalle pelipaikka. Ensin kysytään pelaajaa, sitten pelipaikkaa"
                + " ja viimeiseksi pelaajan sijaintia kentän leveyssuunnassa.");
        System.out.println("");
        System.out.println("Pelipaikat\n0 = maalivahti,\n1 = puolustaja,\n2 = alempi keskikenttä,\n3 = 'normaali keskikenttä',\n4 = ylempi keskikenttä,\nja 5 = hyökkääjä");
        System.out.println("Sijainnissa 1 tarkoittaa vasenta laitaa, 3 keskiakselia, 5 oikeaa laitaa ja 2 ja 4 ovat sijainnit laitojen ja keskustan välissä.");
        System.out.println("Esimerkiksi jos laitat pelaajan pelipaikaksi 1 ja sijainniksi 1, asetat pelaajan vasemmaksi laitapuolustajaksi. Vastaavasti '4,5' on oikea ylempi laitapelaaja.");

    }

    public String kysyPelaajaa(Scanner lukija, Map<String, Pelaaja> pelaajat, List<String> asetetutPelaajat) {

        System.out.println("Aseta haluamasi pelaaja kirjoittamalla pelaajan nimi.");
        System.out.println("");

        String asetettavanPelaajanNimi = lukija.nextLine();

        while (this.pelaajaOnJoAsetettu(asetetutPelaajat, asetettavanPelaajanNimi)) {

            System.out.println("Pelaaja on jo asetettu");

            asetettavanPelaajanNimi = lukija.nextLine();
        }

        while (this.pelaajaaEiOle(asetettavanPelaajanNimi, pelaajat)) {

            System.out.println("Pelaajaa ei ole.");

            asetettavanPelaajanNimi = lukija.nextLine();
        }

        return asetettavanPelaajanNimi;
    }

    private boolean pelaajaOnJoAsetettu(List<String> asetetutPelaajat, String asetettavanPelaajanNimi) {

        if (asetetutPelaajat.contains(asetettavanPelaajanNimi)) {

            System.out.println("Pelaaja on jo asetettu.");

            return true;
        }

        return false;
    }

    private int kysyPelipaikkaa(Scanner lukija) {

        System.out.println("Mille pelipaikalle haluat pelaajan? ");
        
        int pelipaikka;
        
        try {
            pelipaikka = Integer.parseInt(lukija.nextLine());
        } catch(Exception e) {
            
            System.out.println("Käytäthän numeroita pelipaikan kirjoittamiseen");
            
            pelipaikka = Integer.parseInt(lukija.nextLine());
        }

        while (pelipaikkaaEiOle(pelipaikka)) {
            System.out.println("Pelipaikkaa ei ole.");

            pelipaikka = Integer.parseInt(lukija.nextLine());
        }

        return pelipaikka;
    }

    private boolean pelipaikkaaEiOle(int pelipaikka) {

        if (pelipaikka < 0) {
            return true;
        } else if (pelipaikka > 5) {
            return true;
        }

        return false;
    }

    private int kysySijaintia(Scanner lukija) {

        System.out.println("Mille sijainnille pelaajan haluat?");

        int sijainti;
        
        try {
            sijainti = Integer.parseInt(lukija.nextLine());
        } catch(Exception e) {
            
            System.out.println("Käytäthän numeroita sijainnin kirjoittamiseen");
            
            sijainti = Integer.parseInt(lukija.nextLine());
        }
        
        while(this.sijaintiaEiOle(sijainti)) {
            
            System.out.println("Sijaintia ei ole");
            
            sijainti = Integer.parseInt(lukija.nextLine());
        }
        
        return sijainti;
    }

    private void setMaalivahti(Scanner lukija, Map<String, Pelaaja> pelaajat, List<String> asetetutPelaajat) {

        System.out.println("Valitse maalivahti:");

        String asetettavanPelaajanNimi = lukija.nextLine();

        this.maalivahti = pelaajat.get(asetettavanPelaajanNimi);
        asetetutPelaajat.add(asetettavanPelaajanNimi);

        System.out.println("Maalivahti asetettu.");
        System.out.println("");
    }

    private boolean sijaintiaEiOle(int sijainti) {

        if (sijainti < 1) {
            return true;
        } else if (sijainti > 5) {
            return true;
        }

        return false;
    }

    private boolean pelipaikkaOnVarattu(int pelipaikka, int sijainti) {

        if (this.pelipaikat.containsKey(pelipaikka)) {

            if (this.pelipaikat.get(pelipaikka).containsKey(sijainti)) {

                return true;
            }
        }

        return false;
    }

//    private boolean maalivahtiaEiVielaAsetettu() {
//
//        if (this.maalivahti == null) {
//
//            return true;
//        }
//
//        System.out.println("Maalivahti on jo asetettu.");
//
//        return false;
//    }

    private boolean pelaajaaEiOle(String asetettavanPelaajanNimi, Map<String, Pelaaja> pelaajat) {

        if (pelaajat.containsKey(asetettavanPelaajanNimi)) {

            return true;
        }

        return false;
    }

    private void lisaaPelaajaPaikalleen(String asetettavanPelaajanNimi, int pelipaikka, int sijainti, Map<String, Pelaaja> pelaajat) {
        
        if (this.pelipaikat.containsKey(pelipaikka)) {
            
            this.pelipaikat.get(pelipaikka).put(sijainti, pelaajat.get(asetettavanPelaajanNimi));
        } else {
            
            this.pelipaikat.put(pelipaikka, new HashMap<Integer, Pelaaja>());
            this.pelipaikat.get(pelipaikka).put(sijainti, pelaajat.get(asetettavanPelaajanNimi));
        }
        
        System.out.println("Pelaaja asetettu");
        System.out.println("");
    }

}
