package com.mycompany.app;
import java.util.ArrayList;
import java.util.Arrays;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;




/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	   public void testRepetition() {
		      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		      ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		      ArrayList<String> array3 = new ArrayList<>(Arrays.asList("test"));
		      int e = 5;
		      assertTrue(new App().build(array, array2, array3, e).length()>1);
		    }

	    public void testNullResult() { //
		      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		      ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		      ArrayList<String> array3 = new ArrayList<>(Arrays.asList(""));
		      int e = 1;
		      assertTrue(new App().build(array, array2, array3, e).equals("null"));
	    }

	    public void testExpectedResult() { //
		      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		      ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		      ArrayList<String> array3 = new ArrayList<>(Arrays.asList("test"));
		      int e = 2;
		      assertTrue(new App().build(array, array2, array3, e).equals("setset"));
	    }

	    public void testEmptyArrays() {
		      ArrayList<Integer> array = new ArrayList<>();
		      ArrayList<Integer> array2 = new ArrayList<>();
		      ArrayList<String> array3 = new ArrayList<>(Arrays.asList("test"));
		      int e = 2;
		      assertFalse(new App().build(array, array2, array3, e).length()>1);
	    }
	    public void testRandomness() { //
		      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		      ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		      ArrayList<String> array3 = new ArrayList<>(Arrays.asList("ab", "cd", "ef"));
		      int e = 1;
		      StringBuilder sb = new App().build(array, array2, array3, e);
		      assertTrue(sb.equals("b")||sb.equals("d")||sb.equals("f"));
	    }
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
}
