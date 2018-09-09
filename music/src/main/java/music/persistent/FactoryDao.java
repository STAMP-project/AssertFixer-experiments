package music.persistent;

import org.apache.commons.dbcp.BasicDataSource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class FactoryDao {
    private static BasicDataSource dataSource;
    private static final FactoryDao INSTANCE = new FactoryDao();

    private FactoryDao() {
        if (INSTANCE != null) {
            throw new IllegalStateException("Already instantiated");
        }
        getDataSource();
    }

    public static FactoryDao getInstance() {
        return INSTANCE;
    }

    public BasicDataSource getDataSource() {
        if (dataSource == null) {
            BasicDataSource ds = new BasicDataSource();
            ds.setUrl("jdbc:mysql://localhost:3306/music");
            ds.setUsername("root");
            ds.setPassword("root");
            ds.setMinIdle(5);
            ds.setMaxIdle(10);
            ds.setMaxOpenPreparedStatements(100);
            dataSource = ds;
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            init();
        }
        return dataSource;
    }

    private void init() {
        Properties prop = new Properties();
        String propFileName = "mysql.properties";
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName)) {
            prop.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(prop.getProperty("createusers"));
            statement.execute(prop.getProperty("createroles"));
            statement.execute(prop.getProperty("createaddress"));
            statement.execute(prop.getProperty("createmusictype"));
            statement.execute(prop.getProperty("insertroleone"));
            statement.execute(prop.getProperty("insertroletwo"));
            statement.execute(prop.getProperty("insertrolethree"));
            statement.execute(prop.getProperty("inserttypeone"));
            statement.execute(prop.getProperty("inserttypetwo"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
