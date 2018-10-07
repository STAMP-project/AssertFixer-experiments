package fr.olemerdy.yal.text;

import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;

class WordsTextSplitter implements TextSplitter {

    private final Pattern pattern;

    public static WordsTextSplitter getDefault() {
        return new WordsTextSplitter(Pattern.compile("(\\p{Punct}|\\s)+"));
    }

    public WordsTextSplitter(Pattern pattern) {
        this.pattern = requireNonNull(pattern);
    }

    @Override
    public Stream<String> split(String text) {
        return pattern.splitAsStream(text).filter(s -> !s.isEmpty());
    }
}
