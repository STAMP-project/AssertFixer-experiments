import org.junit.Test;

import static org.junit.Assert.*;

public class CollatzTest {

    @org.junit.Test
    public void collatzCalculation() throws Exception {
        assertEquals(324, Collatz.CollatzCalculation(35655));
    }
}