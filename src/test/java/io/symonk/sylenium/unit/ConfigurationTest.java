package io.symonk.sylenium.unit;

import io.symonk.sylenium.SyConfig;
import org.testng.annotations.Test;

import static io.symonk.sylenium.SyConfig.rebuildConfiguration;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * $ylenium configuration unit tests
 * @NotThreadSafe -> run these tests on a single thread to avoid failure(s)
 */
public class ConfigurationTest {

    @Test
    public void $waitOverrideIsCorrect() {
        System.setProperty("sylenium.wait", "100000");
        rebuildConfiguration();
        assertThat(SyConfig.$wait).isEqualTo(100000);
    }

    @Test
    public void $pollOverrideIsCorrect() {
        System.setProperty("sylenium.poll", "19999");
        rebuildConfiguration();
        assertThat(SyConfig.$poll).isEqualTo(19999);
    }

    @Test
    public void $waitDefaultIsCorrect() {
        assertThat(SyConfig.$wait).isEqualTo(5000);
    }

    @Test
    public void $pollDefaultIsCorrect() {
        assertThat(SyConfig.$poll).isEqualTo(100);
    }


}
