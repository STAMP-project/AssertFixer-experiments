package ru.superuin;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

/**
 * Application main class.
 */
public final class App {
    /**
     * Do not construct me.
     */
    private App() { };

    /**
     * Application entry point.
     * @param args Array of command line arguments.
     */
    public static void main(final String[] args) {
        ApplicationContext context =
                new GenericGroovyApplicationContext("/applicationContext.groovy");

        Greeter greeter = context.getBean(Greeter.class);

        System.out.println(greeter.greet());
    }
}