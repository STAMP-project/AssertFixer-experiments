/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Edmundo
 */
public class MatematicaTest {
    
    public MatematicaTest() {
    }

    @Test
    public void testSoma() {
        Matematica m = new Matematica();
        assertEquals(5,m.soma(2, 3));
    }
    @Test
    public void testeMediana() {
        Matematica m = new Matematica();
        List<Double> listaNumeros = new ArrayList<>(Arrays.asList(1.5, 4.0, 4.0, 5.0, 6.0, 7.0, 7.0, 7.0));
        assertEquals(5.0, m.mediana(listaNumeros), 0.01);
    }
    
    @Test
    public void testeMedia() {
        Matematica m = new Matematica();
        List<Double> listaNumeros = new ArrayList<>(Arrays.asList(1.5, 4.0, 4.0, 5.0, 6.0, 7.0, 7.0, 7.0));
        assertEquals(5.18, m.media(listaNumeros), 0.01);
    }
    
    @Test
    public void testeMenorValor() {
        Matematica m = new Matematica();
        List<Double> listaNumeros = new ArrayList<>(Arrays.asList(1.5, 4.0, 4.0, 5.0, 6.0, 7.0, 7.0, 0.1));
        assertEquals(0.1, m.menorValor(listaNumeros), 0.01);
    }
    
    @Test
    public void testeMaiorValor() {
        Matematica m = new Matematica();
        List<Double> listaNumeros = new ArrayList<>(Arrays.asList(1.5, 4.0, 4.0, 5.0, 6.0, 7.0, 7.0, 0.1));
        assertEquals(7, m.maiorValor(listaNumeros), 0.01);
    }
    
    @Test
    public void testeNumeroValoresAcimaMedia() {
        Matematica m = new Matematica();
        List<Double> listaNumeros = new ArrayList<>(Arrays.asList(1.5, 4.0, 4.0, 5.0, 6.0, 7.0, 7.0, 0.1));
        assertEquals(4, m.NumeroValoresAcimaMedia(listaNumeros), 0.01);
    }
    
    @Test
    public void testeNumeroValoresBaixoMedia() {
        Matematica m = new Matematica();
        List<Double> listaNumeros = new ArrayList<>(Arrays.asList(1.5, 4.0, 4.0, 5.0, 6.0, 7.0, 7.0, 0.1, 3.0));
        assertEquals(5, m.NumeroValoresBaixoMedia(listaNumeros), 0.01);
    }
    
    @Test
    public void testeDesvioPadrao() {
        Matematica m = new Matematica();
        List<Double> listaNumeros = new ArrayList<>(Arrays.asList(1.55, 1.70, 1.80));
        assertEquals(0.10, m.desvioPadrao(listaNumeros), 0.01);
    }
}
