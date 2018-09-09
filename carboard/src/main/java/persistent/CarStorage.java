package persistent;

import javax.transaction.Transactional;
import model.*;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarStorage implements CarRepository<Advertisement> {
    private final Session session = HibernateUtil.getInstance().openSession();
    private static final CarStorage ITEM_STORAGE = new CarStorage();

    private CarStorage() {
    }
    public static CarStorage getInstance() {
        return ITEM_STORAGE;
    }

    @Transactional
    @Override
    public List<Advertisement> findAll() {
        List<Advertisement> item;
        item = session.createQuery("from Advertisement").list();
        return item;
    }

       @Transactional
    public List<CarBody> findCarBody() {
        List<CarBody> item;
        item = session.createQuery("from CarBody ").list();
        return item;
    }

    @Transactional
    public List<Transmission> findTransmission() {
        List<Transmission> item;
        item = session.createQuery("from Transmission ").list();
        return item;
    }

    @Transactional
    public List<Engine> findEngine() {
        List<Engine> item;
        item = session.createQuery("from Engine ").list();
        return item;
    }

    @Transactional
    public List<Brand> findBrand() {
        List<Brand> item;
        item = session.createQuery("from Brand ").list();
        return item;
    }

    @Transactional
    @Override
    public List<Advertisement> findAllDone() {
        List<Advertisement> item;
        Query query = session.createQuery("from Advertisement where sell=:sell");
        query.setParameter("sell", true);
        item = query.list();
        return item;
    }

    @Transactional
    @Override
    public Advertisement add(Advertisement advertisement, Photo photo) {
        if (photo != null) {
            session.save(photo);
        }
        session.save(advertisement);
        return advertisement;
    }

    @Transactional
    @Override
    public List<Advertisement> showByDate() {
        List<Advertisement> item;
        List<Advertisement> res = new ArrayList<>();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String test = String.valueOf(timestamp);
        test = test.substring(0, 10);
        item = session.createQuery("from Advertisement").list();
        for (Advertisement i: item) {
            if (String.valueOf(i.getCreatedAt()).contains(test)) {
                res.add(i);
            }
        }
        return res;
    }

    @Transactional
    @Override
    public List<Advertisement> showWithPhoto() {
        List<Advertisement> item;
        Query query = session.createQuery("from Advertisement where photo is not null ");
        item = query.list();
        return item;
    }

    @Transactional
    @Override
    public List<Advertisement> showByBrand(String brand) {
        List<Advertisement> res;
        Query query = session.createQuery("select ad from Advertisement ad left join Brand b on ad.brand.id = b.id where b.name=:name", Advertisement.class);
        query.setParameter("name", brand);
        res = query.list();
        return res;
    }

    @Transactional
    public Advertisement update(int id) {
        Advertisement advertisement = (Advertisement) session.get(Advertisement.class, id);
        advertisement.setSell(!advertisement.getSell());

        session.update(advertisement);
        return advertisement;
    }

    @Transactional
    public boolean isCredentional(String login, String password) {
        List<Login> item;
        boolean exist = false;
        Query query = session.createQuery("from Login where name=:name", Login.class);
        query.setParameter("name", login);
        item = query.list();
        if (item.size() > 0) {
            if (item.iterator().next().getPassword().equals(password)) {
                exist = true;
            }
        }
        return exist;
    }
}
