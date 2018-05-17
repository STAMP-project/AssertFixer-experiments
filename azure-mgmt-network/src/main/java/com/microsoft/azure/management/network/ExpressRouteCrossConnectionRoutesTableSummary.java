/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The routes table associated with the ExpressRouteCircuit.
 */
public class ExpressRouteCrossConnectionRoutesTableSummary {
    /**
     * IP address of Neighbor router.
     */
    @JsonProperty(value = "neighbor")
    private String neighbor;

    /**
     * Autonomous system number.
     */
    @JsonProperty(value = "asn")
    private Integer asn;

    /**
     * The length of time that the BGP session has been in the Established
     * state, or the current status if not in the Established state.
     */
    @JsonProperty(value = "upDown")
    private String upDown;

    /**
     * Current state of the BGP session, and the number of prefixes that have
     * been received from a neighbor or peer group.
     */
    @JsonProperty(value = "stateOrPrefixesReceived")
    private String stateOrPrefixesReceived;

    /**
     * Get the neighbor value.
     *
     * @return the neighbor value
     */
    public String neighbor() {
        return this.neighbor;
    }

    /**
     * Set the neighbor value.
     *
     * @param neighbor the neighbor value to set
     * @return the ExpressRouteCrossConnectionRoutesTableSummary object itself.
     */
    public ExpressRouteCrossConnectionRoutesTableSummary withNeighbor(String neighbor) {
        this.neighbor = neighbor;
        return this;
    }

    /**
     * Get the asn value.
     *
     * @return the asn value
     */
    public Integer asn() {
        return this.asn;
    }

    /**
     * Set the asn value.
     *
     * @param asn the asn value to set
     * @return the ExpressRouteCrossConnectionRoutesTableSummary object itself.
     */
    public ExpressRouteCrossConnectionRoutesTableSummary withAsn(Integer asn) {
        this.asn = asn;
        return this;
    }

    /**
     * Get the upDown value.
     *
     * @return the upDown value
     */
    public String upDown() {
        return this.upDown;
    }

    /**
     * Set the upDown value.
     *
     * @param upDown the upDown value to set
     * @return the ExpressRouteCrossConnectionRoutesTableSummary object itself.
     */
    public ExpressRouteCrossConnectionRoutesTableSummary withUpDown(String upDown) {
        this.upDown = upDown;
        return this;
    }

    /**
     * Get the stateOrPrefixesReceived value.
     *
     * @return the stateOrPrefixesReceived value
     */
    public String stateOrPrefixesReceived() {
        return this.stateOrPrefixesReceived;
    }

    /**
     * Set the stateOrPrefixesReceived value.
     *
     * @param stateOrPrefixesReceived the stateOrPrefixesReceived value to set
     * @return the ExpressRouteCrossConnectionRoutesTableSummary object itself.
     */
    public ExpressRouteCrossConnectionRoutesTableSummary withStateOrPrefixesReceived(String stateOrPrefixesReceived) {
        this.stateOrPrefixesReceived = stateOrPrefixesReceived;
        return this;
    }

}
