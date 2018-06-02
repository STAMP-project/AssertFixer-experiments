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

import org.eclipse.collections.api.map.primitive.ByteCharMap;
import org.eclipse.collections.api.map.primitive.ImmutableByteCharMap;

/**
 * A factory which creates instances of type {@link ImmutableByteCharMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactory.stg.
 *
 * @since 4.0.
 */
public interface ImmutableByteCharMapFactory
{
    /**
     * @since 6.0
     */
    ImmutableByteCharMap empty();

    /**
     * Same as {@link #empty()}.
     */
    ImmutableByteCharMap of();

    /**
     * Same as {@link #empty()}.
     */
    ImmutableByteCharMap with();

    /**
     * Same as {@link #with(byte, char)}.
     */
    ImmutableByteCharMap of(byte key, char value);

    ImmutableByteCharMap with(byte key, char value);

    /**
     * Same as {@link #withAll(ByteCharMap)}.
     */
    ImmutableByteCharMap ofAll(ByteCharMap map);

    ImmutableByteCharMap withAll(ByteCharMap map);
}
