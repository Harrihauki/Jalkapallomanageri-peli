/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.sarja;

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
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void joukkueitaOikeaMaara() {
        
        assertEquals(10, sarja.getJoukkueet().size());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
