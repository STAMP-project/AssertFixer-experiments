package fr.olemerdy.yal.text;

import org.junit.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class TextSplitterTest {

    @Test
    public void a_text_splitter_should_split_empty_text_in_empty_stream() {
        // Given an empty string
        String emptyString = "";
        // And a text splitter
        TextSplitter splitter = TextSplitter.inWords();

        // When the splitter splits the empty string
        Stream<String> empty = splitter.split(emptyString);

        // Then the words obtained are an empty stream
        assertThat(empty).isEmpty();
    }

    @Test
    public void a_text_splitter_should_split_blank_text_in_empty_stream() {
        // Given an blank string
        String blankString = " \t\n";
        // And a text splitter
        TextSplitter splitter = TextSplitter.inWords();

        // When the splitter splits the empty string
        Stream<String> empty = splitter.split(blankString);

        // Then the words obtained are an empty stream
        assertThat(empty).isEmpty();
    }

    @Test
    public void a_text_splitter_in_words_should_split_pangram() {
        // Given our pangram
        String pangram = "The quick brown fox jumped over the lazy brown dog’s back";
        // And a text splitter splitting in words
        TextSplitter splitter = TextSplitter.inWords();

        // When the splitter splits the pangram
        Stream<String> words = splitter.split(pangram);

        // Then the words obtained are as expected in correct order
        assertThat(words).containsExactly("The", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "brown", "dog’s", "back");
    }
}
