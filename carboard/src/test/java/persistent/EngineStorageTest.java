package persistent;

import model.Engine;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class EngineStorageTest {
    private final EngineStorage engineStorage = EngineStorage.getInstance();

    @Test
    public void testFind() {
        Engine engine = new Engine();
        engine.setName("robot");
        engine = this.engineStorage.add(engine);
        assertThat(engine, is(this.engineStorage.find(engine.getName())));
    }
}
