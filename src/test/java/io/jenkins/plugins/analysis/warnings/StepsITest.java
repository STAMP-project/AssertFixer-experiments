package io.jenkins.plugins.analysis.warnings;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.collections.impl.factory.Lists;
import org.jenkinsci.plugins.workflow.job.WorkflowJob;
import org.jenkinsci.plugins.workflow.job.WorkflowRun;
import org.junit.Assume;
import org.junit.Test;
import org.jvnet.hudson.test.TestExtension;
import org.kohsuke.stapler.HttpResponse;

import edu.hm.hafner.analysis.Issue;
import edu.hm.hafner.analysis.Report;
import static edu.hm.hafner.analysis.assertj.Assertions.*;
import static hudson.Functions.*;
import io.jenkins.plugins.analysis.core.model.AnalysisResult;
import io.jenkins.plugins.analysis.core.model.StaticAnalysisTool;
import io.jenkins.plugins.analysis.core.steps.PublishIssuesStep;
import io.jenkins.plugins.analysis.core.steps.ScanForIssuesStep;
import io.jenkins.plugins.analysis.core.testutil.IntegrationTestWithJenkinsPerTest;
import io.jenkins.plugins.analysis.core.views.ResultAction;
import io.jenkins.plugins.analysis.warnings.groovy.GroovyParser;
import io.jenkins.plugins.analysis.warnings.groovy.ParserConfiguration;

import hudson.model.UnprotectedRootAction;
import hudson.util.HttpResponses;

/**
 * Integration tests of the warnings plug-in in pipelines.
 *
 * @author Ullrich Hafner
 * @see ScanForIssuesStep
 * @see PublishIssuesStep
 */
public class StepsITest extends IntegrationTestWithJenkinsPerTest {
    /**
     * Creates a JenkinsFile with parallel steps and aggregates the warnings.
     */
    @Test
    public void shouldRecordOutputOfParallelSteps() {
        WorkflowJob job = createJob();

        copySingleFileToWorkspace(createAgent("node1"), job, "eclipse.txt", "issues.txt");
        copySingleFileToWorkspace(createAgent("node2"), job, "eclipse.txt", "issues.txt");

        job.setDefinition(readDefinition("parallel.jenkinsfile"));

        WorkflowRun run = runSuccessfully(job);
        List<ResultAction> actions = run.getActions(ResultAction.class);

        assertThat(actions).hasSize(2);

        ResultAction first;
        ResultAction second;
        if (actions.get(0).getId().equals("java-1")) {
            first = actions.get(0);
            second = actions.get(1);
        }
        else {
            first = actions.get(1);
            second = actions.get(0);
        }

        assertThat(first.getResult().getIssues()).hasSize(5);
        assertThat(second.getResult().getIssues()).hasSize(3);
    }

    /**
     * Runs the Eclipse parser on the console log that contains 8 issues which are decorated with console notes. The
     * output file is copied to the console log using a shell cat command.
     *
     * @see <a href="http://issues.jenkins-ci.org/browse/JENKINS-11675">Issue 11675</a>
     */
    @Test
    public void issue11675() {
        Assume.assumeFalse("Test not yet OS independent: requires UNIX commands", isWindows());

        WorkflowJob job = createJobWithWorkspaceFiles("issue11675.txt");
        job.setDefinition(asStage(
                "sh 'cat issue11675-issues.txt'",
                "def issues = scanForIssues tool: [$class: 'Eclipse']",
                PUBLISH_ISSUES_STEP));

        AnalysisResult result = scheduleBuild(job, Eclipse.class);

        assertThat(result.getTotalSize()).isEqualTo(8);
        assertThat(result.getIssues()).hasSize(8);

        Report report = result.getIssues();
        assertThat(report.filter(issue -> "eclipse".equals(issue.getOrigin()))).hasSize(8);
        for (Issue annotation : report) {
            assertThat(annotation.getMessage()).matches("[a-zA-Z].*");
        }
    }

    /** Runs the all Java parsers on three output files: the build should report issues of all tools. */
    @Test
    public void shouldCombineIssuesOfSeveralFiles() {
        publishResultsWithIdAndName(
                "publishIssues issues:[java, eclipse, javadoc]",
                "java", "Java Warnings");
    }

