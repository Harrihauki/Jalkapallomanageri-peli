/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.ottelulogiikka;

import jalkapallomanageri.ottelulogiikka.Muodostelma;
import jalkapallomanageri.domain.BottiJoukkue;
import jalkapallomanageri.domain.Joukkue;
import jalkapallomanageri.domain.Pelaaja;
import java.util.List;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lallimyl
 */
public class OtteluTest {
    
    Joukkue liverpool;
    Joukkue arsenal;
    List<Pelaaja> poolinAvaus;
    List<Pelaaja> arsunAvaus;
    
    Ottelu ottelu;
    Random arpoja;
    
    public OtteluTest() {
        
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        liverpool = new BottiJoukkue("Liverpool");
        arsenal = new BottiJoukkue("Arsenal");
        
        this.alustaJoukkueet();
        
        poolinAvaus = liverpool.getMuodostelma().getAvauskentallinen();
        arsunAvaus = arsenal.getMuodostelma().getAvauskentallinen();
        
        arpoja = new Random();
        
        ottelu = new Ottelu(liverpool, arsenal, arpoja);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void kahdenPelaajanEtaisyydenLaskeminenOnnistuu() {
        
        assertEquals(2.0, ottelu.etaisyys(poolinAvaus.get(1), poolinAvaus.get(8)), 0.01);
    }
    
    @Test
    public void pallottomanPelaajanJoukkueTunnistetaanOikeinKotipelaajalla() {
        
        assertTrue(ottelu.pallottomanJoukkueenPelaajat(poolinAvaus.get(0)).contains(arsunAvaus.get(0)));
    }
    
    @Test
    public void pallottomanPelaajanJoukkueTunnistetaanOikeinVieraspelaajalla() {
        
        assertTrue(ottelu.pallottomanJoukkueenPelaajat(arsunAvaus.get(0)).contains(poolinAvaus.get(0)));
    }
    
    @Test
    public void pallollisenPelaajanJoukkueTunnistetaanOikeinKotipelaajalla() {
        
        assertTrue(ottelu.pallollisenJoukkueenPelaajat(poolinAvaus.get(0)).contains(poolinAvaus.get(0)));
    }
    
    @Test
    public void pallollisenPelaajanJoukkueTunnistetaanOikeinVieraspelaajalla() {
        
        assertTrue(ottelu.pallollisenJoukkueenPelaajat(arsunAvaus.get(0)).contains(arsunAvaus.get(0)));
    }
    
    @Test
    public void omienPelaajienEtaisyyksissaEiHuomioidaPelaajaaItseaan() {
        
        assertEquals(9, ottelu.laskeOmienEtaisyydet(poolinAvaus.get(0)).size());
    }
    
    @Test
    public void vastustajanEtaisyyksiaOikeaMaara() {
        
        assertEquals(10, ottelu.laskeVastustajienEtaisyydet(arsunAvaus.get(0)).size());
    }
    
    

    private void alustaJoukkueet() {
        
        arsenal.getPelaajat().put("Walcott", new Pelaaja("Walcott", 3, 3, 3, 3, 3, 3, 3));
        arsenal.getPelaajat().put("Mertesacker", new Pelaaja("Mertesacker", 3, 3, 3, 3, 3, 3, 3));
        arsenal.getPelaajat().put("Oxlade", new Pelaaja("Oxlade", 3, 3, 3, 3, 3, 3, 3));
        arsenal.getPelaajat().put("Coquellin", new Pelaaja("Coquellin", 3, 3, 3, 3, 3, 3, 3));
        arsenal.getPelaajat().put("Giroud", new Pelaaja("Giroud", 3, 3, 3, 3, 3, 3, 3));
        arsenal.getPelaajat().put("Sanchez", new Pelaaja("Sanchez", 3, 3, 3, 3, 3, 3, 3));
        arsenal.getPelaajat().put("Ramsey", new Pelaaja("Ramsey", 3, 3, 3, 3, 3, 3, 3));
        arsenal.getPelaajat().put("Gibbs", new Pelaaja("Gibbs", 3, 3, 3, 3, 3, 3, 3));
        arsenal.getPelaajat().put("Koscielny", new Pelaaja("Koscielny", 3, 3, 3, 3, 3, 3, 3));
        arsenal.getPelaajat().put("Sagna", new Pelaaja("Sagna", 3, 3, 3, 3, 3, 3, 3));
        arsenal.getPelaajat().put("Szcezny", new Pelaaja("Szcezny", 3, 3, 3, 3, 3, 3, 5));
        
        liverpool.getPelaajat().put("Clyne", new Pelaaja("Clyne", 3, 3, 3, 3, 3, 3, 3));
        liverpool.getPelaajat().put("Sakho", new Pelaaja("Sakho", 3, 3, 3, 3, 3, 3, 3));
        liverpool.getPelaajat().put("Skrtel", new Pelaaja("Skrtel", 3, 3, 3, 3, 3, 3, 3));
        liverpool.getPelaajat().put("Johnson", new Pelaaja("Johnson", 3, 3, 3, 3, 3, 3, 3));
        liverpool.getPelaajat().put("Henderson", new Pelaaja("Henderson", 3, 3, 3, 3, 3, 3, 3));
        liverpool.getPelaajat().put("Coutinho", new Pelaaja("Coutinho", 3, 3, 3, 3, 3, 3, 3));
        liverpool.getPelaajat().put("Benteke", new Pelaaja("Benteke", 3, 3, 3, 3, 3, 3, 3));
        liverpool.getPelaajat().put("Can", new Pelaaja("Can", 3, 3, 3, 3, 3, 3, 3));
        liverpool.getPelaajat().put("Milner", new Pelaaja("Milner", 3, 3, 3, 3, 3, 3, 3));
        liverpool.getPelaajat().put("Ings", new Pelaaja("Ings", 3, 3, 3, 3, 3, 3, 3));
        liverpool.getPelaajat().put("Mignolet", new Pelaaja("Mignolet", 3, 3, 3, 3, 3, 3, 5));
        
        arsenal.getMuodostelma().lisaaPelaajaPaikalleen("Walcott", 4, 1, arsenal.getPelaajat());
        arsenal.getMuodostelma().lisaaPelaajaPaikalleen("Mertesacker", 1, 2, arsenal.getPelaajat());
        arsenal.getMuodostelma().lisaaPelaajaPaikalleen("Oxlade", 4, 5, arsenal.getPelaajat());
        arsenal.getMuodostelma().lisaaPelaajaPaikalleen("Coquellin", 2, 3, arsenal.getPelaajat());
        arsenal.getMuodostelma().lisaaPelaajaPaikalleen("Giroud", 5, 3, arsenal.getPelaajat());
        arsenal.getMuodostelma().lisaaPelaajaPaikalleen("Sanchez", 3, 2, arsenal.getPelaajat());
        arsenal.getMuodostelma().lisaaPelaajaPaikalleen("Ramsey", 3, 4, arsenal.getPelaajat());
        arsenal.getMuodostelma().lisaaPelaajaPaikalleen("Gibbs", 1, 1, arsenal.getPelaajat());
        arsenal.getMuodostelma().lisaaPelaajaPaikalleen("Koscielny", 1, 4, arsenal.getPelaajat());
        arsenal.getMuodostelma().lisaaPelaajaPaikalleen("Sagna", 1, 5, arsenal.getPelaajat());
        arsenal.getMuodostelma().setMaalivahti("Szcezny", arsenal.getPelaajat());
        
        liverpool.getMuodostelma().lisaaPelaajaPaikalleen("Clyne", 2, 1, liverpool.getPelaajat());
        liverpool.getMuodostelma().lisaaPelaajaPaikalleen("Sakho", 1, 2, liverpool.getPelaajat());
        liverpool.getMuodostelma().lisaaPelaajaPaikalleen("Coutinho", 4, 3, liverpool.getPelaajat());
        liverpool.getMuodostelma().lisaaPelaajaPaikalleen("Can", 2, 3, liverpool.getPelaajat());
        liverpool.getMuodostelma().lisaaPelaajaPaikalleen("Benteke", 5, 2, liverpool.getPelaajat());
        liverpool.getMuodostelma().lisaaPelaajaPaikalleen("Milner", 3, 2, liverpool.getPelaajat());
        liverpool.getMuodostelma().lisaaPelaajaPaikalleen("Henderson", 3, 4, liverpool.getPelaajat());
        liverpool.getMuodostelma().lisaaPelaajaPaikalleen("Ings", 5, 4, liverpool.getPelaajat());
        liverpool.getMuodostelma().lisaaPelaajaPaikalleen("Skrtel", 1, 4, liverpool.getPelaajat());
        liverpool.getMuodostelma().lisaaPelaajaPaikalleen("Johnson", 2, 5, liverpool.getPelaajat());
        liverpool.getMuodostelma().setMaalivahti("Mignolet", liverpool.getPelaajat());
    }
}
