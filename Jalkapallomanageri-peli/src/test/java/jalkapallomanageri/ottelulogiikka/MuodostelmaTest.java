/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.ottelulogiikka;

import jalkapallomanageri.domain.Pelaaja;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
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
public class MuodostelmaTest {
    
    Muodostelma muodostelma;
    String nimi;
    Pelaaja seppo;
    Map <String, Pelaaja> pelaajat;
    Pelaaja teppo;
    
    public MuodostelmaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        muodostelma = new Muodostelma();
        nimi = "Seppo";
        seppo = new Pelaaja(nimi, 3, 3, 3, 3, 3, 3, 3);
        pelaajat = new HashMap<>();
        teppo = new Pelaaja("Teppo", 3, 3, 3, 3, 3, 3, 3);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void setMaalivahtiToimii() {
        
        pelaajat.put(nimi, seppo);
        muodostelma.setMaalivahti(nimi, pelaajat);
        
        assertEquals(seppo.toString(), muodostelma.getMaalivahti().toString());
    }
    
    @Test
    public void pelaajanAsettaminenToimii() {
        
        pelaajat.put(nimi, seppo);
        
        muodostelma.lisaaPelaajaPaikalleen(nimi, 3, 3, pelaajat);
        
        assertEquals(1, muodostelma.getAvauskentallinen().size());
    }
    
    @Test
    public void pelaajaSaaTiedonPelipaikastaan() {
        
        pelaajat.put(nimi, seppo);
        
        muodostelma.lisaaPelaajaPaikalleen(nimi, 3, 3, pelaajat);
        
        assertEquals("3,3", seppo.koordinaattiEsitys());
    }
    
    @Test
    public void useammanPelaajanAsettaminenToimii() {
        
        pelaajat.put(nimi, seppo);
        pelaajat.put("Teppo", teppo);
        
        muodostelma.lisaaPelaajaPaikalleen(nimi, 3, 3, pelaajat);
        muodostelma.lisaaPelaajaPaikalleen("Teppo", 4, 4, pelaajat);
        
        assertEquals(2, muodostelma.getAvauskentallinen().size());
    }
    
    @Test
    public void varattuPelipaikkaTunnistetaan() {
        
        pelaajat.put(nimi, seppo);
        
        muodostelma.lisaaPelaajaPaikalleen(nimi, 3, 3, pelaajat);
        
        assertEquals(true, muodostelma.pelipaikkaOnVarattu(3, 3));
    }
    
    @Test
    public void varaamatonPelipaikkaTunnistetaan() {
        
        assertEquals(false, muodostelma.pelipaikkaOnVarattu(3, 3));
    }
    
    @Test
    public void joukkueeseenKuulumatonPelaajaTunnistetaan() {
        
        assertEquals(true, muodostelma.pelaajaaEiOle(nimi, pelaajat));
        
    }
    
    @Test
    public void joAsetettuPelaajaTunnistetaan() {
        
        pelaajat.put(nimi, seppo);
        
        muodostelma.lisaaPelaajaPaikalleen(nimi, 3, 3, pelaajat);
        
        assertEquals(true, muodostelma.pelaajaOnJoAsetettu(nimi, pelaajat));
    }
    
    @Test
    public void joAsetettuPelaajaTunnistetaanKunMaalivahti() {
        
        pelaajat.put(nimi, seppo);
        
        muodostelma.setMaalivahti(nimi, pelaajat);
        
        assertEquals(true, muodostelma.pelaajaOnJoAsetettu(nimi, pelaajat));
    }
    
    @Test
    public void asettamatonPelaajaTunnistetaan() {
        
        pelaajat.put(nimi, seppo);
        
        assertEquals(false, muodostelma.pelaajaOnJoAsetettu(nimi, pelaajat));
    }
    
    @Test
    public void asettamatonPelaajaTunnistetaanKunMuitaAsetettuMaaliin() {
        
        pelaajat.put(nimi, seppo);
        pelaajat.put("Teppo", teppo);
        
        muodostelma.setMaalivahti("Teppo", pelaajat);
        
        assertEquals(false, muodostelma.pelaajaOnJoAsetettu(nimi, pelaajat));
    }
    
    @Test
    public void asettamatonPelaajaTunnistetaanKunMuitaAsetettuKentalle() {
        
        pelaajat.put(nimi, seppo);
        pelaajat.put("Teppo", teppo);
        
        muodostelma.lisaaPelaajaPaikalleen("Teppo", 1, 1, pelaajat);
        
        assertEquals(false, muodostelma.pelaajaOnJoAsetettu(nimi, pelaajat));
    }
    
    @Test
    public void muodostelmanAlustaminenToimii() {
        
        pelaajat.put(nimi, seppo);
        pelaajat.put("Teppo", teppo);
        
        muodostelma.lisaaPelaajaPaikalleen(nimi, 3, 3, pelaajat);
        muodostelma.lisaaPelaajaPaikalleen("Teppo", 4, 4, pelaajat);
        
        muodostelma.alustaMuodostelma();
        
        assertEquals(0, muodostelma.getAvauskentallinen().size());
    }
    
    @Test
    public void muodostelmanAlustaminenToimiiKunMaalivahti() {
        
        pelaajat.put(nimi, seppo);
        
        muodostelma.setMaalivahti(nimi, pelaajat);
        
        muodostelma.alustaMuodostelma();
        
        assertEquals(null, muodostelma.getMaalivahti());
    }
    
    @Test
    public void pelaajanOlemassaoloTunnistetaan() {
        
        pelaajat.put(nimi, seppo);
        
        assertEquals(false, muodostelma.pelaajaaEiOle(nimi, pelaajat));
    }
}
