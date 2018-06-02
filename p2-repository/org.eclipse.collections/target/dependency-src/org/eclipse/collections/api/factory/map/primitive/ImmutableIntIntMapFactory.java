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

import org.eclipse.collections.api.map.primitive.IntIntMap;
import org.eclipse.collections.api.map.primitive.ImmutableIntIntMap;

/**
 * A factory which creates instances of type {@link ImmutableIntIntMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactory.stg.
 *
 * @since 4.0.
 */
public interface ImmutableIntIntMapFactory
{
    /**
     * @since 6.0
     */
    ImmutableIntIntMap empty();

    /**
     * Same as {@link #empty()}.
     */
    ImmutableIntIntMap of();

    /**
     * Same as {@link #empty()}.
     */
    ImmutableIntIntMap with();

    /**
     * Same as {@link #with(int, int)}.
     */
    ImmutableIntIntMap of(int key, int value);

    ImmutableIntIntMap with(int key, int value);

    /**
     * Same as {@link #withAll(IntIntMap)}.
     */
    ImmutableIntIntMap ofAll(IntIntMap map);

    ImmutableIntIntMap withAll(IntIntMap map);
}
