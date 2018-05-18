/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.apimanagement;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

/**
 * Defines values for VirtualNetworkType.
 */
public final class VirtualNetworkType extends ExpandableStringEnum<VirtualNetworkType> {
    /** Static value None for VirtualNetworkType. */
    public static final VirtualNetworkType NONE = fromString("None");

    /** Static value External for VirtualNetworkType. */
    public static final VirtualNetworkType EXTERNAL = fromString("External");

    /** Static value Internal for VirtualNetworkType. */
    public static final VirtualNetworkType INTERNAL = fromString("Internal");

    /**
     * Creates or finds a VirtualNetworkType from its string representation.
     * @param name a name to look for
     * @return the corresponding VirtualNetworkType
     */
    @JsonCreator
    public static VirtualNetworkType fromString(String name) {
        return fromString(name, VirtualNetworkType.class);
    }

    /**
     * @return known VirtualNetworkType values
     */
    public static Collection<VirtualNetworkType> values() {
        return values(VirtualNetworkType.class);
    }
}
