import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class DrawNumbersTest {

    private final ByteArrayOutputStream outStream=new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outStream));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }

    @org.junit.Test
    public void main() throws Exception {
        DrawNumbers.main(new String[] {"123"});
        assertEquals("   *     ***    ***  \n" +
                     "  **    *   *      * \n" +
                     " * *    *  *       * \n" +
                     "   *      *     ***  \n" +
                     "   *     *         * \n" +
                     "   *    *          * \n" +
                     " *****  *****   ***  \n", outStream.toString());
    }
}
