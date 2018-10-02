package io.jenkins.plugins.analysis.warnings;

import javax.annotation.Nonnull;

import org.kohsuke.stapler.DataBoundConstructor;

import edu.hm.hafner.analysis.parser.ccm.CcmParser;
import io.jenkins.plugins.analysis.core.model.StaticAnalysisTool;

import hudson.Extension;

/**
 * Provides a parser and customized messages for CCM.
 *
 * @author Ullrich Hafner
 */
public class Ccm extends StaticAnalysisTool {
    private static final long serialVersionUID = 7286546914256953672L;
    static final String ID = "ccm";

    /** Creates a new instance of {@link Ccm}. */
    @DataBoundConstructor
    public Ccm() {
        super();
        // empty constructor required for stapler
    }

    @Override
    public CcmParser createParser() {
        return new CcmParser();
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
            return Messages.Warnings_Ccm_ParserName();
        }
    }
}
