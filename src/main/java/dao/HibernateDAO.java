package dao;

import java.io.Serializable;

import model.Model;

public interface HibernateDAO {

    public void guardar(Model unElementoGuardable);

    public <T> T recuperarEntidad(Class<T> tipo, Serializable key);
}