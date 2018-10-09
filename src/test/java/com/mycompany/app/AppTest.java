package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;


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
   /* public void testApp()
    {
        assertTrue( true );
    }*/
      public void testFound() {
      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
      ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(4, 3, 2, 1));
      assertTrue(new App().myMethod(array,array2,4,4));
    }

    public void testNotFound() {
      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
      ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
      int result=array.size();
      int result2=array.size();
      
      assertFalse(new App().myMethod(array,array2,result,result2));
    }

    public void testEmptyArray() {
      ArrayList<Integer> array = new ArrayList<>();
      ArrayList<Integer> array2 = new ArrayList<>();

      assertFalse(new App().myMethod(array,array2,0,0));
    }

    public void testNull() {
      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1));
      ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1));
      int result=array.size();
      int result2=array.size();
      
      assertFalse(new App().myMethod(array,array2,result,result2));
    }

    public void testSize(){
      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3));
      ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(8,5,3));
      int result=array.size();
      int result2=array.size();
      
      assertFalse(new App().myMethod(array,array2,result,result2));
    }

}
