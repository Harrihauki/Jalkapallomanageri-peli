/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.sarja;

import jalkapallomanageri.domain.Joukkue;
import jalkapallomanageri.domain.Pelaaja;
import jalkapallomanageri.ottelulogiikka.Ottelu;
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
public class SarjaTest {
    
    Sarja sarja;
    Random arpoja;
    Joukkue puiu;
    
    public SarjaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        arpoja = new Random();
        sarja = new Sarja("PuiU", arpoja);
        
        puiu = sarja.getJoukkueet().get(0);
        
        for (Joukkue joukkue : sarja.getJoukkueet()) {
            
            joukkue.setMuodostelma();
        }
        
        this.alustaPuiU();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void joukkueitaOikeaMaara() {
        
        assertEquals(10, sarja.getJoukkueet().size());
    }
    
    @Test
    public void kierrostenLisaysToimii() {
        
        sarja.seuraavaKierros();
        
        assertEquals(2, sarja.getKierrokset());
    }
    
    @Test
    public void pelejaOikeaMaara() {
        
        List<Ottelu> ottelut = sarja.luoKierroksenOttelut();
        
        assertEquals(5, ottelut.size());
    }
    
    @Test
    public void oikeaVastustajaEnsimmaisellaKierroksella() {
        
        List<Ottelu> ottelut = sarja.luoKierroksenOttelut();
        
        assertEquals("Reipas", ottelut.get(0).getVieras().getNimi());
    }
    
    @Test
    public void oikeaVastustajaToisellaKierroksella() {
        
        List<Ottelu> ottelut = sarja.luoKierroksenOttelut();
        ottelut = sarja.luoKierroksenOttelut();
        
        assertEquals("RoPS", ottelut.get(0).getVieras().getNimi());
    }
    
    @Test
    public void oikeaVastustajaKolmannellaKierroksella() {
        
        List<Ottelu> ottelut = sarja.luoKierroksenOttelut();
        ottelut = sarja.luoKierroksenOttelut();
        ottelut = sarja.luoKierroksenOttelut();
        
        assertEquals("Ilves", ottelut.get(0).getVieras().getNimi());
    }
    
    public void alustaPuiU() {
        
        puiu.getPelaajat().put("Walcott", new Pelaaja("Walcott", 3, 3, 3, 3, 3, 3, 3));
        puiu.getPelaajat().put("Mertesacker", new Pelaaja("Mertesacker", 3, 3, 3, 3, 3, 3, 3));
        puiu.getPelaajat().put("Oxlade", new Pelaaja("Oxlade", 3, 3, 3, 3, 3, 3, 3));
        puiu.getPelaajat().put("Coquellin", new Pelaaja("Coquellin", 3, 3, 3, 3, 3, 3, 3));
        puiu.getPelaajat().put("Giroud", new Pelaaja("Giroud", 3, 3, 3, 3, 3, 3, 3));
        puiu.getPelaajat().put("Sanchez", new Pelaaja("Sanchez", 3, 3, 3, 3, 3, 3, 3));
        puiu.getPelaajat().put("Ramsey", new Pelaaja("Ramsey", 3, 3, 3, 3, 3, 3, 3));
        puiu.getPelaajat().put("Gibbs", new Pelaaja("Gibbs", 3, 3, 3, 3, 3, 3, 3));
        puiu.getPelaajat().put("Koscielny", new Pelaaja("Koscielny", 3, 3, 3, 3, 3, 3, 3));
        puiu.getPelaajat().put("Sagna", new Pelaaja("Sagna", 3, 3, 3, 3, 3, 3, 3));
        puiu.getPelaajat().put("Szcezny", new Pelaaja("Szcezny", 3, 3, 3, 3, 3, 3, 5));
        
        puiu.getMuodostelma().lisaaPelaajaPaikalleen("Walcott", 4, 1, puiu.getPelaajat());
        puiu.getMuodostelma().lisaaPelaajaPaikalleen("Mertesacker", 1, 2, puiu.getPelaajat());
        puiu.getMuodostelma().lisaaPelaajaPaikalleen("Oxlade", 4, 5, puiu.getPelaajat());
        puiu.getMuodostelma().lisaaPelaajaPaikalleen("Coquellin", 2, 3, puiu.getPelaajat());
        puiu.getMuodostelma().lisaaPelaajaPaikalleen("Giroud", 5, 3, puiu.getPelaajat());
        puiu.getMuodostelma().lisaaPelaajaPaikalleen("Sanchez", 3, 2, puiu.getPelaajat());
        puiu.getMuodostelma().lisaaPelaajaPaikalleen("Ramsey", 3, 4, puiu.getPelaajat());
        puiu.getMuodostelma().lisaaPelaajaPaikalleen("Gibbs", 1, 1, puiu.getPelaajat());
        puiu.getMuodostelma().lisaaPelaajaPaikalleen("Koscielny", 1, 4, puiu.getPelaajat());
        puiu.getMuodostelma().lisaaPelaajaPaikalleen("Sagna", 1, 5, puiu.getPelaajat());
        puiu.getMuodostelma().setMaalivahti("Szcezny", puiu.getPelaajat());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
