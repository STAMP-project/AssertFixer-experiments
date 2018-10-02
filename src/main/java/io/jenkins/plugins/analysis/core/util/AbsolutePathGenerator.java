package io.jenkins.plugins.analysis.core.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import edu.hm.hafner.analysis.FilteredLog;
import edu.hm.hafner.analysis.Issue;
import edu.hm.hafner.analysis.Report;
import edu.hm.hafner.util.VisibleForTesting;
import io.jenkins.plugins.analysis.core.views.ConsoleDetail;

/**
 * Resolves absolute paths of the affected files of a set of issues.
 *
 * @author Ullrich Hafner
 */
public class AbsolutePathGenerator {
    static final String NOTHING_TO_DO = "-> affected files for all issues already have absolute paths";

    private final FileSystem fileSystem;

    /**
     * Creates a new instance of {@link AbsolutePathGenerator}.
     */
    public AbsolutePathGenerator() {
        this(new FileSystem());
    }

    @VisibleForTesting
    AbsolutePathGenerator(final FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    /**
     * Resolves absolute paths of the affected files of the specified set of issues.
     *
     * @param report
     *         the issues to resolve the paths
     * @param workspace
     *         the workspace containing the affected files
     */
    public void run(final Report report, final File workspace) {
        Set<String> relativeFileNames = report.getFiles()
                .stream()
                .filter(fileName -> fileSystem.isRelative(fileName) && !ConsoleDetail.isInConsoleLog(fileName))
                .collect(Collectors.toSet());

        if (relativeFileNames.isEmpty()) {
            report.logInfo(NOTHING_TO_DO);

            return;
        }

        Map<String, String> relativeToAbsoluteMapping = resolveAbsoluteNames(relativeFileNames, workspace);

        FilteredLog log = new FilteredLog(report, "Can't resolve absolute paths for some files:");
        int resolvedCount = 0;
        int unchangedCount = 0;
        for (Issue issue : report) {
            if (relativeToAbsoluteMapping.containsKey(issue.getFileName())) {
                String absoluteFileName = relativeToAbsoluteMapping.get(issue.getFileName());
                issue.setFileName(absoluteFileName);
                resolvedCount++;
            }
            else {
                if (relativeFileNames.contains(issue.getFileName())) {
                    log.logError("- %s", issue.getFileName());
                }
                else {
                    unchangedCount++;
                }
            }
        }

        report.logInfo("-> %d resolved, %d unresolved, %d already absolute", 
                resolvedCount, log.size(), unchangedCount);
        log.logSummary();
    }

    private Map<String, String> resolveAbsoluteNames(final Set<String> relativeFileNames, final File workspace) {
        Map<String, String> relativeToAbsoluteMapping = new HashMap<>();
        for (String fileName : relativeFileNames) {
            String absolute = fileSystem.resolveFile(fileName, workspace);
            if (!absolute.equals(fileName)) {
                relativeToAbsoluteMapping.put(fileName, absolute);
            }
        }
        return relativeToAbsoluteMapping;
    }

    /**
     * File system facade for test cases.
     */
    @VisibleForTesting
    static class FileSystem {
        String resolveFile(final String fileName, final File workspace) {
            try {
                Path path = workspace.toPath().resolve(fileName);
    
                return path.toAbsolutePath().normalize().toRealPath().toString();
            }
            catch (IOException e){
                return fileName; // fallback
            }
        }

        boolean isRelative(final String fileName) {
            try {
                return !Paths.get(fileName).isAbsolute();
            }
            catch (InvalidPathException ignored) {
                return false; // do not try to resolve illegal paths
            }
        }
    }
}
