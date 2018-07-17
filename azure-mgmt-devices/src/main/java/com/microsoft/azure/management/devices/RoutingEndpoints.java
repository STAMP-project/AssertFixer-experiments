/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.microsoft.azure.management.devices;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The properties related to the custom endpoints to which your IoT hub routes
 * messages based on the routing rules. A maximum of 10 custom endpoints are
 * allowed across all endpoint types for paid hubs and only 1 custom endpoint
 * is allowed across all endpoint types for free hubs.
 */
public class RoutingEndpoints {
    /**
     * The list of Service Bus queue endpoints that IoT hub routes the messages
     * to, based on the routing rules.
     */
    @JsonProperty(value = "serviceBusQueues")
    private List<RoutingServiceBusQueueEndpointProperties> serviceBusQueues;

    /**
     * The list of Service Bus topic endpoints that the IoT hub routes the
     * messages to, based on the routing rules.
     */
    @JsonProperty(value = "serviceBusTopics")
    private List<RoutingServiceBusTopicEndpointProperties> serviceBusTopics;

    /**
     * The list of Event Hubs endpoints that IoT hub routes messages to, based
     * on the routing rules. This list does not include the built-in Event Hubs
     * endpoint.
     */
    @JsonProperty(value = "eventHubs")
    private List<RoutingEventHubProperties> eventHubs;

    /**
     * Get the serviceBusQueues value.
     *
     * @return the serviceBusQueues value
     */
    public List<RoutingServiceBusQueueEndpointProperties> serviceBusQueues() {
        return this.serviceBusQueues;
    }

    /**
     * Set the serviceBusQueues value.
     *
     * @param serviceBusQueues the serviceBusQueues value to set
     * @return the RoutingEndpoints object itself.
     */
    public RoutingEndpoints withServiceBusQueues(List<RoutingServiceBusQueueEndpointProperties> serviceBusQueues) {
        this.serviceBusQueues = serviceBusQueues;
        return this;
    }

    /**
     * Get the serviceBusTopics value.
     *
     * @return the serviceBusTopics value
     */
    public List<RoutingServiceBusTopicEndpointProperties> serviceBusTopics() {
        return this.serviceBusTopics;
    }

    /**
     * Set the serviceBusTopics value.
     *
     * @param serviceBusTopics the serviceBusTopics value to set
     * @return the RoutingEndpoints object itself.
     */
    public RoutingEndpoints withServiceBusTopics(List<RoutingServiceBusTopicEndpointProperties> serviceBusTopics) {
        this.serviceBusTopics = serviceBusTopics;
        return this;
    }

    /**
     * Get the eventHubs value.
     *
     * @return the eventHubs value
     */
    public List<RoutingEventHubProperties> eventHubs() {
        return this.eventHubs;
    }

    /**
     * Set the eventHubs value.
     *
     * @param eventHubs the eventHubs value to set
     * @return the RoutingEndpoints object itself.
     */
    public RoutingEndpoints withEventHubs(List<RoutingEventHubProperties> eventHubs) {
        this.eventHubs = eventHubs;
        return this;
    }

}
