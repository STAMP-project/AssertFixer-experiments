import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Simple implementation with
 * hardcoded targets.
 */
public class GreeterTargetImpl implements GreeterTarget {
    /**
     * Coin, we toss to define greeting target.
     */
    private Coin coin;

    /**
     * Simple constructor.
     *
     * @param newCoin Coin, that we will be tossing.
     */
    public GreeterTargetImpl(final Coin newCoin) {
        this.coin = newCoin;
    }

    /**
     * Selects greeting target tossing a coin.
     *
     * @return "World" or "Spring".
     */
    @Override
    public final String get() {
        if (coin.toss()) {
            return "World";
        }
        return "Spring";
    }
}
    