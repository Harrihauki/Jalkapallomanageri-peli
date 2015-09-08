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
public class KenttapelaajaTest {
    
    public KenttapelaajaTest() {
    }
    
    Kenttapelaaja pelaaja;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        pelaaja = new Kenttapelaaja("Seppo Teppo", 3, 3, 3, 3, 3, 3);
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
        
        assertEquals("Seppo Teppo\nPaikanhaku: 3\nNopeus: 3\nMaalinteko: 3\nSyöttäminen: 3\nPuolustus: 3\nHarhauttaminen: 3\nLoukkaantunut: false", pelaaja.toString());
    }
    
    @Test
    public void luokkaantuminenToimii() {
        
        pelaaja.loukkaannu();
        
        assertEquals(true, pelaaja.loukkaantunut);
    }
    
    @Test
    public void paraneminenToimii() {
        
        pelaaja.loukkaannu();
        pelaaja.parane();
        
        assertEquals(false, pelaaja.loukkaantunut);
    }
    
    
}
