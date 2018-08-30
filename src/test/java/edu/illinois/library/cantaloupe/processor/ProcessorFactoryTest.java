package edu.illinois.library.cantaloupe.processor;

import edu.illinois.library.cantaloupe.config.Configuration;
import edu.illinois.library.cantaloupe.config.Key;
import edu.illinois.library.cantaloupe.image.Format;
import edu.illinois.library.cantaloupe.test.BaseTest;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ProcessorFactoryTest extends BaseTest {

    private ProcessorFactory instance;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        instance = new ProcessorFactory();
    }

    @Test
    public void testGetAllProcessors() {
        assertEquals(9, ProcessorFactory.getAllProcessors().size());
    }

    @Test
    public void testNewProcessorWithWorkingFirstPreferenceMatch() throws Exception {
        instance.setSelectionStrategy(f ->
                Arrays.asList(PdfBoxProcessor.class, Java2dProcessor.class));
        assertTrue(instance.newProcessor(Format.PDF) instanceof PdfBoxProcessor);
    }

    @Test
    public void testNewProcessorWithBrokenFirstPreferenceMatchAndWorkingSecondPreferenceMatch()
            throws Exception {
        instance.setSelectionStrategy(f ->
                Arrays.asList(MockBrokenProcessor.class, Java2dProcessor.class));
        assertTrue(instance.newProcessor(Format.JPG) instanceof Java2dProcessor);
    }

    @Test
    public void testNewProcessorWithWorkingSecondPreferenceMatch() throws Exception {
        instance.setSelectionStrategy(f ->
                Arrays.asList(PdfBoxProcessor.class, Java2dProcessor.class));
        assertTrue(instance.newProcessor(Format.JPG) instanceof Java2dProcessor);
    }

    @Test(expected = InitializationException.class)
    public void testNewProcessorWithBrokenSecondPreferenceMatch() throws Exception {
        instance.setSelectionStrategy(f ->
                Arrays.asList(PdfBoxProcessor.class, MockBrokenProcessor.class));
        instance.newProcessor(Format.JPG);
    }

    @Test(expected = UnsupportedSourceFormatException.class)
    public void testNewProcessorWithNoMatch() throws Exception {
        instance.setSelectionStrategy(f ->
                Arrays.asList(PdfBoxProcessor.class, FfmpegProcessor.class));
        instance.newProcessor(Format.JPG);
    }

    @Test(expected = UnsupportedSourceFormatException.class)
    public void testNewProcessorWithUnknownFormat() throws Exception {
        Configuration.getInstance().setProperty(Key.PROCESSOR_FALLBACK,
                Java2dProcessor.class.getSimpleName());
        instance.newProcessor(Format.UNKNOWN);
    }

}
