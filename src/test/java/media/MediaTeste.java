package media;
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
public class MediaTeste {
    
    public MediaTeste() {
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
    public void vetorOrdenadoTest2(){
        double v[] = {1,2,3,4,5};
        Media m = new Media();
        double res = m.getMedia(v);
        double menorRes = m.getMenorValor(v);
        double maiorRes = m.getMaiorValor(v);
        int qtdMaiorMedia = m.getQtdMaiorMedia(v);
        int qtdMenorMedia = m.getQtdMenorMedia(v);
        assertEquals(3.0 ,res, 0.01);
        assertEquals(1.0, menorRes, 0.01);
        assertEquals(5.0, maiorRes, 0.01);
        assertEquals(2, qtdMaiorMedia);
        assertEquals(2, qtdMenorMedia);
    }
}
