package io.jenkins.plugins.analysis.core.quality;

import org.junit.jupiter.api.Test;

import static io.jenkins.plugins.analysis.core.quality.QualityGateStatusAssert.*;
import static org.mockito.Mockito.*;

import hudson.model.Result;
import hudson.model.Run;

/**
 * Tests the class {@link QualityGateStatus}.
 *
 * @author Ullrich Hafner
 */
class QualityGateStatusTest {
    @Test
    void shouldIdentifySuccessfulStatus() {
        assertThat(QualityGateStatus.PASSED)
                .isSuccessful()
                .hasColor(Result.SUCCESS.color);
        assertThat(QualityGateStatus.INACTIVE)
                .isSuccessful()
                .hasColor(Result.NOT_BUILT.color);
        assertThat(QualityGateStatus.WARNING)
                .isNotSuccessful()
                .hasColor(Result.UNSTABLE.color);
        assertThat(QualityGateStatus.FAILED)
                .isNotSuccessful()
                .hasColor(Result.FAILURE.color);
    }
    
    @Test
    void shouldSetResult() {
        Run run = mock(Run.class);
        QualityGateStatus.PASSED.setResult(run);
        verify(run, never()).setResult(any());
        QualityGateStatus.INACTIVE.setResult(run);
        verify(run, never()).setResult(any());
        QualityGateStatus.WARNING.setResult(run);
        verify(run).setResult(Result.UNSTABLE);
        QualityGateStatus.FAILED.setResult(run);
        verify(run).setResult(Result.FAILURE);
    }
}