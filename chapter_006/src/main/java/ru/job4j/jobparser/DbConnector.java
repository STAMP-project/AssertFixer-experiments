package ru.job4j.jobparser;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class DbConnector {

    final static Logger LOG = Logger.getLogger(DbConnector.class);
    //private Connection connection;

    private Properties properties;

    public DbConnector(Properties properties) {
        this.properties = properties;
    }

    /**
     * @return true if connection is OK. For tests only
     */
    public boolean setUp() {
        boolean result = false;
        try (Connection connection = DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("user"),
                properties.getProperty("password"))) {
            LOG.info("Connecting to 'java_jobs' DB...");
            LOG.info("OK.");
            result = true;
        } catch (SQLException e) {
            LOG.error("Connection failed. DB might haven't been created...", e);
            try (Connection connection = DriverManager.getConnection(
                    properties.getProperty("urlToCreateNewDatabase"),
                    properties.getProperty("user"),
                    properties.getProperty("password"))) {
                LOG.info("Connecting to root DB server...");
                LOG.info("OK.");
                result = true;
                this.createTable();
            } catch (SQLException e1) {
                LOG.error("Connecting failed.", e);
            }
        }
        return result;
    }

    private void createTable() {
        Statement statement = null;
        try (Connection connection = DriverManager.getConnection(
                properties.getProperty("urlToCreateNewDatabase"),
                properties.getProperty("user"),
                properties.getProperty("password"))) {
            statement = connection.createStatement();
            statement.executeUpdate(properties.getProperty("DBCreateScript"));
            LOG.info("Database 'java_jobs' has been successfully created.");
            connection.close();
        } catch (SQLException e) {
            LOG.error("Unable to create Database.", e);
        }
        try (Connection connection = DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("user"),
                properties.getProperty("password"))) {
            statement = connection.createStatement();
            statement.executeUpdate(properties.getProperty("createTableScript"));
            LOG.info("Table 'java_job_vacancy' has been successfully created.");

        } catch (SQLException e) {
            LOG.error("Unable to create Database.", e);
        }
    }

    //todo refactor it Make query to find out if db is empty
    public List<String> checkDB() {
        List<String> result = new LinkedList<>();
        PreparedStatement statement;
        ResultSet queryResult = null;
        try (Connection connection = DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("user"),
                properties.getProperty("password"))) {
            statement = connection.prepareStatement("SELECT link FROM java_vacancy");
            queryResult = statement.executeQuery();
            while (queryResult.next()) {
                result.add(queryResult.getString(1));
            }
        } catch (SQLException e) {
            LOG.error("Unable to connect to DB.", e);
        }
        return result;
    }

    /**
     * contains extra query to DB
     * check if links exist
     * put whole list into db DB
     *
     * @param input
     */
    public void insertToDB(List<ParsedRow> input) {
        List<ParsedRow> list = getUniqueLinks(input);
        this.insert(list);
    }


    private void insert(List<ParsedRow> rowsToAdd) {

        PreparedStatement statement = null;
        if (!rowsToAdd.isEmpty()) {
            for (ParsedRow row : rowsToAdd) {
                try (Connection connection = DriverManager.getConnection(
                        properties.getProperty("url"),
                        properties.getProperty("user"),
                        properties.getProperty("password"))) {
                    statement = connection.prepareStatement(
                            "INSERT INTO java_vacancy (topic_name, link, date_creation) values(?, ?, ?);");
                    statement.setString(1, row.getTitle());
                    statement.setString(2, row.getUrl());
                    statement.setDate(3, new Date(row.getDate()));
                    statement.execute();
                    LOG.info(String.format("Vacancy %s... has been added to DB", row.getTitle().substring(0, 19)));
                } catch (SQLException e) {
                    LOG.error("Unable to insert vacancy to DB", e);
                }
            }
        }
    }

    private List<ParsedRow> getUniqueLinks(List<ParsedRow> selectedRows) {
        List<String> existingLinks = new ArrayList<>();
        List<ParsedRow> result = new LinkedList<>();
        existingLinks.addAll(checkDB());
        for (ParsedRow row : selectedRows) {
            if (!existingLinks.contains(row.getUrl())) {
                result.add(row);
            }
        }
        return result;
    }

    public ParsedRow getLastRow() {
        PreparedStatement statement;
        ParsedRow row = new ParsedRow("blank", "blank", 0);
        ResultSet queryResult = null;
        try (Connection connection = DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("user"),
                properties.getProperty("password"))) {
            statement = connection.prepareStatement("SELECT * FROM java_vacancy  ORDER BY id DESC LIMIT 1;");
            queryResult = statement.executeQuery();
            queryResult.next();
            row = new ParsedRow(
                    queryResult.getString(2),
                    queryResult.getString(3),
                    queryResult.getDate(4).getTime()
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }
}
