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
    public void testApp()
    {
        assertTrue( true );
    }
      public void testFound() {
     // ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
      ArrayList<Integer> a =new ArrayList<>();
      a.add(1); 
      a.add(2);
      a.add(3);
      a.add(4);
      ArrayList<Integer> b=new ArrayList<>();
      b.add(4);
      b.add(3);
      b.add(2);
      b.add(1);
      int sizeA=4;
      int sizeB=4;
      assertTrue(new App().search(a,sizeA,b,sizeB));
      //assertTrue(new App().search(array, 4));
    }

    public void testNotFound() {
     // ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
     // assertFalse(new App().search(array, 5));
     ArrayList<Integer> a =new ArrayList<>(); 
     ArrayList<Integer> b=new ArrayList<>();
     
      a.add(1); 
      a.add(2);
      a.add(3);
      a.add(4);
      
      b.add(4);
      b.add(3);
      b.add(2);
      b.add(1);
      int sizeA=5;
      int sizeB=4;
      assertFalse(new App().search(a,sizeA,b,sizeB));
    }

    public void testEmptyArray() {
    ArrayList<Integer> a =new ArrayList<>(); 
    ArrayList<Integer> b=new ArrayList<>();
      int sizeA=0;
      int sizeB=0;

      assertFalse(new App().search(a,sizeA,b,sizeB));
     // ArrayList<Integer> array = new ArrayList<>();
      //assertFalse(new App().search(array, 1));
    }

    public void testNull() {
      assertFalse(new App().search(null, 0,null,0));
    }
    public void myTest(){
        ArrayList<Integer> a =new ArrayList<>(); 
        ArrayList<Integer> b=new ArrayList<>();
        int sizeA=4;
        int sizeB=4;
        
      a.add(1); 
      a.add(2);
      a.add(3);
      a.add(4);
     
      b.add(4);
      b.add(3);
      b.add(2);
      b.add(1);
        assertTrue(new App().search(a,sizeA,b,sizeB));
    }
}
