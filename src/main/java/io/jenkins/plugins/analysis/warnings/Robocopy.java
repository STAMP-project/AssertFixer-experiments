package io.jenkins.plugins.analysis.warnings;

import javax.annotation.Nonnull;

import org.kohsuke.stapler.DataBoundConstructor;

import edu.hm.hafner.analysis.parser.RobocopyParser;
import io.jenkins.plugins.analysis.core.model.StaticAnalysisTool;

import hudson.Extension;
import hudson.plugins.warnings.parser.Messages;

/**
 * Provides a parser and customized messages for Robocopy.
 *
 * @author Ullrich Hafner
 */
public class Robocopy extends StaticAnalysisTool {
    private static final long serialVersionUID = -9009703818411779941L;
    static final String ID = "robocopy";

    /** Creates a new instance of {@link Robocopy}. */
    @DataBoundConstructor
    public Robocopy() {
        super();
        // empty constructor required for stapler
    }

    @Override
    public RobocopyParser createParser() {
        return new RobocopyParser();
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
            return Messages.Warnings_Robocopy_ParserName();
        }
    }
}