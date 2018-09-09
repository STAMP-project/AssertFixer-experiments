package persistent;

import model.Engine;
import model.HibernateUtil;
import model.Login;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.transaction.Transactional;
import java.util.List;

public class LoginStorage {
    private final Session session = HibernateUtil.getInstance().openSession();
    private static final LoginStorage ITEM_STORAGE = new LoginStorage();

    private LoginStorage() {
    }
    public static LoginStorage getInstance() {
        return ITEM_STORAGE;
    }

    @Transactional
    public Login find(String name) {
        List<Login> item;
        Query query = session.createQuery("from Login where name=:name");
        query.setParameter("name", name);
        item = query.list();
        return item.iterator().next();
    }

    @Transactional
    public Login add(Login login) {
        session.save(login);
        return login;
    }
}
