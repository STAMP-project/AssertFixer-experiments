package supervin;

import org.springframework.context.annotation.Bean;

import java.util.Random;

/**
 * Spring context configuration descriptor.
 */
public class ContextConfiguration {
    /**
     * "Random" service bean.
     * @return Java's built-in random generator.
     */
    @Bean
    public Random random() {
        return new Random();
    }

    @Bean
    public Coin coin() {
        return new CoinImpl(random());
    }

    @Bean
    public GreeterTarget greeterTarget() {
        return new GreeterTargetImpl(coin());
    }

    @Bean
    public Greeter greeter() {
        return new Greeter(greeterTarget());
    }
}