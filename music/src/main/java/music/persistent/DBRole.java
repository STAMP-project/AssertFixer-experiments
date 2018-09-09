package music.persistent;

import music.model.Role;
import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBRole extends DBAbstract<Role> {
    private final static Properties PROPERTIES = new Config().loadProp("role.properties");
    private final BasicDataSource dataSource = FactoryDao.getInstance().getDataSource();

    @Override
    public boolean add(Role role) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(PROPERTIES.getProperty("add"));) {
            statement.setString(1, role.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Role getById(int id) {
        Role role = new Role();
        return super.getById(id, PROPERTIES.getProperty("findbyid"), role);
    }

    @Override
    public Role update(Role role) {
        return super.update(role, PROPERTIES.getProperty("update"));
    }

    @Override
    public boolean delete(int id) {
        return super.delete(id, PROPERTIES.getProperty("delete"));
    }

    @Override
    public List<Role> findAll() {
        ArrayList<Role> result = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(PROPERTIES.getProperty("findall"));
             ResultSet rs = statement.executeQuery();) {
            while (rs.next()) {
                Role role = new Role();
                role.setName(rs.getString(2));
                result.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int findByName(String name) {
        return super.findByName(name, PROPERTIES.getProperty("findbyname"));
    }
}
