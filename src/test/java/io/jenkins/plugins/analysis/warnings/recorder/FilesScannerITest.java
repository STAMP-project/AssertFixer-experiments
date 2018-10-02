package io.jenkins.plugins.analysis.warnings.recorder;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import io.jenkins.plugins.analysis.core.model.AnalysisResult;
import static io.jenkins.plugins.analysis.core.assertions.Assertions.*;
import io.jenkins.plugins.analysis.core.quality.QualityGateStatus;
import io.jenkins.plugins.analysis.core.steps.IssuesRecorder;
import io.jenkins.plugins.analysis.core.steps.ToolConfiguration;
import io.jenkins.plugins.analysis.core.testutil.IntegrationTestWithJenkinsPerSuite;
import io.jenkins.plugins.analysis.core.util.FilesScanner;
import io.jenkins.plugins.analysis.warnings.CheckStyle;

import hudson.Functions;
import hudson.model.FreeStyleProject;
import hudson.model.Result;

/**
 * Integration tests for {@link FilesScanner}. This test is using a ZIP file with all the necessary files. The structure
 * of the ZIP file is:
 * <p>
 * <pre>
 * filesscanner_workspace.zip
 *      |-checkstyle
 *          |-checkstyle.xml
 *      |-multiple_files
 *          |-checkstyle.xml
 *          |-nonFilePatternMatch.xml
 *          |-zero_length_file.xml
 *      |-no_file_pattern_match
 *          |-nonFilePatternMatch.xml
 *      |-no_read_permission
 *          |-no_read_permissions.xml
 *      |-zero_length_file
 *          |-zero_length_file.xml
 * </pre>
 * </p>
 *
 * @author Alexander Praegla
 */
public class FilesScannerITest extends IntegrationTestWithJenkinsPerSuite {
    private static final String WORKSPACE_DIRECTORY = "files-scanner";
    private static final String CHECKSTYLE_WORKSPACE = WORKSPACE_DIRECTORY + "/checkstyle";
    private static final String MULTIPLE_FILES_WORKSPACE = WORKSPACE_DIRECTORY + "/multiple_files";
    private static final String NO_FILE_PATTERN_MATCH_WORKSPACE = WORKSPACE_DIRECTORY + "/no_file_pattern_match";
    private static final String ZERO_LENGTH_WORKSPACE = WORKSPACE_DIRECTORY + "/zero_length_file";
    private static final String NON_READABLE_FILE_WORKSPACE = WORKSPACE_DIRECTORY + "/no_read_permission";
    private static final String NON_READABLE_FILE = "no_read_permissions.xml";

    /**
     * Runs the {@link FilesScanner} on a workspace with no files: the report should contain an error message.
     */
    @Test
    public void shouldReportErrorOnEmptyWorkspace() {
        FreeStyleProject project = createFreeStyleProject();
        enableCheckStyleWarnings(project);

        AnalysisResult result = scheduleBuildAndAssertStatus(project, Result.SUCCESS);

        assertThat(result).hasTotalSize(0);
        assertThat(result).hasErrorMessages("No files found for pattern '**/*issues.txt'. Configuration error?");
    }

    /**
     * Runs the {@link FilesScanner} on a workspace with a not readable file.
     */
    @Test
    public void cantReadFile() {
        FreeStyleProject project = createCheckStyleJob(NON_READABLE_FILE_WORKSPACE);

        makeFileUnreadable(project);

        AnalysisResult result = scheduleBuildAndAssertStatus(project, Result.SUCCESS);

        assertThat(result).hasTotalSize(0);
        if (Functions.isWindows()) { // Windows fails before file.canRead actually could be called
            assertThat(result.getErrorMessages().get(0)).contains("java.io.FileNotFoundException");
        }
        else {
            assertThat(result).hasErrorMessages(
                    "Skipping file 'no_read_permissions.xml' because Jenkins has no permission to read the file.");
        }
    }

