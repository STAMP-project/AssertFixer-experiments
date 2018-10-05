package com.weaverplatform.postgresql;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApplicationTest extends BaseTest {

  @Test
  public void rootTest() {

    given()
      .contentType("application/json")
      .expect()
      .statusCode(200)
      .when()
      .get("/");

  }

  @Test
  public void aboutTest() {

    given()
      .contentType("application/json")
      .expect()
      .statusCode(200)
      .when()
      .get("/about");

  }

  @Test
  public void connectionTest() {

    given()
      .contentType("application/json")
      .expect()
      .statusCode(204)
      .when()
      .get("/connection");

  }

  @Test
  public void notfoundTest() {

    given()
      .contentType("application/json")
      .expect()
      .statusCode(404)
      .body(equalTo("404 - Route not found"))
      .when()
      .get("/this-route-may-never-exist-for-testing-purposes-only");

  }
}
