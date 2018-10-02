package io.jenkins.plugins.analysis.core.filter;

import javax.annotation.Nonnull;

import org.jenkinsci.Symbol;
import org.kohsuke.stapler.DataBoundConstructor;

import edu.hm.hafner.analysis.Report;
import edu.hm.hafner.analysis.Report.IssueFilterBuilder;
import io.jenkins.plugins.analysis.core.model.Messages;

import hudson.Extension;

/**
 * Defines a filter criteria for a {@link Report}.
 *
 * @author Ullrich Hafner
 */
public class IncludeCategory extends RegexpFilter {
    private static final long serialVersionUID = -3109697929021646731L;

    /**
     * Creates a new instance of {@link IncludeCategory}.
     *
     * @param pattern
     *         the regular expression of the filter
     */
    @DataBoundConstructor
    public IncludeCategory(final String pattern) {
        super(pattern);
    }

    @Override
    public void apply(final IssueFilterBuilder builder) {
        builder.setIncludeCategoryFilter(getPattern());
    }

    /**
     * Descriptor for {@link IncludeCategory}.
     *
     * @author Ullrich Hafner
     */
    @Extension @Symbol("includeCategory")
    public static class DescriptorImpl extends RegexpFilterDescriptor {
        @Nonnull
        @Override
        public String getDisplayName() {
            return Messages.Filter_Include_Category();
        }
    }
}