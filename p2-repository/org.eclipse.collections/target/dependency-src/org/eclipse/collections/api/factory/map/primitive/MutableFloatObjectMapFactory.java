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

import org.eclipse.collections.api.map.primitive.MutableFloatObjectMap;
import org.eclipse.collections.api.map.primitive.FloatObjectMap;

/**
 * A factory which creates instances of type {@link MutableFloatObjectMap}.
 * This file was automatically generated from template file mutablePrimitiveObjectMapFactory.stg.
 *
 * @since 6.0.
 */
public interface MutableFloatObjectMapFactory
{
    <V> MutableFloatObjectMap<V> empty();

    /**
     * Same as {@link #empty()}.
     */
    <V> MutableFloatObjectMap<V> of();

    /**
     * Same as {@link #empty()}.
     */
    <V> MutableFloatObjectMap<V> with();

    /**
     * Same as {@link #withAll(FloatObjectMap)}.
     */
    <V> MutableFloatObjectMap<V> ofAll(FloatObjectMap<? extends V>  map);

    <V> MutableFloatObjectMap<V> withAll(FloatObjectMap<? extends V>  map);
}
