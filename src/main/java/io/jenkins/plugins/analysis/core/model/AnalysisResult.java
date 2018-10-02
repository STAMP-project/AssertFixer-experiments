package io.jenkins.plugins.analysis.core.model; // NOPMD

import javax.annotation.CheckForNull;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Maps;

import edu.hm.hafner.analysis.Issue;
import edu.hm.hafner.analysis.Report;
import edu.hm.hafner.analysis.Severity;
import edu.hm.hafner.util.VisibleForTesting;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import io.jenkins.plugins.analysis.core.JenkinsFacade;
import io.jenkins.plugins.analysis.core.quality.AnalysisBuild;
import io.jenkins.plugins.analysis.core.quality.QualityGate;
import io.jenkins.plugins.analysis.core.quality.QualityGateStatus;
import io.jenkins.plugins.analysis.core.scm.Blames;

import hudson.XmlFile;
import hudson.model.Run;
import hudson.util.XStream2;

/**
 * Stores the results of a static analysis run. Provides support for persisting the results of the build and loading and
 * saving of issues (all, new, and fixed) and delta computation.
 *
 * @author Ullrich Hafner
 */
@SuppressFBWarnings(value = "SE", justification = "transient fields are restored using a Jenkins callback (or are checked for null)")
@SuppressWarnings({"PMD.TooManyFields", "PMD.ExcessiveClassLength"})
public class AnalysisResult implements Serializable {
    private static final long serialVersionUID = 1110545450292087475L;

    private static final Logger LOGGER = Logger.getLogger(AnalysisResult.class.getName());
    private static final Pattern ISSUES_FILE_NAME = Pattern.compile("issues.xml", Pattern.LITERAL);
    private static final int NO_BUILD = -1;
    private static final String NO_REFERENCE = StringUtils.EMPTY;

    private final String id;
    private final int size;
    private final int newSize;
    private final int fixedSize;
    private final Map<String, Integer> sizePerOrigin;
    private final Map<Severity, Integer> sizePerSeverity;
    private final Map<Severity, Integer> newSizePerSeverity;
    private final List<String> errors;
    private final List<String> messages;
    /**
     * Reference run to compute the issues difference: since a run cannot be persisted directly, the IDs are only
     * stored.
     */
    private final String referenceBuildId;

    private transient ReentrantLock lock = new ReentrantLock();
    private transient Run<?, ?> owner;

    /**
     * All outstanding issues: i.e. all issues, that are part of the current and reference report.
     */
    @CheckForNull
    private transient WeakReference<Report> outstandingIssuesReference;
    /**
     * All new issues: i.e. all issues, that are part of the current report but have not been shown up in the reference
     * report.
     */
    @CheckForNull
    private transient WeakReference<Report> newIssuesReference;
    /**
     * All fixed issues: i.e. all issues, that are part of the reference report but are not present in the current
     * report anymore.
     */
    @CheckForNull
    private transient WeakReference<Report> fixedIssuesReference;
    /** All SCM blames. Provides a mapping of file names to SCM commit information like author, email or commit ID. */
    @CheckForNull
    private transient WeakReference<Blames> blamesReference;

    /** Determines since which build we have zero warnings. */
    private int noIssuesSinceBuild;
    /** Determines since which build the result is successful. */
    private int successfulSinceBuild;
    /** The result of the quality gate evaluation. */
    private final QualityGateStatus qualityGateStatus;

    /**
     * Creates a new instance of {@link AnalysisResult}.
     *
     * @param owner
     *         the current build as owner of this action
     * @param report
     *         the issues of this result
     * @param blames
     *         author and commit information for all issues
     * @param qualityGateStatus
     *         the quality gate status
     * @param previousResult
     *         the analysis result of the previous run
     */
    public AnalysisResult(final Run<?, ?> owner, final DeltaReport report, final Blames blames,
            final QualityGateStatus qualityGateStatus, final AnalysisResult previousResult) {
        this(owner, report, blames, qualityGateStatus, true);

        if (report.isEmpty()) {
            if (previousResult.noIssuesSinceBuild == NO_BUILD) {
                noIssuesSinceBuild = owner.getNumber();
            }
            else {
                noIssuesSinceBuild = previousResult.noIssuesSinceBuild;
            }
        }
        else {
            noIssuesSinceBuild = NO_BUILD;
        }

        if (this.qualityGateStatus == QualityGateStatus.PASSED) {
            if (previousResult.qualityGateStatus == QualityGateStatus.PASSED) {
                successfulSinceBuild = previousResult.successfulSinceBuild;
            }
            else {
                successfulSinceBuild = owner.getNumber();
            }
        }
        else {
            successfulSinceBuild = NO_BUILD;
        }
    }

