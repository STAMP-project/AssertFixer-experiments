package fr.olemerdy.yal.text;

import fr.olemerdy.yal.util.Comparators;
import org.junit.Test;

import java.util.Locale;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class TextAnalyzerBuilderTest {

    @Test(expected = NullPointerException.class)
    public void builder_with_null_word_comparator_should_fail() {
        new TextAnalyzer.Builder().withWordComparator(null);
    }

    @Test(expected = NullPointerException.class)
    public void builder_with_null_text_splitter_should_fail() {
        new TextAnalyzer.Builder().withTextSplitter(null);
    }

    @Test
    public void builder_with_custom_word_comparator_and_text_splitter_should_build() {
        TextAnalyzer analyzer = new TextAnalyzer.Builder()
                .withTextSplitter(new WordsTextSplitter(Pattern.compile("\\W+")))
                .withWordComparator(Comparators.onLocale(Locale.FRANCE))
                .build();
        assertThat(analyzer).isNotNull();
    }
}
