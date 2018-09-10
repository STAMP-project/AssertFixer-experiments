package com.hedvig.backoffice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import lombok.val;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = IntegrationTestApplication.class)
public class TestControllerIT {

  private DockerService postgres;
  private DockerService productPricing;
  private DockerService botService;

  @Value("/home/meletis/Repos/back-office/src/test/java/com/hedvig/backoffice")
  private File productPricingPathToConfig;

  @Value("/home/meletis/Repos/product-pricing/src/test/resources")
  private File productPricingPathToResource;

  @Value("home/meletis/Repos/back-office/src/test/java/com/hedvig/backoffice")
  private File botServicePathToConfig;


  private static final String PRODUCT_PRICING_TARGET_RESOURCE_NAME = "/tariff-data";
  private static final String POSTGRES_NAME = "postgresOne";
  private static final String PRODUCT_PRICING_NAME = "productPricingOne";
  private static final String BOT_SERVICE_NAME = "botServiceOne";

  @Autowired
  private MockMvc mvc;

  @BeforeEach
  public void prepareContainers() throws Throwable {

    val ports = new HashMap<Integer, Integer>() {
      {
        put(5432, 5432);
      }
    };

    postgres = DockerService.builder().name(POSTGRES_NAME).image("postgres:latest").ports(ports)
      .env(new String[]{"POSTGRES_USER=postgres", "POSTGRES_PASSWORD=hedvig",
        "POSTGRES_DB=product_pricing"})
      .build();

    postgres.startContainer();

    val productPorts = new HashMap<Integer, Integer>() {
      {
        put(7045, 80);
      }
    };

    if (postgres.getDockerHost().length() > 0) {
      productPricing = DockerService.builder().image(
        "201427539538.dkr.ecr.eu-central-1.amazonaws.com/product-pricing:8f44b3204155773766d02ebaad9aec4a92c7ce37")
        .ports(productPorts).link(POSTGRES_NAME).env(new String[]{"AWS_REGION=eu-central-1"})
        .config(productPricingPathToConfig.getPath())
        .resource(productPricingPathToResource.getPath(), PRODUCT_PRICING_TARGET_RESOURCE_NAME)
        .name(PRODUCT_PRICING_NAME)
        .build();

      val botServicePorts = new HashMap<Integer, Integer>() {
        {
          put(7081, 80);
        }
      };

      botService = DockerService.builder().image(
        "201427539538.dkr.ecr.eu-central-1.amazonaws.com/bot-service:bee2a34e9ae5f1a387eac19b8edca20097d2be3e")
        .ports(botServicePorts).config(botServicePathToConfig.getPath()).link(PRODUCT_PRICING_NAME)
        .name(BOT_SERVICE_NAME).build();
    }

    productPricing.startContainer();
    botService.startContainer();

    TimeUnit.MINUTES.sleep(2);

  }

  @AfterEach
  public void dispose() {
    postgres.disposeContainer();
    productPricing.disposeContainer();
    botService.disposeContainer();
  }

  @WithMockUser(value = "spring")
  @Test
  public void test() throws Exception {
    this.mvc.perform(get("/test/test")).andExpect(status().isOk()).andReturn();
  }
}
