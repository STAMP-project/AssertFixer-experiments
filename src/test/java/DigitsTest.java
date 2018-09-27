import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Nasibulin
 * Date: 27.09.18
 * Time: 16:58
 * To change this template use File | Settings | File Templates.
 */
public class DigitsTest {
    @Test
    public void testMain() throws Exception {
    assertEquals("  ***   *****   ***    ***    ***    ***     *     ***  "+"\n"+" *   *  *   *  *   *  *   *  *   *  *   *   **    *   * "+"\n"+"     *      *  *  **  *   *      *  *  **    *    *   * "+"\n"+"    *       *  * * *  *   *     *   * * *    *     ***  "+"\n"+"   *       *   **  *   ****    *    **  *    *    *   * "+"\n"+"  *        *   *   *      *   *     *   *    *    *   * "+"\n"+" *        *    *   *     *   *      *   *    *    *   * "+"\n"+" *****    *     ***    **    *****   ***     *     ***  "+"\n",Digits.main("27092018"));
    }
}
