package persistent;

import model.HibernateUtil;
import model.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;
import java.util.function.Function;

public class ItemStorage implements ItemRepository<Item> {

    private static final ItemStorage ITEM_STORAGE = new ItemStorage();
    private ItemStorage() {
    }

    public static ItemStorage getInstance() {
        return ITEM_STORAGE;
    }

    private <T> T tx(final Function<Session, T> command) {
        final Session session = HibernateUtil.getInstance().openSession();
        final Transaction tx = session.beginTransaction();
        try {
            return command.apply(session);
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public List<Item> findAll() {
        return this.tx(
                session -> session.createQuery("from Item").list());
    }

    @Override
    public List<Item> findAllDone() {
        return this.tx(
                session -> {
                    Query query = session.createQuery("from Item where done=:done");
                    query.setParameter("done", true);
                   return query.list();

                }
        );
    }

    @Override
    public Item save(Item item) {
        return this.tx(session -> {
                session.save(item);
                return item;
        });
    }
}
