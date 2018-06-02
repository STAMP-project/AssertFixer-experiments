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

import org.eclipse.collections.api.map.primitive.ByteFloatMap;
import org.eclipse.collections.api.map.primitive.ImmutableByteFloatMap;

/**
 * A factory which creates instances of type {@link ImmutableByteFloatMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactory.stg.
 *
 * @since 4.0.
 */
public interface ImmutableByteFloatMapFactory
{
    /**
     * @since 6.0
     */
    ImmutableByteFloatMap empty();

    /**
     * Same as {@link #empty()}.
     */
    ImmutableByteFloatMap of();

    /**
     * Same as {@link #empty()}.
     */
    ImmutableByteFloatMap with();

    /**
     * Same as {@link #with(byte, float)}.
     */
    ImmutableByteFloatMap of(byte key, float value);

    ImmutableByteFloatMap with(byte key, float value);

    /**
     * Same as {@link #withAll(ByteFloatMap)}.
     */
    ImmutableByteFloatMap ofAll(ByteFloatMap map);

    ImmutableByteFloatMap withAll(ByteFloatMap map);
}
