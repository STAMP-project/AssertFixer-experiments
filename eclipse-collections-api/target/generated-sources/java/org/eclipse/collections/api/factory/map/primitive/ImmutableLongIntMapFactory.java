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

import org.eclipse.collections.api.map.primitive.LongIntMap;
import org.eclipse.collections.api.map.primitive.ImmutableLongIntMap;

/**
 * A factory which creates instances of type {@link ImmutableLongIntMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactory.stg.
 *
 * @since 4.0.
 */
public interface ImmutableLongIntMapFactory
{
    /**
     * @since 6.0
     */
    ImmutableLongIntMap empty();

    /**
     * Same as {@link #empty()}.
     */
    ImmutableLongIntMap of();

    /**
     * Same as {@link #empty()}.
     */
    ImmutableLongIntMap with();

    /**
     * Same as {@link #with(long, int)}.
     */
    ImmutableLongIntMap of(long key, int value);

    ImmutableLongIntMap with(long key, int value);

    /**
     * Same as {@link #withAll(LongIntMap)}.
     */
    ImmutableLongIntMap ofAll(LongIntMap map);

    ImmutableLongIntMap withAll(LongIntMap map);
}
