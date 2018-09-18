/*
 * Swagger Petstore
 * This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\
 *
 * OpenAPI spec version: 1.0.0
 * Contact: apiteam@swagger.io
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.swagger.client.ApiClient;
import io.swagger.client.model.User;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;
import static io.restassured.config.RestAssuredConfig.config;
import static io.swagger.client.GsonObjectMapper.gson;
import static io.swagger.client.ResponseSpecBuilders.shouldBeCode;
import static io.swagger.client.ResponseSpecBuilders.validatedWith;
import static io.swagger.client.api.TestUtils.nextId;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

/**
 * API tests for UserApi
 */
public class UserApiTest {

    private UserApi api;

    @Before
    public void createApi() {
        api = ApiClient.api(ApiClient.Config.apiConfig().reqSpecSupplier(
                () -> new RequestSpecBuilder().setConfig(config().objectMapperConfig(objectMapperConfig().defaultObjectMapper(gson())))
                        .addFilter(new ErrorLoggingFilter())
                        .setBaseUri("http://petstore.swagger.io:80/v2"))).user();
    }

    @Test
    public void createUsersWithArrayInputTest() {
        User first = getUser().id(nextId());
        User second = getUser().id(nextId());
        List<User> body = Arrays.asList(first, second);
        api.createUsersWithArrayInput()
                .body(body).execute(validatedWith(shouldBeCode(SC_OK)));
        api.deleteUser().usernamePath(first.getUsername()).execute(
                validatedWith(shouldBeCode(SC_OK)));
    }

    @Test
    public void createUsersWithListInputTest() {
        User first = getUser().id(nextId());
        User second = getUser().id(nextId());
        List<User> body = Arrays.asList(first, second);
        api.createUsersWithListInput()
                .body(body).execute(validatedWith(shouldBeCode(SC_OK)));
        api.deleteUser().usernamePath(first.getUsername()).execute(
                validatedWith(shouldBeCode(SC_OK)));
    }

    @Test
    public void createUserTest() {
        String userName = "Blah";
        User user = getUser().username(userName);
        api.createUser().body(user).execute(validatedWith(shouldBeCode(SC_OK)));
        User fetched = api.getUserByName()
                .usernamePath(userName).executeAs(validatedWith(shouldBeCode(SC_OK)));

        assertThat(fetched, notNullValue());
        assertThat(fetched.getUsername(), equalTo(userName));
        assertThat(fetched.getPassword(), equalTo(user.getPassword()));
        assertThat(fetched.getEmail(), equalTo(user.getEmail()));
        assertThat(fetched.getFirstName(), equalTo(user.getFirstName()));
        assertThat(fetched.getLastName(), equalTo(user.getLastName()));
        assertThat(fetched.getId(), equalTo(user.getId()));
        api.deleteUser().usernamePath(user.getUsername()).execute(
                validatedWith(shouldBeCode(SC_OK)));
    }

    @Test
    public void loginTest() {
        String username = "a";
        String password = "b";
        String result = api.loginUser()
                .usernameQuery(username)
                .passwordQuery(password).executeAs(validatedWith(shouldBeCode(SC_OK)));
        assertThat(result, containsString("logged in user session"));

    }

    @Test
    public void logoutTest() {
        api.logoutUser().execute(validatedWith(shouldBeCode(SC_OK)));
    }

    @Test
    public void updateUserTest() {
        String username = "me";
        String email = "me@blah.com";
        User user = new User().username(username).email(email);
        api.createUser().body(user).execute(validatedWith(shouldBeCode(SC_OK)));
        api.updateUser()
                .usernamePath(username)
                .body(user).execute(validatedWith(shouldBeCode(SC_OK)));
        User fetched = api.getUserByName().usernamePath(username).executeAs(validatedWith(shouldBeCode(SC_OK)));
        assertThat(fetched, notNullValue());
        assertThat(fetched.getUsername(), equalTo(username));
        assertThat(fetched.getEmail(), equalTo(email));
        api.deleteUser().usernamePath(user.getUsername()).execute(
                validatedWith(shouldBeCode(SC_OK)));

    }

    private User getUser() {
        return new User().id(nextId()).username("Username")
                .email("blah@blah.com").firstName("Firstname").lastName("Lastname").userStatus(1);
    }
}