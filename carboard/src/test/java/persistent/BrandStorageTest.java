package persistent;

import model.Brand;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BrandStorageTest {
    private final BrandStorage brandStorage = BrandStorage.getInstance();

    @Test
    public void testFind() {
        Brand brand = new Brand();
        brand.setName("KAMAZ");
        brand = this.brandStorage.add(brand);
        assertThat(brand, is(this.brandStorage.find(brand.getName())));
    }
}
