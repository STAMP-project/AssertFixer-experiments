package persistent;

import model.*;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CarStorageTest {
    private final CarStorage carStorage = CarStorage.getInstance();

    @Test
    public void testFindAllDone() {
        Advertisement advertisement = new Advertisement();
        advertisement.setSell(true);
        this.carStorage.add(advertisement, null);
        assertTrue(this.carStorage.findAllDone().contains(advertisement));
    }

    @Test
    public void testAdd() {
        Advertisement advertisement = new Advertisement();
        this.carStorage.add(advertisement, null);
        assertTrue(this.carStorage.findAll().contains(advertisement));
    }

    @Test
    public void testShowWithPhoto() {
        Advertisement advertisement1 = new Advertisement();
        Advertisement advertisement2 = new Advertisement();
        Photo photo = new Photo();
        photo.setName("1.jpg");
        advertisement2.setPhoto(photo);
        advertisement1 = this.carStorage.add(advertisement1, null);
        advertisement2 = this.carStorage.add(advertisement2, photo);
        assertFalse(this.carStorage.showWithPhoto().contains(advertisement1));
        assertTrue(this.carStorage.showWithPhoto().contains(advertisement2));
    }

    @Test
    public void testShowByBrand() {
        Advertisement advertisement = new Advertisement();
        Brand brand = new Brand();
        brand.setName("audi");
        advertisement.setBrand(brand);
        carStorage.add(advertisement, null);
        assertTrue(this.carStorage.showByBrand("audi").contains(advertisement));
        assertFalse(this.carStorage.showByBrand("bmw").contains(advertisement));
    }

    @Test
    public void testUpdate() {
        Advertisement advertisement = new Advertisement();
        advertisement.setSell(true);
        carStorage.add(advertisement, null);
        assertThat(false, is(this.carStorage.update(1).getSell()));
    }

    @Test
    public void testIsCredential() {
        Login login = new Login();
        login.setPassword("123");
        login.setName("admin");
        Advertisement advertisement = new Advertisement();
        advertisement.setLogin(login);
        assertFalse(this.carStorage.isCredentional("user", "123"));
    }
}
