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

import org.eclipse.collections.api.map.primitive.LongCharMap;
import org.eclipse.collections.api.map.primitive.ImmutableLongCharMap;

/**
 * A factory which creates instances of type {@link ImmutableLongCharMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactory.stg.
 *
 * @since 4.0.
 */
public interface ImmutableLongCharMapFactory
{
    /**
     * @since 6.0
     */
    ImmutableLongCharMap empty();

    /**
     * Same as {@link #empty()}.
     */
    ImmutableLongCharMap of();

    /**
     * Same as {@link #empty()}.
     */
    ImmutableLongCharMap with();

    /**
     * Same as {@link #with(long, char)}.
     */
    ImmutableLongCharMap of(long key, char value);

    ImmutableLongCharMap with(long key, char value);

    /**
     * Same as {@link #withAll(LongCharMap)}.
     */
    ImmutableLongCharMap ofAll(LongCharMap map);

    ImmutableLongCharMap withAll(LongCharMap map);
}
