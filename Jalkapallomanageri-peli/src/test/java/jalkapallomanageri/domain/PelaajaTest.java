/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.domain;

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
public class PelaajaTest {
    
    public PelaajaTest() {
    }
    
    Pelaaja pelaaja;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        pelaaja = new Pelaaja("Seppo Teppo", 3, 3, 3, 3, 3, 3, 3);
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
    public void pelaajanKonstruktoriToimii() {
        
        assertEquals("Seppo Teppo\nSijoittuminen: 3\nNopeus: 3\nMaalinteko: 3\nSyöttäminen: 3\nPuolustus: 3\nHarhauttaminen: 3\nMaalivahti: 3\nLoukkaantunut: false", pelaaja.toString());
    }
    
    @Test
    public void luokkaantuminenToimii() {
        
        pelaaja.loukkaannu();
        
        assertEquals(true, pelaaja.getLoukkaantunut());
    }
    
    @Test
    public void paraneminenToimii() {
        
        pelaaja.loukkaannu();
        pelaaja.parane();
        
        assertEquals(false, pelaaja.getLoukkaantunut());
    }
    
    
}
