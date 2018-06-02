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

import org.eclipse.collections.api.map.primitive.ShortByteMap;
import org.eclipse.collections.api.map.primitive.ImmutableShortByteMap;

/**
 * A factory which creates instances of type {@link ImmutableShortByteMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactory.stg.
 *
 * @since 4.0.
 */
public interface ImmutableShortByteMapFactory
{
    /**
     * @since 6.0
     */
    ImmutableShortByteMap empty();

    /**
     * Same as {@link #empty()}.
     */
    ImmutableShortByteMap of();

    /**
     * Same as {@link #empty()}.
     */
    ImmutableShortByteMap with();

    /**
     * Same as {@link #with(short, byte)}.
     */
    ImmutableShortByteMap of(short key, byte value);

    ImmutableShortByteMap with(short key, byte value);

    /**
     * Same as {@link #withAll(ShortByteMap)}.
     */
    ImmutableShortByteMap ofAll(ShortByteMap map);

    ImmutableShortByteMap withAll(ShortByteMap map);
}
