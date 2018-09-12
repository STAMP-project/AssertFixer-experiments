package com.weaverplatform.postgresql.database;

import static com.weaverplatform.postgresql.util.WeaverError.DATABASE_CONNECTION;
import static com.weaverplatform.postgresql.util.WeaverError.DATABASE_NOT_PROVIDED;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbcp2.BasicDataSource;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.internal.dbsupport.FlywaySqlException;
import org.postgresql.core.Utils;
import org.postgresql.util.PSQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.weaverplatform.postgresql.controllers.DatabaseController;
import com.weaverplatform.postgresql.util.Props;
import com.weaverplatform.postgresql.util.WeaverError;

/**
 * @author Mohamad Alamili
 */
public enum Postgres {
  INSTANCE;

  private static Logger log = LoggerFactory.getLogger(Postgres.class);

  public static final String POSTGRES_HOST, POSTGRES_USER, POSTGRES_PASS;

  private final Map<String, BasicDataSource> connectionPool;

  static {
    POSTGRES_HOST = Props.get("POSTGRES_HOST", "postgres.host");
    POSTGRES_USER = Props.get("POSTGRES_USER", "postgres.user");
    POSTGRES_PASS = Props.get("POSTGRES_PASS", "postgres.pass");
  }

  Postgres() {
    connectionPool = new HashMap<>();
  }

  /**
   * Tries to setup a basic connection to the backend database server. A basic
   * connection is nothing more than a connection without selecting a database.
   * Using such connection makes it possible to execute CREATE DATABASE and DROP
   * DATABASE queries.
   *
   * @return a basic connection
   * @throws SQLException
   *           when no connection to the postgres server could be setup.
   */
  public Connection getConnection() throws SQLException {
    return getConnection("");
  }

  /**
   * Returns a non-basic connection associated to a database.
   *
   * @param database
   *          what database to select.
   * @return a connection where the database is already selected.
   * @throws SQLException
   *           when no connection to the postgres server could be setup.
   */
  public Connection getConnection(String database) throws SQLException {
    if (!connectionPool.containsKey(database)) {
      log.info(String.format("Connecting to database <%s> for the first time", database));
      String url = "jdbc:postgresql://" + POSTGRES_HOST + "/" + database;

      if(!"".equals(database) && !"postgres".equals(database)) {
        Flyway flyway = new Flyway();
        flyway.setDataSource(url, POSTGRES_USER, POSTGRES_PASS);
        flyway.setBaselineDescription("Baseline");
        flyway.setBaselineOnMigrate(true);
        flyway.setLocations("schema");
        try {
          flyway.migrate();
        } catch (FlywaySqlException e) {
          log.error("Error migrating database", e);
          throw new WeaverError(WeaverError.DATABASE_CONNECTION, String.format("Error connecting to database %s (MIG)", database));
        }
      }

      BasicDataSource bds = new BasicDataSource();

      bds.setUrl(url + "?ApplicationName=Weaver Postgres Connector");
      bds.setUsername(POSTGRES_USER);
      bds.setPassword(POSTGRES_PASS);

      bds.setDriverClassName("org.postgresql.Driver");
      bds.setInitialSize(5);
      bds.setMaxTotal(10);

      connectionPool.put(database, bds);
    }

    return connectionPool.get(database).getConnection();
  }

  public void removeFromConnectionPool(String database) {
    if (connectionPool.containsKey(database)) {
      try {
        connectionPool.get(database).close();
        connectionPool.remove(database);
      } catch (SQLException e) {
        handleSqlError(e);
      }
    }
  }

  /**
   * Creates a database and inserts it's connection into the pool.
   *
   * @return true if database was succesfully created, false otherwise.
   */
  public void createDatabase(String database) {
    if(!DatabaseController.isLegalDatabaseName(database))
      throw new WeaverError(443, "Illegal database name: " + database);

    boolean initialize = false;
    try (Connection conn = getConnection()) {
      conn.createStatement().execute(String.format(Query.CREATE_DATABASE, Utils.escapeLiteral(null, database, true).toString()));
      initialize = true;
    } catch (SQLException e) {
      handleSqlError(e);
    }

    if(initialize) {
      log.debug(String.format("Going to initialize database %s", database));
      try {
        initializeDatabase(database);
      } catch (SQLException e) {
        handleSqlError(e);
      }
    }
  }

  /**
   * Attempts to create a database using the provided database as a
   * template. When it fails, due to open connections, it will force
   * close all open connections and try to template that database
   * again (retries one time).
   *
   * @param database which database to template.
   */
  public void duplicateDatabase(String database, String cloned_database) {
    // Check if the cloned_database name is valid, otherwise throw
    // WeaverError
    if(!DatabaseController.isLegalDatabaseName(cloned_database))
      throw new WeaverError(443, "Illegal database name: " + cloned_database);

    try(Connection conn = getConnection()) {
      // Force drop all connections to the database
      dropConnections(database, conn);
      // Escape the database names
      // then execute the query.
      String escapedClonedDatabase = Utils.escapeLiteral(null, cloned_database, true).toString();
      String escapedDatabase = Utils.escapeLiteral(null, database, true).toString();
      conn.createStatement().execute(String.format(Query.CREATE_DATABASE_TEMPLATED,
          escapedClonedDatabase,
          escapedDatabase
          ));
    } catch(SQLException e) {
      handleSqlError(e);
    }
  }

  /**
   * Drops all the connections that are open to the database, does
   * not discriminate between connections and forces all of them to
   * drop.
   *
   * @param database drop all connections from this database.
   */
  private void dropConnections(String database, Connection conn) throws SQLException {
    PreparedStatement ps = conn.prepareStatement(Query.CLOSE_CONNECTIONS);
    ps.setString(1, database);
    ps.executeQuery();
    removeFromConnectionPool(database);
    log.info("Successfully cleared all connections to " + database);
  }

  /**
   * Looks up all the databases and retrieves it in JSON format.
   *
   * @return String[] containing all the databases.
   */
  public Object[] databases() {
    List<String> databases = new ArrayList<String>();
    try (Connection conn = getConnection()) {
      ResultSet rs = conn.createStatement().executeQuery(Query.LIST_DATABASES);
      while (rs.next()) {
        String result = rs.getString(1);
        if (!result.equals("template1") && !result.equals("template0"))
          databases.add(rs.getString(1));
      }
    } catch (SQLException e) {
      handleSqlError(e);
    }
    return databases.toArray();
  }

  /**
   * Initializes a database, makes it ready for use. Executing the structure onto
   * the database and inserting it into the connection pool.
   *
   * @param database
   *          the database that needs initialization.
   * @return true if structure is succesfully ran on the database, false
   *         otherwise.
   * @throws SQLException
   *           when no connection could have been retrieved from the initialized
   *           database.
   */
  private void initializeDatabase(String database) throws SQLException {
    try(Connection conn = getConnection(database)) {
      // Flyway takes care of this now
      log.trace(String.format("Conn tostring: %s", conn.toString()));
    }
  }

  public Database getDatabase(String database) {
    if (database == null) {
      throw new WeaverError(DATABASE_NOT_PROVIDED, "Please supply the database");
    }

    return new Database(database);
  }

  private void handleSqlError(final SQLException e) {
    if(e instanceof PSQLException)
      throw new WeaverError(DATABASE_CONNECTION, "" + ((PSQLException) e).getServerErrorMessage());
    else
      throw new WeaverError(DATABASE_CONNECTION, e.getMessage());
  }
}
