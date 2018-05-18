import org.junit.Test;

import static org.junit.Assert.*;

public class minimizeDiapasoneTest {

    @Test
    public void minimize() {
        minimizeDiapasone testString = new minimizeDiapasone();
        String result = testString.minimize("10,11,12,13,14");
        assertEquals("10-14", result);
    }
}