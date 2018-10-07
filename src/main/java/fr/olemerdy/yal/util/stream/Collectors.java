package fr.olemerdy.yal.util.stream;

import java.util.Comparator;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.stream.Collector;

import static java.util.stream.Collectors.counting;

/**
 * Provides utility methods to get useful {@link Collector}s.
 */
public interface Collectors {

    /**
     * Provides a collector that transforms a {@link java.util.stream.Stream} into a {@link java.util.NavigableMap}
     * containing stream's elements as keys, number of occurrences of each element as values, the keys being sorted
     * using a given {@link Comparator}.
     *
     * @param comparator a key comparator
     * @param <K>        some key types with sensible {@link Object#equals(Object)} and {@link Object#hashCode()} methods
     * @return a collector
     */
    static <K> Collector<K, ?, NavigableMap<K, Long>> groupingBySelfCountingThenSortBy(Comparator<? super K> comparator) {
        return java.util.stream.Collectors.groupingBy(
                self -> self,
                () -> new TreeMap<>(comparator),
                counting()
        );
    }
}
