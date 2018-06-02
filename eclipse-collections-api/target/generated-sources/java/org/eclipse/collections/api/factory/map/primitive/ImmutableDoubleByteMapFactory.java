/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.api.factory.map.primitive;

import org.eclipse.collections.api.map.primitive.DoubleByteMap;
import org.eclipse.collections.api.map.primitive.ImmutableDoubleByteMap;

/**
 * A factory which creates instances of type {@link ImmutableDoubleByteMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactory.stg.
 *
 * @since 4.0.
 */
public interface ImmutableDoubleByteMapFactory
{
    /**
     * @since 6.0
     */
    ImmutableDoubleByteMap empty();

    /**
     * Same as {@link #empty()}.
     */
    ImmutableDoubleByteMap of();

    /**
     * Same as {@link #empty()}.
     */
    ImmutableDoubleByteMap with();

    /**
     * Same as {@link #with(double, byte)}.
     */
    ImmutableDoubleByteMap of(double key, byte value);

    ImmutableDoubleByteMap with(double key, byte value);

    /**
     * Same as {@link #withAll(DoubleByteMap)}.
     */
    ImmutableDoubleByteMap ofAll(DoubleByteMap map);

    ImmutableDoubleByteMap withAll(DoubleByteMap map);
}
