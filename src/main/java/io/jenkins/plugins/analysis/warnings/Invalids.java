package io.jenkins.plugins.analysis.warnings;

import javax.annotation.Nonnull;

import org.kohsuke.stapler.DataBoundConstructor;

import edu.hm.hafner.analysis.parser.InvalidsParser;
import io.jenkins.plugins.analysis.core.model.StaticAnalysisTool;

import hudson.Extension;

/**
 * Provides a parser and customized messages for Oracle Invalids.
 *
 * @author Ullrich Hafner
 */
public class Invalids extends StaticAnalysisTool {
    private static final long serialVersionUID = 8400984149210830144L;
    static final String ID = "invalids";

    /** Creates a new instance of {@link Invalids}. */
    @DataBoundConstructor
    public Invalids() {
        super();
        // empty constructor required for stapler
    }

    @Override
    public InvalidsParser createParser() {
        return new InvalidsParser();
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
            return Messages.Warnings_OracleInvalids_ParserName();
        }
    }
}