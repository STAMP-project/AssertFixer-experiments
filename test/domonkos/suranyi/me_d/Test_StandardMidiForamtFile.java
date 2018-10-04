package domonkos.suranyi.me_d;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class Test_StandardMidiForamtFile {

    @Test
    public void test_getForamt() throws IOException {
        StandardMidiFormatFile smf = new StandardMidiFormatFile("test_resource/csendvan.mid");
        assertEquals(MidiFormat.FORMAT_1, smf.getFormat());
    }

}
