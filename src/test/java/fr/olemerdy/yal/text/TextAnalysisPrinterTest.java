package fr.olemerdy.yal.text;

import fr.olemerdy.yal.io.Printer;
import org.junit.Test;

import java.io.*;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Assembly test.
 */
public class TextAnalysisPrinterTest {

    @Test
    public void default_text_analysis_printer_should_print_pangram_analysis() throws IOException {
        // Given our pangram
        String pangram = "The quick brown fox jumped over the lazy brown dog’s back ";
        // And a text analyzer
        TextAnalyzer analyzer = TextAnalyzer.getDefault();
        // And a resulting text analysis
        TextAnalysis analysis = analyzer.analyze(pangram);
        // And a text analysis printer
        Printer<TextAnalysis> printer = TextAnalysisPrinter.getDefault();
        // And a string writer
        try (Writer writer = new StringWriter()) {

            // When printer prints analysis to writer
            printer.print(analysis, writer);

            // Then the resulting output is OK
            assertThat(writer.toString())
                    .hasLineCount(10)
                    .isEqualTo(String.join(lineSeparator(),
                            "1 The",
                            "1 fox",
                            "1 the",
                            "1 back",
                            "1 lazy",
                            "1 over",
                            "2 brown",
                            "1 dog’s",
                            "1 quick",
                            "1 jumped"
                    ) + lineSeparator());
        }
    }

    @Test
    public void lines() throws IOException {
        // Given a lipsum text
        String lipsum = String.join(lineSeparator(), readLinesFromClasspath("lipsum.txt"));
        // And an analyzer
        TextAnalyzer analyzer = TextAnalyzer.getDefault();
        // And the resulting analysis
        TextAnalysis analysis = analyzer.analyze(lipsum);
        // And a text analysis printer
        Printer<TextAnalysis> printer = TextAnalysisPrinter.getDefault();
        // And an expected printed analysis
        List<String> expectedOutput = readLinesFromClasspath("lipsum-analysis");

        // And a string writer
        try (Writer writer = new StringWriter()) {

            // When printer prints analysis to writer
            printer.print(analysis, writer);

            // Then the resulting output is OK
            assertThat(writer.toString())
                    .hasLineCount(64)
                    .isEqualTo(expectedOutput);
        }
    }

    @Test(expected = IllegalStateException.class)
    public void faulty_writer_should_make_printer_fail() {
        // Given an analysis
        NavigableMap<String, Long> map = new TreeMap<>();
        map.put("foobar", 123L);
        TextAnalysis analysis = new TextAnalysis(map);
        // And a printer
        Printer<TextAnalysis> printer = TextAnalysisPrinter.getDefault();
        // And a faulty writer
        Writer writer = new Writer() {
            @Override
            public void write(char[] cbuf, int off, int len) throws IOException {
                throw new IOException("Oops I did it again");
            }

            @Override
            public void flush() {
            }

            @Override
            public void close() {
            }
        };

        // When printer prints analysis to writer
        printer.print(analysis, writer);
    }

    private List<String> readLinesFromClasspath(String relativePath) throws IOException {
        try (
                InputStream stream = TextAnalysisPrinterTest.class.getResourceAsStream(relativePath);
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream))
        ) {
            return reader.lines().collect(toList());
        }
    }
}
