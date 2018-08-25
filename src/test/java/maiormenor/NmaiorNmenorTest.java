package maiormenor;
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
public class NmaiorNmenorTest {
    
    public NmaiorNmenorTest() {
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
    public void NMaiorNMenorTeste(){
        NMaiorNMenor nm = new NMaiorNMenor();
        double v[]={1,2,3,4,5};
        double v1[] = nm.getNMaior(v, 2);
        double v2[] = nm.getNMenor(v, 2);
        
        assertEquals(4.0f, v1[0], 0.01);
        assertEquals(5.0f, v1[0], 0.01);
        assertEquals(1.0f, v2[0], 0.01);
        assertEquals(2.0f, v2[0], 0.01);
    }
}