    /**
     * Creates a new instance of {@link AnalysisResult}.
     *
     * @param owner
     *         the current build as owner of this action
     * @param report
     *         the issues of this result
     * @param blames
     *         author and commit information for all issues
     * @param qualityGateStatus
     *         the quality gate status
     */
    public AnalysisResult(final Run<?, ?> owner, 
            final DeltaReport report, final Blames blames, final QualityGateStatus qualityGateStatus) {
        this(owner, report, blames, qualityGateStatus, true);

        if (report.isEmpty()) {
            noIssuesSinceBuild = owner.getNumber();
        }
        else {
            noIssuesSinceBuild = NO_BUILD;
        }
        if (this.qualityGateStatus == QualityGateStatus.PASSED) {
            successfulSinceBuild = owner.getNumber();
        }
        else {
            successfulSinceBuild = NO_BUILD;
        }
    }

    /**
     * Creates a new instance of {@link AnalysisResult}.
     *
     * @param owner
     *         the current run as owner of this action
     * @param report
     *         the issues of this result
     * @param blames
     *         author and commit information for all issues
     * @param qualityGateStatus
     *         the quality gate to enforce
     * @param canSerialize
     *         determines whether the result should be persisted in the build folder
     */
    @VisibleForTesting
    protected AnalysisResult(final Run<?, ?> owner, final DeltaReport report, final Blames blames, 
            final QualityGateStatus qualityGateStatus, final boolean canSerialize) {
        this.owner = owner;

        Report allIssues = report.getAllIssues();
        id = allIssues.getId();
        size = allIssues.getSize();
        sizePerOrigin = new HashMap<>(allIssues.getSizeByOrigin());
        sizePerSeverity = getSizePerSeverity(allIssues);
        referenceBuildId = report.getReferenceBuildId();

        Report outstandingIssues = report.getOutstandingIssues();
        outstandingIssuesReference = new WeakReference<>(outstandingIssues);

        Report newIssues = report.getNewIssues();
        newSize = newIssues.getSize();
        newSizePerSeverity = getSizePerSeverity(newIssues);
        newIssuesReference = new WeakReference<>(newIssues);

        Report fixedIssues = report.getFixedIssues();
        fixedSize = fixedIssues.size();
        fixedIssuesReference = new WeakReference<>(fixedIssues);

        List<String> aggregatedMessages = new ArrayList<>(allIssues.getInfoMessages().castToList());

        this.messages = new ArrayList<>(aggregatedMessages);
        errors = new ArrayList<>(allIssues.getErrorMessages().castToList());

        this.qualityGateStatus = qualityGateStatus;
        
        this.blamesReference = new WeakReference<>(blames);
        if (canSerialize) {
            serializeIssues(outstandingIssues, newIssues, fixedIssues);
            serializeBlames(blames);
        }
    }

    /**
     * Returns the blames for the report.
     *
     * @return the blames
     */
    public Blames getBlames() {
        lock.lock();
        try {
            if (blamesReference == null) {
                return readBlames();
            }
            Blames result = blamesReference.get();
            if (result == null) {
                return readBlames();
            }
            return result;
        }
        finally {
            lock.unlock();
        }
    }

    private void serializeBlames(final Blames blames) {
        try {
            getBlamesFile().write(blames);
        }
        catch (IOException exception) {
            LOGGER.log(Level.SEVERE,
                    String.format("Failed to serialize SCM blame information for results %s in build %s.",
                            id, owner), exception);
        }
    }

    private XmlFile getBlamesFile() {
        return new XmlFile(new XStream2(), new File(getOwner().getRootDir(), id + "-blames.xml"));
    }

