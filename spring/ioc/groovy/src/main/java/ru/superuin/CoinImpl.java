package ru.superuin;


import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Random;

/**
 * A simple implementation of Coin,
 * based on Random class.
 */
@Service
public class CoinImpl implements Coin {
    /**
     * Random data source.
     */
    private Random random;

    /**
     * Simple constructor.
     *
     * @param newRandom Supplied random generator.
     */
    @Inject
    public CoinImpl(final Random newRandom) {
        this.random = newRandom;
    }

    /**
     * Here we toss the coin.
     *
     * @return unpredicted true of false.
     */
    @Override
    public final boolean toss() {
        return random.nextBoolean();
    }
}