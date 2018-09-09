package persistent;

import model.Brand;
import model.CarBody;
import model.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import javax.transaction.Transactional;
import java.util.List;

public class CarBodyStorage {
    private final Session session = HibernateUtil.getInstance().openSession();
    private static final CarBodyStorage ITEM_STORAGE = new CarBodyStorage();

    private CarBodyStorage() {
    }
    public static CarBodyStorage getInstance() {
        return ITEM_STORAGE;
    }

    @Transactional
    public CarBody find(String name) {
        List<CarBody> item;
        Query query = session.createQuery("from CarBody where name=:name");
        query.setParameter("name", name);
        item = query.list();
        return item.iterator().next();
    }

    @Transactional
    public CarBody add(CarBody carBody) {
        session.save(carBody);
        return carBody;
    }
}
