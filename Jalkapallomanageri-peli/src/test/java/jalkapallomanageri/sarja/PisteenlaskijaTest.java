/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.sarja;

import jalkapallomanageri.domain.Joukkue;
import jalkapallomanageri.domain.KayttajanJoukkue;
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
public class PisteenlaskijaTest {
    
    Pisteenlaskija laskija;
    
    public PisteenlaskijaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        laskija = new Pisteenlaskija(new KayttajanJoukkue("PuiU"));
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void pisteidenLisaysOnnistuu() {
        
        laskija.lisaaPisteita(3);
        
        assertEquals(3, laskija.getPisteet());
    }
    
    @Test
    public void tehtyjenMaalienLisaysOnnistuu() {
        
        laskija.lisaaTehtyjaMaaleja(2);
        
        assertEquals(2, laskija.getTehdytMaalit());
    }
    
    @Test
    public void paastettyjenMaalienLisaysOnnistuu() {
        
        laskija.lisaaPaastettyjaMaaleja(1);
        
        assertEquals(-1, laskija.getMaaliero());
    }
}
