package ru.superuin;


/**
 * Here we determine, who we are greeting today.
 */
public interface GreeterTarget {
    /**
     * Selects greeting target tossing a coin.
     * @return "World" or "Spring".
     */
    String get();
}