    private void makeFileUnreadable(final FreeStyleProject project) {
        makeFileUnreadable(getWorkspaceFor(project) + File.separator + NON_READABLE_FILE);
    }

    /**
     * Runs the {@link FilesScanner} on a workspace with a file with zero length.
     */
    @Test
    public void fileLengthIsZero() {
        FreeStyleProject project = createCheckStyleJob(ZERO_LENGTH_WORKSPACE);
        
        AnalysisResult result = scheduleBuildAndAssertStatus(project, Result.SUCCESS);

        assertThat(result).hasTotalSize(0);
        assertThat(result).hasErrorMessages("Skipping file 'zero_length_file.xml' because it's empty.");
    }

    /**
     * Runs the {@link FilesScanner} on a workspace with files that do not match the file pattern.
     */
    @Test
    public void filePatternDoesNotMatchAnyFile() {
        FreeStyleProject project = createCheckStyleJob(NO_FILE_PATTERN_MATCH_WORKSPACE);
        
        AnalysisResult result = scheduleBuildAndAssertStatus(project, Result.SUCCESS);

        assertThat(result).hasTotalSize(0);
        assertThat(result).hasErrorMessages("No files found for pattern '*.xml'. Configuration error?");
    }

    /**
     * Runs the {@link FilesScanner} on a workspace with multiple files where some do match the criteria.
     * 
     * @see <a href="http://issues.jenkins-ci.org/browse/JENKINS-51588">Issue 51588</a>
     */
    @Test 
    public void findIssuesWithMultipleFiles() {
        FreeStyleProject project = createJobWithWorkspaceFile(MULTIPLE_FILES_WORKSPACE);
        IssuesRecorder recorder = enableWarnings(project, new ToolConfiguration(new CheckStyle(), "*.xml"));
        recorder.setFailedTotalAll(6);

        AnalysisResult result = scheduleBuildAndAssertStatus(project, Result.FAILURE);

        assertThat(result).hasTotalSize(6);
        assertThat(result).hasQualityGateStatus(QualityGateStatus.FAILED);
        assertThat(result).hasInfoMessages(
                "Successfully parsed file " + getCheckStyleFile(project),
                "-> found 6 issues (skipped 0 duplicates)",
                "-> found 2 files");
        assertThat(result).hasErrorMessages("Skipping file 'zero_length_file.xml' because it's empty.");
    }

    /**
     * Runs the {@link FilesScanner} on a workspace with a correct file that can be parsed.
     */
    @Test
    public void parseCheckstyleFileCorrectly() {
        FreeStyleProject project = createCheckStyleJob(CHECKSTYLE_WORKSPACE);

        AnalysisResult result = scheduleBuildAndAssertStatus(project, Result.SUCCESS);
        
        assertThat(result).hasTotalSize(6);
        assertThat(result).hasInfoMessages(
                "Successfully parsed file " + getCheckStyleFile(project),
                "-> found 6 issues (skipped 0 duplicates)",
                "-> found 1 file");
    }

    private String getCheckStyleFile(final FreeStyleProject project) {
        return project.getSomeWorkspace().getRemote() + File.separator + "checkstyle.xml";
    }

    private FreeStyleProject createCheckStyleJob(final String workspaceFolder) {
        FreeStyleProject project = createJobWithWorkspaceFile(workspaceFolder);
        enableWarnings(project, new ToolConfiguration(new CheckStyle(), "*.xml"));
        return project;
    }

    /**
     * Creates a new free style project and copies a whole directory to the workspace of the project.
     *
     * @param importDirectory
     *         directory containing the resources
     *
     * @return created {@link FreeStyleProject}
     */
    private FreeStyleProject createJobWithWorkspaceFile(final String importDirectory) {
        try {
            FreeStyleProject job = getJenkins().createFreeStyleProject();
            copyDirectoryToWorkspace(job, importDirectory);

            return job;
        }
        catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
