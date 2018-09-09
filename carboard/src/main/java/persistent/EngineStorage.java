package persistent;

import model.Engine;
import model.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.transaction.Transactional;
import java.util.List;


public class EngineStorage {
    private final Session session = HibernateUtil.getInstance().openSession();
    private static final EngineStorage ITEM_STORAGE = new EngineStorage();

    private EngineStorage() {
    }
    public static EngineStorage getInstance() {
        return ITEM_STORAGE;
    }

    @Transactional
    public Engine find(String name) {
        List<Engine> item;
        Query query = session.createQuery("from Engine where name=:name");
        query.setParameter("name", name);
        item = query.list();
        return item.iterator().next();
    }

    @Transactional
    public Engine add(Engine engine) {
        session.save(engine);
        return engine;
    }
}
