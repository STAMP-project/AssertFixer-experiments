import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created with IntelliJ IDEA.
 * User: Nasibulin
 * Date: 27.09.18
 * Time: 9:22
 * To change this template use File | Settings | File Templates.
 */
public class CollatzTest {
    @Test
    public void testMaxCollatz() throws Exception {
    assertEquals(837799,Collatz.MaxCollatz(1000000));
    }

}
