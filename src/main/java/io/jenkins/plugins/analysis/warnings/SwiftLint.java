package io.jenkins.plugins.analysis.warnings;

import javax.annotation.Nonnull;

import org.kohsuke.stapler.DataBoundConstructor;

import edu.hm.hafner.analysis.parser.checkstyle.CheckStyleParser;
import io.jenkins.plugins.analysis.core.model.StaticAnalysisTool;

import hudson.Extension;

/**
 * Provides a parser and customized messages for SwiftLint. Delegates to {@link CheckStyleParser}.
 *
 * @author Ullrich Hafner
 */
public class SwiftLint extends StaticAnalysisTool {
    private static final long serialVersionUID = -1112001682237184947L;
    
    static final String ID = "swiftlint";

    /** Creates a new instance of {@link SwiftLint}. */
    @DataBoundConstructor
    public SwiftLint() {
        super();
        // empty constructor required for stapler
    }

    @Override
    public boolean canScanConsoleLog() {
        return false;
    }

    @Override
    public CheckStyleParser createParser() {
        return new CheckStyleParser();
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
            return Messages.Warnings_SwiftLint_Name();
        }

        @Override
        public String getHelp() {
            return "Use configuration reporter: \\”checkstyle\\”.";
        }

        @Override
        public String getUrl() {
            return "https://github.com/realm/SwiftLint";
        }
    }
}
