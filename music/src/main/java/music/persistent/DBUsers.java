package music.persistent;

import music.model.*;
import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBUsers extends DBAbstract<User> {
    private final static Properties PROPERTIES = new Config().loadProp("user.properties");
    private final BasicDataSource dataSource = FactoryDao.getInstance().getDataSource();

    @Override
    public boolean add(User user) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(PROPERTIES.getProperty("add"));) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getLastName());
            statement.setInt(5, user.getAge());
            statement.setInt(6, user.getRoleId());
            statement.setInt(7, user.getAddressId());
            statement.setInt(8, user.getMusicTypeId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public User getById(int id) {
        User user = new User();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(PROPERTIES.getProperty("findbyid"));) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                user.setName(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setFirstName(rs.getString(4));
                user.setLastName(rs.getString(5));
                user.setAge(rs.getInt(6));
                user.setRoleId(rs.getInt(7));
                user.setAddressId(rs.getInt(8));
                user.setMusicTypeId(rs.getInt(9));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User update(User user) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(PROPERTIES.getProperty("update"));) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getLastName());
            statement.setInt(5, user.getAge());
            statement.setInt(6, user.getRoleId());
            statement.setInt(7, user.getAddressId());
            statement.setInt(8, user.getMusicTypeId());
            statement.setInt(9, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    @Override
    public boolean delete(int id) {
        return super.delete(id, PROPERTIES.getProperty("delete"));
    }

    @Override
    public List<User> findAll() {
        ArrayList<User> result = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(PROPERTIES.getProperty("findall"));
             ResultSet rs = statement.executeQuery();) {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setFirstName(rs.getString(4));
                user.setLastName(rs.getString(5));
                user.setAge(rs.getInt(6));
                user.setRoleId(rs.getInt(7));
                user.setAddressId(rs.getInt(8));
                user.setMusicTypeId(rs.getInt(9));
                result.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<User> findUser(Address address, Role role, MusicType musicType) {
        ArrayList<User> result = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(PROPERTIES.getProperty("findbyparam"));) {
            statement.setString(1, address.getCountry());
            statement.setString(2, address.getCity());
            statement.setString(3, musicType.getName());
            statement.setString(4, role.getName());
            try (ResultSet rs = statement.executeQuery();) {
                while (rs.next()) {
                    User user = new User();
                    user.setName(rs.getString(1));
                    user.setFirstName(rs.getString(2));
                    user.setLastName(rs.getString(3));
                    user.setAge(rs.getInt(4));
                    result.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean isCredentional(String login, String password) {
        boolean exist = false;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(PROPERTIES.getProperty("iscredentional"));) {
            statement.setString(1, login);
            try (ResultSet rs = statement.executeQuery();) {
                rs.next();
                if (rs.getString(1).equals(password)) {
                    exist = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exist;
    }

    public User findByLogin(String login) {
        User user = new User();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(PROPERTIES.getProperty("findbylogin"));) {
                statement.setString(1, login);
                try (ResultSet rs = statement.executeQuery();) {
                    while (rs.next()) {
                        user.setId(rs.getInt(1));
                        user.setPassword(rs.getString(3));
                        user.setFirstName(rs.getString(4));
                        user.setLastName(rs.getString(5));
                        user.setAge(rs.getInt(6));
                        user.setRoleId(rs.getInt(7));
                        user.setAddressId(rs.getInt(8));
                        user.setMusicTypeId(rs.getInt(9));
                    }
                }
            } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}