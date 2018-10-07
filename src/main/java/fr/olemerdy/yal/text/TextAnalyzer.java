package fr.olemerdy.yal.text;

import fr.olemerdy.yal.util.Comparators;

import java.util.Comparator;

import static fr.olemerdy.yal.util.stream.Collectors.groupingBySelfCountingThenSortBy;
import static java.util.Objects.requireNonNull;

/**
 * Defines a text analyzer which can run analysis on any given {@link String} text.
 * <p>
 * This analysis includes:
 * <ul>
 * <li>Word count, the words being sorted</li>
 * </ul>
 * The notion of "word" is configurable by providing a custom {@link TextSplitter}
 */
public class TextAnalyzer {

    private final TextSplitter splitter;

    private final Comparator<? super String> wordComparator;

    /**
     * Provides a default {@link TextAnalyzer}
     *
     * @return
     */
    public static TextAnalyzer getDefault() {
        return new TextAnalyzer.Builder().build();
    }

    private TextAnalyzer(TextSplitter splitter, Comparator<? super String> wordComparator) {
        this.splitter = requireNonNull(splitter);
        this.wordComparator = wordComparator;
    }

    public TextAnalysis analyze(String text) {
        return new TextAnalysis(
                splitter.split(text)
                        .collect(groupingBySelfCountingThenSortBy(wordComparator)));
    }

    /**
     *
     */
    public static class Builder {

        private TextSplitter splitter;

        private Comparator<? super String> wordComparator;

        public Builder withTextSplitter(TextSplitter splitter) {
            this.splitter = requireNonNull(splitter);
            return this;
        }

        public Builder withWordComparator(Comparator<? super String> wordComparator) {
            this.wordComparator = requireNonNull(wordComparator);
            return this;
        }

        public TextAnalyzer build() {
            return new TextAnalyzer(
                    splitter == null
                            ? TextSplitter.inWords()
                            : splitter,
                    wordComparator == null
                            ? Comparators.onLength().thenComparing(Comparators.onASCIIOrder())
                            : wordComparator
            );
        }
    }

}