    private Blames readBlames() {
        Blames blames = readXml(Blames.class, getBlamesFile(), new Blames());
        blamesReference = new WeakReference<>(blames);
        return blames;
    }

    private <T> T readXml(final Class<T> type, final XmlFile dataFile, final T defaultValue) {
        try {
            Object deserialized = dataFile.read();

            if (type.isInstance(deserialized)) {
                if (LOGGER.isLoggable(Level.FINE)) {
                    LOGGER.log(Level.FINE, "Loaded data file " + dataFile + " for run " + getOwner());
                }
                return type.cast(deserialized);
            }
            if (LOGGER.isLoggable(Level.SEVERE)) {
                LOGGER.log(Level.SEVERE, "Failed to load " + dataFile + ", wrong type: " + deserialized);
            }
        }
        catch (IOException exception) {
            if (LOGGER.isLoggable(Level.SEVERE)) {
                LOGGER.log(Level.SEVERE, "Failed to load " + dataFile, exception);
            }
        }
        return defaultValue; // fallback
    }

    private Map<Severity, Integer> getSizePerSeverity(final Report report) {
        return new HashMap<>(report.getPropertyCount(Issue::getSeverity));
    }

    /**
     * Returns the ID of the static analysis result.
     *
     * @return the ID
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the run that created this static analysis result.
     *
     * @return the run
     */
    public Run<?, ?> getOwner() {
        return owner;
    }

    /**
     * Sets the run for this result after Jenkins read its data from disk.
     *
     * @param owner
     *         the initialized run
     */
    public void setOwner(final Run<?, ?> owner) {
        this.owner = owner;
        lock = new ReentrantLock();
    }

    /**
     * Returns the error messages of the analysis run.
     *
     * @return the error messages
     */
    public ImmutableList<String> getErrorMessages() {
        return Lists.immutable.withAll(errors);
    }

    /**
     * Returns the info messages of the analysis run.
     *
     * @return the info messages
     */
    public ImmutableList<String> getInfoMessages() {
        return Lists.immutable.withAll(messages);
    }

    /**
     * Returns the serialization file for the fixed warnings.
     *
     * @param suffix
     *         suffix of the file
     *
     * @return the serialization file.
     */
    private XmlFile getDataFile(final String suffix) {
        return new XmlFile(new IssueStream().createStream(), new File(getOwner().getRootDir(),
                ISSUES_FILE_NAME.matcher(getSerializationFileName())
                        .replaceAll(Matcher.quoteReplacement(suffix + "-issues.xml"))));
    }

    private String getSerializationFileName() {
        return id + "-issues.xml";
    }

    private void serializeIssues(final Report outstandingIssues,
            final Report newIssues, final Report fixedIssues) {
        serializeIssues(outstandingIssues, "outstanding");
        serializeIssues(newIssues, "new");
        serializeIssues(fixedIssues, "fixed");
    }

    private void serializeIssues(final Report report, final String suffix) {
        try {
            getDataFile(suffix).write(report);
        }
        catch (IOException exception) {
            LOGGER.log(Level.SEVERE, String.format("Failed to serialize the %s issues of the build.", suffix),
                    exception);
        }
    }

    /**
     * Returns all issues of the associated static analysis run. These include outstanding issues as well as new
     * issues.
     *
     * @return all issues
     */
    public Report getIssues() {
        Report merged = new Report();
        merged.addAll(getNewIssues(), getOutstandingIssues());
        return merged;
    }

    /**
     * Returns all outstanding issues of the associated static analysis run. I.e. all issues, that are part of the
     * current and previous report.
     *
     * @return all outstanding issues
     */
    public Report getOutstandingIssues() {
        return getIssues(AnalysisResult::getOutstandingIssuesReference, AnalysisResult::setOutstandingIssuesReference,
                "outstanding");
    }

    /**
     * Returns all new issues of the associated static analysis run. I.e. all issues, that are part of the current
     * report but have not been shown up in the previous report.
     *
     * @return all new issues
     */
    public Report getNewIssues() {
        return getIssues(AnalysisResult::getNewIssuesReference, AnalysisResult::setNewIssuesReference,
                "new");
    }

