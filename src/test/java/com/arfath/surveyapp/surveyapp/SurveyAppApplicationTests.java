package com.arfath.surveyapp.surveyapp;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SurveyAppApplicationTests {

    @Value("${SPRING_DATASOURCE_DRIVER-CLASS-NAME}")
    private String datasourceDriverClassName;

    @Test
    public void contextLoads() {
    }

    @Test
    @IfProfileValue(name ="spring.profiles.active", value ="production")
    public void whenProfileProductionDataSourceTobePostgres() {
        Assertions.assertThat(this.datasourceDriverClassName).contains("com.");
    }

}
