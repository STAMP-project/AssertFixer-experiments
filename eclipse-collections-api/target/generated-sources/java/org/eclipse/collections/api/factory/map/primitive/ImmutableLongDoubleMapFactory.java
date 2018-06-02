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

import org.eclipse.collections.api.map.primitive.LongDoubleMap;
import org.eclipse.collections.api.map.primitive.ImmutableLongDoubleMap;

/**
 * A factory which creates instances of type {@link ImmutableLongDoubleMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactory.stg.
 *
 * @since 4.0.
 */
public interface ImmutableLongDoubleMapFactory
{
    /**
     * @since 6.0
     */
    ImmutableLongDoubleMap empty();

    /**
     * Same as {@link #empty()}.
     */
    ImmutableLongDoubleMap of();

    /**
     * Same as {@link #empty()}.
     */
    ImmutableLongDoubleMap with();

    /**
     * Same as {@link #with(long, double)}.
     */
    ImmutableLongDoubleMap of(long key, double value);

    ImmutableLongDoubleMap with(long key, double value);

    /**
     * Same as {@link #withAll(LongDoubleMap)}.
     */
    ImmutableLongDoubleMap ofAll(LongDoubleMap map);

    ImmutableLongDoubleMap withAll(LongDoubleMap map);
}