    /**
     * Returns all fixed issues of the associated static analysis run. I.e. all issues, that are part of the previous
     * report but are not present in the current report anymore.
     *
     * @return all fixed issues
     */
    public Report getFixedIssues() {
        return getIssues(AnalysisResult::getFixedIssuesReference, AnalysisResult::setFixedIssuesReference,
                "fixed");
    }

    private WeakReference<Report> getOutstandingIssuesReference() {
        return outstandingIssuesReference;
    }

    private void setOutstandingIssuesReference(final WeakReference<Report> outstandingIssuesReference) {
        this.outstandingIssuesReference = outstandingIssuesReference;
    }

    private WeakReference<Report> getNewIssuesReference() {
        return newIssuesReference;
    }

    private void setNewIssuesReference(final WeakReference<Report> newIssuesReference) {
        this.newIssuesReference = newIssuesReference;
    }

    private WeakReference<Report> getFixedIssuesReference() {
        return fixedIssuesReference;
    }

    private void setFixedIssuesReference(final WeakReference<Report> fixedIssuesReference) {
        this.fixedIssuesReference = fixedIssuesReference;
    }

    private Report getIssues(final Function<AnalysisResult, WeakReference<Report>> getter,
            final BiConsumer<AnalysisResult, WeakReference<Report>> setter, final String suffix) {
        lock.lock();
        try {
            if (getter.apply(this) == null) {
                return readIssues(setter, suffix);
            }
            Report result = getter.apply(this).get();
            if (result == null) {
                return readIssues(setter, suffix);
            }
            return result;
        }
        finally {
            lock.unlock();
        }
    }

    private Report readIssues(final BiConsumer<AnalysisResult, WeakReference<Report>> setter,
            final String suffix) {
        XmlFile dataFile = getDataFile(suffix);
        Report report = readXml(Report.class, dataFile, new Report());
        setter.accept(this, new WeakReference<>(report));
        return report;
    }

    /**
     * Returns the build number since the associated job has no issues.
     *
     * @return the build number since there are no issues, or -1 if issues have been reported
     */
    public int getNoIssuesSinceBuild() {
        return noIssuesSinceBuild;
    }

    /**
     * Returns the build number since the associated job has a successful static analysis result.
     *
     * @return the build number since the static analysis result is successful, or -1 if the result is not successful
     */
    public int getSuccessfulSinceBuild() {
        return successfulSinceBuild;
    }

    /**
     * Returns whether the static analysis result is successful with respect to the defined {@link QualityGate}.
     *
     * @return {@code true} if the static analysis result is successful, {@code false} if the static analysis result is
     *         {@link QualityGateStatus#WARNING} or {@link QualityGateStatus#FAILED}
     */
    public boolean isSuccessful() {
        return qualityGateStatus.isSuccessful();
    }

    /**
     * Returns the {@link QualityGateStatus} of the {@link QualityGate} evaluation of the static analysis run.
     *
     * @return the quality gate status
     */
    public QualityGateStatus getQualityGateStatus() {
        return qualityGateStatus;
    }

    @Override
    public String toString() {
        return getId() + " : " + getTotalSize() + " issues";
    }

    /**
     * Returns the reference static analysis run that has been used to compute the new issues.
     *
     * @return the reference build
     */
    public Optional<Run<?, ?>> getReferenceBuild() {
        if (NO_REFERENCE.equals(referenceBuildId)) {
            return Optional.empty();
        }
        return new JenkinsFacade().getBuild(referenceBuildId);
    }

    /**
     * Returns the number of issues in this analysis run, mapped by their origin. The origin is the tool that created
     * the report.
     *
     * @return number of issues per origin
     */
    public Map<String, Integer> getSizePerOrigin() {
        return Maps.immutable.ofAll(sizePerOrigin).toMap();
    }

    /**
     * Returns the number of issues in this analysis run, mapped by {@link Severity}.
     *
     * @return number of issues per severity
     */
    public Map<Severity, Integer> getSizePerSeverity() {
        return Maps.immutable.ofAll(sizePerSeverity).toMap();
    }

    /**
     * Returns the new number of issues in this analysis run, mapped by {@link Severity}.
     *
     * @return number of issues per severity
     */
    public Map<Severity, Integer> getNewSizePerSeverity() {
        return Maps.immutable.ofAll(sizePerSeverity).toMap();
    }