    /**
     * Runs the all Java parsers on three output files: the build should report issues of all tools. The results should
     * be aggregated into a new action with the specified ID. Since no name is given the default name is used.
     */
    @Test
    public void shouldProvideADefaultNameIfNoOneIsGiven() {
        publishResultsWithIdAndName(
                "publishIssues issues:[java, eclipse, javadoc], id:'my-id'",
                "my-id", "Static Analysis Warnings");
    }

    /**
     * Runs the all Java parsers on three output files: the build should report issues of all tools. The results should
     * be aggregated into a new action with the specified ID and the specified name.
     */
    @Test
    public void shouldUseSpecifiedName() {
        publishResultsWithIdAndName(
                "publishIssues issues:[java, eclipse, javadoc], id:'my-id', name:'my-name'",
                "my-id", "my-name");
    }

    private void publishResultsWithIdAndName(final String publishStep, final String expectedId,
            final String expectedName) {
        WorkflowJob job = createJobWithWorkspaceFiles("eclipse.txt", "javadoc.txt", "javac.txt");
        job.setDefinition(asStage(createScanForIssuesStep(Java.class, "java"),
                createScanForIssuesStep(Eclipse.class, "eclipse"),
                createScanForIssuesStep(JavaDoc.class, "javadoc"),
                publishStep));

        WorkflowRun run = runSuccessfully(job);

        ResultAction action = getResultAction(run);
        assertThat(action.getId()).isEqualTo(expectedId);
        assertThat(action.getDisplayName()).contains(expectedName);

        assertThatJavaIssuesArePublished(action.getResult());
    }

    private void assertThatJavaIssuesArePublished(final AnalysisResult result) {
        Report report = result.getIssues();
        assertThat(report.filter(issue -> "eclipse".equals(issue.getOrigin()))).hasSize(8);
        assertThat(report.filter(issue -> "java".equals(issue.getOrigin()))).hasSize(2);
        assertThat(report.filter(issue -> "javadoc".equals(issue.getOrigin()))).hasSize(6);
        assertThat(report.getTools()).containsExactlyInAnyOrder("java", "javadoc", "eclipse");
        assertThat(result.getIssues()).hasSize(8 + 2 + 6);
    }

    /**
     * Runs the Java parser on an pep8 log file: the build should report no issues. A result should be available with
     * the java ID and name.
     */
    @Test
    public void shouldHaveActionWithIdAndNameWithEmptyResults() {
        WorkflowJob job = createJobWithWorkspaceFiles("pep8Test.txt");
        job.setDefinition(asStage(createScanForIssuesStep(Java.class, "java"),
                "publishIssues issues:[java]"));

        WorkflowRun run = runSuccessfully(job);

        ResultAction action = getResultAction(run);
        assertThat(action.getId()).isEqualTo("java");
        assertThat(action.getDisplayName()).contains(Messages.Warnings_JavaParser_ParserName());

        AnalysisResult result = action.getResult();
        assertThat(result.getIssues()).isEmpty();
    }

    /**
     * Registers a new {@link GroovyParser} (a Pep8 parser) in Jenkins global configuration and runs this parser on an
     * error log with 8 issues.
     */
    @Test
    public void shouldShowWarningsOfGroovyParser() {
        WorkflowJob job = createJobWithWorkspaceFiles("pep8Test.txt");
        job.setDefinition(asStage(
                "def groovy = scanForIssues tool: [$class: 'GroovyScript', id:'groovy-pep8'], "
                        + "pattern:'**/*issues.txt', defaultEncoding:'UTF-8'",
                "publishIssues issues:[groovy]"));

        ParserConfiguration configuration = ParserConfiguration.getInstance();
        String id = "groovy-pep8";
        configuration.setParsers(Collections.singletonList(
                new GroovyParser(id, "Groovy Pep8",
                        "(.*):(\\d+):(\\d+): (\\D\\d*) (.*)",
                        toString("groovy/pep8.groovy"), "")));
        WorkflowRun run = runSuccessfully(job);

        ResultAction action = getResultAction(run);
        assertThat(action.getId()).isEqualTo(id);
        assertThat(action.getDisplayName()).contains("Groovy Pep8");

        AnalysisResult result = action.getResult();
        assertThat(result.getIssues()).hasSize(8);

        assertThat(result.getIssues()).hasId(id);
        assertThat(result.getIssues().getPropertyCount(Issue::getOrigin)).containsOnly(entry(id, 8));
    }
    
