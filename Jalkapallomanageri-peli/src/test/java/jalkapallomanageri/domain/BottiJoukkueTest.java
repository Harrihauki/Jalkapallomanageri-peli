/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.domain;

import java.util.List;
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
public class BottiJoukkueTest {
    
    Joukkue arsenal;
    List<Pelaaja> arsunAvaus;
    
    public BottiJoukkueTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        arsenal = new BottiJoukkue("Arsenal");
        
        this.alustaJoukkueet();
        
        arsenal.setMuodostelma();
        
        arsunAvaus = arsenal.getMuodostelma().getAvauskentallinen();
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
    public void maalivahtiAsetetaanOikein() {
        
        assertEquals(arsenal.getPelaajat().get("Szcezny"), arsenal.getMuodostelma().getMaalivahti());
    }
    
    @Test
    public void puolustajatAsetetaanOikein1() {
        
        Pelaaja mertesacker = arsenal.getPelaajat().get("Mertesacker");
        
        assertEquals(1, mertesacker.getPelipaikka());
    }
    
    @Test
    public void puolustajatAsetetaanOikein2() {
        
        Pelaaja gibbs = arsenal.getPelaajat().get("Gibbs");
        
        assertEquals(1, gibbs.getPelipaikka());
    }
    
    @Test
    public void keskikenttaAsetetaanOikein1() {
        
        Pelaaja walcott = arsenal.getPelaajat().get("Walcott");
        
        assertEquals(4, walcott.getPelipaikka());
    }
    
    @Test
    public void keskikenttaAsetetaanOikein2() {
        
        Pelaaja coquellin = arsenal.getPelaajat().get("Coquellin");
        
        assertEquals(3, coquellin.getPelipaikka());
    }
    
    @Test
    public void keskikenttaAsetetaanOikein3() {
        
        Pelaaja sanchez = arsenal.getPelaajat().get("Sanchez");
        
        assertEquals(2, sanchez.getPelipaikka());
    }
    
    @Test
    public void hyokkaajaAsetetaanOikein1() {
        
        Pelaaja giroud = arsenal.getPelaajat().get("Giroud");
        
        assertEquals(5, giroud.getPelipaikka());
    }
    
    @Test
    public void asetinReagoiLoukkaantumiseenMv() {
        
        arsenal.getPelaajat().get("Szcezny").loukkaannu();
        
        arsenal.setMuodostelma();
        
        assertEquals(arsenal.getPelaajat().get("Sagna"), arsenal.getMuodostelma().getMaalivahti());
    }
    
    @Test
    public void asetinReagoiLoukkaantumiseenPuolustaja() {
        
        arsenal.getPelaajat().get("Mertesacker").loukkaannu();
        
        arsenal.setMuodostelma();
        
        assertFalse(arsunAvaus.contains(arsenal.getPelaajat().get("Mertesacker")));
    }
    
    @Test
    public void asetinReagoiLoukkaantumiseenKeskikentta() {
        
        arsenal.getPelaajat().get("Walcott").loukkaannu();
        
        arsenal.setMuodostelma();
        
        assertFalse(arsunAvaus.contains(arsenal.getPelaajat().get("Walcott")));
    }
    
    @Test
    public void asetinReagoiLoukkaantumiseenHyokkaaja() {
        
        arsenal.getPelaajat().get("Giroud").loukkaannu();
        
        arsenal.setMuodostelma();
        
        assertFalse(arsunAvaus.contains(arsenal.getPelaajat().get("Giroud")));
    }
    
    private void alustaJoukkueet() {
        
        arsenal.getPelaajat().put("Walcott", new Pelaaja("Walcott", 3, 3, 3, 3, 3, 9, 3));
        arsenal.getPelaajat().put("Mertesacker", new Pelaaja("Mertesacker", 3, 3, 3, 3, 7, 3, 3));
        arsenal.getPelaajat().put("Oxlade", new Pelaaja("Oxlade", 3, 3, 3, 3, 3, 3, 3));
        arsenal.getPelaajat().put("Coquellin", new Pelaaja("Coquellin", 3, 3, 3, 3, 6, 7, 3));
        arsenal.getPelaajat().put("Giroud", new Pelaaja("Giroud", 3, 3, 10, 3, 3, 3, 3));
        arsenal.getPelaajat().put("Sanchez", new Pelaaja("Sanchez", 3, 3, 3, 3, 7, 4, 3));
        arsenal.getPelaajat().put("Ramsey", new Pelaaja("Ramsey", 3, 3, 9, 3, 3, 3, 3));
        arsenal.getPelaajat().put("Gibbs", new Pelaaja("Gibbs", 3, 3, 3, 3, 7, 3, 3));
        arsenal.getPelaajat().put("Koscielny", new Pelaaja("Koscielny", 3, 3, 3, 3, 7, 3, 3));
        arsenal.getPelaajat().put("Sagna", new Pelaaja("Sagna", 3, 3, 3, 3, 3, 3, 9));
        arsenal.getPelaajat().put("Szcezny", new Pelaaja("Szcezny", 3, 3, 3, 3, 3, 3, 10));
        arsenal.getPelaajat().put("Wenger", new Pelaaja("Wenger", 1, 1, 1, 1, 1, 1, 1));
        
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
        
    }
}
