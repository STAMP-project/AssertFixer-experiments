package io.jenkins.plugins.analysis.core.views;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import hudson.model.Run;

/**
 * Tests the class {@link ConsoleDetail}.
 *
 * @author Ullrich Hafner
 */
class ConsoleDetailTest {
    @Test
    void shouldDetectConsoleLog() {
        assertThat(ConsoleDetail.isInConsoleLog("/path/to/log")).isTrue();        
        assertThat(ConsoleDetail.isInConsoleLog("/my/log")).isTrue();        
        assertThat(ConsoleDetail.isInConsoleLog("C:/build/log")).isTrue();        
    
        assertThat(ConsoleDetail.isInConsoleLog("logger")).isFalse();        
        assertThat(ConsoleDetail.isInConsoleLog("blog")).isFalse();        
    }
    
    @Test
    void shouldShowLinesOfConsoleLogStartAtBeginning() {
        ConsoleDetail consoleDetail = new ConsoleDetail(mock(Run.class), createLines(1, 20), 1, 2);
        
        assertThat(consoleDetail.getSourceCode()).contains("#FCAF3E\">1</td>");
        assertThat(consoleDetail.getSourceCode()).contains("#FCAF3E\">2</td>");
        assertThat(consoleDetail.getSourceCode()).contains("<td >3</td>");
        assertThat(consoleDetail.getSourceCode()).contains("<td >12</td>");
        assertThat(consoleDetail.getSourceCode()).doesNotContain("<td >13</td>");
    }

    @Test
    void shouldShowLinesOfConsoleLogStartAt10() {
        ConsoleDetail consoleDetail = new ConsoleDetail(mock(Run.class), createLines(1, 30), 11, 11);
        
        assertThat(consoleDetail.getSourceCode()).contains("<td >1</td>");
        assertThat(consoleDetail.getSourceCode()).contains("<td >10</td>");
        assertThat(consoleDetail.getSourceCode()).contains("#FCAF3E\">11</td>");
        assertThat(consoleDetail.getSourceCode()).contains("<td >12</td>");
        assertThat(consoleDetail.getSourceCode()).contains("<td >21</td>");
        assertThat(consoleDetail.getSourceCode()).doesNotContain("<td >22</td>");
    }

    @Test
    void shouldShowLinesOfConsoleEndAtHighlighting() {
        ConsoleDetail consoleDetail = new ConsoleDetail(mock(Run.class), createLines(1, 10), 5, 10);
        
        assertThat(consoleDetail.getSourceCode()).contains("<td >1</td>");
        assertThat(consoleDetail.getSourceCode()).contains("<td >4</td>");
        assertThat(consoleDetail.getSourceCode()).contains("#FCAF3E\">5</td>");
        assertThat(consoleDetail.getSourceCode()).contains("#FCAF3E\">10</td>");
        assertThat(consoleDetail.getSourceCode()).doesNotContain("<td >11</td>");
    }

    private Stream<String> createLines(final int start, final int end) {
        List<String> lines = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            lines.add(String.valueOf(i));
        }
        return lines.stream();
    }
}