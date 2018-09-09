package supervin;

import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Greeting service.
 */
public class Greeter {
    /**
     * Here we ask, who we are greeting.
     */
    private  GreeterTarget target;

    /**
     * Simple constructor.
     * @param newTarget Greeter target selector to use.
     */
    public Greeter(final GreeterTarget newTarget) {
        this.target = newTarget;
    }

    /**
     * Generates greeting.
     * @return "Hello-style" string.
     */
    public final String greet() {
        return "Hello " + target.get();
    }
}