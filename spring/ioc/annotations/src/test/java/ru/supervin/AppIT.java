package ru.supervin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.annotation.Resource;
import javax.inject.Inject;

import java.util.Random;

import static junit.framework.Assert.assertTrue;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class AppIT {

    @Inject
    private ApplicationContext context;

    @Configuration
    @ComponentScan("ru.supervin")
    public static class SpringConfig { }

    @Test
    public void testSpring() {
        Greeter greeter = context.getBean(Greeter.class);

        assertTrue(greeter.greet().startsWith("Hello"));
    }
}