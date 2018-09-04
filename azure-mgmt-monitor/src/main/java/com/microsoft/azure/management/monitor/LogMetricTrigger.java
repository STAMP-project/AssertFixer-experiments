/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.monitor;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A log metrics trigger descriptor.
 */
public class LogMetricTrigger {
    /**
     * Evaluation operation for Metric -'GreaterThan' or 'LessThan' or 'Equal'.
     * Possible values include: 'GreaterThan', 'LessThan', 'Equal'.
     */
    @JsonProperty(value = "thresholdOperator")
    private ConditionalOperator thresholdOperator;

    /**
     * The threshold of the metric trigger.
     */
    @JsonProperty(value = "threshold")
    private Double threshold;

    /**
     * Metric Trigger Type - 'Consecutive' or 'Total'. Possible values include:
     * 'Consecutive', 'Total'.
     */
    @JsonProperty(value = "metricTriggerType")
    private MetricTriggerType metricTriggerType;

    /**
     * Evaluation of metric on a particular column.
     */
    @JsonProperty(value = "metricColumn")
    private String metricColumn;

    /**
     * Get evaluation operation for Metric -'GreaterThan' or 'LessThan' or 'Equal'. Possible values include: 'GreaterThan', 'LessThan', 'Equal'.
     *
     * @return the thresholdOperator value
     */
    public ConditionalOperator thresholdOperator() {
        return this.thresholdOperator;
    }

    /**
     * Set evaluation operation for Metric -'GreaterThan' or 'LessThan' or 'Equal'. Possible values include: 'GreaterThan', 'LessThan', 'Equal'.
     *
     * @param thresholdOperator the thresholdOperator value to set
     * @return the LogMetricTrigger object itself.
     */
    public LogMetricTrigger withThresholdOperator(ConditionalOperator thresholdOperator) {
        this.thresholdOperator = thresholdOperator;
        return this;
    }

    /**
     * Get the threshold of the metric trigger.
     *
     * @return the threshold value
     */
    public Double threshold() {
        return this.threshold;
    }

    /**
     * Set the threshold of the metric trigger.
     *
     * @param threshold the threshold value to set
     * @return the LogMetricTrigger object itself.
     */
    public LogMetricTrigger withThreshold(Double threshold) {
        this.threshold = threshold;
        return this;
    }

    /**
     * Get metric Trigger Type - 'Consecutive' or 'Total'. Possible values include: 'Consecutive', 'Total'.
     *
     * @return the metricTriggerType value
     */
    public MetricTriggerType metricTriggerType() {
        return this.metricTriggerType;
    }

    /**
     * Set metric Trigger Type - 'Consecutive' or 'Total'. Possible values include: 'Consecutive', 'Total'.
     *
     * @param metricTriggerType the metricTriggerType value to set
     * @return the LogMetricTrigger object itself.
     */
    public LogMetricTrigger withMetricTriggerType(MetricTriggerType metricTriggerType) {
        this.metricTriggerType = metricTriggerType;
        return this;
    }

    /**
     * Get evaluation of metric on a particular column.
     *
     * @return the metricColumn value
     */
    public String metricColumn() {
        return this.metricColumn;
    }

    /**
     * Set evaluation of metric on a particular column.
     *
     * @param metricColumn the metricColumn value to set
     * @return the LogMetricTrigger object itself.
     */
    public LogMetricTrigger withMetricColumn(String metricColumn) {
        this.metricColumn = metricColumn;
        return this;
    }

}
