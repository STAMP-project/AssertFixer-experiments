package fr.olemerdy.yal.util;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.Objects.requireNonNull;

/**
 * Provides utility methods to get useful {@link Comparator}s.
 */
public interface Comparators {

    /**
     * Gets a comparator that compare strings on their length, using int natural order.
     *
     * @return a String comparator
     */
    static Comparator<String> onLength() {
        return comparingInt(String::length);
    }

    /**
     * Gets a comparator that compares strings on their natural ASCII order.
     *
     * @return a String comparator
     */
    static Comparator<String> onASCIIOrder() {
        return comparing(s -> s);
    }

    /**
     * Gets a comparator that compares {@link Object}s based on a standard set of rules for a given {@link Locale}.
     * <p>
     * This comparator will apply rules specific to a given language, e.g. relatively to accentuated characters.
     *
     * @param locale a locale
     * @return an Object comparator
     */
    static Comparator<Object> onLocale(Locale locale) {
        return Collator.getInstance(requireNonNull(locale));
    }

}
