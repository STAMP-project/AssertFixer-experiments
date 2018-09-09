package persistent;

import model.Advertisement;
import model.Brand;
import model.HibernateUtil;
import model.Photo;
import org.hibernate.Session;
import org.hibernate.query.Query;
import javax.transaction.Transactional;
import java.util.List;

public class BrandStorage {
    private final Session session = HibernateUtil.getInstance().openSession();
    private static final BrandStorage ITEM_STORAGE = new BrandStorage();

    private BrandStorage() {
    }
    public static BrandStorage getInstance() {
        return ITEM_STORAGE;
    }

    @Transactional
    public Brand find(String name) {
        List<Brand> item;
        Query query = session.createQuery("from Brand where name=:name");
        query.setParameter("name", name);
        item = query.list();
        return item.iterator().next();
    }

    @Transactional
    public Brand add(Brand brand) {
        session.save(brand);
        return brand;
    }
}
