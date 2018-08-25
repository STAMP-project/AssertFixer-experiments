package mediana;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author daphnemillss
 */
public class MedianaTest {
    
    public MedianaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void vetorOrdenadoTest(){
        double v[] = {1,2,3,4,5};
        CalculadoraMediana m = new CalculadoraMediana();
        double res = m.getMediana();
        assertEquals(3.0, res, 0.01);
    }

}
