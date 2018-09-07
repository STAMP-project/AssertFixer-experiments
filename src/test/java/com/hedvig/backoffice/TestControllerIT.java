package com.hedvig.backoffice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.hedvig.backoffice.services.product_pricing.ProductPricingService;
import com.hedvig.backoffice.web.TestController;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import lombok.val;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = TestController.class)
@AutoConfigureMockMvc
@ContextConfiguration(classes= IntegrationTestApplication.class)
public class TestControllerIT {

  private DockerService postgres;
  private DockerService productPricing;

  @Autowired
  private ProductPricingService productPricingService;

  @Autowired
  private MockMvc mvc;

  @BeforeEach
  public void prepareContainers() throws Throwable {

    val ports = new HashMap<Integer, Integer>() {
      {
        put(5432, 5432);
      }
    };

    postgres = DockerService.builder().name("postgresTest").image("postgres:latest").ports(ports)
        .env(new String[] { "POSTGRES_USER=postgres", "POSTGRES_PASSWORD=hedvig", "POSTGRES_DB=product_pricing" })
        .build();

    postgres.startContainer();

    val productPorts = new HashMap<Integer, Integer>() {
      {
        put(80, 80);
      }
    };

    if (postgres.getDockerHost().length() > 0) {
      productPricing = DockerService.builder().image(
          "201427539538.dkr.ecr.eu-central-1.amazonaws.com/product-pricing:8f44b3204155773766d02ebaad9aec4a92c7ce37")
          .ports(productPorts).link("postgresTest").env(new String[] { "AWS_REGION=eu-central-1" }).waitForPort("80")
          .build();
    }

    productPricing.startContainer();

    TimeUnit.MINUTES.sleep(1);

//    mvc = MockMvcBuilders.standaloneSetup(productPricingService).build();
  }

  @AfterEach
  public void dispose() {
    postgres.disposeContainer();
    productPricing.disposeContainer();
  }

  @Test
  public void test() throws Exception {
    this.mvc.perform(get("/test/test")).andExpect(status().isOk()).andReturn();
  }
}
