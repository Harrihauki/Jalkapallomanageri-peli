/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.pelaajaGeneraattori;

import jalkapallomanageri.domain.Pelaaja;
import jalkapallomanageri.domain.Pelaaja;
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
public class PelaajageneraattoriTest {
    
    Pelaajageneraattori generaattori;
    Random arpoja;
    
    public PelaajageneraattoriTest() {
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
        generaattori = new Pelaajageneraattori(arpoja);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void arvoEiMeneYli10() {
        
        assertTrue(generaattori.arvoArvo() <= 10);
    }
    
}
