/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.cosmosdb.implementation;

import com.microsoft.azure.management.cosmosdb.UnitType;
import com.microsoft.azure.management.cosmosdb.MetricName;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The usage data for a usage request.
 */
public class UsageInner {
    /**
     * The unit of the metric. Possible values include: 'Count', 'Bytes',
     * 'Seconds', 'Percent', 'CountPerSecond', 'BytesPerSecond',
     * 'Milliseconds'.
     */
    @JsonProperty(value = "unit")
    private UnitType unit;

    /**
     * The name information for the metric.
     */
    @JsonProperty(value = "name", access = JsonProperty.Access.WRITE_ONLY)
    private MetricName name;

    /**
     * The quota period used to summarize the usage values.
     */
    @JsonProperty(value = "quotaPeriod", access = JsonProperty.Access.WRITE_ONLY)
    private String quotaPeriod;

    /**
     * Maximum value for this metric.
     */
    @JsonProperty(value = "limit", access = JsonProperty.Access.WRITE_ONLY)
    private Integer limit;

    /**
     * Current value for this metric.
     */
    @JsonProperty(value = "currentValue", access = JsonProperty.Access.WRITE_ONLY)
    private Integer currentValue;

    /**
     * Get the unit value.
     *
     * @return the unit value
     */
    public UnitType unit() {
        return this.unit;
    }

    /**
     * Set the unit value.
     *
     * @param unit the unit value to set
     * @return the UsageInner object itself.
     */
    public UsageInner withUnit(UnitType unit) {
        this.unit = unit;
        return this;
    }

    /**
     * Get the name value.
     *
     * @return the name value
     */
    public MetricName name() {
        return this.name;
    }

    /**
     * Get the quotaPeriod value.
     *
     * @return the quotaPeriod value
     */
    public String quotaPeriod() {
        return this.quotaPeriod;
    }

    /**
     * Get the limit value.
     *
     * @return the limit value
     */
    public Integer limit() {
        return this.limit;
    }

    /**
     * Get the currentValue value.
     *
     * @return the currentValue value
     */
    public Integer currentValue() {
        return this.currentValue;
    }

}
