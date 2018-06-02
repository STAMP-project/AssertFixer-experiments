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

import org.eclipse.collections.api.map.primitive.MutableLongObjectMap;
import org.eclipse.collections.api.map.primitive.LongObjectMap;

/**
 * A factory which creates instances of type {@link MutableLongObjectMap}.
 * This file was automatically generated from template file mutablePrimitiveObjectMapFactory.stg.
 *
 * @since 6.0.
 */
public interface MutableLongObjectMapFactory
{
    <V> MutableLongObjectMap<V> empty();

    /**
     * Same as {@link #empty()}.
     */
    <V> MutableLongObjectMap<V> of();

    /**
     * Same as {@link #empty()}.
     */
    <V> MutableLongObjectMap<V> with();

    /**
     * Same as {@link #withAll(LongObjectMap)}.
     */
    <V> MutableLongObjectMap<V> ofAll(LongObjectMap<? extends V>  map);

    <V> MutableLongObjectMap<V> withAll(LongObjectMap<? extends V>  map);
}
