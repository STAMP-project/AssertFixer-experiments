package io.jenkins.plugins.analysis.core.model;

import java.util.ArrayList;
import java.util.List;

import edu.hm.hafner.analysis.Issue;
import edu.hm.hafner.analysis.Report;
import io.jenkins.plugins.analysis.core.model.StaticAnalysisLabelProvider.AgeBuilder;
import io.jenkins.plugins.analysis.core.scm.BlameRequest;
import io.jenkins.plugins.analysis.core.scm.Blames;

/**
 * FIXME: write comment.
 *
 * @author Ullrich Hafner
 */
public class ReferenceDetailsModel extends DetailsTableModel {
    private final Blames blames;

    public ReferenceDetailsModel(final AgeBuilder ageBuilder, final FileNameRenderer fileNameRenderer,
            final DescriptionProvider descriptionProvider, final Blames blames) {
        super(ageBuilder, fileNameRenderer, descriptionProvider);
        
        this.blames = blames;
    }

    @Override
    public List<Integer> getWidths(final Report report) {
        List<Integer> widths = new ArrayList<>();
        widths.add(1);
        widths.add(1);
        widths.add(1);
        widths.add(1);
        widths.add(1);
        widths.add(1);
        return widths;
    }

    @Override
    public List<String> getHeaders(final Report report) {
        List<String> visibleColumns = new ArrayList<>();
        visibleColumns.add(Messages.Table_Column_Details());
        visibleColumns.add(Messages.Table_Column_File());
        visibleColumns.add(Messages.Table_Column_Age());
        visibleColumns.add("Author");
        visibleColumns.add("Email");
        visibleColumns.add("Commit");
        return visibleColumns;
    }

    @Override
    protected List<String> getRow(final Report report, final Issue issue, final AgeBuilder ageBuilder,
            final FileNameRenderer fileNameRenderer, final String description) {
        List<String> columns = new ArrayList<>();
        columns.add(formatDetails(issue, description));
        columns.add(formatFileName(issue, fileNameRenderer));
        columns.add(formatAge(issue, ageBuilder));
        if (blames.contains(issue.getFileName())) {
            BlameRequest blameRequest = blames.get(issue.getFileName());
            int line = issue.getLineStart();
            columns.add(blameRequest.getName(line));
            columns.add(blameRequest.getEmail(line));
            columns.add(blameRequest.getCommit(line));
        }
        else {
            columns.add("-");
            columns.add("-");
            columns.add("-");
        }
        return columns;
    }
}
