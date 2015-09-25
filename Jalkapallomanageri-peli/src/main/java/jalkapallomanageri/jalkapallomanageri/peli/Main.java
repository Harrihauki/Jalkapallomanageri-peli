    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.jalkapallomanageri.peli;

import jalkapallomanageri.domain.BottiJoukkue;
import jalkapallomanageri.domain.Joukkue;
import jalkapallomanageri.domain.KayttajanJoukkue;
import jalkapallomanageri.domain.Pelaaja;
import jalkapallomanageri.ottelulogiikka.Ottelu;
import jalkapallomanageri.pelaajaGeneraattori.Pelaajageneraattori;
import jalkapallomanageri.sarja.Sarja;
import java.util.List;
import java.util.Random;

/**
 *
 * @author lallimyl
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Random arpoja = new Random();
        Sarja sarja = new Sarja("PuiU", arpoja);
//        Pelaajageneraattori generaattori = new Pelaajageneraattori(arpoja);
//        Joukkue joukkue = new KayttajanJoukkue("PuiU");
//
//        joukkue.generoiPelaajat(generaattori);
//        System.out.println(joukkue.getPelaajat().size());
//
//        Joukkue liverpool;
//        Joukkue arsenal;
//        List<Pelaaja> poolinAvaus;
//        List<Pelaaja> arsunAvaus;
//
//        liverpool = new BottiJoukkue("Liverpool");
//        arsenal = new BottiJoukkue("Arsenal");
//
//        Ottelu ottelu;
//
//        arpoja = new Random();
//
//        arsenal.getPelaajat().put("Walcott", new Pelaaja("Walcott", 3, 3, 3, 3, 3, 3, 3));
//        arsenal.getPelaajat().put("Mertesacker", new Pelaaja("Mertesacker", 3, 3, 3, 3, 3, 3, 3));
//        arsenal.getPelaajat().put("Oxlade", new Pelaaja("Oxlade", 3, 3, 3, 3, 3, 3, 3));
//        arsenal.getPelaajat().put("Coquellin", new Pelaaja("Coquellin", 3, 3, 3, 3, 3, 3, 3));
//        arsenal.getPelaajat().put("Giroud", new Pelaaja("Giroud", 3, 3, 3, 3, 3, 3, 3));
//        arsenal.getPelaajat().put("Sanchez", new Pelaaja("Sanchez", 3, 3, 3, 3, 3, 3, 3));
//        arsenal.getPelaajat().put("Ramsey", new Pelaaja("Ramsey", 3, 3, 3, 3, 3, 3, 3));
//        arsenal.getPelaajat().put("Gibbs", new Pelaaja("Gibbs", 3, 3, 3, 3, 3, 3, 3));
//        arsenal.getPelaajat().put("Koscielny", new Pelaaja("Koscielny", 3, 3, 3, 3, 3, 3, 3));
//        arsenal.getPelaajat().put("Sagna", new Pelaaja("Sagna", 3, 3, 3, 3, 3, 3, 3));
//        arsenal.getPelaajat().put("Szcezny", new Pelaaja("Szcezny", 3, 3, 3, 3, 3, 3, 5));
//
//        liverpool.getPelaajat().put("Clyne", new Pelaaja("Clyne", 3, 3, 3, 3, 3, 3, 3));
//        liverpool.getPelaajat().put("Sakho", new Pelaaja("Sakho", 3, 3, 3, 3, 3, 3, 3));
//        liverpool.getPelaajat().put("Skrtel", new Pelaaja("Skrtel", 3, 3, 3, 3, 3, 3, 3));
//        liverpool.getPelaajat().put("Johnson", new Pelaaja("Johnson", 3, 3, 3, 3, 3, 3, 3));
//        liverpool.getPelaajat().put("Henderson", new Pelaaja("Henderson", 3, 3, 3, 3, 3, 3, 3));
//        liverpool.getPelaajat().put("Coutinho", new Pelaaja("Coutinho", 3, 3, 3, 3, 3, 3, 3));
//        liverpool.getPelaajat().put("Benteke", new Pelaaja("Benteke", 3, 3, 3, 3, 3, 3, 3));
//        liverpool.getPelaajat().put("Can", new Pelaaja("Can", 3, 3, 3, 3, 3, 3, 3));
//        liverpool.getPelaajat().put("Milner", new Pelaaja("Milner", 3, 3, 3, 3, 3, 3, 3));
//        liverpool.getPelaajat().put("Ings", new Pelaaja("Ings", 3, 3, 3, 3, 3, 3, 3));
//        liverpool.getPelaajat().put("Mignolet", new Pelaaja("Mignolet", 3, 3, 3, 3, 3, 3, 5));
//
//        poolinAvaus = liverpool.getMuodostelma().getAvauskentallinen();
//        arsunAvaus = arsenal.getMuodostelma().getAvauskentallinen();
//
//        arsenal.getMuodostelma().lisaaPelaajaPaikalleen("Walcott", 4, 1, arsenal.getPelaajat());
//        arsenal.getMuodostelma().lisaaPelaajaPaikalleen("Mertesacker", 1, 2, arsenal.getPelaajat());
//        arsenal.getMuodostelma().lisaaPelaajaPaikalleen("Oxlade", 4, 5, arsenal.getPelaajat());
//        arsenal.getMuodostelma().lisaaPelaajaPaikalleen("Coquellin", 2, 3, arsenal.getPelaajat());
//        arsenal.getMuodostelma().lisaaPelaajaPaikalleen("Giroud", 5, 3, arsenal.getPelaajat());
//        arsenal.getMuodostelma().lisaaPelaajaPaikalleen("Sanchez", 3, 2, arsenal.getPelaajat());
//        arsenal.getMuodostelma().lisaaPelaajaPaikalleen("Ramsey", 3, 4, arsenal.getPelaajat());
//        arsenal.getMuodostelma().lisaaPelaajaPaikalleen("Gibbs", 1, 1, arsenal.getPelaajat());
//        arsenal.getMuodostelma().lisaaPelaajaPaikalleen("Koscielny", 1, 4, arsenal.getPelaajat());
//        arsenal.getMuodostelma().lisaaPelaajaPaikalleen("Sagna", 1, 5, arsenal.getPelaajat());
//        arsenal.getMuodostelma().setMaalivahti("Szcezny", arsenal.getPelaajat());
//
//        liverpool.getMuodostelma().lisaaPelaajaPaikalleen("Clyne", 2, 1, liverpool.getPelaajat());
//        liverpool.getMuodostelma().lisaaPelaajaPaikalleen("Sakho", 1, 2, liverpool.getPelaajat());
//        liverpool.getMuodostelma().lisaaPelaajaPaikalleen("Coutinho", 4, 3, liverpool.getPelaajat());
//        liverpool.getMuodostelma().lisaaPelaajaPaikalleen("Can", 2, 3, liverpool.getPelaajat());
//        liverpool.getMuodostelma().lisaaPelaajaPaikalleen("Benteke", 5, 2, liverpool.getPelaajat());
//        liverpool.getMuodostelma().lisaaPelaajaPaikalleen("Milner", 3, 2, liverpool.getPelaajat());
//        liverpool.getMuodostelma().lisaaPelaajaPaikalleen("Henderson", 3, 4, liverpool.getPelaajat());
//        liverpool.getMuodostelma().lisaaPelaajaPaikalleen("Ings", 5, 4, liverpool.getPelaajat());
//        liverpool.getMuodostelma().lisaaPelaajaPaikalleen("Skrtel", 1, 4, liverpool.getPelaajat());
//        liverpool.getMuodostelma().lisaaPelaajaPaikalleen("Johnson", 2, 5, liverpool.getPelaajat());
//        liverpool.getMuodostelma().setMaalivahti("Mignolet", liverpool.getPelaajat());
//        
//        ottelu = new Ottelu(liverpool, arsenal, arpoja);
//        
//        System.out.println(ottelu.laskeOmienEtaisyydet(poolinAvaus.get(0)).size());
    }

}
