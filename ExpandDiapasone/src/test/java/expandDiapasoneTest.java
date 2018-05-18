import org.junit.Test;

import static org.junit.Assert.*;

public class expandDiapasoneTest {

    @Test
    public void expand() throws Exception{
        expandDiapasone testString = new expandDiapasone();
        String result = testString.expand("1-6");
        assertEquals("1,2,3,4,5,6", result);
    }
}