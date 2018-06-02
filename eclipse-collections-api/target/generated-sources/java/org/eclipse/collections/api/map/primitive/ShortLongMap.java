/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.api.map.primitive;

import java.util.Map;

import org.eclipse.collections.api.LazyShortIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.predicate.primitive.ShortLongPredicate;
import org.eclipse.collections.api.block.procedure.primitive.ShortLongProcedure;
import org.eclipse.collections.api.block.procedure.primitive.ShortProcedure;
import org.eclipse.collections.api.set.primitive.MutableShortSet;
import org.eclipse.collections.api.tuple.primitive.ShortLongPair;

/**
 * This file was automatically generated from template file primitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface ShortLongMap extends LongValuesMap
{
    long get(short key);

    long getIfAbsent(short key, long ifAbsent);

    long getOrThrow(short key);

    boolean containsKey(short key);

    void forEachKey(ShortProcedure procedure);

    void forEachKeyValue(ShortLongProcedure procedure);

    LazyShortIterable keysView();

    /**
     * @since 5.0
     */
    RichIterable<ShortLongPair> keyValuesView();
    /**
     * Return the LongShortMap that is obtained by flipping the direction of this map and making the associations
     * from value to key.
     *
     * @throws IllegalStateException if the LongShortMap contains duplicate values.
     * @since 9.0
     */
    LongShortMap flipUniqueValues();

    ShortLongMap select(ShortLongPredicate predicate);

    ShortLongMap reject(ShortLongPredicate predicate);

    /**
     * Follows the same general contract as {@link Map#equals(Object)}.
     */
    @Override
    boolean equals(Object o);

    /**
     * Follows the same general contract as {@link Map#hashCode()}.
     */
    @Override
    int hashCode();

    /**
     * Follows the same general contract as {@link java.util.AbstractMap#toString()}
     *
     * @return a string representation of this ShortLongMap
     */
    @Override
    String toString();

    ImmutableShortLongMap toImmutable();

    MutableShortSet keySet();
}
