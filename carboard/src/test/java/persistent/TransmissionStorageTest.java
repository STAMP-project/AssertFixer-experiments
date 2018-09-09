package persistent;

import model.Transmission;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransmissionStorageTest {
    private final TransmissionStorage transmissionStorage = TransmissionStorage.getInstance();

    @Test
    public void testFind() {
        Transmission transmission = new Transmission();
        transmission.setName("admin");
        transmission = this.transmissionStorage.add(transmission);
        assertThat(transmission, is(this.transmissionStorage.find(transmission.getName())));
    }
}
