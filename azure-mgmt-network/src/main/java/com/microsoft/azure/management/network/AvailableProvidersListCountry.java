/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Country details.
 */
public class AvailableProvidersListCountry {
    /**
     * The country name.
     */
    @JsonProperty(value = "countryName")
    private String countryName;

    /**
     * A list of Internet service providers.
     */
    @JsonProperty(value = "providers")
    private List<String> providers;

    /**
     * List of available states in the country.
     */
    @JsonProperty(value = "states")
    private List<AvailableProvidersListState> states;

    /**
     * Get the countryName value.
     *
     * @return the countryName value
     */
    public String countryName() {
        return this.countryName;
    }

    /**
     * Set the countryName value.
     *
     * @param countryName the countryName value to set
     * @return the AvailableProvidersListCountry object itself.
     */
    public AvailableProvidersListCountry withCountryName(String countryName) {
        this.countryName = countryName;
        return this;
    }

    /**
     * Get the providers value.
     *
     * @return the providers value
     */
    public List<String> providers() {
        return this.providers;
    }

    /**
     * Set the providers value.
     *
     * @param providers the providers value to set
     * @return the AvailableProvidersListCountry object itself.
     */
    public AvailableProvidersListCountry withProviders(List<String> providers) {
        this.providers = providers;
        return this;
    }

    /**
     * Get the states value.
     *
     * @return the states value
     */
    public List<AvailableProvidersListState> states() {
        return this.states;
    }

    /**
     * Set the states value.
     *
     * @param states the states value to set
     * @return the AvailableProvidersListCountry object itself.
     */
    public AvailableProvidersListCountry withStates(List<AvailableProvidersListState> states) {
        this.states = states;
        return this;
    }

}
