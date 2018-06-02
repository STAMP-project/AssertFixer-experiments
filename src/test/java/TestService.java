import java.io.Serializable;

import dao.impl.HibernateUserDAO;
import model.User;
import org.hibernate.Session;
import arq.service.runner.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static arq.service.runner.Runner.*;

public class TestService {

    @Before
    public void prepare() {

        HibernateUserDAO userDAO = new HibernateUserDAO();

        this.crearEntidad(new User("Manuel", "Re", "manure", "mre@gmail.com", "1334", null));
    }

    @After
    public void cleanup() {
        //Destroy cierra la session factory y fuerza a que, la proxima vez, una nueva tenga
        //que ser creada.
        //
        //Al tener hibernate configurado con esto <property name="hibernate.hbm2ddl.auto">create-drop</property>
        //al crearse una nueva session factory todo el schema serÃ¡ destruido y creado desde cero.
        SessionFactoryProvider.destroy();
    }

    @Test
    public void test_obtenerDeLaBaseDeDatosUnUsuarioYaCargado() {

        runInSession(() -> {
            User manuel = this.recuperarEntidad(User.class, "manure");
            Assert.assertEquals("Manuel", manuel.getName());
            return null;
        });
    }


    public void crearEntidad(Object object) {
        Runner.runInSession(() -> {
            Session session = Runner.getCurrentSession();
            session.save(object);
            return null;
        });
    }

    public <T> T recuperarEntidad(Class<T> tipo, Serializable key) {
        return Runner.runInSession(() -> {
            Session session = Runner.getCurrentSession();
            T valor = session.get(tipo, key);
            return valor;
        });
    }

}

