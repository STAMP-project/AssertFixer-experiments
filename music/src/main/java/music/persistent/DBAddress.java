package music.persistent;

import music.model.Address;
import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBAddress extends DBAbstract<Address> implements StoreDAO<Address>, AutoCloseable {
    private final static Properties PROPERTIES = new Config().loadProp("address.properties");
    private final BasicDataSource dataSource = FactoryDao.getInstance().getDataSource();

    @Override
    public boolean add(Address address) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(PROPERTIES.getProperty("add"));) {
            statement.setString(1, address.getCountry());
            statement.setString(2, address.getCity());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Address getById(int id) {
        Address address = new Address();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(PROPERTIES.getProperty("findbyid"));) {
            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery();) {
                while (rs.next()) {
                    String country = rs.getString(2);
                    String city = rs.getString(3);
                    address.setCountry(country);
                    address.setCity(city);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }

    @Override
    public Address update(Address address) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(PROPERTIES.getProperty("update"));) {
            statement.setString(1, address.getCountry());
            statement.setString(5, address.getCity());
            statement.setInt(3, address.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }

    @Override
    public boolean delete(int id) {
        return super.delete(id, PROPERTIES.getProperty("delete"));
    }

    @Override
    public List<Address> findAll() {
        ArrayList<Address> result = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(PROPERTIES.getProperty("findall"));
             ResultSet rs = statement.executeQuery();) {
            while (rs.next()) {
                Address address = new Address();
                address.setCountry(rs.getString(2));
                address.setCity(rs.getString(3));
                result.add(address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int findByParam(String country, String city) {
        int res = 0;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(PROPERTIES.getProperty("findbyparam"));) {
                statement.setString(1, country);
                statement.setString(2, city);
                try (ResultSet rs = statement.executeQuery();) {
                    while (rs.next()) {
                        res = rs.getInt(1);
                    }
                }
            } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public void close() throws Exception {
            }
}
