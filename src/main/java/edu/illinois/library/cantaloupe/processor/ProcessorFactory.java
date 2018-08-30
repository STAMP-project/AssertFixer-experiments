package edu.illinois.library.cantaloupe.processor;

import edu.illinois.library.cantaloupe.image.Format;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Used to obtain an instance of a {@link Processor} for a given source format,
 * as defined in the configuration.
 */
public final class ProcessorFactory {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(ProcessorFactory.class);

    private SelectionStrategy selectionStrategy =
            SelectionStrategy.fromConfiguration();

    public static Set<Processor> getAllProcessors() {
        return new HashSet<>(Arrays.asList(
                new FfmpegProcessor(),
                new GraphicsMagickProcessor(),
                new ImageMagickProcessor(),
                new JaiProcessor(),
                new Java2dProcessor(),
                new KakaduDemoProcessor(),
                new KakaduNativeProcessor(),
                new OpenJpegProcessor(),
                new PdfBoxProcessor()));
    }

    public SelectionStrategy getSelectionStrategy() {
        return selectionStrategy;
    }

    /**
     * Retrieves the best-match processor for the given source format.
     *
     * @param sourceFormat Source format for which to retrieve a processor.
     * @return             Instance suitable for handling the given source
     *                     format, based on configuration settings.
     */
    public Processor newProcessor(final Format sourceFormat)
            throws UnsupportedSourceFormatException,
            InitializationException,
            ReflectiveOperationException {
        final List<Class<? extends Processor>> candidates =
                getSelectionStrategy().getPreferredProcessors(sourceFormat);
        InitializationException e = null;

        for (Class<? extends Processor> class_ : candidates) {
            Processor candidate = class_.getDeclaredConstructor().newInstance();
            e = candidate.getInitializationException();
            if (e == null) {
                try {
                    candidate.setSourceFormat(sourceFormat);
                    LOGGER.info("{} selected for format {} ({} offered {})",
                            candidate.getClass().getSimpleName(),
                            sourceFormat.name(),
                            getSelectionStrategy(),
                            candidates.stream()
                                    .map(Class::getSimpleName)
                                    .collect(Collectors.joining(", ")));
                    return candidate;
                } catch (UnsupportedSourceFormatException ignore) {}
            }
        }

        if (e != null) {
            throw e;
        }
        throw new UnsupportedSourceFormatException(sourceFormat);
    }

    void setSelectionStrategy(SelectionStrategy selectionStrategy) {
        this.selectionStrategy = selectionStrategy;
    }

}
