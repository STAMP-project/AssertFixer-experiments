package domonkos.suranyi.me_d;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class Test_HeaderChunk {
    @Test
    public void test_ctor() {
        HeaderChunk hc = new HeaderChunk(new byte[] {0x00, 0x01, 0x00, 0x05, 0x01, (byte) 0xE0});
        assertEquals(1, hc.format);
        assertEquals(5, hc.numOfTrackChunks);
        assertEquals(480, hc.division);
    }

}