    /**
     * Returns the associated build that this run was part of.
     *
     * @return the associated build
     */
    public AnalysisBuild getBuild() {
        return new RunAdapter(owner);
    }

    /**
     * Returns the total number of issues in this analysis run.
     *
     * @return total number of issues
     */
    public int getTotalSize() {
        return size;
    }

    /**
     * Returns the total number of issues in this analysis run that have the specified {@link Severity}.
     *
     * @param severity
     *         the severity of the issues to match
     *
     * @return total number of issues
     */
    public int getTotalSizeOf(final Severity severity) {
        return sizePerSeverity.getOrDefault(severity, 0);
    }

    /**
     * Returns the total number of errors in this analysis run.
     *
     * @return total number of errors
     */
    public int getTotalErrorsSize() {
        return getTotalSizeOf(Severity.ERROR);
    }

    /**
     * Returns the total number of high severity issues in this analysis run.
     *
     * @return total number of high severity issues
     */
    public int getTotalHighPrioritySize() {
        return getTotalSizeOf(Severity.WARNING_HIGH);
    }

    /**
     * Returns the total number of normal severity issues in this analysis run.
     *
     * @return total number of normal severity issues
     */
    public int getTotalNormalPrioritySize() {
        return getTotalSizeOf(Severity.WARNING_NORMAL);
    }

    /**
     * Returns the total number of low severity issues in this analysis run.
     *
     * @return total number of low severity of issues
     */
    public int getTotalLowPrioritySize() {
        return getTotalSizeOf(Severity.WARNING_LOW);
    }

    /**
     * Returns the number of new issues in this analysis run.
     *
     * @return number of new issues
     */
    public int getNewSize() {
        return newSize;
    }

    /**
     * Returns the new number of issues in this analysis run that have the specified {@link Severity}.
     *
     * @param severity
     *         the severity of the issues to match
     *
     * @return total number of issues
     */
    public int getNewSizeOf(final Severity severity) {
        return newSizePerSeverity.getOrDefault(severity, 0);
    }

    /**
     * Returns the number of new errors in this analysis run.
     *
     * @return number of new errors issues
     */
    public int getNewErrorSize() {
        return getNewSizeOf(Severity.ERROR);
    }

    /**
     * Returns the number of new high severity issues in this analysis run.
     *
     * @return number of new high severity issues
     */
    public int getNewHighPrioritySize() {
        return getNewSizeOf(Severity.WARNING_HIGH);
    }

    /**
     * Returns the number of new normal severity issues in this analysis run.
     *
     * @return number of new normal severity issues
     */
    public int getNewNormalPrioritySize() {
        return getNewSizeOf(Severity.WARNING_NORMAL);
    }

    /**
     * Returns the number of new low severity issues in this analysis run.
     *
     * @return number of new low severity of issues
     */
    public int getNewLowPrioritySize() {
        return getNewSizeOf(Severity.WARNING_LOW);
    }

    /**
     * Returns the number of fixed issues in this analysis run.
     *
     * @return number of fixed issues
     */
    public int getFixedSize() {
        return fixedSize;
    }

    /**
     * Wraps a Jenkins {@link Run} instance into an {@link AnalysisBuild}.
     */
    // TODO: if the trend charts are refactored then this adapter might be obsolete 
    public static class RunAdapter implements AnalysisBuild {
        private final Run<?, ?> run;

        /**
         * Creates a new instance of {@link RunAdapter}.
         *
         * @param run
         *         the run to wrap
         */
        public RunAdapter(final Run<?, ?> run) {
            this.run = run;
        }

        @Override
        public long getTimeInMillis() {
            return run.getTimeInMillis();
        }

        @Override
        public int getNumber() {
            return run.getNumber();
        }

        @Override
        public String getDisplayName() {
            return run.getDisplayName();
        }

        @Override
        public int compareTo(final AnalysisBuild o) {
            return getNumber() - o.getNumber();
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            RunAdapter that = (RunAdapter) o;

            return run.equals(that.run);
        }

        @Override
        public int hashCode() {
            return run.hashCode();
        }
    }
}
