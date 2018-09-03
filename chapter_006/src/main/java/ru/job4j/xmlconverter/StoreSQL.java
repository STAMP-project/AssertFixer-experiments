package ru.job4j.xmlconverter;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StoreSQL {
    //private Connection connection;
    Config config;

    public void setUp() {
        try (Connection connection = DriverManager.getConnection(config.getUrl(), config.getUser(),
                config.getPassword())) {
            System.out.println("Connecting to 'Entries' DB...OK.");
            if (this.isRowsExist()) {
                this.eraseAllRows();
            }
            this.createEntry();
        } catch (SQLException e) {
            System.out.println("Connection failed. DB might haven't been created...");
            e.printStackTrace();
            try (Connection connection = DriverManager.getConnection(config.getUrlToCreateNewDb(), config.getUser(),
                    config.getPassword())) {
                System.out.println("Connecting to root DB server...OK.");
                this.createTable();
            } catch (SQLException e1) {
                System.out.println("Connecting failed.");
                e1.printStackTrace();
            }
        }
    }

    private void eraseAllRows() {
        PreparedStatement st = null;
        try (Connection connection = DriverManager.getConnection(config.getUrl(), config.getUser(),
                config.getPassword())) {
            st = connection.prepareStatement("DELETE FROM entry;");
            st.execute();
        } catch (SQLException e) {
            System.out.println("Unable to delete rows.");
            e.printStackTrace();
        }
    }

    public StoreSQL(Config config) {
        this.config = config;
    }

    public void generate(int n) {
        for (int i = 0; i < n; i++) {
            try (Connection connection = DriverManager.getConnection(config.getUrl(), config.getUser(),
                    config.getPassword())) {
                PreparedStatement st = connection.prepareStatement("INSERT into entry (field) VALUES (?)");
                st.setInt(1, (i));
                st.execute();
                System.out.println(String.format("Field %d has been inserted in DB", i));
            } catch (SQLException e) {
                System.out.println("Unable to insert field in DB.");
                e.printStackTrace();
            }
        }
    }

    private void createTable() {
        Statement statement = null;
        try (Connection connection = DriverManager.getConnection(config.getUrl(), config.getUser(),
                config.getPassword())) {
            statement = connection.createStatement();
            statement.executeUpdate(config.getdBCreateScript());
            System.out.println("Database 'entries' has been successfully created.");
            statement = connection.createStatement();
            statement.executeUpdate(config.getCreateTableScript());
            System.out.println("Table 'entry' has been successfully created.");
        } catch (SQLException e) {
            System.out.println("Unable to create Database.");
            e.printStackTrace();

        }
    }

    /**
     * This method creates table if Db connection OK(for SQLite)
     */
    private void createEntry() {
        Statement statement = null;
        try (Connection connection = DriverManager.getConnection(config.getUrl(), config.getUser(),
                config.getPassword())) {
            statement = connection.createStatement();
            statement.executeUpdate(config.getCreateTableScript());
            System.out.println("Table 'entry' has been successfully created.");
        } catch (SQLException e) {
            System.out.println("Unable to create table 'entry'.");
            e.printStackTrace();

        }
    }


    public List<Integer> get() {
        PreparedStatement st = null;
        ResultSet result;
        List<Integer> entry = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(config.getUrl(), config.getUser(),
                config.getPassword())) {
            System.out.println("Loading entry from DB...");
            st = connection.prepareStatement("SELECT field FROM entry;");
            result = st.executeQuery();
            System.out.println("Fields have been selected from DB");
            while (result.next()) {
                entry.add(result.getInt(1));
            }
            System.out.println("OK.");

        } catch (SQLException e) {
            System.out.println("Unable to load entry from DB...");
            e.printStackTrace();
        }
        return entry;
    }

    private boolean isRowsExist() {
        PreparedStatement st = null;
        ResultSet result;
        int count = 0;
        try (Connection connection = DriverManager.getConnection(config.getUrl(), config.getUser(),
                config.getPassword())) {
            st = connection.prepareStatement("SELECT COUNT(field) FROM entry;");
            result = st.executeQuery();
            result.next();
            count = result.getInt(1);
        } catch (SQLException e) {
            System.out.println("Unable to execute query.");
            e.printStackTrace();
        }
        return count > 0;
    }

}
