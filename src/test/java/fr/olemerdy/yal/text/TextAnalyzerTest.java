package fr.olemerdy.yal.text;

import org.junit.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class TextAnalyzerTest {

    @Test
    public void pangram_should_split() {
        // Given our pangram
        String pangram = "The quick brown fox jumped over the lazy brown dog’s back ";
        // And a default text analyzer
        TextAnalyzer analyzer = TextAnalyzer.getDefault();

        // When the analyzer analyzes a pangram
        TextAnalysis analysis = analyzer.analyze(pangram);

        // Then the analysis contains the expected output in correct order
        assertThat(analysis.asWordCountMap()).containsExactly(
                entry("The", 1L),
                entry("fox", 1L),
                entry("the", 1L),
                entry("back", 1L),
                entry("lazy", 1L),
                entry("over", 1L),
                entry("brown", 2L),
                entry("dog’s", 1L),
                entry("quick", 1L),
                entry("jumped", 1L)
        );
    }

}
