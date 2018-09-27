import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created with IntelliJ IDEA.
 * User: Nasibulin
 * Date: 27.09.18
 * Time: 10:22
 * To change this template use File | Settings | File Templates.
 */
public class ProgramTest {
    @Test
    public void testSqrt() throws Exception {
    assertEquals(100.0,Program.sqrt(10000.0,0.0000001),0.0000001);
    }
}
