package domonkos.suranyi.me_d;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class Test_Utility {

    @Rule
    public ExpectedException ex = ExpectedException.none();

    @Test
    public void test_intArrayToInt() {
        assertEquals(0x012345, Utility.intArrayToInt(new byte[] {0x01, 0x23, 0x45}));
        assertEquals(0x00, Utility.intArrayToInt(new byte[] {0x00}));
        assertEquals(0x00, Utility.intArrayToInt(new byte[] {0x00, 0x00, 0x00, 0x00}));
        assertEquals(0x01, Utility.intArrayToInt(new byte[] {0x00, 0x00, 0x00, 0x00, 0x00, 0x01}));
        assertNotEquals(0xF0_00_00_00_00L, Utility.intArrayToInt(new byte[] {(byte) 0xF0, 0x00, 0x00, 0x00, 0x00, 0x00}));
    }

    @Test
    public void test_getInt() {
        assertEquals(0x012345, Utility.getInt(new byte[] {0x01, 0x23, 0x45}, 0, 3));
        assertEquals(0x012345, Utility.getInt(new byte[] {(byte) 0xFF, (byte) 0xFF, 0x00, 0x01, 0x23, 0x45}, 2, 4));
        assertEquals(0x00, Utility.getInt(new byte[] {(byte) 0xFF, (byte) 0xFF, 0x00, 0x01, 0x23, 0x45}, 2, 1));
        assertEquals(0x00, Utility.getInt(new byte[] {}, 0, 0));
    }

    @Test
    public void test_getInt_too_long() {
        ex.expect(IllegalArgumentException.class);
        Utility.getInt(new byte[] {0x01, 0x23, 0x45}, 0, 5);
    }
    
    @Test
    public void test_getInt_negative_length() {
        ex.expect(IllegalArgumentException.class);
        Utility.getInt(new byte[] {0x01, 0x23, 0x45}, 0, -1);
    }

}
