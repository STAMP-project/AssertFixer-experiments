import org.junit.Test;

import static org.junit.Assert.*;

public class SqrtTest {

    @Test
    public void main() {
        Sqrt sqrt1 = new Sqrt(9, 0.01);
        assertEquals(3, sqrt1.calc(),0.01);
    }
}