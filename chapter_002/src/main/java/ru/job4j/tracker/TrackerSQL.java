package ru.job4j.tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrackerSQL extends Tracker {
    private static final Logger LOG = LoggerFactory.getLogger(TrackerSQL.class);
    private final ConfigReader config;
    //  private Connection conn = null;
    private String url;
    private String user;
    private String password;

    public TrackerSQL(final ConfigReader config) {
        this.config = config;
        startUp();
    }

    @Override
    public Item add(Item item) {
        item.setId(this.generateId());
        int tempId = -1;
        try (Connection conn = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword())) {
            PreparedStatement st = conn.prepareStatement(
                    "INSERT into item_table( item_name, description, date_field) VALUES (?, ?, current_timestamp);",
                    Statement.RETURN_GENERATED_KEYS);
            st.setString(1, item.getName());
            st.setString(2, item.getDesc());
            st.execute();
            ResultSet key = st.getGeneratedKeys();
            key.next();
            tempId = key.getInt(1);
            PreparedStatement stComments;
            if (item.getComments() != null) {
                for (String string : item.getComments()) {
                    stComments = conn.prepareStatement(
                            "INSERT INTO comments_table (comment_field, item_id) values (?, ?);");
                    stComments.setString(1, string);
                    stComments.setInt(2, tempId);
                    stComments.execute();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            LOG.error(e.getMessage(), e);
        }
        return item;
    }

    @Override
    protected Item findById(String id) {
        ArrayList<String> comments = new ArrayList<String>();
        Item item = new Item();
        ResultSet queryComments = null;
        ResultSet queryItem = null;

        try (Connection conn = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword())) {

            try (PreparedStatement st = conn.prepareStatement("select * from item_table where id =?")) {
                st.setInt(1, Integer.valueOf(id));
                queryItem = st.executeQuery();
                queryItem.next();
                item = makeItemFromQuery(queryItem);
                PreparedStatement st1 = conn.prepareStatement("select comment_field from comments_table where item_id =?");
                st1.setInt(1, Integer.valueOf(id));
                queryComments = st1.executeQuery();

                while (queryComments.next()) {
                    comments.add(queryComments.getString(1));
                }
                item.setComments(comments);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            LOG.error(e.getMessage(), e);
        }

        return item;
    }


    @Override
    public List<Item> getAll() {
        List<Item> result = new ArrayList<>();
        ResultSet queryResult = null;
        Item item;
        int tempId;
        try (Connection conn = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword())) {
            Statement st = conn.createStatement();
            queryResult = st.executeQuery("select * from item_table;");
            while (queryResult.next()) {
                result.add(makeItemFromQuery(queryResult));
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        Item item = new Item();
        ArrayList<String> comments = new ArrayList<String>();
        ResultSet itemQueryResult = null;
        ResultSet commentQueryResult = null;
        try (Connection conn = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword())) {
            PreparedStatement st = conn.prepareStatement("select * from item_table where item_name = ?");
            st.setString(1, key);
            itemQueryResult = st.executeQuery();
            while (itemQueryResult.next()) {
                result.add(makeItemFromQuery(itemQueryResult));
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public void replace(String id, Item item) {


        try (Connection conn = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword())) {
            PreparedStatement st = conn.prepareStatement(
                    "update item_table * set item_name =?, description=?, date_field=? where id = ?");
            st.setString(1, item.getName());
            st.setString(2, item.getDesc());
            st.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            st.setInt(4, Integer.valueOf(id));
            st.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            LOG.error(e.getMessage(), e);
        }
    }

    @Override
    public void delete(String id) {
        try (Connection conn = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword())) {
            PreparedStatement st = conn.prepareStatement("delete  from comments_table where item_id =?");
            st.setInt(1, Integer.valueOf(id));
            st.execute();
            PreparedStatement st1 = conn.prepareStatement("delete  from item_table where id =?");

            st1.setInt(1, Integer.valueOf(id));
            st1.execute();

        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    private Item makeItemFromQuery(ResultSet queryResult) {
        Item item = new Item();
        try {
            item.setId(String.valueOf(queryResult.getInt(1)));
            item.setName(queryResult.getString(2));
            item.setDesc(queryResult.getString(3));
            item.setCreated(queryResult.getTimestamp(4).getTime());
        } catch (SQLException e) {
            e.printStackTrace();
            LOG.error(e.getMessage(), e);
        }
        return item;
    }


    private void readConfig() {
        url = config.getUrl();
        user = config.getUser();
        password = config.getPassword();
    }


    private void startUp() {
        if (!isDBExist()) {
            createTable();
        }
    }

    private void createTable() {
        Statement statement = null;
        try (Connection conn = DriverManager.getConnection(config.getUrlDb(), config.getUser(), config.getPassword())) {
            statement = conn.createStatement();
            statement.executeUpdate(DefaultConfig.getInstance().mainDB);
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        try (Connection conn = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword())) {
            statement = conn.createStatement();
            statement.executeUpdate(DefaultConfig.getInstance().mainTable);
            statement = conn.createStatement();
            statement.executeUpdate(DefaultConfig.getInstance().commentsDB);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isDBExist() {
        boolean result = false;
        String databaseName;
        try (Connection conn = DriverManager.getConnection(config.getUrlDb(), config.getUser(), config.getPassword())) {
            ResultSet resultSet = conn.getMetaData().getCatalogs();
            while (resultSet.next()) {
                // Get the database name
                databaseName = resultSet.getString(1);
                if (databaseName.equals("items")) {
                    result = true;
                }
            }
            resultSet.close();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }


}
