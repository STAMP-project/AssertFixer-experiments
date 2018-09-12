package com.weaverplatform.postgresql;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.weaverplatform.postgresql.database.TestQuery;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Ignore("This file hangs")
public class DatabaseTest extends BaseTest {

  @Test
  public void run01_listDatabasesTest() throws SQLException {
    given()
      .contentType("application/json")
      .expect()
      .statusCode(200)
      .body(containsString("postgres"))
      .when()
      .get("http://localhost:4567/databases");

    ResultSet rs = executeQuery(TestQuery.TEST_NO_DATABASE);
    assertEquals(rs.getInt(1), 1);
  }

  @Test
  public void run02_createDatabasesTest() throws SQLException {

    String databaseName = "helloworld";
    given()
        .contentType("application/json")
        .with()
        .queryParam("database", databaseName)
        .expect()
        .statusCode(200)
        .when()
        .post("http://localhost:4567/createDatabase");

    ResultSet rs = listDatabasesQuery(databaseName);
    assertEquals(rs.getString(1), databaseName);
  }

  @Test
  public void run03_createDatabaseWithSameNameTest() throws SQLException {

    String databaseName = "helloworld";
    given()
      .contentType("application/json")
      .with()
      .queryParam("database", databaseName)
      .expect()
      .statusCode(400)
      .when()
      .post("http://localhost:4567/createDatabase");

    ResultSet rs = listDatabasesQuery(databaseName);
    assertEquals(rs.getString(1), databaseName);
  }

  @Test
  public void run04_duplicateDatabaseTest() throws SQLException {
    given()
      .contentType("application/json")
      .with()
      .queryParam("database", "helloworld")
      .queryParam("cloned_database", "helloworld_copy_0")
      .expect()
      .statusCode(200)
      .when()
      .post("http://localhost:4567/duplicateDatabase");
  }

  @Test
  public void run05_duplicateDatabaseAgainTest() throws SQLException {

    String databaseName = "helloworld";
    given()
      .contentType("application/json")
      .with()
      .queryParam("database", databaseName)
      .queryParam("cloned_database", "helloworld_copy_1")
      .expect()
      .statusCode(200)
      .when()
      .post("http://localhost:4567/duplicateDatabase");

  }

  @Test
  public void run06_duplicatePostgresDatabaseTest() throws SQLException {
    given()
      .contentType("application/json")
      .with()
      .queryParam("database", "postgres")
      .queryParam("cloned_database", "shouldnotwork")
      .expect()
      .statusCode(400)
      .when()
      .post("http://localhost:4567/duplicateDatabase");

  }

  @Test
  public void run07_duplicateUnknownDatabaseTest() throws SQLException {

    String databaseName = "this_database_should_not_exist_test";
    given()
      .contentType("application/json")
      .with()
      .queryParam("database", databaseName)
      .queryParam("cloned_database", databaseName)
      .expect()
      .statusCode(400)
      .when()
      .post("http://localhost:4567/duplicateDatabase");

  }

  @Test
  public void run08_deleteDatabasesTest() throws SQLException {

    String databaseName = "helloworld";
    given()
      .contentType("application/json")
      .with()
      .queryParam("database", databaseName)
      .expect()
      .statusCode(200)
      .when()
      .post("http://localhost:4567/deleteDatabase");

    ResultSet rs = listDatabasesQuery(databaseName);
    assertFalse(rs.next());
  }

  @Test
  public void run09_deleteDatabasesTest() throws SQLException {

    String databaseName = "helloworld_copy_0";
    given()
      .contentType("application/json")
      .with()
      .queryParam("database", databaseName)
      .expect()
      .statusCode(200)
      .when()
      .post("http://localhost:4567/deleteDatabase");

    ResultSet rs = listDatabasesQuery(databaseName);
    assertFalse(rs.next());
  }

  @Test
  public void run10_deleteDatabasesTest() throws SQLException {

    String databaseName = "helloworld_copy_1";
    given()
      .contentType("application/json")
      .with()
      .queryParam("database", databaseName)
      .expect()
      .statusCode(200)
      .when()
      .post("http://localhost:4567/deleteDatabase");

    ResultSet rs = listDatabasesQuery(databaseName);
    assertFalse(rs.next());
  }

  @Test
  public void run11_deleteUnknownDatabaseTest() throws SQLException {

    String databaseName = "unknowndatabase";
    given()
      .contentType("application/json")
      .with()
      .queryParam("database", databaseName)
      .expect()
      .statusCode(400)
      .when()
      .post("http://localhost:4567/deleteDatabase");

    ResultSet rs = listDatabasesQuery(databaseName);
    assertFalse(rs.next());
  }

  private ResultSet listDatabasesQuery(String database) throws SQLException {
    PreparedStatement ps = prepareQuery(TestQuery.TEST_LIST_DATABASES);
    ps.setString(1, database);
    ResultSet rs = ps.executeQuery();
    rs.next();
    return rs;
  }
}
