package music.persistent;

import music.model.Entity;
import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DBAbstract<T extends Entity> implements StoreDAO<T> {
    private final BasicDataSource dataSource =  FactoryDao.getInstance().getDataSource();

    public boolean delete(int id, String query) {
        boolean current = false;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);) {
            statement.setInt(1, id);
            if (statement.executeUpdate() >= 1) {
                current = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return current;
    }

    public T update(T t, String prop) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(prop);) {
            statement.setString(1, t.getName());
            statement.setInt(2, t.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }

    public T getById(int id, String prop, T t) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(prop);) {
            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery();) {
                while (rs.next()) {
                    String musicName = rs.getString(2);
                    t.setName(musicName);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }

    public int findByName(String name, String prop) {
        int id = 0;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(prop);) {
            statement.setString(1, name);
            try (ResultSet rs = statement.executeQuery();) {
                rs.next();
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
