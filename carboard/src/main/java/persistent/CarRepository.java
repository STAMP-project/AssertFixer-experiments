package persistent;

import model.Photo;

import java.util.List;
import java.util.Optional;

public interface CarRepository<Advertisement> {
    List<Advertisement> findAll();
    List<Advertisement> findAllDone();
    Advertisement add(Advertisement advertisement, Photo photo);
    List<Advertisement> showByDate();
    List<Advertisement> showWithPhoto();
    List<Advertisement> showByBrand(String brand);
}
