package fr.olemerdy.yal.io;

import java.io.Writer;

/**
 * @param <T>
 */
@FunctionalInterface
public interface Printer<T> {

    /**
     * Prints an object to a given {@link java.io.Writer}.
     *
     * @param object an object
     * @param writer a print writer
     */
    void print(T object, Writer writer);
}
