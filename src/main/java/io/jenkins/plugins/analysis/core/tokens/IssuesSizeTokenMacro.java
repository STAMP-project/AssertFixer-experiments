package io.jenkins.plugins.analysis.core.tokens;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.jenkinsci.plugins.tokenmacro.DataBoundTokenMacro;

import io.jenkins.plugins.analysis.core.model.ByIdResultSelector;
import io.jenkins.plugins.analysis.core.views.ResultAction;

import hudson.Extension;
import hudson.FilePath;
import hudson.model.AbstractBuild;
import hudson.model.Run;
import hudson.model.TaskListener;

/**
 * Provides a token that evaluates to the number of issues.
 *
 * @author Ullrich Hafner
 */
@Extension(optional = true)
public class IssuesSizeTokenMacro extends DataBoundTokenMacro {
    private String tool;

    /**
     * Creates a new instance of {@link IssuesSizeTokenMacro}.
     */
    public IssuesSizeTokenMacro() {
        super();
    }

    @Parameter
    public void setTool(final String tool) {
        this.tool = tool;
    }

    @Override
    public boolean acceptsMacroName(final String macroName) {
        return "ANALYSIS_ISSUES_COUNT".equals(macroName);
    }

    @Override
    public String evaluate(final AbstractBuild<?, ?> abstractBuild, final TaskListener taskListener, final String macroName) {
        return extractIssuesSize(abstractBuild);
    }

    @Override
    public String evaluate(final Run<?, ?> run, final FilePath workspace, final TaskListener listener,
            final String macroName) {
        return extractIssuesSize(run);
    }

    private String extractIssuesSize(final Run<?, ?> run) {
        List<ResultAction> actions = getActions(run);
        int count = 0;
        for (ResultAction action : actions) {
            count += action.getResult().getTotalSize();
        }
        return String.valueOf(count);
    }

    private List<ResultAction> getActions(final Run<?, ?> run) {
        if (StringUtils.isBlank(tool)) {
            return run.getActions(ResultAction.class);
        }
        else {
            ByIdResultSelector selector = new ByIdResultSelector(tool);
            Optional<ResultAction> action = selector.get(run);
            if (action.isPresent()) {
                return Collections.singletonList(action.get());
            }
            return Collections.emptyList();
        }
    }
}

