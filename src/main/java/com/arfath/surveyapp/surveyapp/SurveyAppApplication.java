package com.arfath.surveyapp.surveyapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SurveyAppApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SurveyAppApplication.class, args);
        System.out.println(context.getEnvironment().getProperty("spring.datasource.url"));
    }
}
