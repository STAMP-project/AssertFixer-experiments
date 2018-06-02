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

import org.eclipse.collections.api.map.primitive.IntDoubleMap;
import org.eclipse.collections.api.map.primitive.ImmutableIntDoubleMap;

/**
 * A factory which creates instances of type {@link ImmutableIntDoubleMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactory.stg.
 *
 * @since 4.0.
 */
public interface ImmutableIntDoubleMapFactory
{
    /**
     * @since 6.0
     */
    ImmutableIntDoubleMap empty();

    /**
     * Same as {@link #empty()}.
     */
    ImmutableIntDoubleMap of();

    /**
     * Same as {@link #empty()}.
     */
    ImmutableIntDoubleMap with();

    /**
     * Same as {@link #with(int, double)}.
     */
    ImmutableIntDoubleMap of(int key, double value);

    ImmutableIntDoubleMap with(int key, double value);

    /**
     * Same as {@link #withAll(IntDoubleMap)}.
     */
    ImmutableIntDoubleMap ofAll(IntDoubleMap map);

    ImmutableIntDoubleMap withAll(IntDoubleMap map);
}
