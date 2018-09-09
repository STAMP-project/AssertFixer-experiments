package persistent;

import model.Brand;
import model.HibernateUtil;
import model.Transmission;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.transaction.Transactional;
import java.util.List;

public class TransmissionStorage {
    private final Session session = HibernateUtil.getInstance().openSession();
    private static final TransmissionStorage ITEM_STORAGE = new TransmissionStorage();

    private TransmissionStorage() {
    }
    public static TransmissionStorage getInstance() {
        return ITEM_STORAGE;
    }

    @Transactional
    public Transmission find(String name) {
        List<Transmission> item;
        Query query = session.createQuery("from Transmission where name=:name");
        query.setParameter("name", name);
        item = query.list();
        return item.iterator().next();
    }

    @Transactional
    public Transmission add(Transmission transmission) {
        session.save(transmission);
        return transmission;
    }
}
