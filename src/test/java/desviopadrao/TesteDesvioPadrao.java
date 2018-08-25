package desviopadrao;
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
public class TesteDesvioPadrao {
    
    public TesteDesvioPadrao() {
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
    public void TesteDesvPadrao(){
        DesvioPadrao d = new DesvioPadrao();
        double v[] = {1,2,3,4,5};
        assertEquals(1.414214f, d.CalculaDesvioPadrao(v), 0.01);
    }
}
