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
public class SarjataulukkoTest {
    
    Sarja sarja;
    
    public SarjataulukkoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        this.sarja = new Sarja("PuiU", new Random());
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void jarjestaminenToimii1() {
        
        Pisteenlaskija laskija = sarja.getSarjataulukko().getPisteenlaskijat().get(5);
        laskija.lisaaPisteita(3);
        
        sarja.getSarjataulukko().jarjesta();
        
        assertEquals(laskija, sarja.getSarjataulukko().getPisteenlaskijat().get(0));
    }
    
    @Test
    public void jarjestaminenToimii2() {
        
        Pisteenlaskija laskija = sarja.getSarjataulukko().getPisteenlaskijat().get(5);
        laskija.lisaaPaastettyjaMaaleja(3);
        
        sarja.getSarjataulukko().jarjesta();
        
        assertEquals(laskija, sarja.getSarjataulukko().getPisteenlaskijat().get(9));
    }
    
    @Test
    public void jarjestaminenToimii3() {
        
        Pisteenlaskija laskija1 = sarja.getSarjataulukko().getPisteenlaskijat().get(5);
        Pisteenlaskija laskija2 = sarja.getSarjataulukko().getPisteenlaskijat().get(6);
        
        laskija1.lisaaPisteita(4);
        laskija2.lisaaPisteita(4);
        laskija1.lisaaTehtyjaMaaleja(7);
        laskija2.lisaaTehtyjaMaaleja(2);
        laskija1.lisaaPaastettyjaMaaleja(5);
        
        sarja.getSarjataulukko().jarjesta();
        
        assertEquals(laskija2, sarja.getSarjataulukko().getPisteenlaskijat().get(1));
    }
    
    @Test
    public void jarjestaminenToimii4() {
        
        Pisteenlaskija laskija1 = sarja.getSarjataulukko().getPisteenlaskijat().get(5);
        Pisteenlaskija laskija2 = sarja.getSarjataulukko().getPisteenlaskijat().get(6);
        
        laskija1.lisaaPisteita(5);
        laskija2.lisaaPisteita(4);
        laskija1.lisaaTehtyjaMaaleja(7);
        laskija2.lisaaTehtyjaMaaleja(2);
        laskija1.lisaaPaastettyjaMaaleja(5);
        
        sarja.getSarjataulukko().jarjesta();
        
        assertEquals(laskija2, sarja.getSarjataulukko().getPisteenlaskijat().get(1));
    }
    
    @Test
    public void jarjestaminenToimii5() {
        
        Pisteenlaskija laskija1 = sarja.getSarjataulukko().getPisteenlaskijat().get(5);
        Pisteenlaskija laskija2 = sarja.getSarjataulukko().getPisteenlaskijat().get(6);
        
        laskija1.lisaaPisteita(4);
        laskija2.lisaaPisteita(4);
        laskija1.lisaaTehtyjaMaaleja(7);
        laskija2.lisaaTehtyjaMaaleja(2);
        laskija1.lisaaPaastettyjaMaaleja(9);
        
        sarja.getSarjataulukko().jarjesta();
        
        assertEquals(laskija1, sarja.getSarjataulukko().getPisteenlaskijat().get(1));
    }
    
    @Test
    public void jarjestaminenToimii6() {
        
        Pisteenlaskija laskija1 = sarja.getSarjataulukko().getPisteenlaskijat().get(5);
        Pisteenlaskija laskija2 = sarja.getSarjataulukko().getPisteenlaskijat().get(6);
        
        laskija1.lisaaPisteita(5);
        laskija2.lisaaPisteita(4);
        laskija1.lisaaTehtyjaMaaleja(7);
        laskija2.lisaaTehtyjaMaaleja(1);
        laskija1.lisaaPaastettyjaMaaleja(5);
        
        sarja.getSarjataulukko().jarjesta();
        
        assertEquals(laskija2, sarja.getSarjataulukko().getPisteenlaskijat().get(1));
    }
}
