package com.weaverplatform.postgresql;

import com.weaverplatform.postgresql.database.Database;
import com.weaverplatform.postgresql.database.Postgres;
import com.weaverplatform.postgresql.database.TestQuery;
import com.weaverplatform.postgresql.database.query.model.WeaverQuery;
import com.weaverplatform.postgresql.util.Props;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.BeforeClass;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author Mohamad Alamili
 */
public class BaseTest {

  static Application application;
  static String database;

  @BeforeClass
  public static void setup(){
    RestAssured.baseURI = "http://localhost";
    BaseTest.database = "testdatabase";

    if(application == null) {
      application = new Application();
    }
    RestAssured.port = application.getPort();

    createOrWipe();
  }

  public static WeaverQuery query(){
    return new WeaverQuery();
  }

  public Database getDatabase() {
    return Postgres.INSTANCE.getDatabase(database);
  }

  public void wipe() {
    given()
      .contentType("application/json")
      .with()
      .queryParam("database", BaseTest.database)
      .expect()
      .statusCode(200)
      .body(equalTo("Success"))
      .when()
      .get("http://localhost:4567/wipe");
  }

  public static void createOrWipe() {
    System.out.println("Create or wipe");
    int result = given()
      .contentType("application/json")
      .with()
      .queryParam("database", BaseTest.database)
      .when()
      .post("/createDatabase")
      .then().extract().response().getStatusCode();

    if(result == 400) {
      given().with().queryParam("database", BaseTest.database).get("/wipe").then().statusCode(200);
    }
  }

  public PreparedStatement prepareQuery(String query) throws SQLException {
    return Postgres.INSTANCE.getConnection(database).prepareStatement(query);
  }

  public ResultSet executeQuery(String query) throws SQLException {
    ResultSet rs = prepareQuery(query).executeQuery();
    rs.next();
    return rs;
  }

  public ResultSet listNode(String nodeName) throws SQLException {
    PreparedStatement ps = prepareQuery(TestQuery.TEST_CREATE_NODE);
    ps.setString(1, nodeName);
    ResultSet rs = ps.executeQuery();
    rs.next();
    return rs;
  }
}
