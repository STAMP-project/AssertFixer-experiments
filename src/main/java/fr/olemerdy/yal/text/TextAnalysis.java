package fr.olemerdy.yal.text;

import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.function.BiConsumer;

import static java.util.Collections.unmodifiableNavigableMap;
import static java.util.Objects.requireNonNull;

/**
 * Defines a text analysis report, containing the statistics for a given analysis run.
 */
public class TextAnalysis {

    private final NavigableMap<String, Long> wordCountMap;

    TextAnalysis(NavigableMap<String, Long> wordCountMap) {
        this.wordCountMap = unmodifiableNavigableMap(new TreeMap<>(requireNonNull(wordCountMap))); // defensive copy
    }

    /**
     * Gets a navigable word count map view of this text analysis, the keys being the words, and the counts of each
     * word the values.
     *
     * @return a navigable map
     */
    public NavigableMap<String, Long> asWordCountMap() {
        return wordCountMap;
    }

    /**
     * Performs the given action for each word count in the analysis order.
     *
     * @param consumer a consumer
     */
    public void forEachWordCount(BiConsumer<String, Long> consumer) {
        this.wordCountMap.forEach(consumer);
    }
}
