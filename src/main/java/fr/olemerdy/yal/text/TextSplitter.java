package fr.olemerdy.yal.text;

import java.util.stream.Stream;

/**
 *
 */
@FunctionalInterface
public interface TextSplitter {

    /**
     * @return a splitter splitting a text in words
     */
    static TextSplitter inWords() {
        return WordsTextSplitter.getDefault();
    }

    /**
     * Splits a given String text into a stream of String parts.
     *
     * @param text a text String
     * @return a Stream of String parts
     */
    Stream<String> split(String text);
}
