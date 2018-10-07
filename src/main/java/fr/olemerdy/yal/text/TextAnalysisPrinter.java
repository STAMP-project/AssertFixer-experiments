package fr.olemerdy.yal.text;

import fr.olemerdy.yal.io.Printer;

import java.io.IOException;
import java.io.Writer;
import java.util.Locale;

public class TextAnalysisPrinter implements Printer<TextAnalysis> {

    private final Locale locale;

    public static Printer<TextAnalysis> getDefault() {
        return new TextAnalysisPrinter(Locale.US);
    }

    public TextAnalysisPrinter(Locale locale) {
        this.locale = locale;
    }

    @Override
    public void print(TextAnalysis object, Writer writer) {
        object.forEachWordCount((word, count) -> {
            try {
                writer.write(String.format(locale, "%2$d %1$s%n", word, count));
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        });
    }
}