    /**
     * Registers a new {@link GroovyParser} (a Pep8 parser) in Jenkins global configuration and uses this parser twice.
     */
    @Test 
    public void shouldUseGroovyParserTwice() {
        WorkflowJob job = createJobWithWorkspaceFiles("pep8Test.txt");
        job.setDefinition(asStage(
                "recordIssues tools: [" 
                        + "[pattern: '**/*issues.txt', id: 'groovy-1', tool: [$class: 'GroovyScript', id:'groovy-pep8']]," 
                        + "[pattern: '**/*issues.txt', id: 'groovy-2', tool: [$class: 'GroovyScript', id:'groovy-pep8']]" 
                        + "] "));
        ParserConfiguration configuration = ParserConfiguration.getInstance();
        String id = "groovy-pep8";
        configuration.setParsers(Collections.singletonList(
                new GroovyParser(id, "Groovy Pep8",
                        "(.*):(\\d+):(\\d+): (\\D\\d*) (.*)",
                        toString("groovy/pep8.groovy"), "")));
        WorkflowRun run = runSuccessfully(job);

        List<AnalysisResult> results = getAnalysisResults(run);
        assertThat(results).hasSize(2);

        Set<String> ids = results.stream().map(AnalysisResult::getId).collect(Collectors.toSet());
        assertThat(ids).containsExactly("groovy-1", "groovy-2");
    }

    /**
     * Runs the PMD parser on an output file that contains 16 issues. Applies file filters that select subsets of the
     * issues.
     */
    @Test
    public void shouldApplyFileFilters() {
        WorkflowJob job = createJobWithWorkspaceFiles("pmd-filtering.xml");

        setFilter(job, "includeFile('File.*.java')");
        assertThat(scheduleBuild(job, Pmd.class).getTotalSize()).isEqualTo(16);

        setFilter(job, "excludeFile('File.*.java')");
        assertThat(scheduleBuild(job, Pmd.class).getTotalSize()).isZero();

        setFilter(job, "includeFile('')");
        assertThat(scheduleBuild(job, Pmd.class).getTotalSize()).isEqualTo(16);

        setFilter(job, "excludeFile('')");
        assertThat(scheduleBuild(job, Pmd.class).getTotalSize()).isEqualTo(16);

        setFilter(job, "");
        assertThat(scheduleBuild(job, Pmd.class).getTotalSize()).isEqualTo(16);

        verifyIncludeFile(job, "File1.java");
        verifyIncludeFile(job, "File2.java");
        verifyExcludeFile(job, "File1.java", "File2.java");
        verifyExcludeFile(job, "File2.java", "File1.java");
    }

    /**
     * Runs the PMD parser on an output file that contains 16 issues. Combines file filters that select 1 issue
     */
    @Test
    public void shouldCombineFilter() {
        WorkflowJob job = createJobWithWorkspaceFiles("pmd-filtering.xml");

        setFilter(job, "includeFile('File1.java'), includeCategory('Category1')");
        AnalysisResult result = scheduleBuild(job, Pmd.class);
        assertThat(result.getTotalSize()).isEqualTo(8 + 4);

        setFilter(job, "includeFile('File1.java'), excludeCategory('Category1'), excludeType('Type1'), excludeNamespace('.*package1') ");
        AnalysisResult oneIssue = scheduleBuild(job, Pmd.class);
        assertThat(oneIssue.getIssues().getFiles()).containsExactly("File1.java");
        assertThat(oneIssue.getIssues().getCategories()).containsExactly("Category2");
        assertThat(oneIssue.getIssues().getTypes()).containsExactly("Type2");
        assertThat(oneIssue.getIssues().getPackages()).containsExactly("hm.edu.hafner.package2");
    }

    private void verifyIncludeFile(final WorkflowJob job, final String fileName) {
        setFilter(job, "includeFile('" + fileName + "')");
        
        AnalysisResult result = scheduleBuild(job, Pmd.class);
        
        assertThat(result.getTotalSize()).isEqualTo(8);
        assertThat(result.getIssues().getFiles()).containsExactly(fileName);
    }

    private void verifyExcludeFile(final WorkflowJob job, final String excludedFileName, final String expectedFileName) {
        setFilter(job, "excludeFile('" + excludedFileName + "')");
        
        AnalysisResult result = scheduleBuild(job, Pmd.class);
        
        assertThat(result.getTotalSize()).isEqualTo(8);
        assertThat(result.getIssues().getFiles()).containsExactly(expectedFileName);
    }

