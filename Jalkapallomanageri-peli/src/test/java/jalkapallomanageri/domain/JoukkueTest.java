/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.domain;

import jalkapallomanageri.pelaajaGeneraattori.Pelaajageneraattori;
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
public class JoukkueTest {
    
    Joukkue joukkue;
    
    public JoukkueTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        joukkue = new KayttajanJoukkue("PuiU");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriToimii() {
        
        assertEquals("PuiU", joukkue.getNimi());
    }
    
    @Test
    public void pelaajagenerointiToimii() {
        
        Random arpoja = new Random();
        Pelaajageneraattori generaattori = new Pelaajageneraattori(arpoja);
        
        joukkue.generoiPelaajat(generaattori);
        
        assertTrue(joukkue.getPelaajat().size() == 16);
    }
}
