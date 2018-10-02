package io.jenkins.plugins.analysis.warnings;

import javax.annotation.Nonnull;

import org.kohsuke.stapler.DataBoundConstructor;

import edu.hm.hafner.analysis.parser.violations.PitAdapter;
import io.jenkins.plugins.analysis.core.model.StaticAnalysisLabelProvider;
import io.jenkins.plugins.analysis.core.model.StaticAnalysisTool;

import hudson.Extension;

/**
 * Provides a parser and customized messages for PIT.
 *
 * @author Ullrich Hafner
 */
public class Pit extends StaticAnalysisTool {
    private static final long serialVersionUID = -3769283356498049888L;
    static final String ID = "pit";

    /** Creates a new instance of {@link Pit}. */
    @DataBoundConstructor
    public Pit() {
        super();
        // empty constructor required for stapler
    }

    @Override
    public boolean canScanConsoleLog() {
        return false;
    }

    @Override
    public PitAdapter createParser() {
        return new PitAdapter();
    }

    /** Descriptor for this static analysis tool. */
    @Extension
    public static class Descriptor extends StaticAnalysisToolDescriptor {
        /** Creates the descriptor instance. */
        public Descriptor() {
            super(ID);
        }

        @Nonnull
        @Override
        public String getDisplayName() {
            return Messages.Violations_PIT();
        }

        @Override
        public StaticAnalysisLabelProvider getLabelProvider() {
            return new IconLabelProvider(getId(), getDisplayName());
        }

        @Override
        public String getUrl() {
            return "http://pitest.org";
        }
    }
}
