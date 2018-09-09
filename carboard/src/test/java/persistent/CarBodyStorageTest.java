package persistent;

import model.Brand;
import model.CarBody;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CarBodyStorageTest {
    private final CarBodyStorage carBodyStorage = CarBodyStorage.getInstance();

    @Test
    public void testFind() {
        CarBody carBody = new CarBody();
        carBody.setName("sedan");
        carBody = this.carBodyStorage.add(carBody);
        assertThat(carBody, is(this.carBodyStorage.find(carBody.getName())));
    }
}
