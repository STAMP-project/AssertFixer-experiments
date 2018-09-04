package io.testrex;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import static org.assertj.core.api.BDDAssertions.then;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = { "management.port=0" })
@ActiveProfiles("itest")
public class TestRexApplicationTests {

  @LocalServerPort
  private int port;

  @Value("${local.management.port}")
  private int mgt;

  @Autowired
  private TestRestTemplate testRestTemplate;

  @Test
  public void shouldReturn200WhenSendingRequestToController() {
    System.out.println("http://localhost:" + this.port + "/testsuites/1");
    
    @SuppressWarnings("rawtypes")
    ResponseEntity<Map> entity = this.testRestTemplate.getForEntity("http://localhost:" + this.port + "/testsuites/1", Map.class);

    then(entity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
  }

  @Test
  public void shouldReturn200WhenSendingRequestToManagementEndpoint() {
    System.out.println("http://localhost:" + this.mgt + "/actuator/info");
    @SuppressWarnings("rawtypes")
    ResponseEntity<Map> entity = this.testRestTemplate.getForEntity("http://localhost:" + this.mgt + "/actuator/info", Map.class);

    then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
  }

  @Test
  public void classWithNoTestXml() {

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_XML);

    HttpEntity<String> entity = new HttpEntity<String>(readTestFile(Paths.get("src/test/resources/TEST-classWithNoTests.NoMethodsTestCase.xml")), headers);
    ResponseEntity<String> response = testRestTemplate.postForEntity("http://localhost:" + this.port + "testsuites/", entity, String.class);
    then(response.getStatusCode().is2xxSuccessful());
  }

  private String readTestFile(Path filePath) {
    try(BufferedReader br = new BufferedReader(new FileReader(String.valueOf(filePath)))) {

      String returnString = "";
      String line;
      while ((line = br.readLine()) != null) returnString += line;
      return returnString;

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
  // TODO: implement integration tests for all TEST-*.xml files under src/test/resources folder

}
