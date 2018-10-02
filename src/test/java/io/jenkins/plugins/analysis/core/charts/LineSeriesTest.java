package io.jenkins.plugins.analysis.core.charts;

import org.junit.jupiter.api.Test;

import static io.jenkins.plugins.analysis.core.testutil.Assertions.*;

/**
 * Tests the class {@link LineSeries}.
 *
 * @author Ullrich Hafner
 */
class LineSeriesTest {
    private static final String SEVERITY = "High";
    private static final String STACKED = "stacked";
    private static final String LINE = "line";
    private static final String COLOR = "#fff";

    @Test
    void shouldCreateLineSeries() {
        LineSeries lineSeries = new LineSeries(SEVERITY, COLOR);

        assertThatJson(lineSeries).node("areaStyle").isEqualTo(new AreaStyle());
        assertThatJson(lineSeries).node("name").isEqualTo(SEVERITY);
        assertThatJson(lineSeries).node("stack").isEqualTo(STACKED);
        assertThatJson(lineSeries).node("type").isEqualTo(LINE);
        assertThatJson(lineSeries).node("data").isArray().ofLength(0);
    }

    @Test
    void shouldCreateLineSeriesWithValues() {
        LineSeries lineSeries = new LineSeries("High", COLOR);
        lineSeries.add(22);
        
        assertThatJson(lineSeries).node("areaStyle").isEqualTo(new AreaStyle());
        assertThatJson(lineSeries).node("name").isEqualTo(SEVERITY);
        assertThatJson(lineSeries).node("stack").isEqualTo(STACKED);
        assertThatJson(lineSeries).node("type").isEqualTo(LINE);
        assertThatJson(lineSeries).node("data").isArray().ofLength(1).thatContains(22);
    }
}