package music.persistent;

import music.model.MusicType;
import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBMusicType extends DBAbstract<MusicType> {
    private final static Properties PROPERTIES = new Config().loadProp("type.properties");
    private final BasicDataSource dataSource = FactoryDao.getInstance().getDataSource();

    @Override
    public boolean add(MusicType musicType) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(PROPERTIES.getProperty("add"));) {
            statement.setString(1, musicType.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public MusicType getById(int id) {
        MusicType musicType = new MusicType();
        return super.getById(id, PROPERTIES.getProperty("findbyid"), musicType);
    }

    @Override
    public MusicType update(MusicType musicType) {
        return super.update(musicType, PROPERTIES.getProperty("update"));
    }

    @Override
    public boolean delete(int id) {
        return super.delete(id, PROPERTIES.getProperty("delete"));
    }

    @Override
    public List<MusicType> findAll() {
        ArrayList<MusicType> result = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(PROPERTIES.getProperty("findall"));
             ResultSet rs = statement.executeQuery();) {
            while (rs.next()) {
                MusicType musicType = new MusicType();
                musicType.setName(rs.getString(2));
                result.add(musicType);
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
