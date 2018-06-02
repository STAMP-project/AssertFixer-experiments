package dao.impl;

import arq.service.runner.Runner;
import dao.HibernateDAO;
import model.Model;
import org.hibernate.Session;

import java.io.Serializable;

public abstract class HibernateModelDAO implements HibernateDAO {

    @Override
    public void guardar(Model guardable) {
        Runner.runInSession(() -> {
            Session session = Runner.getCurrentSession();
            session.save(guardable);
            return null;
        });

    }

    @Override
    public <T> T recuperarEntidad(Class<T> tipo, Serializable key) {
        return Runner.runInSession(() -> {
            Session session = Runner.getCurrentSession();
            T valor = session.get(tipo, key);
            return valor;
        });
    }

}
