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
public class MaalivahtiTest {
    
    Maalivahti maalivahti;
    
    public MaalivahtiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        maalivahti = new Maalivahti("Teppo Töppö", 3);
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
    public void maalivahdinKonstruktoriToimii() {
        
        assertEquals("Teppo Töppö\nTorjuminen: 3\nLoukkaantunut: false", maalivahti.toString());
    }
    
    @Test
    public void luokkaantuminenToimii() {
        
        maalivahti.loukkaannu();
        
        assertEquals(true, maalivahti.loukkaantunut);
    }
    
    @Test
    public void paraneminenToimii() {
        
        maalivahti.loukkaannu();
        maalivahti.parane();
        
        assertEquals(false, maalivahti.loukkaantunut);
    }
}
