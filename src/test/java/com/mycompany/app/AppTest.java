package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    

    public void testTrue() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(65, 66, 67, 68));
        Integer[] array2 = {65,65,65,65};
        assertTrue(App.stringToByte(array, array2, "ABCD", "AAAA"));
      }

    public void testFalse() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(65, 66, 67, 68));
        Integer[] array2 = {65,65,65,65};
        assertFalse(App.stringToByte(array, array2, "AAAA", "AAAA"));
    }
  
      public void testEmptyString() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(65, 66, 67, 68));
        Integer[] array2 = {65,65,65,65};
        assertFalse(App.stringToByte(array, array2, "", "AAAA"));
      }
  
      public void testEmptyArray() {
        ArrayList<Integer> array = new ArrayList<>();
        Integer[] array2 = {65,65,65,65};
        assertTrue(App.stringToByte(array, array2, "ABCD", "AAAA"));
      }
  
      public void testNull() {
        Integer[] array2 = {65,65,65,65};
        assertTrue(App.stringToByte(null, array2, "ABCD", "AAAA"));
      }
  
}
