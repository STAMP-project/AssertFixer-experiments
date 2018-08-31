package ru.avvorotov.hw1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RunApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RunApplication.class, args);
        Application application = context.getBean(Application.class);
        application.run();
    }
}
