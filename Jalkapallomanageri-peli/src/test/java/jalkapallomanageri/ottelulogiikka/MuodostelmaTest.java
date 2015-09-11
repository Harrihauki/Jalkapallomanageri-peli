/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.ottelulogiikka;

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
    Scanner lukija;
    
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
        lukija = new Scanner(System.in);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void kysyPelaajaaToimiiAsiallisellaSyotteella() {
        
        
    }
}
