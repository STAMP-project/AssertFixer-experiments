package io.jenkins.plugins.analysis.core.steps;

import javax.annotation.CheckForNull;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import edu.hm.hafner.analysis.Severity;
import edu.hm.hafner.util.VisibleForTesting;
import io.jenkins.plugins.analysis.core.JenkinsFacade;

import hudson.util.ComboBoxModel;
import hudson.util.FormValidation;
import hudson.util.ListBoxModel;

/**
 * Validates all properties of a configuration of a static analysis tool in a job. 
 *
 * @author Ullrich Hafner
 */
public class JobConfigurationModel {
    /** All available character sets. */
    private static final Set<String> ALL_CHARSETS = Charset.availableCharsets().keySet();

    @VisibleForTesting
    static final String NO_REFERENCE_JOB = "-";

    private final JenkinsFacade jenkins;

    /** Creates a new descriptor. */
    public JobConfigurationModel() {
        this(new JenkinsFacade());
    }

    @VisibleForTesting
    JobConfigurationModel(final JenkinsFacade jenkins) {
        super();

        this.jenkins = jenkins;
    }

    /**
     * Returns all available character set names.
     *
     * @return all available character set names
     */
    public ComboBoxModel getAllCharsets() {
        return new ComboBoxModel(ALL_CHARSETS);
    }

    /**
     * Returns the default charset for the specified encoding string. If the default encoding is empty or {@code null},
     * or if the charset is not valid then the default encoding of the platform is returned.
     *
     * @param charset
     *         identifier of the character set
     *
     * @return the default charset for the specified encoding string
     */
    public Charset getCharset(@CheckForNull final String charset) {
        try {
            if (StringUtils.isNotBlank(charset)) {
                return Charset.forName(charset);
            }
        }
        catch (UnsupportedCharsetException | IllegalCharsetNameException exception) {
            // ignore and return default
        }
        return Charset.defaultCharset();
    }

    /**
     * Performs on-the-fly validation of the character encoding.
     *
     * @param reportEncoding
     *         the character encoding
     *
     * @return the validation result
     */
    public FormValidation validateCharset(final String reportEncoding) {
        try {
            if (StringUtils.isBlank(reportEncoding) || Charset.isSupported(reportEncoding)) {
                return FormValidation.ok();
            }
        }
        catch (IllegalCharsetNameException | UnsupportedCharsetException ignore) {
            // throw a FormValidation error
        }
        return FormValidation.errorWithMarkup(createWrongEncodingErrorMessage());
    }

    /**
     * Returns a model with all available severity filters.
     *
     * @return a model with all available severity filters
     */
    public ListBoxModel getAllSeverityFilters() {
        ListBoxModel options = new ListBoxModel();
        options.add(Messages.SeverityFilter_High(), Severity.WARNING_HIGH.getName());
        options.add(Messages.SeverityFilter_Normal(), Severity.WARNING_NORMAL.getName());
        options.add(Messages.SeverityFilter_Low(), Severity.WARNING_LOW.getName());
        return options;
    }

    /**
     * Returns the model with the possible reference jobs.
     *
     * @return the model with the possible reference jobs
     */
    public ComboBoxModel getAllJobs() {
        ComboBoxModel model = new ComboBoxModel(jenkins.getAllJobs());
        model.add(0, NO_REFERENCE_JOB); // make sure that no input is valid
        return model;
    }

    /**
     * Performs on-the-fly validation of the reference job.
     *
     * @param referenceJobName
     *         the reference job
     *
     * @return the validation result
     */
    public FormValidation validateJob(final String referenceJobName) {
        if (NO_REFERENCE_JOB.equals(referenceJobName)
                || StringUtils.isBlank(referenceJobName)
                || jenkins.getJob(referenceJobName).isPresent()) {
            return FormValidation.ok();
        }
        return FormValidation.error(Messages.FieldValidator_Error_ReferenceJobDoesNotExist());
    }

    @VisibleForTesting
    static String createWrongEncodingErrorMessage() {
        return Messages.FieldValidator_Error_DefaultEncoding(
                "https://docs.oracle.com/javase/8/docs/api/java/nio/charset/Charset.html");
    }

    /**
     * Performs on-the-fly validation of the health report thresholds.
     *
     * @param healthy
     *         the healthy threshold
     * @param unhealthy
     *         the unhealthy threshold
     *
     * @return the validation result
     */
    public FormValidation validateHealthy(final int healthy, final int unhealthy) {
        if (healthy == 0 && unhealthy > 0) {
            return FormValidation.error(Messages.FieldValidator_Error_ThresholdHealthyMissing());
        }
        return validateHealthReportConstraints(healthy, healthy, unhealthy);
    }

    /**
     * Performs on-the-fly validation of the health report thresholds.
     *
     * @param healthy
     *         the healthy threshold
     * @param unhealthy
     *         the unhealthy threshold
     *
     * @return the validation result
     */
    public FormValidation validateUnhealthy(final int healthy, final int unhealthy) {
        if (healthy > 0 && unhealthy == 0) {
            return FormValidation.error(Messages.FieldValidator_Error_ThresholdUnhealthyMissing());
        }
        return validateHealthReportConstraints(unhealthy, healthy, unhealthy);
    }

    private FormValidation validateHealthReportConstraints(final int nonNegative,
            final int healthy, final int unhealthy) {
        if (nonNegative < 0) {
            return FormValidation.error(Messages.FieldValidator_Error_NegativeThreshold());
        }
        if (healthy == 0 && unhealthy == 0) {
            return FormValidation.ok();
        }
        if (healthy >= unhealthy) {
            return FormValidation.error(Messages.FieldValidator_Error_ThresholdOrder());
        }
        return FormValidation.ok();
    }

}
