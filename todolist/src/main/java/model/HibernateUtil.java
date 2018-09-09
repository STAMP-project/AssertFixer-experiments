package model;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;


public class HibernateUtil {
    private static final SessionFactory SESSION_FACTORY;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Item.class);

            SESSION_FACTORY = configuration
                    .configure()
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getInstance() {
        return SESSION_FACTORY;
    }
}