    private void setFilter(final WorkflowJob job, final String filters) {
        job.setDefinition(asStage(createScanForIssuesStep(Pmd.class),
                String.format("publishIssues issues:[issues], filters:[%s]", filters)));
    }

    /**
     * Creates a reference job and starts the analysis for this job. Then another job is created that uses the first one
     * as reference. Verifies that the association is correctly stored.
     */
    @Test
    public void shouldUseOtherJobAsReference() {
        WorkflowJob reference = createJob("reference");
        copyMultipleFilesToWorkspaceWithSuffix(reference, "java-start.txt");
        reference.setDefinition(parseAndPublish(Java.class));

        AnalysisResult referenceResult = scheduleBuild(reference, Java.class);

        assertThat(referenceResult.getTotalSize()).isEqualTo(2);
        assertThat(referenceResult.getIssues()).hasSize(2);
        assertThat(referenceResult.getReferenceBuild()).isEmpty();

        WorkflowJob job = createJobWithWorkspaceFiles("java-start.txt");
        job.setDefinition(asStage(createScanForIssuesStep(Java.class),
                "publishIssues issues:[issues], referenceJobName:'reference'"));

        AnalysisResult result = scheduleBuild(reference, Java.class);

        assertThat(result.getTotalSize()).isEqualTo(2);
        assertThat(result.getIssues()).hasSize(2);
        assertThat(result.getReferenceBuild()).hasValue(referenceResult.getOwner());

        // TODO: add verification for io.jenkins.plugins.analysis.core.model.IssueDifference
    }

    /**
     * Verifies that parsers based on Digester are not vulnerable to an XXE attack. Previous versions allowed any user
     * with an ability to configure a job to read any file from the Jenkins Master (even on hardened systems where
     * execution on master is disabled).
     *
     * @see <a href="https://jenkins.io/security/advisory/2018-01-22/">Jenkins Security Advisory 2018-01-22</a>
     */
    @Test
    public void showPreventXxeSecurity656() {
        String oobInUserContentLink = getUrl("userContent/oob.xml");
        String triggerLink = getUrl("triggerMe");

        String xxeFileContent = toString("testXxe-xxe.xml");
        String oobFileContent = toString("testXxe-oob.xml");

        write(oobFileContent.replace("$TARGET_URL$", triggerLink));

        WorkflowJob job = createJob();
        String adaptedXxeFileContent = xxeFileContent.replace("$OOB_LINK$", oobInUserContentLink);
        createFileInWorkspace(job, "xxe.xml", adaptedXxeFileContent);

        List<Class<? extends StaticAnalysisTool>> classes = Lists.mutable.of(CheckStyle.class, Pmd.class,
                FindBugs.class, JcReport.class);
        for (Class<? extends StaticAnalysisTool> tool : classes) {
            job.setDefinition(asStage(
                    String.format("def issues = scanForIssues tool: [$class: '%s'], pattern:'xxe.xml'",
                            tool.getSimpleName()),
                    "publishIssues issues:[issues]"));

            scheduleBuild(job, tool);

            YouCannotTriggerMe urlHandler = getJenkins().jenkins.getExtensionList(UnprotectedRootAction.class)
                    .get(YouCannotTriggerMe.class);
            assertThat(urlHandler).isNotNull();

            assertThat(urlHandler.triggerCount).as("XXE detected for parser %s: URL has been triggered!", tool)
                    .isEqualTo(0);
        }
    }

    private void write(final String adaptedOobFileContent) {
        try {
            File userContentDir = new File(getJenkins().jenkins.getRootDir(), "userContent");
            Files.write(new File(userContentDir, "oob.xml").toPath(), adaptedOobFileContent.getBytes());
        }
        catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    private String getUrl(final String relative) {
        try {
            return getJenkins().getURL() + relative;
        }
        catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    /**
     * Extension that should not be triggered.
     *
     * @see StepsITest#showPreventXxeSecurity656
     */
    @TestExtension
    public static class YouCannotTriggerMe implements UnprotectedRootAction {
        private int triggerCount = 0;

        @Override
        public String getIconFileName() {
            return null;
        }

        @Override
        public String getDisplayName() {
            return null;
        }

        @Override
        public String getUrlName() {
            return "triggerMe";
        }

        /**
         * Should not be invoked by the test, otherwise Xxe attack is successful.
         *
         * @return the response
         */
        public HttpResponse doIndex() {
            triggerCount++;
            return HttpResponses.text("triggered");
        }
    }
}
