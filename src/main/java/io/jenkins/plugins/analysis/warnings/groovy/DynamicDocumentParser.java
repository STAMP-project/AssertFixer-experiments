package io.jenkins.plugins.analysis.warnings.groovy;

import java.util.regex.Matcher;

import edu.hm.hafner.analysis.Issue;
import edu.hm.hafner.analysis.IssueBuilder;
import edu.hm.hafner.analysis.RegexpDocumentParser;

/**
 * A multi-line parser that uses a configurable regular expression and Groovy script to parse warnings.
 *
 * @author Ullrich Hafner
 */
public class DynamicDocumentParser extends RegexpDocumentParser {
    private static final long serialVersionUID = -690643673847390322L;
    private static final int NO_LINE_NUMBER_AVAILABLE = 0;
    
    private final GroovyExpressionMatcher expressionMatcher;

    /**
     * Creates a new instance of {@link DynamicDocumentParser}.
     *
     * @param regexp
     *         regular expression
     * @param script
     *         Groovy script
     */
    public DynamicDocumentParser(final String regexp, final String script) {
        super(regexp, true);

        expressionMatcher = new GroovyExpressionMatcher(script, FALSE_POSITIVE);
    }

    @Override
    protected Issue createIssue(final Matcher matcher, final IssueBuilder builder) {
        return expressionMatcher.createIssue(matcher, builder, 
                NO_LINE_NUMBER_AVAILABLE, getFileName());
    }
}

