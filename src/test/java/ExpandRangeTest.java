import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created with IntelliJ IDEA.
 * User: Nasibulin
 * Date: 27.09.18
 * Time: 11:05
 * To change this template use File | Settings | File Templates.
 */
public class ExpandRangeTest {
    @Test
    public void testExpandRange() throws Exception {
    assertEquals("1,2,3,4,5,6,7,8,9,10,11,12,14,17,19,20,21,22,23,25,26,30,35,41",ExpandRange.ExpandRange("1,2,3,4-12,14,17,19-23,25,26,30,35,41"));
    }
}
